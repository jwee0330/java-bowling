package bowling.state;

import bowling.pin.domain.Pin;
import bowling.score.domain.Score;

public interface State {
    String DELIMITER = "|";
    String STANDBY = " ";
    String STRIKE = "X";
    String SPARE = "/";
    String GUTTER = "-";

    State bowl(Pin felledPins);

    boolean isFinished();

    String view();

    Score getScore();

}
