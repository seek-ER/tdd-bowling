import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    private BowlingGame bowlingGame;
    @BeforeEach
    void resetGame(){
        bowlingGame = new BowlingGame();
    }

    @Test
    void should_return_0_when_scoring_given_every_roll_is_0(){
        for (int rollIndex = 0; rollIndex<20;rollIndex++){
            bowlingGame.roll(0);
        }
        int score = bowlingGame.scoring();
        assertEquals(score,0);
    }

    @Test
    void should_sum_all_rolls_when_scoring_given_every_roll_is_common_as_3(){
        for (int rollIndex = 0; rollIndex < 20; rollIndex++) {
            bowlingGame.roll(3);
        }
        assertEquals(bowlingGame.scoring(),60);
    }
}
