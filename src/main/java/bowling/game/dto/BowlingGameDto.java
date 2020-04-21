package bowling.game.dto;

import bowling.frame.domain.Frames;
import bowling.score.domain.Scores;

public class BowlingGameDto {

    private final Frames game;
    private final Scores scores;

    public BowlingGameDto(Frames game, Scores scores) {
        this.game = game;
        this.scores = scores;
    }

    public Frames getFrames() {
        return game;
    }

    public int getCurrentFrame() {
        return game.getSize();
    }

    public Scores getScores() {
        return scores;
    }
}
