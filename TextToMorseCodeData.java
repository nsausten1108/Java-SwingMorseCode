/* Author: Nicholas Austen
 * Date: 16 July 2023
 * Description: This is the TextToMorseCodeData class, which provides a HashMap that assigns different characters to 
 * Morse code output. This will be used by the MorseCodeGUI class for translation of characters from text to Morse code.
 * Morse code courtesy of morsecode.world. According to this resource, spaces between words should be 7 units long, and
 * spaces between characters should be 1 unit long. 7 underscore characters represent 7 spaces in this translator.
 * 
 */

import java.util.HashMap;

public class TextToMorseCodeData {
	//Create HashMaps for conversion of Text to Morse Code, and Morse Code to Text
	private HashMap<Character, String> textToMorse = new HashMap<>();
	private HashMap<String, Character> morseToText = new HashMap<>();
	//Fields to assign text characters and Morse Code strings to their appropriate arrays 
	private char[] textCharacter = {' ', '.', ',', ':', '\'', '-', '(', ')', '&', '!', '.', '"', '?', '/', '0', '1', '2', '3', 
			'4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private String[] morseString = {"_______", ".-.-.-", "--..--", "---...",  ".----.",  "-....-", "-.--.", "-.--.-", ".-...", 
			"-.-.--", ".-.-.-", ".-..-.", "..--..", "-..-.", "-----", ".----", "..---", "...--", "....-", ".....", "-....", 
			"--...", "---..", "----.", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", 
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
	
	//Method to build Hashmaps for test-to-morse, or morse-to-text translation
	public void assignValues() {
		for (int i = 0; i < textCharacter.length; i++) {
			textToMorse.put(textCharacter[i], morseString[i]);
			morseToText.put(morseString[i], textCharacter[i]);
		}
	}//end method
	//getters and setters to be used by respective GUIs
	public void setTextToMorse() {
		this.assignValues();
	}
	public void setMorseToText() {
		this.assignValues();
	}
	public HashMap<Character, String> getTextToMorse() {
		return textToMorse;
	}
	public HashMap<String, Character> getMorseToText(){
		return morseToText;
	}
	
}//end class  
