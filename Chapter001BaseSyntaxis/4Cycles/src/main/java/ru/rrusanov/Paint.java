package ru.rrusanov;
<<<<<<< HEAD
/** "Exercise 4.3. To build a pyramid in pseudographics."
=======
/** Exercise 4.3. To build a pyramid in pseudographics.
>>>>>>> f24cb77b5384a0de3726ed8d5869de9616c170e9
 * @author Roman Rusanov
 * @since 21.11.2016
 * @version 0.1
 */
import java.lang.StringBuilder;
public class Paint {
	/** Build Piramid use charecter '^'.
	 * @param n - (int) Heigth of the piramid.
	 * @{value} baseChar - (String)Symbol base to build piramid.
	 * @{value} i - index of iteration for loop.
	 * @{value} numberOfSpacesBeforeChar - (string) number of ' ' space character before print baseChar '^'.
	 * @{value} numberOfSpacesAfterChar - (string) number of ' ' space character between baseChar '^'.
	 * @{value} sb - (StringBuilder) Each 
	 */
	public void piramid(int h) {
		// Initialization of variables.
	 	String baseChar = "^";
	 	int numberOfSpacesBeforeChar = h;
	 	int numberOfSpacesAfterChar = 1;
		StringBuilder sb = new StringBuilder();
		//Build and out to console first string of piramid.
		sb.append(spaces(numberOfSpacesBeforeChar));
		sb.append(baseChar);
		System.out.println(sb);
		sb.delete(0,sb.length());
		numberOfSpacesBeforeChar -= 1;
		// Loop build other strings of piramid.
	 	for (int i = 1; i != h; i++) {
	 		sb.append(spaces(numberOfSpacesBeforeChar));
	 		sb.append(baseChar);
	 		sb.append(spaces(numberOfSpacesAfterChar));
	 		sb.append(baseChar);
	 		System.out.println(sb);
	 		sb.delete(0,sb.length());
	 		numberOfSpacesBeforeChar -= 1;
	 		numberOfSpacesAfterChar += 2;
	 	}
	}
	/** Build string use charecter ' '(space).
	 * @param s - (int) String length.
	 * @return string - return the sequence of space.
	 * @{value} sb - (StringBuilder) plus space to sb for each iteration.
	 * @{value} i - index of iteration for loop.
	 */
	public String spaces(int s) {
		String space = " ";
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i != s; i++){
			sb1.append(" ");
		}
		return sb1.toString();
	}

}
/**
		^
   	   ^ ^ -----1
 	  ^   ^ ----3
 	 ^     ^ ---5
*/