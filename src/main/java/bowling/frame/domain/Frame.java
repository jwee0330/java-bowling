package bowling.frame.domain;

import bowling.pin.domain.Pin;
import bowling.score.domain.Score;
import bowling.state.State;

public interface Frame {

    static Frame normal() {
        return NormalFrame.of();
    }

    static Frame last() {
        return LastFrame.of();
    }

    State bowl(Pin felledPins);

    boolean isFinished();

    String view();

    Score getScore();

    Score calculateScore(Score score);
}
