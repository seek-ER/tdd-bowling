import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> scores = new ArrayList<>();
    public int scoring() {
        return scores.stream().mapToInt(number -> number).sum();
    }

    public void roll(int score) {
        scores.add(score);
    }
}
