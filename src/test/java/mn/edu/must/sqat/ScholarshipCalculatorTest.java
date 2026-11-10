
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    ScholarshipCalculator calculator = new ScholarshipCalculator();

    // Test 1: 95 оноо A дүн болох
    @Test
    void letterGrade_returnsA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    // Test 2: 85 оноо B дүн болох
    @Test
    void letterGrade_returnsB() {
        assertEquals("B", calculator.letterGrade(85));
    }

    // Test 3: 75 оноо C дүн болох
    @Test
    void letterGrade_returnsC() {
        assertEquals("C", calculator.letterGrade(75));
    }

    // Test 4: GPA зөв тооцоолох
    @Test
    void gpa_calculatesAverageCorrectly() {
        double[] scores = {95, 85};

        assertEquals(3.5, calculator.gpa(scores));
    }

    // Test 5: 100% тэтгэлэг олгох
    @Test
    void scholarship_returns100Percent() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }
}
