package bowling.score.domain;

import java.util.ArrayList;
import java.util.List;

public class Scores {
    private final List<Score> scores;

    private Scores(List<Score> scores) {
        this.scores = scores;
    }

    public static Scores init() {
        return new Scores(new ArrayList<>());
    }

    public static Scores of(List<Score> scores) {
        return new Scores(scores);
    }

    public List<Score> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "scores=" + scores +
                '}';
    }

    public void add(Score score) {

    }
}
