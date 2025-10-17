import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private final StringCalculatorTDD testCalculator = new StringCalculator();

    @Test
    void testEmptyStringReturnsZero() {
        assertEquals(0, testCalculator.add(""));
    }

    @Test
    void testSingleNumberReturnsValue() {
        assertEquals(1, testCalculator.add("1"));
    }

    @Test
    void testTwoNumbersCommaSeparated() {
        assertEquals(6, testCalculator.add("1,5"));
    }

    @Test
    void testMultipleNumbers() {
        assertEquals(10, testCalculator.add("1,2,3,4"));
    }

    @Test
    void testNewLineAsDelimiter() {
        assertEquals(6, testCalculator.add("1\n2,3"));
    }

    @Test
    void testCustomDelimiter() {
        assertEquals(3, testCalculator.add("//;\n1;2"));
    }

    @Test
    void testNegativeNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testCalculator.add("1,-2,3"));
        assertTrue(exception.getMessage().contains("negative numbers not allowed"));
        assertTrue(exception.getMessage().contains("-2"));
    }

    @Test
    void testMultipleNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.add("-1,-2,3"));
        assertEquals("negative numbers not allowed: -1, -2", exception.getMessage());
    }
}
