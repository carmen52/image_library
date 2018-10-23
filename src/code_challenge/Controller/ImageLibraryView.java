package code_challenge.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  // Using Frame class in package java.awt
import java.util.ArrayList;

public class ImageLibraryView extends Frame {
  // private variables
  private JLabel label = new JLabel("");
  private JFrame frame = new JFrame();
  private IImageLibraryController controller;

  // Constructor to setup the GUI components
  public ImageLibraryView() {
    this.controller = new ImageLibraryController();
    JPanel panel = new JPanel();

    // add drawings for testing
    controller.addDrawing("lines.jpg", "Three lines.");
    controller.addDrawing("lines2.jpg", "Four lines.");
    controller.addDrawing("lines3.jpg", "Five lines.");

    // add User Button
    JButton addUserButton = new JButton("Change User");
    JLabel userLabel = new JLabel("");

    // add text field
    JTextField textField = new JTextField(20);

    // the panel with the button and text
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(userLabel);
    panel.add(textField);
    panel.add(addUserButton);

    // add user button action
    addUserButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        String getValue = textField.getText();
        controller.onChangeUserClick(getValue);
        userLabel.setText(getValue);
      }
    });

    // for each drawing
    ArrayList<String> drawings = controller.getDrawings();
    for (int i = 0; i < drawings.size(); i ++) {
      String d = drawings.get(i);
      int j = i;

       JLabel label = new JLabel(d);
       panel.add(label);

       String sub = controller.getSubmissions(i);
       JLabel submissions = new JLabel(sub);
       panel.add(submissions);


      // add text field
      JTextField interpretationField = new JTextField(20);
      panel.add(interpretationField);

      // add Interpretation Button
      JButton addInterpretationButton = new JButton("Add Interpretation");
      addInterpretationButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
          String getValue = interpretationField.getText();
          controller.addInterpretation(getValue, j);
          frame.revalidate();
        }
      });
      panel.add(addInterpretationButton);

    }

    // set up the frame and display it
    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Image Library");
    frame.pack();
    frame.setVisible(true);
  }

  // The entry main() method
  public static void main(String[] args) {
    // Invoke the constructor (to setup the GUI) by allocating an instance
    new ImageLibraryView();
  }

}
