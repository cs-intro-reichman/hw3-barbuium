import java.util.Arrays;
import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		  // Step 1: Preprocess both strings to clean them up (remove non-letters, convert to lowercase)
        String cleanedStr1 = preProcess(str1);
        String cleanedStr2 = preProcess(str2);
        
        // Step 2: If the lengths are different, they cannot be anagrams
        if (cleanedStr1.length() != cleanedStr2.length()) {
            return false;
        }
        
        // Step 3: Convert strings to character arrays, sort them, and compare
        char[] arr1 = cleanedStr1.toCharArray();
        char[] arr2 = cleanedStr2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        // Step 4: If sorted arrays are the same, then the strings are anagrams
        return Arrays.equals(arr1, arr2);
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
			// Remove all non-alphabetical characters and convert to lowercase
			StringBuilder cleaned = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (Character.isLetter(c)) {
					cleaned.append(Character.toLowerCase(c));
				}
			}
			return cleaned.toString();
		}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Convert the string into a character array
        char[] charArray = str.toCharArray();
        
        // Create a Random object for generating random indices
        Random rand = new Random();
        
        // Randomly shuffle the array
        for (int i = 0; i < charArray.length; i++) {
            // Pick a random index from the remaining part of the array
            int randomIndex = rand.nextInt(charArray.length);
            
            // Swap the current character with the randomly selected character
            char temp = charArray[i];
            charArray[i] = charArray[randomIndex];
            charArray[randomIndex] = temp;
        }
        
        // Convert the shuffled character array back into a string and return it
        return new String(charArray);
    }
}
