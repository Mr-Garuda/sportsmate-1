package sportsmate.menus;

import java.io.Console;
import java.util.Arrays;

public class RegisterMenu extends AbstractMenu {

  /**
   * Displays menu to register a new account.
   */
  @Override
  public String[] displayMenu() {
    String userFirstName;
    String userLastName;
    String userGender;

    getPrompt(getLineBreak(20) + "\nCreate a new account\n\n");

    getPrompt("Enter your first name: ");
    userFirstName = getScanner().nextLine();

    getPrompt("Enter your last name: ");
    userLastName = getScanner().nextLine();

    getPrompt("Enter your gender: ");
    userGender = getScanner().nextLine();

    Console console = System.console();
    if (console == null) {
      System.out.println("Couldn't get Console instance");
      System.exit(1);
    }

    String username = console.readLine("Enter a username: ");

    char[] passwordArray = console.readPassword("Enter your secret password: ");

    char[] passwordArrayConfirm = console.readPassword("Confirm your secret password: ");

    // Confirm passwords match
    while (!Arrays.equals(passwordArray, passwordArrayConfirm)) {
      getPrompt("\n" + getLineBreak(35) + "\nPASSWORDS DO NOT MATCH - TRY AGAIN!\n\n");
      passwordArray = console.readPassword("Enter your secret password: ");
      passwordArrayConfirm = console.readPassword("Confirm your secret password: ");
    }

    String[] str = {userFirstName, userLastName, username, userGender, new String(passwordArray)};

    // Immediately overwrite password array elements with a filler value.
    Arrays.fill(passwordArray, 'x');

    return str;
  }

}
