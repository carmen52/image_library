package code_challenge.Model;

import java.util.ArrayList;

import javax.imageio.IIOImage;

public class ImageLibraryModel implements IImageLibraryModel {
  private ArrayList<IUser> applicationUsers;
  private ArrayList<IDrawing> drawings;

  public ImageLibraryModel() {
    this.applicationUsers = new ArrayList<>();
    this.drawings = new ArrayList<>();
  }

  @Override
  public void addUser(String username) {
    this.applicationUsers.add(new User(username));
  }

  @Override
  public void addDrawing(String url, String description) {
    this.drawings.add(new Drawing(url, description));
  }

  @Override
  public void addSubmission(int drawingIndex, String text, IUser user) {
    IDrawing drawing = this.drawings.get(drawingIndex);
    drawing.addInterpretation(user, text);
  }

  @Override
  public String getSubmissions(int drawingIndex) {
    IDrawing drawing = this.drawings.get(drawingIndex);
    return drawing.printSubmissions();
  }

  @Override
  public ArrayList<String> getDrawings() {
    ArrayList<String> result = new ArrayList<>();
    for (IDrawing d : this.drawings) {
      String s = "";
      s = d.printDescription();
      s = s + "\n";
      s = s + d.printSubmissions();
      s = s + "\n";

      result.add(s);
    }
    return result;
  }
}
