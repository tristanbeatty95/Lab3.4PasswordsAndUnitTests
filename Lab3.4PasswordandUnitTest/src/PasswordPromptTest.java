import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PasswordPromptTest {

	@Test //Test to see if I can add a valid password that isn't already in the list
	void passwordExists() {
		String pass = "ArmagEddon1";
		ArrayList<String> passwords = new ArrayList<>();
		int expected = 1;
		int actual = PasswordPrompt.passwordExists(passwords, pass);
		assertEquals(expected, actual);
	}
	
	@Test //Test to see if the password already exists, it won't be added to the list
	void passwordExists2() {
		String pass = "ArmagEddon1";
		ArrayList<String> passwords = new ArrayList<>();
		passwords.add("ArmagEddon1");
		int expected = 0;
		int actual = PasswordPrompt.passwordExists(passwords, pass);
		assertEquals(expected, actual);
	}
	
	@Test //Test to see if between 7-12 characters exclusively
	void passLength() {
		String pass = "ArmahEddon1";
		int expected = 1;
		int actual = PasswordPrompt.passLength(pass);
		assertEquals(expected, actual);
	}
	
	@Test //Test to make sure you couldn't have more than 11 characters
	void passLength2() {
		String pass = "ArmahEddon1shshsas";
		int expected = 0;
		int actual = PasswordPrompt.passLength(pass);
		assertEquals(expected, actual);
	}
	
	@Test //Make sure it's looking for at least 1 num that isn't 6
	void passNum() {
		String pass = "ArmagEddon1";
		int expected = 1;
		int actual = PasswordPrompt.passNum(pass);
		assertEquals(expected, actual);
	}
	
	@Test //Make sure 6 ruins your day
	void passNum2() {
		String pass = "ArmagEddon6";
		int expected = 0;
		int actual = PasswordPrompt.passNum(pass);
		assertEquals(expected, actual);
	}
	
	@Test //Makes sure it works without a space
	void passSpace() {
		String pass = "ArmagEddon1";
		int expected = 1;
		int actual = PasswordPrompt.passSpace(pass);
		assertEquals(expected, actual);
	}
	
	@Test //Makes sure spaces aren't valid
	void passSpace2() {
		String pass = "Arm gEddon1";
		int expected = 0;
		int actual = PasswordPrompt.passSpace(pass);
		assertEquals(expected, actual);
	}
	
	@Test //Makes sure you have two cap vowels
	void passVowel() {
		String pass = "ArmagEddon1";
		int expected = 1;
		int actual = PasswordPrompt.passVowel(pass);
		assertEquals(expected, actual);
	}
	
	@Test //Makes sure you have two cap vowels
	void passVowel2() {
		String pass = "armagEddon1";
		int expected = 0;
		int actual = PasswordPrompt.passVowel(pass);
		assertEquals(expected, actual);
	}
}
