package password.validator.individualSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PasswordValidatorLengthTest.class,
        PasswordValidatorNumericTest.class,
        PasswordValidatorCapitalsTest.class,
        PasswordValidatorSpecialCharactersTest.class,
        PasswordValidatorCombinedTest.class
})
public class PasswordValidatorTestSuite {
}


