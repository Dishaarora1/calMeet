import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {

	JLabel calmeet;
	JLabel logo;
	JPanel logoclr;
	JLabel emaillb;
	JLabel passlb;

	JTextField emailtf;
	JPasswordField passtf;

	JButton loginbtn;

	login() {
		setLayout(null);
		setBounds(300, 50, 550, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font f1 = new Font("Times New Roman", Font.PLAIN, 15);
		Font f2 = new Font("Times New Roman", Font.PLAIN, 20);
		Font f3 = new Font("consolas", Font.BOLD, 20);

		logoclr = new JPanel();
		logoclr.setLayout(null);
		logoclr.setBackground(Color.BLACK);
		logoclr.setBounds(0, 0, 550, 65);
		add(logoclr);

		ImageIcon icon = new ImageIcon("src/icons/calmeet_logo2.png");
		logo = new JLabel(icon);
		logo.setBounds(200, 10, icon.getIconWidth(), icon.getIconHeight());
		logoclr.add(logo);

		calmeet = new JLabel("CalMeet");
		calmeet.setBounds(270, 10, 100, 50);
		calmeet.setForeground(Color.WHITE);
		logoclr.add(calmeet);
		calmeet.setFont(f3);

		emaillb = new JLabel("Enter your Email");
		emaillb.setBounds(120, 140, 200, 30);
		add(emaillb);
		emaillb.setFont(f1);

		emailtf = new JTextField();
		emailtf.setBounds(120, 170, 300, 30);
		add(emailtf);
		emailtf.setFont(f1);

		passlb = new JLabel("Enter Password");
		passlb.setBounds(120, 200, 200, 30);
		add(passlb);
		passlb.setFont(f1);

		passtf = new JPasswordField();
		passtf.setBounds(120, 230, 300, 30);
		add(passtf);
		passtf.setFont(f1);

		loginbtn = new JButton("Login");
		loginbtn.setBounds(120, 280, 150, 40);
		add(loginbtn);
		loginbtn.setFont(f2);
		loginbtn.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		String email = emailtf.getText();
		String password = passtf.getText();

		if (e.getSource() == loginbtn) {
			if (email.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Email");
			} else if (password.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Password");
			} else {
				String name = UserDao.loginUser(email, password);

				if (name != null) {
					JOptionPane.showMessageDialog(loginbtn, "Hello, " + name + ". Wecome to CalMeet.");
					welcome.main(new String[] {});
					dispose();
				} else {
					JOptionPane.showMessageDialog(loginbtn, "Incorrect credentials");
				}
			}
		}

	}

	public static void main(String[] args) {
		new login();
	}
}
