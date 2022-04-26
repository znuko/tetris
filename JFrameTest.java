import java.awt.*;
import javax.swing.*;

class JFrameTest extends JFrame {
JFrameTest() {
getContentPane().setLayout(new FlowLayout());
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("JFrameTest");
setSize(200, 100);
setVisible(true);
}
public static void main(String [] args) {
new JFrameTest();
}
}
