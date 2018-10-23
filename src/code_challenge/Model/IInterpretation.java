package code_challenge.Model;

/**
 * Represents an interpretation of an image.
 */
public interface IInterpretation {

  public void addUser(IUser user);

  public boolean sameText(String s);

  public String printText();

  public String printUsers();

}
