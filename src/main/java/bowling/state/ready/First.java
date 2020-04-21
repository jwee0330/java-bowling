package bowling.state.ready;

import bowling.pin.domain.Pin;
import bowling.score.domain.Score;
import bowling.state.State;
import bowling.state.finish.Strike;

public class First extends Ready {

    public static First of() {
        return new First();
    }

    @Override
    public State bowl(Pin felledPins) {
        if (felledPins.isFelledAllPins()) {
            return Strike.of();
        }
        return Second.of(felledPins);
    }

    @Override
    public String view() {
        return STANDBY;
    }

    @Override
    public Score getScore() {
        return Score.ofFirst();
    }
}
