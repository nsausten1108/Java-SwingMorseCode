import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextToMorseCodeGUI {

	private JFrame textToMorse;
	private JTextField userTextInput;
	private JTextArea morseOutput;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextToMorseCodeGUI window = new TextToMorseCodeGUI();
					window.textToMorse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TextToMorseCodeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textToMorse = new JFrame();
		textToMorse.setTitle("Text To Morse Code Converter");
		textToMorse.setResizable(false);
		textToMorse.setBounds(100, 100, 400, 380);
		textToMorse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textToMorse.getContentPane().setLayout(null);
		
		userTextInput = new JTextField();
		userTextInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		userTextInput.setBounds(10, 50, 364, 37);
		textToMorse.getContentPane().add(userTextInput);
		userTextInput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please Input The Text You Wish To Convert");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 364, 28);
		textToMorse.getContentPane().add(lblNewLabel);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TextToMorseCodeData data = new TextToMorseCodeData();
			data.setMorseToText();
			String userInputText = userTextInput.getText();
			char[] textArray = userInputText.toUpperCase().toCharArray();
			String convertedResult="";
			for (char cr : textArray) {
				convertedResult += data.getTextToMorse().get(cr) + " ";
			}
			morseOutput.setText(convertedResult.toString());
			}
		});
		convertButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		convertButton.setBounds(102, 98, 181, 37);
		textToMorse.getContentPane().add(convertButton);
		
		morseOutput = new JTextArea();
		morseOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		morseOutput.setLineWrap(true);
		morseOutput.setWrapStyleWord(true);
		
		JScrollPane textToMorseScrollPane = new JScrollPane(morseOutput);
		textToMorseScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textToMorseScrollPane.setBounds(10, 152, 364, 98);
		textToMorseScrollPane.setViewportView(morseOutput);
		textToMorse.getContentPane().add(textToMorseScrollPane);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
			MorseCodeConverterGUI mainScreen = new MorseCodeConverterGUI();
			mainScreen.main(null);
			textToMorse.dispose();
			}
		});
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		returnButton.setBounds(102, 278, 181, 37);
		textToMorse.getContentPane().add(returnButton);
	}
	}
