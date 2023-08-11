package password.validator.individualSuites;

import org.junit.Test;
import org.junit.Assert;

public class PasswordValidatorCombinedTest extends BaseTest{

    @Test public void TestAllConditionsMet() {
        Assert.assertEquals(true, pw.validate("Password12!"));
        Assert.assertEquals(0, pw.errorMessages.size());
    }

    @Test public void TestLengthWhenNoConditionsAreMet() {
        Assert.assertEquals(false, pw.validate("noskf"));
        Assert.assertEquals(4, pw.errorMessages.size());
    }

    @Test public void TestLengthWhenCapitalAndNumericsAreMet() {
        Assert.assertEquals(false, pw.validate("No12"));
        Assert.assertEquals(2, pw.errorMessages.size());
    }

    @Test public void TestMessageContentWhenConditionsAreMet() {
        Assert.assertEquals("", pw.getError());
    }

    @Test public void TestMessageContentWhenOnlyLengthNotMet() {
        pw.validate("No12@");
        Assert.assertEquals("Password must be at least 8 characters", pw.getError());
    }

    @Test public void TestMessageContentWhenNoConditionsAreMet() {
        pw.validate("abc");
        String error = "Password must be at least 8 characters\nThe password must contain at least one capital letter.\nThe password must contain at least 2 numbers\nPassword must contain at least one special character.";
        Assert.assertEquals(error, pw.getError());
    }
}
