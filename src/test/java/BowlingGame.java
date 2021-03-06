import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> scores = new ArrayList<>();
    public int scoring() {
        int totalScore = 0;
        int rollIndex = 0;
        for (int round = 0; round < 10; round++) {
            if (isStrike(rollIndex)){
                totalScore += (10+getStrikeBonus(rollIndex));
                rollIndex++;
            }else if (isSpare(rollIndex)){
                totalScore += 10+getSpareBonus(rollIndex);
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

    private boolean isSpare(int rollIndex){
        return (scores.get(rollIndex) + scores.get(rollIndex+1)) >=10;
    }

    private boolean isStrike(int rollIndex){
        return scores.get(rollIndex) == 10;
    }

    private int getSpareBonus(int rollIndex){
        return scores.get(rollIndex+2);
    }

    private int getStrikeBonus(int rollIndex){
        return scores.get(rollIndex+1)+scores.get(rollIndex+2);
    }
}
