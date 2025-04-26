package com.ChalkerCharles.morecolorful.util.melody;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class MelodyHandler {
    private static final MelodyHandler INSTANCE = new MelodyHandler();

    private final NoteBlockHandler[] noteBlockHandlers = new NoteBlockHandler[]{
            new NoteBlockHandler(Melodies.EXAMPLE),
            new NoteBlockHandler(Melodies.EXAMPLE_1),
            new NoteBlockHandler(Melodies.EXAMPLE_2),
            new NoteBlockHandler(Melodies.EXAMPLE_3)
    };

    public static MelodyHandler getInstance() {
        return INSTANCE;
    }

    public void onNoteBlockPlaying(Level level, BlockPos pos, BlockState state, int noteId, NoteBlockInstrument instrument) {
        if (!level.isClientSide()) {
            for (NoteBlockHandler handler : noteBlockHandlers) {
                handler.handleMelody(level, pos, state, noteId, instrument);
            }
        }
    }

    public static class NoteBlockHandler {
        private int ordinal = 0;
        private int chordOrdinal = 0;
        private Set<Integer> noteSet;
        private final Melody melody;
        private LocalDateTime lastNote = null;
        private LocalDateTime lastChordNote = null;

        private NoteBlockHandler(Melody melody) {
            this.melody = melody;
        }

        private void handleMelody(Level level, BlockPos pos, BlockState state, int noteId, NoteBlockInstrument instrument) {
            if (melody.matchedType(instrument)) {
                Note note = melody.notes()[ordinal];
                if (note.isChord()) {
                    handleChord(note, noteId);
                } else {
                    if (note.keyId() == noteId) {
                        ordinal++;
                    } else {
                        restore();
                    }
                }

                if (ordinal == melody.notes().length) {
                    restore();
                    System.out.println("yes");
                }
            }
            LocalDateTime currentNote = LocalDateTime.now();
            if (lastNote != null) {
                Duration duration = Duration.between(lastNote, currentNote);
                long seconds = duration.toSeconds();
                if (seconds > 8) {
                    restore();
                }
            }
            lastNote = currentNote;
        }

        private void handleChord(Note note, int noteId) {
            Note.Chord chord = (Note.Chord) note;
            if (chordOrdinal == 0) {
                noteSet = new HashSet<>(Set.of(chord.keyIds()));
            }
            if (noteSet.contains(noteId)) {
                noteSet.remove(noteId);
                chordOrdinal++;
            } else {
                restore();
            }
            if (noteSet.isEmpty()) {
                ordinal++;
                chordOrdinal = 0;
                lastChordNote = null;
            }
            LocalDateTime currentChordNote = LocalDateTime.now();
            if (lastChordNote != null) {
                Duration duration = Duration.between(lastChordNote, currentChordNote);
                long milliseconds = duration.toMillis();
                if (milliseconds > 200) {
                    restore();
                }
            }
            lastChordNote = currentChordNote;
        }

        private void restore() {
            this.ordinal = 0;
            this.chordOrdinal = 0;
            this.lastNote = null;
            this.lastChordNote = null;
        }
    }
}