package bowling.pin.domain;

public class Pin {
    private static final int FELLED_MAX_PINS = 10;
    private static final int FELLED_MIN_PINS = 0;

    private final int felledPins;

    private Pin(int felledPins) {
        this.felledPins = felledPins;
    }

    public static Pin of(int felledPins) {
        return new Pin(felledPins);
    }

    public Pin sum(Pin pin) {
        return of(felledPins + pin.getFelledPins());
    }

    public int getFelledPins() {
        return felledPins;
    }

    public boolean isFelledAllPins() {
        return felledPins == FELLED_MAX_PINS;
    }

    public boolean isNotFelledPinsAtAll() {
        return felledPins == FELLED_MIN_PINS;
    }

    public void isValidCount() {
        if (felledPins < FELLED_MIN_PINS || felledPins > FELLED_MAX_PINS) {
            throw new OutRangeOfPinsException();
        }
    }

    @Override
    public String toString() {
        return "Pin{" +
                "felledPins=" + felledPins +
                '}';
    }
}
