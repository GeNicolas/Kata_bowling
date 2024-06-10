import com.fft.facturation.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class KataBowlingTest {

    private Game game = new Game();

    @Test
    void roll_8_pins_score_should_retunr_8() {
        game.roll(8);
        int score = game.score();

        Assertions.assertThat(score).isEqualTo(8);
    }

    @Test
    void roll_two_times_8_pins_then_2_down_score_should_return_10_for_one_frame() {
        game.roll(8);
        game.roll(2);

        int score = game.score();

        Assertions.assertThat(score).isEqualTo(10);
    }

    @Test
    void for_two_frames_roll_4_times_scrore_should_return() {
        // Frame 1
        game.roll(2);
        game.roll(6);

        // Frame 2
        game.roll(2);
        game.roll(4);

        int score = game.score();

        Assertions.assertThat(score).isEqualTo(14);
    }

    @Test
    void for_two_frames_strike_frame_1_and_frame_2_2_pins_then_2_pins_() {
        // Frame 1
        game.roll(10);

        // Frame 2
        game.roll(2);
        game.roll(2);

        int score = game.score();

        Assertions.assertThat(score).isEqualTo(18);
    }

    @Test
    void for_two_frames_spare_frame_1_and_frame_2_2_pins_then_2_pins() {
        // Frame 1
        game.roll(8);
        game.roll(2);

        // Frame 2
        game.roll(2);
        game.roll(5);

        int score = game.score();

        Assertions.assertThat(score).isEqualTo(19);
    }

    @Test
    void testTenthFrame_is_a_strike() {
        // Frame 1
        game.roll(1);
        game.roll(1);

        // Frame 2
        game.roll(1);
        game.roll(1);

        // Frame 3
        game.roll(1);
        game.roll(1);

        // Frame 4
        game.roll(1);
        game.roll(1);

        // Frame 5
        game.roll(1);
        game.roll(1);

        // Frame 6
        game.roll(1);
        game.roll(1);

        // Frame 7
        game.roll(1);
        game.roll(1);

        // Frame 8
        game.roll(1);
        game.roll(1);

        // Frame 9
        game.roll(1);
        game.roll(1);

        // Frame 10
        game.roll(10);

        //ExtraRoll
        game.roll(5);

        int score = game.score();

        Assertions.assertThat(score).isEqualTo(33);
    }

    @Test
    void testTenthFrame_is_a_spare() {
        // Frame 1
        game.roll(1);
        game.roll(1);

        // Frame 2
        game.roll(1);
        game.roll(1);

        // Frame 3
        game.roll(1);
        game.roll(1);

        // Frame 4
        game.roll(1);
        game.roll(1);

        // Frame 5
        game.roll(1);
        game.roll(1);

        // Frame 6
        game.roll(1);
        game.roll(1);

        // Frame 7
        game.roll(1);
        game.roll(1);

        // Frame 8
        game.roll(1);
        game.roll(1);

        // Frame 9
        game.roll(1);
        game.roll(1);

        // Frame 10
        game.roll(5);
        game.roll(5);

        //ExtraRoll
        game.roll(5);

        int score = game.score();

        Assertions.assertThat(score).isEqualTo(33);
    }

    @Test
    void test_not_roll_take_in_account_after_frame_ten() {
        // Frame 1
        game.roll(1);
        game.roll(1);

        // Frame 2
        game.roll(1);
        game.roll(1);

        // Frame 3
        game.roll(1);
        game.roll(1);

        // Frame 4
        game.roll(1);
        game.roll(1);

        // Frame 5
        game.roll(1);
        game.roll(1);

        // Frame 6
        game.roll(1);
        game.roll(1);

        // Frame 7
        game.roll(1);
        game.roll(1);

        // Frame 8
        game.roll(1);
        game.roll(1);

        // Frame 9
        game.roll(1);
        game.roll(1);

        // Frame 10
        game.roll(2);
        game.roll(5);

        //ExtraRoll
        game.roll(5);

        int score = game.score();

        Assertions.assertThat(score).isEqualTo(25);
    }


}
