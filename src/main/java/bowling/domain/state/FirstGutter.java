package bowling.domain.state;

import static bowling.domain.FrameConstants.MAX_HIT_COUNT;
import static bowling.domain.FrameConstants.MIN_HIT_COUNT;

public class FirstGutter implements State {

    public static final String TEXT = "-";

    @Override
    public State play(int newHitCount) {
        if (newHitCount == MIN_HIT_COUNT) {
            return new SecondGutter();
        }

        if (newHitCount == MAX_HIT_COUNT) {
            return new Spare();
        }

        return new Miss(newHitCount);
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public State snapShot() {
        return new FirstGutter();
    }

    @Override
    public boolean isBonusPlayableState() {
        return false;
    }

    @Override
    public String getString() {
        return FirstGutter.TEXT;
    }
}