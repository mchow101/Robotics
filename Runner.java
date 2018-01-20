import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Runner {

	static int width = 800;
	static int height = 800;
	static JFrame window = new JFrame("FRC PowerUp Simulation");
	static JButton[] actionButtons = new JButton[8];
	static JButton[] robotButtons = new JButton[6];
	static JPanel buttonPanel = new JPanel();
	static JPanel robotPanel = new JPanel();
	static JTextPane stats = new JTextPane();
	static JTextPane action = new JTextPane();
	static ArrayList<Robot> robots = new ArrayList<Robot>();
	static Font f = new Font(Font.SANS_SERIF, 3, 75);
	static Font z = new Font(Font.SANS_SERIF, 3, 15);
	static Font p = new Font(Font.SANS_SERIF, 3, 20);
	static Robot m;

	public static void main(String args[]) {

		for(int i = 0; i < 6; i++) {
			robots.add((new Robot("Robot" + (i + 1), (int) (Math.random() * 10) + 10, (int) 
					(Math.random() * 10) + 10, true, true)));
		}
		m = robots.get(0);
		window.setLayout(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		buttonPanel.setLayout(new GridLayout(4, 2));
		buttonPanel.setSize(width, height - (height / 2));
		buttonPanel.setLocation(0, 200);

		robotPanel.setLayout(new GridLayout(1, 6));
		robotPanel.setSize(width, height - ((height / 4) * 3));
		robotPanel.setLocation(0, 600);

		action.setSize((width - (width / 4) - 5), height / 4);
		action.setLocation((width / 4) + 5, 0);

		StyledDocument doc = action.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		for (int i = 0; i < 8; i++) {
			actionButtons[i] = new JButton("" + (i + 1));
			buttonPanel.add(actionButtons[i]);
			actionButtons[i].addActionListener(new playListener(i + 1));
			actionButtons[i].setFont(z);
			switch (i) {
			case 0:
				actionButtons[i].setText("Place Cube onto Switch");
				break;
			case 1:
				actionButtons[i].setText("Place Cube onto Scale");
				break;
			case 2:
				actionButtons[i].setText("Toss Cube onto Switch (Close)");
				break;
			case 3:
				actionButtons[i].setText("Toss Cube onto Scale (Close)");
				break;
			case 4:
				actionButtons[i].setText("Toss Cube onto Switch (Far)");
				break;
			case 5:
				actionButtons[i].setText("Toss Cube onto Scale (Far)");
				break;
			case 6:
				actionButtons[i].setText("Single Climb");
				break;
			case 7:
				actionButtons[i].setText("Dual Climb");
				break;

			}
		}

		for (int i = 0; i < 6; i++) {
			robotButtons[i] = new JButton(robots.get(i).getName());
			robotPanel.add(robotButtons[i]);
			robotButtons[i].addActionListener(new robotListener(i));
			robotButtons[i].setFont(z);

			if (i < 3) {
				robotButtons[i].setForeground(Color.red.darker().darker());
				robotButtons[i].setBackground(Color.red.brighter().brighter());
			} else {
				robotButtons[i].setForeground(Color.blue.darker().darker());
				robotButtons[i].setBackground(Color.blue.brighter().brighter());
			}
		}

		window.setSize(width, height);
		window.add(action);
		window.add(buttonPanel);
		window.add(stats);
		window.add(robotPanel);

		window.setBackground(Color.blue);

	}

}

class playListener implements ActionListener {
	private int i;
	public playListener(int i) {
		this.i = i;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Runner.action.setFont(Runner.f);
			System.out.println(i);
		if (Runner.m.returnProb(i)) {
			Runner.action.setBackground(Color.green.brighter());
			Runner.action.setForeground(Color.green.darker());
			Runner.action.setText("Action successful!");
		} else {
			Runner.action.setBackground(Color.red.brighter());
			Runner.action.setForeground(Color.red.darker());
			Runner.action.setText("Action\nfailed!");
		}
	}
}
	
class robotListener implements ActionListener {
	private int i;
	public robotListener(int i) {
		this.i = i;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Runner.action.setFont(Runner.f);
		Runner.m = Runner.robots.get(i);
		Runner.stats.setSize(Runner.width / 4, Runner.height / 4);
		Runner.stats.setFont(Runner.p);
		Runner.stats.setText(Runner.m.returnStats());
	}
}
