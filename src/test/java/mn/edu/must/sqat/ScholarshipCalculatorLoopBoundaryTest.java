
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorLoopBoundaryTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    // Zero iterations: empty array

    @Test
    void gpa_emptyArray_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{}));
    }

    // Null input

    @Test
    void gpa_nullArray_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
    }

    // One iteration

    @Test
    void gpa_singleScore_returnsFour() {
        assertEquals(4.0,
                calculator.gpa(new double[]{95}),
                0.0001);
    }

    // Two or more iterations

    @Test
    void gpa_multipleScores_calculatesCorrectAverage() {
        double[] scores = {95, 85, 75, 65};

        assertEquals(2.5,
                calculator.gpa(scores),
                0.0001);
    }
}

