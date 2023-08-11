package password.validator.individualSuites;

import org.junit.Test;
import org.junit.Assert;

public class PasswordValidatorSpecialCharactersTest extends BaseTest{

    @Test public void Test1SpecialCharacter() {
        Assert.assertEquals(true, pw.validateSpecialCharacters("@password"));
        Assert.assertEquals(0, pw.errorMessages.size());
    }

    @Test public void TestMultipleSpecialCharacters() {
        Assert.assertEquals(true, pw.validateSpecialCharacters("$p[a]ss_word"));
        Assert.assertEquals(0, pw.errorMessages.size());
    }

    @Test public void TestNoSpecialCharacters() {
        Assert.assertEquals(false, pw.validateSpecialCharacters("1Password"));
        Assert.assertEquals(1, pw.errorMessages.size());
        Assert.assertEquals("Password must contain at least one special character.", pw.errorMessages.get(0));
    }
}
