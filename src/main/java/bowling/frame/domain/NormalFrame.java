package bowling.frame.domain;

import bowling.pin.domain.Pin;
import bowling.score.domain.Score;
import bowling.state.State;
import bowling.state.ready.First;

public class NormalFrame implements Frame {

    private State state = First.of();

    private NormalFrame() {
    }

    static Frame of() {
        return new NormalFrame();
    }

    @Override
    public State bowl(Pin felledPins) {
        state = state.bowl(felledPins);
        return state;
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }

    @Override
    public String view() {
        return state.view();
    }

    @Override
    public Score getScore() {
        return state.getScore();
    }

    @Override
    public Score calculateScore(Score score) {
        return score.sum(state.getScore());
    }

}
