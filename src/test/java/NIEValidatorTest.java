import com.fewlaps.picoleto.validators.NIEValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class NIEValidatorTest {

    @Test
    public void shouldReturnTrue_forAValidNIEStartingWithX() {
        String validNIE = "X3923161M";

        assertTrue(NIEValidator.withDocument(validNIE).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidNIEStartingWithY() {
        String validNIE = "Y6928050G";

        assertTrue(NIEValidator.withDocument(validNIE).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidNIEStartingWithZ() {
        String validNIE = "Z4512648F";

        assertTrue(NIEValidator.withDocument(validNIE).isValid());
    }

    @Test
    public void shouldReturnFalse_forANotValidNIE() {
        String validNIE = "Y9628050G";

        assertFalse(NIEValidator.withDocument(validNIE).isValid());
    }

    @Test
    public void shouldReturnFalse_forANotValidFirstLetterNIE() {
        String validNIE = "B9628050G";

        assertFalse(NIEValidator.withDocument(validNIE).isValid());
    }

    @Test
    public void shouldReturnFalse_forNullNIE() {
        String nullNIE = null;

        assertFalse(NIEValidator.withDocument(nullNIE).isValid());
    }

    @Test
    public void shouldReturnFalse_forEmptyNIE() {
        String emptyNIE = "";

        assertFalse(NIEValidator.withDocument(emptyNIE).isValid());
    }
}
