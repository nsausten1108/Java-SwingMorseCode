/* Author: Nicholas Austen
 * Date: 16 July 2023
 * Description: This class provides a GUI interface for the user to select if they would like to convert from Text to Morse Code,
 * or Morse Code to Text. When the user makes their selection and clicks the "Select" button, the appropriate class is called, 
 * the appropriate window opens, and the main menu closes. 
 * 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MorseCodeConverterGUI {

	private JFrame firstFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MorseCodeConverterGUI window = new MorseCodeConverterGUI();
					window.firstFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MorseCodeConverterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		firstFrame = new JFrame();
		firstFrame.setResizable(false);
		firstFrame.setTitle("Morse Code Converter");
		firstFrame.setBounds(100, 100, 392, 243);
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstFrame.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Please Select From The Following Options:");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		welcomeLabel.setBounds(10, 11, 356, 38);
		firstFrame.getContentPane().add(welcomeLabel);
		
		JComboBox userSelections = new JComboBox();
		userSelections.setModel(new DefaultComboBoxModel(new String[] {"Text to Morse Code", "Morse Code to Text"}));
		userSelections.setFont(new Font("Tahoma", Font.BOLD, 14));
		userSelections.setBounds(45, 60, 291, 38);
		firstFrame.getContentPane().add(userSelections);
		
		JButton selectButton = new JButton("Select");
		selectButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
			int userSelection = userSelections.getSelectedIndex();
			if (userSelection == 0) {
				TextToMorseCodeGUI a = new TextToMorseCodeGUI();
				a.main(null);
				firstFrame.dispose();
			}
			else if (userSelection == 1) {
				MorseCodeToTextGUI b = new MorseCodeToTextGUI();
				b.main(null);
				firstFrame.dispose();
			}
			}
		});
		selectButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		selectButton.setBounds(86, 123, 206, 38);
		firstFrame.getContentPane().add(selectButton);
	}
}
