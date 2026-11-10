
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorCoverageTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    // letterGrade() - input validation

    @Test
    void letterGrade_throwsExceptionWhenScoreBelowZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(-1));
    }

    @Test
    void letterGrade_throwsExceptionWhenScoreAbove100() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(101));
    }

    // gpa() - input validation

    @Test
    void gpa_throwsExceptionWhenScoresAreNull() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
    }

    @Test
    void gpa_throwsExceptionWhenScoresAreEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{}));
    }

    // gpa() - all switch branches: A, B, C, D, F

    @Test
    void gpa_coversAllGradeBranches() {
        double[] scores = {95, 85, 75, 65, 50};

        assertEquals(2.0, calculator.gpa(scores), 0.0001);
    }

    // scholarship() - input validation

    @Test
    void scholarship_throwsExceptionWhenGpaBelowZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(-1, 15, false));
    }

    @Test
    void scholarship_throwsExceptionWhenGpaAboveFour() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 15, false));
    }

    @Test
    void scholarship_throwsExceptionWhenCreditsBelowZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(3.5, -1, false));
    }

    // scholarship() - hasViolation condition

    @Test
    void scholarship_returnsZeroWhenViolationExists() {
        assertEquals(0, calculator.scholarship(4.0, 20, true));
    }

    // scholarship() - 100 percent condition

    @Test
    void scholarship_returns70WhenCreditsBelow15() {
        assertEquals(70, calculator.scholarship(3.9, 14, false));
    }

    @Test
    void scholarship_returns70WhenGpaBelow38() {
        assertEquals(70, calculator.scholarship(3.7, 15, false));
    }

    // scholarship() - 70 percent condition

    @Test
    void scholarship_returns70Percent() {
        assertEquals(70, calculator.scholarship(3.5, 12, false));
    }

    @Test
    void scholarship_returns50WhenCreditsBelow12() {
        assertEquals(50, calculator.scholarship(3.5, 11, false));
    }

    @Test
    void scholarship_returns50WhenGpaBelow34() {
        assertEquals(50, calculator.scholarship(3.3, 12, false));
    }

    // scholarship() - 50 percent and zero percent

    @Test
    void scholarship_returns50Percent() {
        assertEquals(50, calculator.scholarship(3.0, 10, false));
    }

    @Test
    void scholarship_returnsZeroWhenGpaBelowThree() {
        assertEquals(0, calculator.scholarship(2.9, 15, false));
    }
}
