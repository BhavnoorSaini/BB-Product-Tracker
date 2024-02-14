package bbProductTracker;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tracker extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFemail;
	private JTextField availableTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tracker frame = new Tracker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tracker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(171, 215, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel emailLbl = new JLabel("Enter Your Email Address:");
		
		TFemail = new JTextField();
		TFemail.setHorizontalAlignment(SwingConstants.CENTER);
		TFemail.setColumns(10);
		
		String availability = SiteData.inStock();
		Boolean available = SiteData.isAvailable();
		JLabel availablelbl = new JLabel("Availablility:");
		
		availableTxt = new JTextField(availability);
		availableTxt.setHorizontalAlignment(SwingConstants.CENTER);
		availableTxt.setEditable(false);
		availableTxt.setColumns(10);
		
		if (available) {
			availableTxt.setBackground(Color.green);
		} else {
			availableTxt.setBackground(Color.red);
		}
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When the submit button is clicked, the email is passed to the SiteData class
				String email = TFemail.getText();
				TFemail.setEditable(false);
				JOptionPane.showMessageDialog(null, "We will notify you once the product is available");
				
				while (!available) {
					// Product availability is checked every 10 seconds until it is available
					SiteData.refresh();
					
					try {
		                // Sleep for 5 seconds
		                Thread.sleep(10000);
		            } catch (InterruptedException e1) {
		                e1.printStackTrace();
		            }
					
					if (SiteData.isAvailable()) {
						break;
					}
				}
				JOptionPane.showMessageDialog(null, "Your product is now available");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addComponent(TFemail, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addComponent(emailLbl))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(152)
							.addComponent(availableTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(173)
							.addComponent(availablelbl))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(166)
							.addComponent(btnNewButton)))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(availablelbl)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(availableTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(emailLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TFemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnNewButton)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
