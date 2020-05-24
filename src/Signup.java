import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

	JLabel calmeet;
	JLabel logo;
	JPanel logoclr;
	JLabel signuplb;
	JLabel emaillb;
	JLabel namelb;
	JLabel passlb;
	JLabel confirmpasslb;
	JLabel existlb;

	JTextField emailtf;
	JTextField nametf;

	JPasswordField passtf;
	JPasswordField confirmpasstf;

	JButton signupbtn;
	JButton loginbtn;

	Signup() {

		setLayout(null);
		setBounds(300, 10, 750, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font f = new Font("Times New Roman", Font.BOLD, 20);
		Font f1 = new Font("Times New Roman", Font.PLAIN, 15);
		Font f2 = new Font("Times New Roman", Font.PLAIN, 20);
		Font f3 = new Font("consolas", Font.BOLD, 20);

		logoclr = new JPanel();
		logoclr.setLayout(null);
		logoclr.setBackground(Color.BLACK);
		logoclr.setBounds(0, 0, 850, 65);
		add(logoclr);

		ImageIcon icon = new ImageIcon("src/icons/calmeet_logo2.png");
		logo = new JLabel(icon);
		logo.setBounds(290, 10, icon.getIconWidth(), icon.getIconHeight());
		logoclr.add(logo);

		calmeet = new JLabel("CalMeet");
		calmeet.setBounds(360, 10, 100, 50);
		calmeet.setForeground(Color.WHITE);
		logoclr.add(calmeet);
		calmeet.setFont(f3);

		signuplb = new JLabel("Sign up with CalMeet for free");
		signuplb.setBounds(230, 80, 500, 100);
		add(signuplb);
		signuplb.setFont(f);

		emaillb = new JLabel("Enter your Email");
		emaillb.setBounds(200, 175, 300, 40);
		add(emaillb);
		emaillb.setFont(f1);

		emailtf = new JTextField();
		emailtf.setBounds(200, 210, 300, 30);
		add(emailtf);
		emailtf.setFont(f1);

		namelb = new JLabel("Enter Name");
		namelb.setBounds(200, 240, 200, 40);
		add(namelb);
		namelb.setFont(f1);

		nametf = new JTextField();
		nametf.setBounds(200, 275, 300, 30);
		add(nametf);
		nametf.setFont(f1);

		passlb = new JLabel("Enter Password");
		passlb.setBounds(200, 310, 200, 40);
		add(passlb);
		passlb.setFont(f1);

		passtf = new JPasswordField();
		passtf.setBounds(200, 345, 300, 30);
		add(passtf);
		passtf.setFont(f1);

		confirmpasslb = new JLabel("Confirm Password");
		confirmpasslb.setBounds(200, 380, 200, 40);
		add(confirmpasslb);
		confirmpasslb.setFont(f1);

		confirmpasstf = new JPasswordField();
		confirmpasstf.setBounds(200, 415, 300, 30);
		add(confirmpasstf);
		confirmpasstf.setFont(f1);

		signupbtn = new JButton("Sign up");
		signupbtn.setBounds(200, 465, 150, 40);
		add(signupbtn);
		signupbtn.setFont(f2);
		signupbtn.addActionListener(this);

		existlb = new JLabel("Already have an account?");
		existlb.setBounds(200, 530, 300, 40);
		add(existlb);
		existlb.setFont(f1);

		loginbtn = new JButton("Login");
		loginbtn.setBounds(200, 570, 150, 40);
		add(loginbtn);
		loginbtn.setFont(f2);
		loginbtn.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signupbtn) {
			String s1 = emailtf.getText();
			String s2 = nametf.getText();
			String s3 = passtf.getText();
			String s4 = confirmpasstf.getText();

			if (s1.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Email");
			} else if (s2.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Name");
			} else if (s3.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Password");
			} else if (s4.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Confirm Password");
			}

			else if (!s3.contentEquals(s4)) {
				JOptionPane.showMessageDialog(signupbtn, "Password does not match");
			}

			else {
				int status = UserDao.saveUser(s1, s2, s3);
				if (status == 1) {
					JOptionPane.showMessageDialog(signupbtn, "Data saved successfully,"
							+ " Login to continue.");
					login.main(new String[] {});
					dispose();
				}
				else
					JOptionPane.showMessageDialog(signupbtn, "Email already used.");
			}
		} else if (e.getSource() == loginbtn) {
			login.main(new String[] {});
			dispose();
		}
	}

	public static void main(String[] args) {
		new Signup();
	}

}
