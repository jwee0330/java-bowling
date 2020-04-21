package bowling.state.finish;

import bowling.score.domain.Score;
import bowling.state.State;

public class Gutter extends Finished {

    private Gutter() {
    }

    public static State of() {
        return new Gutter();
    }

    @Override
    public String view() {
        return GUTTER;
    }

    public Score getScore() {
        return Score.ofGutter();
    }

    @Override
    public String toString() {
        return "Gutter{score=" + getScore() + ", view=" + view() + "}";
    }
}
