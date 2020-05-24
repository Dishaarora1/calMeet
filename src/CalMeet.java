import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalMeet extends JFrame implements ActionListener {

	JLabel describe;
	JLabel logo;
	JLabel calmeet;
	JButton started;
	JPanel logoclr;

	CalMeet() {
		setLayout(null);
		// setSize(600,600);
		setBounds(300, 100, 850, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font f = new Font("Times New Roman", Font.PLAIN, 20);
		Font f1 = new Font("consolas", Font.BOLD, 20);
		
		logoclr = new JPanel();
		logoclr.setLayout(null);
		logoclr.setBackground(Color.BLACK);
		logoclr.setBounds(0,0,850,65);
		add(logoclr);
		
		ImageIcon icon = new ImageIcon("src/icons/calmeet_logo2.png");
		logo = new JLabel(icon);
		logo.setBounds(330, 10, icon.getIconWidth(), icon.getIconHeight());
		logoclr.add(logo);

		calmeet = new JLabel("CalMeet");
		calmeet.setBounds(400, 10, 100, 50);
		calmeet.setForeground(Color.WHITE);
		logoclr.add(calmeet);
		calmeet.setFont(f1);

		describe = new JLabel("CalMeet helps you schedule meetings without the back-and-forth emails");
		describe.setBounds(130, 150, 700, 50);
		add(describe);
		describe.setFont(f);

		started = new JButton("Get Started For Free");
		started.setBounds(250, 250, 300, 40);
		add(started);
		started.setFont(f);
		started.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Signup.main(new String[] {});
		dispose();
	}

	public static void main(String[] args) {
		// FirstPage fp = new FirstPage();
		new CalMeet();
	}
}
