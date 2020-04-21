package bowling.frame.domain;

import bowling.pin.domain.Pin;
import bowling.player.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FramesTest {

    @DisplayName("한 프레임이 종료되면 다음 프레임을 생성한다")
    @Test
    public void generateFrameTest() {
        Frames frames = Frames.init(Player.of("LJW"));
        frames.bowl(Pin.of(10));
        assertThat(frames.getSize()).isEqualTo(2);
    }

    @DisplayName("모든 프레임이 종료되면 게임이 종료 된다")
    @Test
    public void isDoneTest() {
        Frames frames = Frames.init(Player.of("LJW"));
        frames.bowl(Pin.of(10));
        frames.bowl(Pin.of(10));
        frames.bowl(Pin.of(10));
        frames.bowl(Pin.of(10));
        frames.bowl(Pin.of(10));
        frames.bowl(Pin.of(10));
        frames.bowl(Pin.of(10));
        frames.bowl(Pin.of(10));
        frames.bowl(Pin.of(10));
        // 10 frame Pin.of(Gutter) 라고 가정
        frames.bowl(Pin.of(0));
        frames.bowl(Pin.of(0));
        assertThat(frames.isDone()).isTrue();
    }



    @Test
    public void test() {
        String a = "[" +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}," +
                " Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}," +
                " Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}, " +
                "Score{score=1, remains=0}]";
    }


}
