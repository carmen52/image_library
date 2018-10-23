package code_challenge.Model;

/**
 * Represents a user.
 */
public class User implements IUser {
  private String username;

  public User(String u) {
    if (u == null) {
      throw new IllegalArgumentException("Username cannot be null");
    }
    this.username = u;
  }

  @Override
  public String printUsername() {
    String s = username;
    return s;
  }
}
