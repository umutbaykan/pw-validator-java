package password.validator.individualSuites;

import org.junit.Before;
import password.validator.PasswordValidator;

public class BaseTest {

    protected PasswordValidator pw;

    @Before
    public void setup() {
        pw = new PasswordValidator();
    }
}
