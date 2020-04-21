package bowling.state.finish;

import bowling.score.domain.Score;
import bowling.state.State;

public class Strike extends Finished {

    private Strike() {
    }

    public static State of() {
        return new Strike();
    }

    @Override
    public String view() {
        return STRIKE;
    }

    @Override
    public Score getScore() {
        return Score.ofStrike();
    }

    @Override
    public String toString() {
        return "Strike{score=" + getScore() + ", view=" + view() + "}";
    }
}
