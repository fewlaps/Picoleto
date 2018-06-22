import com.fewlaps.picoleto.validators.ZipCodeValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ZipCodeValidatorTest {

    @Test
    public void shouldReturnTrue_forAValidZipCode() {
        String validZipCode="52120";

        assertTrue(ZipCodeValidator.withZipCode(validZipCode).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidZipCode2() {
        String validZipCode="17750";

        assertTrue(ZipCodeValidator.withZipCode(validZipCode).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidZipCode3() {
        String validZipCode="08240";

        assertTrue(ZipCodeValidator.withZipCode(validZipCode).isValid());
    }

    @Test
    public void shouldReturnFalse_forInvalidZipCode() {
        String invalidZipCode="53700";

        assertFalse(ZipCodeValidator.withZipCode(invalidZipCode).isValid());
    }

    @Test
    public void shouldReturnFalse_forInvalidZipCode2() {
        String invalidZipCode="60700";

        assertFalse(ZipCodeValidator.withZipCode(invalidZipCode).isValid());
    }

    @Test
    public void shouldReturnFalse_forInvalidZipCode3() {
        String invalidZipCode="177502";

        assertFalse(ZipCodeValidator.withZipCode(invalidZipCode).isValid());
    }

    @Test
    public void shouldReturnFalse_forNullZipCode() {
        String invalidZipCode=null;

        assertFalse(ZipCodeValidator.withZipCode(invalidZipCode).isValid());
    }

    @Test
    public void shouldReturnFalse_forEmptyZipCode() {
        String invalidZipCode="";

        assertFalse(ZipCodeValidator.withZipCode(invalidZipCode).isValid());
    }
}

