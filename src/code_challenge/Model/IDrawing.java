package code_challenge.Model;

/**
 * Represents a drawing consisting of an image.
 */
public interface IDrawing {

  /**
   * Adds the given user and interpretation to this drawings submissions.
   * @param user the user who submits this interpretation
   * @param interpretation the users interpretation of this image
   */
  public void addInterpretation(IUser user, String s);

  /**
   * Prints out the submissions for this drawing.
   * @return String list of submissions.
   */
  public String printSubmissions();

  public String printDescription();
}
