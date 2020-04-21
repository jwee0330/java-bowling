package bowling.frame.domain;

import bowling.pin.domain.Pin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LastFrameTest {

    @DisplayName("마지막 프레임에 모두 스트라이크를 치면 보너스 기회가 주어진다.")
    @Test
    public void allStrikeTest() {
        Frame frame = LastFrame.of();

        frame.bowl(Pin.of(10));
        assertThat(frame.isFinished()).isFalse();
        frame.bowl(Pin.of(10));
        assertThat(frame.isFinished()).isFalse();
        frame.bowl(Pin.of(10));
        assertThat(frame.isFinished()).isTrue();
    }

    @DisplayName("마지막 프레임의 두번째 시도에 스트라이크를 치면 보너스 기회가 주어진다.")
    @Test
    public void secondStrikeTest() {
        Frame frame = LastFrame.of();

        frame.bowl(Pin.of(0));
        assertThat(frame.isFinished()).isFalse();
        frame.bowl(Pin.of(10));
        assertThat(frame.isFinished()).isFalse();
        frame.bowl(Pin.of(10));
        assertThat(frame.isFinished()).isTrue();
    }

    @DisplayName("마지막 프레임의 두번째 시도에 스페어 처리를 하면 보너스 기회가 주어진다.")
    @Test
    public void secondSpareTest() {
        Frame frame = LastFrame.of();

        frame.bowl(Pin.of(5));
        assertThat(frame.isFinished()).isFalse();
        frame.bowl(Pin.of(5));
        assertThat(frame.isFinished()).isFalse();
        frame.bowl(Pin.of(5));
        assertThat(frame.isFinished()).isTrue();
    }

    @DisplayName("마지막 프레임의 두번째 시도에 미스를 하면 보너스 기회가 주어지지 않는다.")
    @Test
    public void secondMissTest() {
        Frame frame = LastFrame.of();

        frame.bowl(Pin.of(5));
        assertThat(frame.isFinished()).isFalse();
        frame.bowl(Pin.of(1));
        assertThat(frame.isFinished()).isTrue();
    }

    @DisplayName("마지막 프레임의 두번째 시도까지 거터를 하면 보너스 기회가 주어지지 않는다.")
    @Test
    public void secondGutterTest() {
        Frame frame = LastFrame.of();

        frame.bowl(Pin.of(0));
        assertThat(frame.isFinished()).isFalse();
        frame.bowl(Pin.of(0));
        assertThat(frame.isFinished()).isTrue();
    }

}
