import os
import json
import re
import argparse

TEMPLATE = 'BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.{name}, RenderType.{render}());'

def process_json_file(path, results):
    with open(path, 'r', encoding='utf-8') as f:
        try:
            data = json.load(f)
        except json.JSONDecodeError:
            return

    raw_render = data.get('render_type')
    if not raw_render:
        return
    # remove namespace if present (e.g., "namespace:type")
    render_type = raw_render.split(':', 1)[1] if ':' in raw_render else raw_render

    textures = data.get('textures')
    if not isinstance(textures, dict):
        return

    for tex in textures.values():
        if isinstance(tex, str) and tex.startswith('morecolorful:block/'):
            # extract name after 'block/'
            name = tex.split('block/', 1)[1]
            # strip trailing _number
            name = re.sub(r'_(\d+)$', '', name)
            # uppercase and non-alphanumeric to underscore
            name_const = re.sub(r'[^0-9A-Za-z]', '_', name).upper()
            # use stripped render_type
            results.append((name_const, render_type))


def collect_results(root_dir):
    results = []
    for dirpath, _, filenames in os.walk(root_dir):
        for fname in filenames:
            if fname.endswith('.json'):
                process_json_file(os.path.join(dirpath, fname), results)
    # remove duplicates, sort by block name
    return sorted(set(results), key=lambda x: x[0])


def write_to_java(java_file, entries):
    with open(java_file, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    start_idx = None
    end_idx = None
    for i, line in enumerate(lines):
        if 'public static void setRenderLayers()' in line and '{' in line:
            start_idx = i + 1
        elif start_idx is not None and '}' in line:
            end_idx = i
            break

    if start_idx is None or end_idx is None:
        print('Could not locate setRenderLayers method in', java_file)
        return

    # build insertion lines
    insert_lines = [f'        {TEMPLATE.format(name=name, render=render)}\n' for name, render in entries]

    # replace between start_idx and end_idx
    new_lines = lines[:start_idx] + insert_lines + lines[end_idx:]

    with open(java_file, 'w', encoding='utf-8') as f:
        f.writelines(new_lines)

    print(f'Inserted {len(entries)} entries into {java_file}')


def main():
    parser = argparse.ArgumentParser(description='Generate render layer mappings')
    parser.add_argument('json_dir', help='Directory containing JSON files')
    parser.add_argument('java_file', help='Target Java file to update')
    args = parser.parse_args()

    entries = collect_results(args.json_dir)
    if not entries:
        print('No entries found.')
        return

    write_to_java(args.java_file, entries)

if __name__ == '__main__':
    main()