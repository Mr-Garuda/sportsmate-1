package sportsmate.menus;

import java.util.NoSuchElementException;

public class TeamMatchMenu extends AbstractMenu {

  /**
   * Displays Team Match menu.
   */
  @Override
  public String[] displayMenu() {
    getPrompt("\nEnter 1 to Create a Team"
        + "\nEnter 2 to Join a Team"
        + "\nEnter 3 Leave a Team"
        + "\nEnter 4 to List Teams I have created"
        + "\nEnter 5 to List Teams I have joined"
        + "\nEnter 6 to List All Teams"
        + "\nEnter 7 to go to previous menu"
        + "\nEnter 8 to Exit\n");
    try {
      do {
        System.out.printf("%n> ");
        selection = getScanner().next();
      } while ((!selection.equals("1")) && (!selection.equals("2")) && (!selection.equals("3")) &&
          (!selection.equals("4")) && (!selection.equals("5")) && (!selection.equals("6")));
    } catch (NoSuchElementException noSuchElementException) {
      System.err.println("Invalid input. Terminating.");
    }

    String[] str = {selection};
    return str;
  }
}
