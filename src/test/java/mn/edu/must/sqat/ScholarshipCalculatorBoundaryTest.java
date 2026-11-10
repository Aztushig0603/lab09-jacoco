
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorBoundaryTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    @Test
    void letterGrade_60_returnsD() {
        assertEquals("D", calculator.letterGrade(60));
    }

    @Test
    void letterGrade_59_99_returnsF() {
        assertEquals("F", calculator.letterGrade(59.99));
    }

    @Test
    void letterGrade_69_99_returnsD() {
        assertEquals("D", calculator.letterGrade(69.99));
    }

    @Test
    void letterGrade_zero_returnsF() {
        assertEquals("F", calculator.letterGrade(0));
    }

    @Test
    void letterGrade_100_returnsA() {
        assertEquals("A", calculator.letterGrade(100));
    }

    @Test
    void letterGrade_89_99_returnsB() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    void letterGrade_90_returnsA() {
        assertEquals("A", calculator.letterGrade(90));
    }
}
