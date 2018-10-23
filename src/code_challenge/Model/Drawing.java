package code_challenge.Model;

import java.util.ArrayList;

/**
 * Represents a drawing consisting of an image url and a text description.
 */
public class Drawing implements IDrawing {
  private String image_url;
  private String description;
  private ArrayList<IInterpretation> submissions;

  /**
   * Constructs a drawing with a given image_url and description.
   * @param image_url the url of the drawing
   * @param description the description of the drawing
   * @throws IllegalArgumentException if either parameter is null
   */
  Drawing(String image_url, String description) {
    if (image_url == null) {
      throw new IllegalArgumentException("Image url cannot be null");
    }
    if (description == null) {
      throw new IllegalArgumentException("Image description cannot be null");
    }
    this.image_url = image_url;
    this.description = description;
    this.submissions = new ArrayList<>();
  }

  @Override
  public void addInterpretation(IUser user, String s) {
    boolean isAdded = false;

    // Check if interpretation already in submissions
    for (IInterpretation i : this.submissions) {
      if (i.sameText(s)) {
        if (!isAdded) {
          i.addUser(user);
          isAdded = true;
        }
      }
    }

    // if interpretation doesn't already exist, add in list
    if (!isAdded) {
      IInterpretation i = new Interpretation(s, user);
      this.submissions.add(i);
    }
  }

  @Override
  public String printSubmissions() {
    StringBuilder result = new StringBuilder();

    for (IInterpretation i : this.submissions) {
      result.append("Interpretation: ");
      result.append(i.printText());
      result.append("/n");
      result.append("Submitted by: ");
      result.append(i.printUsers());
      result.append("\n");
    }

    return result.toString();
  }

  @Override
  public String printDescription() {
    return this.image_url + ": " + this.description;
  }

}
