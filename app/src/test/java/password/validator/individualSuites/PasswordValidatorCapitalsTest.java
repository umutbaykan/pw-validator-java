package password.validator.individualSuites;

import org.junit.Test;
import org.junit.Assert;

public class PasswordValidatorCapitalsTest extends BaseTest {
    @Test public void TestCapitalLetterExists() {
        Assert.assertEquals(true, pw.validateCapitals("Password"));
        Assert.assertEquals(0, pw.errorMessages.size());
    }

    @Test public void TestCapitalLetterDoesNotExist() {
        Assert.assertEquals(false, pw.validateCapitals("pass@1word"));
        Assert.assertEquals(1, pw.errorMessages.size());
        Assert.assertEquals("The password must contain at least one capital letter.", pw.errorMessages.get(0));
    }

}
