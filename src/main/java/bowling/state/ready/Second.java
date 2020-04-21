package bowling.state.ready;

import bowling.pin.domain.Pin;
import bowling.score.domain.Score;
import bowling.state.State;
import bowling.state.finish.Gutter;
import bowling.state.finish.Miss;
import bowling.state.finish.Spare;

import static java.lang.String.valueOf;

public class Second extends Ready {

    private final Pin firstFelledPins;

    private Second(Pin felledPins) {
        this.firstFelledPins = felledPins;
    }

    public static State of(Pin felledPins) {
        return new Second(felledPins);
    }

    @Override
    public State bowl(Pin secondFelledPins) {
        Pin felledPinsTotal = firstFelledPins.sum(secondFelledPins);
        if (felledPinsTotal.isFelledAllPins()) {
            return Spare.of(firstFelledPins);
        }
        if (felledPinsTotal.isNotFelledPinsAtAll()) {
            return Gutter.of();
        }
        return Miss.of(firstFelledPins, secondFelledPins);
    }

    @Override
    public String view() {
        if (firstFelledPins.isNotFelledPinsAtAll()) {
            return GUTTER;
        }
        return valueOf(firstFelledPins.getFelledPins());
    }

    @Override
    public Score getScore() {
        return Score.ofSecond(firstFelledPins);
    }

}
