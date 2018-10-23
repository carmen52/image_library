package code_challenge.Model;

import java.util.ArrayList;

public interface IImageLibraryModel {
  public void addUser(String username);

  public void addDrawing(String url, String description);

  public void addSubmission(int drawingIndex, String text, IUser user);

  public String getSubmissions(int drawingIndex);

  public ArrayList<String> getDrawings();

}

