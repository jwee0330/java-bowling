package bowling.state.finish;

import bowling.pin.domain.Pin;
import bowling.score.domain.Score;
import bowling.state.State;

import java.io.Serializable;

public class Miss extends Finished {
    private final Pin firstFelledPins;
    private final Pin secondFelledPins;

    private Miss(Pin firstFelledPins, Pin secondFelledPins) {
        this.firstFelledPins = firstFelledPins;
        this.secondFelledPins = secondFelledPins;
    }

    public static State of(Pin firstFelledPins, Pin secondFelledPins) {
        Pin felledPinsTotal = firstFelledPins.sum(secondFelledPins);
        if (felledPinsTotal.isFelledAllPins()) {
            throw new IllegalArgumentException("스페어처리 된 상태는 미스상태가 될 수 없습니다.");
        }
        return new Miss(firstFelledPins, secondFelledPins);
    }

    @Override
    public String view() {
        if (secondFelledPins.isNotFelledPinsAtAll()) {
            return firstFelledPins.getFelledPins() + DELIMITER + GUTTER;
        }
        if (firstFelledPins.isNotFelledPinsAtAll()) {
            return GUTTER + DELIMITER + secondFelledPins.getFelledPins();
        }
        return firstFelledPins.getFelledPins() + DELIMITER + getFinalMisStrike();
    }

    private Serializable getFinalMisStrike() {
        return secondFelledPins.getFelledPins() != 10 ? secondFelledPins.getFelledPins() : "X";
    }

    @Override
    public Score getScore() {
        return Score.ofMiss(firstFelledPins.sum(secondFelledPins));
    }

    @Override
    public String toString() {
        return "Miss{score=" + getScore() + ", view=" + view() + "}";
    }
}
