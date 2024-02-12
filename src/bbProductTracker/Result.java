package bbProductTracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Result extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField descriptiontxt;
	private JTextField availabletxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(171, 215, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel descriptionlbl = new JLabel("Product Description:");
		
		descriptiontxt = new JTextField(SiteData.getDescription());
		descriptiontxt.setHorizontalAlignment(SwingConstants.CENTER);
		descriptiontxt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		descriptiontxt.setEditable(false);
		descriptiontxt.setColumns(10);
		
		String availability = SiteData.inStock();
		Boolean available = SiteData.isAvailable();
		JLabel availablelbl = new JLabel("Availability:");
		availabletxt = new JTextField(availability);
		availabletxt.setHorizontalAlignment(SwingConstants.CENTER);
		availabletxt.setColumns(10);
		if (available) {
			availabletxt.setBackground(Color.green);
		} else {
			availabletxt.setBackground(Color.red);
		}
		
		JButton refreshButton = new JButton("REFRESH");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SiteData.refresh();
				Result Result = new Result();
				EventQueue.invokeLater(() -> Result.setVisible(true));
			}
		});
		
		JButton resetButton = new JButton("NEW SEARCH");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StartMenu Menu = new StartMenu();
				EventQueue.invokeLater(() -> Menu.setVisible(true));
			}
		});
		
		try {
		    JLabel imagelbl = new JLabel();
		    
		    BufferedImage img = ImageIO.read(new URL(SiteData.getImageUrl()));
		    Image scaledImage = img.getScaledInstance(173, 105, Image.SCALE_SMOOTH);
		    
		    imagelbl.setIcon(new ImageIcon(scaledImage));
		    imagelbl.setBounds(145, 5, 175, 105);
		    getContentPane().add(imagelbl);
		} catch (IOException e2) {
		    e2.printStackTrace();
		}
		
		JButton notifyButton = new JButton("NOTIFY ME");
		notifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Tracker Tracker = new Tracker();
				EventQueue.invokeLater(() -> Tracker.setVisible(true));
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(descriptionlbl)
					.addContainerGap(273, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(refreshButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(resetButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(availabletxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(availablelbl))
							.addGap(6)))
					.addGap(18)
					.addComponent(notifyButton)
					.addGap(46))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(descriptiontxt, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addComponent(descriptionlbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(descriptiontxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(availablelbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(availabletxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(refreshButton)
						.addComponent(resetButton)
						.addComponent(notifyButton))
					.addGap(7))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
