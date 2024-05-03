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
import java.util.Map.Entry;

public class MorseCodeToTextGUI {

	private JFrame morseToText;
	private JTextField userMorseInput;
	private JTextArea morseOutput;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MorseCodeToTextGUI window = new MorseCodeToTextGUI();
					window.morseToText.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MorseCodeToTextGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		morseToText = new JFrame();
		morseToText.setTitle("Morse Code To Text Converter");
		morseToText.setResizable(false);
		morseToText.setBounds(100, 100, 400, 380);
		morseToText.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		morseToText.getContentPane().setLayout(null);
		
		userMorseInput = new JTextField();
		userMorseInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		userMorseInput.setBounds(10, 50, 364, 37);
		morseToText.getContentPane().add(userMorseInput);
		userMorseInput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please Input The Morse Code You Wish To Convert");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 364, 28);
		morseToText.getContentPane().add(lblNewLabel);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TextToMorseCodeData data = new TextToMorseCodeData();
			data.setMorseToText();
			String userInput = userMorseInput.getText();
			String[] morseArray = userInput.split(" ");
			StringBuilder textString = new StringBuilder();
			for (String morseSegment : morseArray) {
				textString.append(data.getMorseToText().get(morseSegment));
			}
			morseOutput.setText(textString.toString());
			}
		});
		convertButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		convertButton.setBounds(102, 98, 181, 37);
		morseToText.getContentPane().add(convertButton);
		
		morseOutput = new JTextArea();
		morseOutput.setEditable(false);
		morseOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		morseOutput.setLineWrap(true);
		morseOutput.setWrapStyleWord(true);
		
		JScrollPane textToMorseScrollPane = new JScrollPane(morseOutput);
		textToMorseScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textToMorseScrollPane.setBounds(10, 152, 364, 98);
		textToMorseScrollPane.setViewportView(morseOutput);
		morseToText.getContentPane().add(textToMorseScrollPane);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
			MorseCodeConverterGUI mainScreen = new MorseCodeConverterGUI();
			mainScreen.main(null);
			morseToText.dispose();
			}
		});
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		returnButton.setBounds(102, 271, 181, 37);
		morseToText.getContentPane().add(returnButton);
	}
	}
