import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class welcome extends JFrame implements ActionListener {
	
	JLabel calmeet;
	JLabel logo;
	JPanel logoclr;
	JLabel heading1;
	JLabel heading2;
	JLabel heading3;
	JLabel hourslb;
	JLabel dayslb;
	JLabel heading4;
	JLabel heading5;
	JLabel to;
	
	JComboBox hrsfrom;
	JComboBox hrsto;
	
	JCheckBox daysck;
	
	JButton setmeetbtn;
	
	
	welcome()
	{
		setLayout(null);
		setBounds(350,10,600,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f = new Font("Times New Roman",Font.BOLD ,20);
		Font f1 = new Font("Times New Roman",Font.PLAIN,15);
		Font f2 = new Font("Times New Roman",Font.PLAIN ,18);
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
		
		heading1 = new JLabel("Set your availability");
		heading1.setBounds(190,90,300,50);
		add(heading1);
		heading1.setFont(f);
		
		heading2 = new JLabel("Let CalMeet know when you are typically available");
		heading2.setBounds(75,140,500,30);
		add(heading2);
		heading2.setFont(f);
		
		heading3 = new JLabel("to accept meetings");
		heading3.setBounds(200,160,300,30);
		add(heading3);
		heading3.setFont(f);
		
		hourslb = new JLabel("Available Hours:");
		hourslb.setBounds(100,220,200,40);
		add(hourslb);
		hourslb.setFont(f2);
		
		String[] time = {" 12:00am"," 1:00am"," 2:00am"," 3:00am"," 4:00am"," 5:00am"," 6:00am"," 7:00am"," 8:00am"," 9:00am"," 10:00am"," 11:00am",
				         " 12:00pm"," 1:00pm"," 2:00pm"," 3:00pm"," 4:00pm"," 5:00pm"," 6:00pm"," 7:00pm"," 8:00pm"," 9:00pm"," 10:00pm"," 11:00pm"};
		
		hrsfrom = new JComboBox(time);
		hrsfrom.setBounds(100,260,100,40);
		hrsfrom.setEditable(true);
		hrsfrom.setSelectedItem(" 9:00am");
		add(hrsfrom);
		hrsfrom.setFont(f1);
		
		to = new JLabel("to");
		to.setBounds(240,260,200,40);
		add(to);
		to.setFont(f2);
		
		hrsto = new JComboBox(time);
		hrsto.setBounds(300,260,100,40);
		hrsto.setEditable(true);
		hrsto.setSelectedItem(" 5:00pm");
		add(hrsto);
		hrsto.setFont(f1);
		
		dayslb = new JLabel("Available Days:");
		dayslb.setBounds(100,310,200,40);
		add(dayslb);
		dayslb.setFont(f2);
		
		String[] days = {"Sundays","Mondays","Tuesdays","Wednesdays","Thursdays","Fridays","Saturdays"};
		
		for(int i=0; i<days.length; i++)
		{
			daysck = new JCheckBox(days[i]);
		    daysck.setBounds(100,350+(30*i),200,30);
		    add(daysck);
		    daysck.setFont(f1);
		}
		
		heading4 = new JLabel("Don't worry! You'll be able to further customize your");
		heading4.setBounds(100,580,350,20);
		add(heading4);
		heading4.setFont(f1);
		
		heading5 = new JLabel("availability later on.");
		heading5.setBounds(190,600,300,20);
		add(heading5);
		heading5.setFont(f1);
		
		setmeetbtn = new JButton("Set-up Meeting");
		setmeetbtn.setBounds(390, 630, 150, 40);
		add(setmeetbtn);
		setmeetbtn.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//JOptionPane.showMessageDialog(setmeetbtn, "");
		setupMail.main(new String[]{});
		dispose();
	}

	public static void main(String[] args)
	{
		new welcome();
	}
}
