import com.fewlaps.picoleto.Picoleto;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PicoletoTest {

    @Test
    public void shouldReturnTrue_withAValidNIF() {
        String validNIF = "71573454F";

        assertTrue(Picoleto.withDocument(validNIF).isValid());
    }

    @Test
    public void shouldReturnFalse_withANotValidNIF() {
        String wrongNIF = "17573454F";

        assertFalse(Picoleto.withDocument(wrongNIF).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidNIE() {
        String validNIE = "Y6928050G";

        assertTrue(Picoleto.withDocument(validNIE).isValid());
    }

    @Test
    public void shouldReturnFalse_forANotValidNIE() {
        String wrongNIE = "Y9628050G";

        assertFalse(Picoleto.withDocument(wrongNIE).isValid());
    }

    @Test
    public void shouldReturnTypeNIF_forANIFDocument() {
        String validNIF = "71573454F";

        int documentType = Picoleto.withDocument(validNIF).getDocumentType();

        assertTrue(documentType == Picoleto.TYPE_NIF);
    }

    @Test
    public void shouldReturnFalse_forNullNIE() {
        String nullNIE = null;

        assertFalse(Picoleto.withDocument(nullNIE).isValid());
    }

    @Test
    public void shouldReturnFalse_forEmptyNIE() {
        String emptyNIE = "";

        assertFalse(Picoleto.withDocument(emptyNIE).isValid());
    }

    @Test
    public void shouldReturnFalse_forNullNIF() {
        String nullNIF = null;

        assertFalse(Picoleto.withDocument(nullNIF).isValid());
    }

    @Test
    public void shouldReturnFalse_forEmptyNIF() {
        String emptyNIF = "";

        assertFalse(Picoleto.withDocument(emptyNIF).isValid());
    }

    @Test
    public void shouldReturnTypeNIE_forANIEDocument() {
        String validNIE = "Y6928050G";

        int documentType = Picoleto.withDocument(validNIE).getDocumentType();

        assertTrue(documentType == Picoleto.TYPE_NIE);
    }

    @Test
    public void shouldReturnInvalidDocument_forNullDocument() {
        String document = null;

        int documentType = Picoleto.withDocument(document).getDocumentType();

        assertTrue(documentType == Picoleto.INVALID_DOCUMENT);
    }

    @Test
    public void shouldReturnInvalidDocument_forEmptyDocument() {
        String document = "";

        int documentType = Picoleto.withDocument(document).getDocumentType();

        assertTrue(documentType == Picoleto.INVALID_DOCUMENT);
    }

    @Test
    public void shouldReturnInvalidDocument_forCifDocument() {
        String validCif = "E33447392";

        int documentType = Picoleto.withDocument(validCif).getDocumentType();

        assertTrue(documentType == Picoleto.INVALID_DOCUMENT);
    }

    @Test
    public void shouldReturnTypePassport_forAPassportDocument() {
        String validPassport = "PMD339649B";

        int documentType = Picoleto.withDocument(validPassport).getDocumentType();

        assertTrue(documentType == Picoleto.TYPE_PASSPORT);
    }

    @Test
    public void shouldReturnTypePassport_forAPassportDocument_startsWithX() {
        String validPassport = "XMD339649B";

        int documentType = Picoleto.withDocument(validPassport).getDocumentType();

        assertTrue(documentType == Picoleto.TYPE_PASSPORT);
    }

    @Test
    public void shouldReturnTypePassport_forAPassportDocument_startsWithY() {
        String validPassport = "YMD339649B";

        int documentType = Picoleto.withDocument(validPassport).getDocumentType();

        assertTrue(documentType == Picoleto.TYPE_PASSPORT);
    }

    @Test
    public void shouldReturnTypePassport_forAPassportDocument_startsWithZ() {
        String validPassport = "ZMD339649B";

        int documentType = Picoleto.withDocument(validPassport).getDocumentType();

        assertTrue(documentType == Picoleto.TYPE_PASSPORT);
    }

    @Test
    public void shouldReturnTrue_forAValidPassport() {
        String validPassport = "PMD339649B";

        assertTrue(Picoleto.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidPassport_startsWithX() {
        String validPassport = "XMD339649B";

        assertTrue(Picoleto.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidPassport_startsWithY() {
        String validPassport = "YMD339649B";

        assertTrue(Picoleto.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnTrue_forAValidPassport_startsWithZ() {
        String validPassport = "ZMD339649B";

        assertTrue(Picoleto.withDocument(validPassport).isValid());
    }

    @Test
    public void shouldReturnFalse_forANotValidPassport() {
        String wrongPassport = "PM339649B";

        assertFalse(Picoleto.withDocument(wrongPassport).isValid());
    }
}