package bowling.pin.domain;

public class OutRangeOfPinsException extends IllegalArgumentException {
    public OutRangeOfPinsException() {
        super("쓰러트린 볼링핀은 0 ~ 10 사이로 입력하세요");
    }
}
