package schwarz.it.lws.misc.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    @Disabled("Calc 5 + 5 = 10")
    void calc5plus5is10() {
        int opA = 5;
        int opB = 5;

        int result = calculator.add(opA, opB);

        assertThat(result).isEqualTo(10);
    }
}