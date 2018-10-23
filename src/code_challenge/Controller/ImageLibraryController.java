package code_challenge.Controller;

import java.util.ArrayList;

import code_challenge.Model.IImageLibraryModel;
import code_challenge.Model.IUser;
import code_challenge.Model.ImageLibraryModel;
import code_challenge.Model.User;

public class ImageLibraryController implements IImageLibraryController {
  private IImageLibraryModel model;
  private IUser currentUser;

  ImageLibraryController() {
    this.model = new ImageLibraryModel();
  }


  @Override
  public void onChangeUserClick(String username) {
    this.currentUser = new User(username);
  }

  @Override
  public ArrayList<String> getDrawings() {
    return model.getDrawings();
  }

  @Override
  public void addDrawing(String description, String url) {
    this.model.addDrawing(url, description);
  }

  @Override
  public void addInterpretation(String text, int index) {
    this.model.addSubmission(index, text, this.currentUser);
  }

  @Override
  public String getSubmissions(int index) {
    return this.model.getSubmissions(index);
  }
}
