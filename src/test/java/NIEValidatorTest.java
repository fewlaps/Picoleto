import com.fewlaps.picoleto.validators.NIEValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class NIEValidatorTest {

    @Test
    public void shouldReturnTrue_forAValidNIE() {
        String validNIE = "Y6928050G";

        assertTrue(NIEValidator.withDocument(validNIE).isValid());
    }

    @Test
    public void shouldReturnFalse_forANotValidNIE() {
        String validNIE = "Y9628050G";

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
