package password.validator;
import java.util.ArrayList;

public class PasswordValidator {
  public ArrayList<String> errorMessages;
  
  
  public PasswordValidator() {
    this.errorMessages = new ArrayList<>();
  }

  public Boolean validate(String input) {
    Boolean length = this.validateLength(input);
    Boolean capitals = this.validateCapitals(input);
    Boolean numerics = this.validate2numerics(input);
    Boolean characters = this.validateSpecialCharacters(input);
    return length && capitals && numerics && characters;
  }

  public Boolean exceptionThrower(int input) {
    if (input < 500) {
      throw new IllegalArgumentException();
    } else {
      return true;
    }
  }

  public String getError() {
    String result = "";
    if (this.errorMessages.isEmpty()) {
      return result;
    }
    return String.join("\n", this.errorMessages);
  }

  public Boolean validateLength(String input) {
    if (input.length() >= 8) { 
      return true;
    } else {
      this.errorMessages.add("Password must be at least 8 characters");
      return false;
    }
  }

  public Boolean validateCapitals(String input) {
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (Character.isAlphabetic(c)) {
        String stringC = String.valueOf(c);
        if (stringC == stringC.toUpperCase()) {
          return true;
        }
      };
    }
    this.errorMessages.add("The password must contain at least one capital letter.");
    return false;
  }

  public Boolean validate2numerics(String input) {
    String digits = "1234567890";
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (digits.contains(String.valueOf(input.charAt(i)))) {
        count += 1;
      }
    }
    if (count >= 2) {
      return true;
    } else {
      this.errorMessages.add("The password must contain at least 2 numbers");
      return false;
    }
  }

  public Boolean validateSpecialCharacters(String input) {
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (!Character.isLetterOrDigit(c)) {
        count += 1;
      }
    };
    if (count > 0) {
      return true;
    } else {
      this.errorMessages.add("Password must contain at least one special character.");
      return false;
    }
  }
}
