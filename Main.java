import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

public class Main {
  public static void main(String[] args)
  {
    //Setting the frame and labels
    Frame f = new Frame("Tetris");
    f.setLayout(new FlowLayout());
    f.setSize(200, 200);
    Label l = new Label();
    l.setText("This is a Game");
    f.add(l);
    f.setVisible(true);
    
    //Creating and adding the key listener
    GameControler k = new GameControler();
    f.addKeyListener(k);
  }
}
