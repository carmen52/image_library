package code_challenge.Controller;

import java.util.ArrayList;

public interface IImageLibraryController {
  public void onChangeUserClick(String username);

  public ArrayList<String> getDrawings();

  public void addDrawing(String description, String url);

  public void addInterpretation(String text, int index);

  public String getSubmissions(int index);
}
