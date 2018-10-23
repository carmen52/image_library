package code_challenge.Model;

import java.util.ArrayList;

public class Interpretation implements IInterpretation{
  private String text;
  private ArrayList<IUser> users;

  Interpretation(String text, IUser user) {
    if (text == null) {
      throw new IllegalArgumentException("Interpretation cannot be null");
    }

    if (user == null) {
      throw new IllegalArgumentException("User cannot be null");
    }
    this.text = text;
    users = new ArrayList<>();
    users.add(user);
  }

  @Override
  public void addUser(IUser user) {
    users.add(user);
  }

  @Override
  public boolean sameText(String s) {
    return s.equals(this.text);
  }

  @Override
  public String printText() {
    String s = this.text;
    return s;
  }

  @Override
  public String printUsers() {
    StringBuilder result = new StringBuilder();
    if (this.users != null && this.users.size() > 0) {
      result.append(this.users.get(0).printUsername());
      if (this.users.size() > 1) {
        result.append(", ");
        result.append(this.users.get(1).printUsername());
      }
      if (this.users.size() > 2) {
        result.append(", and ");
        result.append(Integer.toString(this.users.size() - 2));
        result.append(" others.");
      }

    }
    return result.toString();
  }

}
