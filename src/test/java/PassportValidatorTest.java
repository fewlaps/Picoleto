import com.fewlaps.picoleto.validators.PassportValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PassportValidatorTest {

    @Test
    public void shouldReturnTrue_forAValidPassport() {
        String validPassport = "PMD339649B";

        assertTrue(PassportValidator.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidPassportWithoutEndLetter() {
        String validPassport = "QTI012687";

        assertTrue(PassportValidator.withDocument(validPassport).isValid());
    }
    @Test
    public void shouldReturnTrue_forAValidPassport_withLowerCase() {
        String validPassport = "pmd339649B";

        assertTrue(PassportValidator.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidPassportWithoutEndLetter_withLowerCase() {
        String validPassport = "qti012687";

        assertTrue(PassportValidator.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnFalse_forInvalidPassport() {
        String validPassport = "pm339649B";

        assertFalse(PassportValidator.withDocument(validPassport).isValid());
    }


    @Test
    public void shouldReturnFalse_forInvalidPassportWithoutEndLetter() {
        String validPassport = "qt012687";

        assertFalse(PassportValidator.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnFalse_forANullPassport() {
        String validPassport = null;

        assertFalse(PassportValidator.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnTrue_forAnEmptyPassport() {
        String validPassport = "";

        assertFalse(PassportValidator.withDocument(validPassport).isValid());
    }

}
