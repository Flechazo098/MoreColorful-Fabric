#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
import json
import argparse

def replace_loader_in_file(file_path: str,
                           old_loader: str,
                           new_loader: str) -> bool:
    """
    在指定 JSON 文件中，将 loader 从 old_loader 替换为 new_loader。
    如果发生替换，返回 True；否则返回 False。
    """
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            data = json.load(f)
    except (json.JSONDecodeError, UnicodeDecodeError) as e:
        print(f"跳过无法解析的文件: {file_path} ({e})")
        return False

    # 仅替换顶层 loader 字段
    if isinstance(data, dict) and data.get("loader") == old_loader:
        data["loader"] = new_loader
        with open(file_path, 'w', encoding='utf-8') as f:
            json.dump(data, f, ensure_ascii=False, indent=2)
        return True

    return False

def traverse_and_replace(folder: str,
                         old_loader: str,
                         new_loader: str) -> None:
    """
    递归遍历 folder 目录，调用 replace_loader_in_file 进行替换。
    并在控制台输出处理结果。
    """
    replaced_count = 0
    total_count = 0

    for root, _, files in os.walk(folder):
        for name in files:
            if not name.lower().endswith('.json'):
                continue
            total_count += 1
            file_path = os.path.join(root, name)
            if replace_loader_in_file(file_path, old_loader, new_loader):
                print(f"[已替换] {file_path}")
                replaced_count += 1

    print(f"\n遍历完成，共扫描 JSON 文件：{total_count} 个，成功替换：{replaced_count} 个。")

def main():
    parser = argparse.ArgumentParser(
        description="将 JSON 文件中的 loader from neoforge:separate_transforms 替换为 morecolorful:separate_transforms"
    )
    parser.add_argument(
        "folder",
        help="要遍历的根目录路径"
    )
    parser.add_argument(
        "--old",
        default="neoforge:separate_transforms",
        help="原 loader 值（默认：neoforge:separate_transforms）"
    )
    parser.add_argument(
        "--new",
        default="morecolorful:separate_transforms",
        help="新 loader 值（默认：morecolorful:separate_transforms）"
    )
    args = parser.parse_args()

    if not os.path.isdir(args.folder):
        print(f"错误：路径不存在或不是文件夹：{args.folder}")
        return

    traverse_and_replace(args.folder, args.old, args.new)

if __name__ == "__main__":
    main()
