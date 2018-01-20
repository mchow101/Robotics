import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	
	public static void main(String args[]) {
		Font f = new Font(Font.SANS_SERIF, 3, 75);
		Font z = new Font(Font.SANS_SERIF, 3, 15);

		window.setLayout(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		buttonPanel.setLayout(new GridLayout(4, 2));
		buttonPanel.setSize(width, height - (height / 2));
		buttonPanel.setLocation(0, 200);
		
		robotPanel.setLayout(new GridLayout(1,6));
		robotPanel.setSize(width, height - ((height/4)*3));
		robotPanel.setLocation(0, 600);

		stats.setSize(width / 4, height / 4);
		stats.setText("Stats:");

		action.setSize((width - (width / 4) - 5), height / 4);
		action.setLocation((width / 4) + 5, 0);

		StyledDocument doc = action.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		action.setFont(f);
		action.setForeground(Color.green.darker());
		action.setText("Action successful!");

		window.setSize(width, height);
		window.add(action);
		window.add(buttonPanel);
		window.add(stats);
		window.add(robotPanel);

		for (int i = 0; i < 8; i++) {
			actionButtons[i] = new JButton("" + (i + 1));
			buttonPanel.add(actionButtons[i]);
			actionButtons[i].addActionListener(new playListener());
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

			}}
			
			for(int i = 0; i < 6; i++){
				robotButtons[i] = new JButton("Robot" + (i + 1));
				robotPanel.add(robotButtons[i]);
				robotButtons[i].addActionListener(new playListener());
				robotButtons[i].setFont(z);
				
				
				
				if(i < 3){
					robotButtons[i].setForeground(Color.red.darker());
				}else{
					robotButtons[i].setForeground(Color.blue.darker());
				}
			}
			

		
		window.setBackground(Color.blue);

	}

}

class playListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
