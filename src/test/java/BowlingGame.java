import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> scores = new ArrayList<>();
    public int scoring() {
        int totalScore = 0;
        int rollIndex = 0;
        for (int round = 0; round < 10; round++) {
            if (scores.get(rollIndex)+scores.get(rollIndex+1)>=10){
                totalScore += 10;
                totalScore += scores.get(rollIndex+2);
                rollIndex += 2;
            }else {
                totalScore += scores.get(rollIndex);
                totalScore += scores.get(rollIndex+1);
                rollIndex += 2;
            }
        }
        return totalScore;
    }

    public void roll(int score) {
        scores.add(score);
    }
}
