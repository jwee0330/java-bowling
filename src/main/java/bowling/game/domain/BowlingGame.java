package bowling.game.domain;

import bowling.frame.domain.Frames;
import bowling.pin.domain.Pin;
import bowling.player.domain.Player;
import bowling.score.domain.Score;
import bowling.score.domain.Scores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BowlingGame {

    private final Frames game;
    private List<Score> scores = new ArrayList<>();

    private BowlingGame(Frames game) {
        this.game = game;
    }

    public static BowlingGame init(String userName) {
        return Stream.of(userName)
                .map(Player::of)
                .map(Frames::init)
                .map(BowlingGame::new)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Frames getGame() {
        return Frames.of(game);
    }

    public Scores getScores() {
        return Scores.of(scores);
    }

    public boolean isDone() {
        return game.isDone();
    }

    public void bowl(Pin felledPins) {
        felledPins.isValidCount();

        game.bowl(felledPins);
        Score score = game.getScore();

        scores.add(score);
//        System.out.println(scores);
    }

}
