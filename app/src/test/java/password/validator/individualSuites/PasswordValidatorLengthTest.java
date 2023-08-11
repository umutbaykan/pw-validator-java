package password.validator.individualSuites;

import org.junit.Test;
import org.junit.Assert;

public class PasswordValidatorLengthTest extends BaseTest {

    @Test public void TestPasswordLengthLongerThan8Characters() {
        Assert.assertEquals(true, pw.validateLength("morethan8"));
    }

    @Test public void TestPasswordLengthEqualTo8Characters() {
        Assert.assertEquals(true, pw.validateLength("morethan"));
    }

    @Test public void TestPasswordLengthLessThan8Characters() {
        Assert.assertEquals(false, pw.validateLength("mrethan"));
    }
}
