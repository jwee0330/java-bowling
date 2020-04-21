package bowling.frame.domain;

import bowling.pin.domain.Pin;
import bowling.player.domain.Player;
import bowling.score.domain.Score;
import bowling.state.State;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class Frames {
    private static final int ONE = 1;
    private static final int NORMAL_FRAME = 9;
    private static final int LAST_FRAME = 10;

    private final Player player;
    private final List<Frame> frames;
    private Deque<State> states = new LinkedList<>();
    private Deque<Score> scores = new LinkedList<>();
    private List<Score> reversedScores = new ArrayList<>();

    int i = 1;

    private Frames(Player player, List<Frame> frames) {
        this.player = player;
        this.frames = frames;
    }

    public Frames(Frames game) {
        this.player = game.getPlayer();
        this.frames = game.getFrames();
    }

    public static Frames init(Player player) {
        return new Frames(player, new ArrayList<>(Collections.singletonList(Frame.normal())));
    }

    public static Frames of(Frames game) {
        return new Frames(game);
    }

    public void bowl(Pin felledPins) {
        Frame current = getCurrent();
        State afterBowlState = current.bowl(felledPins);
        states.add(afterBowlState);

        if (current.isFinished() && (current instanceof NormalFrame)) {
            generate();
        }
    }

    private void generate() {
        if (frames.size() < NORMAL_FRAME) {
            frames.add(Frame.normal());
            return;
        }
        frames.add(Frame.last());
    }

    public Score getScore() {
        if (states.size() == 10) {
            return states.peekLast().getScore();
        }

        scores = states.stream()
                .map(State::getScore)
                .collect(toCollection(LinkedList::new));

        Score last = scores.getLast();
        Score secondLast = scores.getLast();
        for (int i = 2; i < scores.size(); i++) {
            secondLast = last.sum(secondLast);
        }
        scores.push(last);
        scores.removeFirst();

//        System.out.println("            : " + score);
        System.out.println("scores      : " + scores);

        return last;


//        scores = states.stream()
//                .map(State::getScore)
//                .collect(toCollection(LinkedList::new));
//
//        if (getCurrent().isFinished()) {
//            Score first = scores.getFirst();
//            reversedScores.add(first);
//            return first;
//        }
//        Score score = scores.stream()
//                .reduce(Score::sum)
//                .orElseThrow(IllegalArgumentException::new);
//        reversedScores.add(score);
//        Collections.reverse(reversedScores);
//
//        return reversedScores.get(0);

//        if (calculatedScore.isEnd()) {
//            System.out.println("remove element: " + states.peekLast() + ", size: " + states.size());
//            states.removeLast();
//        }
//        return calculatedScore;
    }

    private Score test() {
        return states.stream()
                .map(State::getScore)
                .reduce(Score::sum)
                .orElseThrow(IllegalArgumentException::new);
    }

    private Frame getCurrent() {
        int lastIndex = frames.size() - ONE;
        return frames.get(lastIndex);
    }

    public Player getPlayer() {
        return Player.of(player);
    }

    public List<Frame> getFrames() {
        return new ArrayList<>(frames);
    }

    public int getSize() {
        return frames.size();
    }

    // 게임이 끝났는지 확인
    public boolean isDone() {
        return frames.size() == LAST_FRAME && getCurrent().isFinished();
    }

}
