package password.validator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import password.validator.individualSuites.PasswordValidatorNumericTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PasswordValidatorNumericTest.class
})
public class PasswordValidatorNumericTestSuite {
    // This class doesn't need any methods, it's just a marker for the suite.
}
