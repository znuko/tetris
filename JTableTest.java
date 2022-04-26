import java.awt.*;
import javax.swing.*;

class JTableTest extends JFrame {
	JTableTest() {
		getContentPane().setLayout(new FlowLayout());

		JTable tb = new JTable(10, 5);
		tb.setValueAt("AAA", 0, 0);
		tb.setValueAt("BBB", 1, 1);
		tb.setValueAt("CCC", 2, 2);

		JScrollPane sp = new JScrollPane(tb);
		// sp.setPreferredSize(new Dimension(230, 80));
		getContentPane().add(sp);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JTableTest");
		// setSize(250, 120);
		setSize(500, 200);
		setVisible(true);

		tb.setValueAt("hoge", 1, 2);
	}
	public static void main(String[] args) {
		new JTableTest();
	}
}
