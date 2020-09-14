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
        rolls(0);
        int score = bowlingGame.scoring();
        assertEquals(score,0);
    }

    @Test
    void should_sum_all_rolls_when_scoring_given_every_roll_is_common_as_3(){
        rolls(3);
        assertEquals(bowlingGame.scoring(),60);
    }

    @Test
    void should_involve_spare_bonus_when_scoring_given_one_spare_occurs(){
        bowlingGame.roll(6);
        bowlingGame.roll(4);
        rolls(3,18);
        assertEquals(bowlingGame.scoring(),67);
    }

    @Test
    void should_involve_strike_bonus_when_scoring_given_one_strike_occurs(){
        bowlingGame.roll(10);
        rolls(3,18);
        assertEquals(bowlingGame.scoring(),70);
    }

    @Test
    void should_sum_all_strike_bonus_when_scoring_given_every_round_is_strike(){
        rolls(10,12);
        assertEquals(bowlingGame.scoring(),300);
    }

    private void rolls(int score){
        for (int rollIndex = 0; rollIndex < 20; rollIndex++) {
            bowlingGame.roll(score);
        }
    }

    private void rolls(int score,int times){
        for (int rollIndex = 0; rollIndex < times; rollIndex++) {
            bowlingGame.roll(score);
        }
    }
}
