import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class MyFrame extends JFrame {
	private MyPanel panel;
	
    public MyPanel getPanel() {
		return panel;
	}

	public MyFrame() {
        super("BALL");
        panel = new MyPanel();
        add(panel); 
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
	public static void main(String[] args) throws InterruptedException {
		new MyFrame().getPanel().dzialaj();
	}
}