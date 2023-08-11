package password.validator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class PasswordValidatorTest {
  private PasswordValidator pw;
  @Before
  public void setup() {
    pw = new PasswordValidator();
  }

  @Test public void TestInitialization() {
    Assert.assertNotNull(pw.errorMessages);
    Assert.assertEquals(0, pw.errorMessages.size());
  }

  @Test public void TestPasswordLengthLongerThan8Characters() {
    Assert.assertEquals(true, pw.validateLength("morethan8"));
  }

  @Test(expected = IllegalArgumentException.class) public void TestException(){
    pw.exceptionThrower(1);
  }

  @Test public void TestPasswordLengthEqualTo8Characters() {
    Assert.assertEquals(true, pw.validateLength("morethan"));
  }

  @Test public void TestPasswordLengthLessThan8Characters() {
    Assert.assertEquals(false, pw.validateLength("mrethan"));
  }

  @Test public void TestPasswordErrorMessageWithEnoughCharacterLength() {
    pw.validateLength("morethan8");
    Assert.assertEquals(0, pw.errorMessages.size());
  }

  @Test public void TestPasswordErrorMessageWithNotEnoughCharacterLength() {
    pw.validateLength("moretha");
    Assert.assertEquals(1, pw.errorMessages.size());
    Assert.assertEquals("Password must be at least 8 characters", pw.errorMessages.get(0));
  }

  @Test public void TestPasswordNumeric2Characters() {
    Assert.assertEquals(true, pw.validate2numerics("12password"));
    Assert.assertEquals(0, pw.errorMessages.size());
  }

  @Test public void TestPasswordNumeric3Characters() {
    Assert.assertEquals(true, pw.validate2numerics("123password"));
    Assert.assertEquals(0, pw.errorMessages.size());
  }

  @Test public void TestPasswordNumeric1Character() {
    Assert.assertEquals(false, pw.validate2numerics("1password"));
    Assert.assertEquals(1, pw.errorMessages.size());
    Assert.assertEquals("The password must contain at least 2 numbers", pw.errorMessages.get(0));
  }

  @Test public void TestCapitalLetterExists() {
    Assert.assertEquals(true, pw.validateCapitals("Password"));
    Assert.assertEquals(0, pw.errorMessages.size());
  }

  @Test public void TestCapitalLetterDoesNotExist() {
    Assert.assertEquals(false, pw.validateCapitals("pass@1word"));
    Assert.assertEquals(1, pw.errorMessages.size());
    Assert.assertEquals("The password must contain at least one capital letter.", pw.errorMessages.get(0));
  }

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
