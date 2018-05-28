import  com.fewlaps.picoleto.validators.NIFValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class NIFValidatorTest {

    @Test
    public void shouldReturnTrue_forAValidNIF() {
        String validNIF = "71573454F";

        assertTrue(NIFValidator.withDocument(validNIF).isValid());
    }

    @Test
    public void shouldReturnFalse_forANotValidNIF() {
        String wrongNIF = "17573454F";

        assertFalse(NIFValidator.withDocument(wrongNIF).isValid());
    }

    @Test
    public void shouldReturnFalse_forAnEmptyString() {
        String emptyNIF = "";

        assertFalse(NIFValidator.withDocument(emptyNIF).isValid());
    }

    @Test
    public void shouldReturnFalse_forANullString() {
        String nullNIF = null;

        assertFalse(NIFValidator.withDocument(nullNIF).isValid());
    }
}
