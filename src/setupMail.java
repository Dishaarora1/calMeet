import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class setupMail extends JFrame implements ActionListener {

	JLabel calmeet;
	JLabel logo;
	JPanel logoclr;
	JLabel heading1;
	JLabel heading2;
	JLabel heading3;
	JLabel emaillb;
	JLabel namelb;
	JLabel agendalb;
	JLabel descriptionlb;

	JTextField emailtf;
	JTextField nametf;
	JTextField agendata;

	JTextArea descriptionta;

	JButton setupbtn;

	setupMail() {
		setLayout(null);
		setBounds(350, 0, 600, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font f = new Font("Times New Roman", Font.BOLD, 20);
		Font f1 = new Font("Times New Roman", Font.PLAIN, 15);
		Font f2 = new Font("Times New Roman", Font.PLAIN, 18);
		Font f3 = new Font("consolas", Font.BOLD, 20);

		logoclr = new JPanel();
		logoclr.setLayout(null);
		logoclr.setBackground(Color.BLACK);
		logoclr.setBounds(0, 0, 600, 65);
		add(logoclr);

		ImageIcon icon = new ImageIcon("src/icons/calmeet_logo2.png");
		logo = new JLabel(icon);
		logo.setBounds(230, 10, icon.getIconWidth(), icon.getIconHeight());
		logoclr.add(logo);

		calmeet = new JLabel("CalMeet");
		calmeet.setBounds(300, 10, 100, 50);
		calmeet.setForeground(Color.WHITE);
		logoclr.add(calmeet);
		calmeet.setFont(f3);

		heading1 = new JLabel("Setting up Meeting");
		heading1.setBounds(190, 90, 300, 50);
		add(heading1);
		heading1.setFont(f);

		heading2 = new JLabel("CalMeet will send Email to help set up meetings");
		heading2.setBounds(90, 140, 500, 30);
		add(heading2);
		heading2.setFont(f);

		/*
		 * heading3 = new JLabel(""); heading3.setBounds(200,160,300,30); add(heading3);
		 * heading3.setFont(f);
		 */

		emaillb = new JLabel("Recipient Email");
		emaillb.setBounds(100, 205, 200, 40);
		add(emaillb);
		emaillb.setFont(f2);

		emailtf = new JTextField();
		emailtf.setBounds(100, 240, 300, 30);
		add(emailtf);
		emailtf.setFont(f1);

		namelb = new JLabel("Recipient Name");
		namelb.setBounds(100, 275, 200, 40);
		add(namelb);
		namelb.setFont(f2);

		nametf = new JTextField();
		nametf.setBounds(100, 310, 300, 30);
		add(nametf);
		nametf.setFont(f1);

		agendalb = new JLabel("Agenda");
		agendalb.setBounds(100, 355, 200, 40);
		add(agendalb);
		agendalb.setFont(f2);

		agendata = new JTextField();
		agendata.setBounds(100, 390, 450, 30);
		add(agendata);
		agendata.setFont(f1);

		descriptionlb = new JLabel("Description");
		descriptionlb.setBounds(100, 425, 200, 40);
		add(descriptionlb);
		descriptionlb.setFont(f2);

		descriptionta = new JTextArea();
		descriptionta.setBounds(100, 460, 450, 170);
		add(descriptionta);
		descriptionta.setFont(f1);

		setupbtn = new JButton("Send Email");
		setupbtn.setBounds(400, 640, 150, 40);
		add(setupbtn);
		setupbtn.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String email = emailtf.getText();
		String name = nametf.getText();
		String agenda = agendata.getText();
		String description = descriptionta.getText();

		if (e.getSource() == setupbtn) {
			if (email.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter Email");
			}
			else {
				int status = EmailService.sendMail(email, name, agenda,description);
				if (status == 1) {
					JOptionPane.showMessageDialog(setupbtn, "Email sent successfully");
				} else {
					JOptionPane.showMessageDialog(setupbtn, "Connection Error");
				}
			}
		}
	}

	public static void main(String[] args) {
		new setupMail();
	}
}
