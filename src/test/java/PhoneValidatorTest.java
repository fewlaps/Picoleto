import com.fewlaps.picoleto.validators.PhoneValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PhoneValidatorTest {

    @Test
    public void shouldReturnTrue_forAValidMobilePhoneNumber() {
        String validMobileNumber = "616333383";

        assertTrue(PhoneValidator.withPhone(validMobileNumber).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidLineLanePhoneNumber() {
        String validLaneLaneNumber = "915146000";

        assertTrue(PhoneValidator.withPhone(validLaneLaneNumber).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidLineLanePhoneNumberWithPlusPrefix() {
        String validLaneLaneNumber = "+34915146000";

        assertTrue(PhoneValidator.withPhone(validLaneLaneNumber).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidLineLanePhoneNumberWithDoubleZeroPrefix() {
        String validLaneLaneNumber = "0034915146000";

        assertTrue(PhoneValidator.withPhone(validLaneLaneNumber).isValid());
    }

    @Test
    public void shouldReturnFalse_forANotValidPhoneNumber() {
        String notValidPhoneNumber = "111222333";

        assertFalse(PhoneValidator.withPhone(notValidPhoneNumber).isValid());
    }

    @Test
    public void shouldReturnTrue_forAMobilePhoneNumber() {
        String validMobileNumber = "616333383";

        assertTrue(PhoneValidator.withPhone(validMobileNumber).isMobileLine());
    }

    @Test
    public void shouldReturnTrue_forALineLanePhoneNumber() {
        String validLaneLaneNumber = "915146000";

        assertTrue(PhoneValidator.withPhone(validLaneLaneNumber).isLaneLine());
    }

    @Test
    public void shouldReturnFalse_forNullPhoneNumber() {
        String nullPhoneNumber = null;

        assertFalse(PhoneValidator.withPhone(nullPhoneNumber).isValid());
    }

    @Test
    public void shouldReturnFalse_foEmptyPhoneNumber() {
        String emptyPhoneNumber = "";

        assertFalse(PhoneValidator.withPhone(emptyPhoneNumber).isValid());
    }
}
