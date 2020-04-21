package bowling.frame.domain;

import bowling.pin.domain.Pin;
import bowling.score.domain.Score;
import bowling.state.State;
import bowling.state.finish.LastFrameState;

public class LastFrame implements Frame {

    private State state = LastFrameState.init();

    static Frame of() {
        return new LastFrame();
    }

    @Override
    public State bowl(Pin felledPins) {
        state = state.bowl(felledPins);
//        System.out.println("last frames: " + state.getScore() + ", state: " + state + ", view: " + state.view() + ", isFinished: " + state.isFinished());
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
