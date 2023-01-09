package schwarz.it.lws.misc.palindrom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schwarz.it.lws.misc.palindrom.Palindrom;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromTest {
    Palindrom palindrom;

    @BeforeEach
    void setUp() {
        palindrom = new Palindrom();
    }

    @Test
    void is_lagerregal_a_palindrom() {
        // given
        String text = "lagerregal";

        // when
        boolean isPalindrom = palindrom.isPalindrom(text);

        // then
        assertThat(isPalindrom).isTrue();
    }
}
