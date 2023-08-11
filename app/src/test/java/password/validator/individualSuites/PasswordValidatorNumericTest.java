package password.validator.individualSuites;

import org.junit.Test;
import org.junit.Assert;

public class PasswordValidatorNumericTest extends BaseTest {

    @Test
    public void TestPasswordNumeric2Characters() {
        Assert.assertEquals(true, pw.validate2numerics("12password"));
        Assert.assertEquals(0, pw.errorMessages.size());
    }

    @Test
    public void TestPasswordNumeric3Characters() {
        Assert.assertEquals(true, pw.validate2numerics("123password"));
        Assert.assertEquals(0, pw.errorMessages.size());
    }

    @Test
    public void TestPasswordNumeric1Character() {
        Assert.assertEquals(false, pw.validate2numerics("1password"));
        Assert.assertEquals(1, pw.errorMessages.size());
        Assert.assertEquals("The password must contain at least 2 numbers", pw.errorMessages.get(0));
    }
}
