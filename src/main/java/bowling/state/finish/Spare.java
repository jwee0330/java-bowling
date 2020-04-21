package bowling.state.finish;

import bowling.pin.domain.Pin;
import bowling.score.domain.Score;
import bowling.state.State;

public class Spare extends Finished {

    private final Pin firstFelledPins;

    private Spare(Pin firstFelledPins) {
        this.firstFelledPins = firstFelledPins;
    }

    public static State of(Pin firstFelledPins) {
        return new Spare(firstFelledPins);
    }

    @Override
    public String view() {
        return firstFelledPins.getFelledPins() + DELIMITER + State.SPARE;
    }

    @Override
    public Score getScore() {
        return Score.ofSpare(firstFelledPins);
    }

    @Override
    public String toString() {
        return "Spare{score=" + getScore() + ", view=" + view() + "}";
    }
}
