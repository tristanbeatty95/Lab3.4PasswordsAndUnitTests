import java.util.ArrayList;
import java.util.Scanner;

public class PasswordPrompt {
	
	static ArrayList<String> passwords = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		do { //Continues to ask the user to enter a password until they say anything other than Y
		System.out.println("Please enter a password with the following requiremenets: \n"
				+ "Cannot be an already existing password \n"
				+ "Must have more than 7 characters, but less than 12 \n"
				+ "Must have a number, but not contain the number 6. We hate the number 6. \n"
				+ "Must not contain any spaces \n"
				+ "Must have at least TWO capital vowels \n"
				+ "The words \"admin\" and \"mod\" can be used, but may only be used once.");
		String input = scan.nextLine();
		if(addPassword(input) == true) {
			System.out.println("Adding your password to the list...");
			System.out.println(passwords);
		} else {
			System.out.println("Your password didn't meet our ridiculous criteria...");
		}
		System.out.println("Would you like to try again? (y/n)");
		String cont = scan.nextLine();
		if(cont.equalsIgnoreCase("y")) {
			continue;
		} else {
			System.out.println("Goodbye, I would have left too!");
			break;
		}
		} while(true);	
	}

	public static boolean addPassword(String password) { //Checks if admin and mod are already added
		//if you didn't type admin or mod, checks to see if it passes all 5 tests
		
		int passAllTests = 0;
		passAllTests = passwordExists(passwords, password) + passLength(password) + passNum(password) + passSpace(password) + passVowel(password);
		if(password.contains("admin") && !passwords.contains(password)) {
			passwords.add(password);
			return true;
		}
		if(password.contains("mod") && !passwords.contains(password)) {
			passwords.add(password);
			return true;
		}
		if (passAllTests == 5) {
			passwords.add(password);
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public static int passwordExists(ArrayList<String> passwordList, String password) {
		//checks to see if the password already exists
		if(passwordList.contains(password)) {
			return 0;		
		} else {
			return 1;
		}
	}
	
	public static int passLength(String password) {
		//checks the length of the password
		if(password.length() > 7 && password.length() < 12) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int passNum(String password) {
		//checks to see if there is a number in the password that isn't '6'
		int numCount = 0;
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(Character.isDigit(c) && !password.contains("6")) {
				numCount++;
			}
		}
		if(numCount >= 1) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	public static int passSpace(String password) {
		//checks to see if password contains a space
		if(!password.contains(" ")) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int passVowel(String password) {
		//checks to see if there are at least 2 capital vowels in the password
		int capVowel = 0;
			for(int i = 0; i < password.length(); i++) {
				if(password.charAt(i) == 'A' || password.charAt(i) == 'E' 
						|| password.charAt(i) == 'I' || password.charAt(i) == 'O' 
						|| password.charAt(i) == 'U' || password.charAt(i) == 'Y') {
					capVowel++;
				}
			}
			if(capVowel >= 2) {
				return 1;
			} else {
				return 0;
			}
	}
}
