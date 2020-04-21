package bowling.score.domain;

import bowling.pin.domain.Pin;

import java.util.Objects;

public class Score {
    private static final int MAX = 3;
    private static final int TWO_BONUS = 2;
    private static final int ONE_BONUS = 1;
    private static final int REMAINS_FINISHED = 0;
    private static final int SCORE_ZERO = 0;
    private static final int SCORE_TEN = 10;

    private int score;
    private int remains;

    public Score(int score, int remains) {
        this.score = score;
        this.remains = remains;
    }

    private static Score of(int score, int remains) {
        return new Score(score, remains);
    }

    public static Score ofFinalFrame(int score) {
        return new Score(score, REMAINS_FINISHED);
    }

    public static Score ofGutter() {
        return Score.of(SCORE_ZERO, REMAINS_FINISHED);
    }

    public static Score ofFirst() {
        return Score.of(0, 0);
    }

    public static Score ofSecond(Pin felledPins) {
        return Score.of(felledPins.getFelledPins(), REMAINS_FINISHED);
    }

    public static Score ofMiss(Pin sum) {
        return Score.of(sum.getFelledPins(), REMAINS_FINISHED);
    }

    public static Score ofStrike() {
        return Score.of(SCORE_TEN, TWO_BONUS);
    }

    public static Score ofSpare(Pin firstFelledPins) {
        return Score.of(firstFelledPins.getFelledPins(), ONE_BONUS);
    }

    public static Score init() {
        return Score.of(SCORE_ZERO, ONE_BONUS);
    }

    public static Score ofScoreNotYet() {
        return Score.of(-1, -1);
    }

    public int getScore() {
        return score;
    }

    public boolean isEnd() {
        return remains == REMAINS_FINISHED;
    }

    public Score sum(Score prevScore) {
        if (isEnd()) {
            return this;
        }
        int remains = this.remains - ONE_BONUS;
        return Score.of(score + prevScore.getScore(), remains);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;
        Score score1 = (Score) o;
        return getScore() == score1.getScore() &&
                remains == score1.remains;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore(), remains);
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                ", remains=" + remains +
                '}';
    }

}
