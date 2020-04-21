package bowling.state.finish;

import bowling.pin.domain.Pin;
import bowling.state.State;

public abstract class Finished implements State {

    @Override
    public State bowl(Pin felledPins) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
