package ru.rrusanov;
/** Exercise 4.3. To build a pyramid in pseudographics.
 * @author Roman Rusanov
 * @since 21.11.2016
 * @version 0.2
 */
import java.lang.StringBuilder;
public class Paint {
	/** Build Piramid use charecter '^'.
	 * @param n - (int) Heigth of the piramid.
	 * @{value} baseChar - (String)Symbol base to build piramid.
	 * @{value} i,j - index of iteration for loop.
	 * @{value} incrementIndex - (int) depends on the height of the pyramid, need build sequence spaces between base chars.
	 * @{value} decrementIndex - (int) need for build string spaces before base char.
	 * @{value} sb - (StringBuilder) string contain the piramid.
	 */
	public String piramid(int h) {
		// Initialization of variables.
	 	String baseChar = "^";
	 	int incrementIndex = 0;
	 	int decrimentIndex = h;
		StringBuilder sb = new StringBuilder();
		// Chek hight of piramid
		if (h == 1) {
			incrementIndex = 0;
		} else if (h == 2) {
			incrementIndex = 1;
		} else if (h >= 3) {
			incrementIndex = 2;
		} else {
			sb.append("ERROR! Height of the pyramid cannot be a zero or negative number");
		}
		// Loop build of piramid.
	 	for (int i = 0; i != h; i++) {
	 		// Loop for build sequence space before ^
	 		for (int f = 0; f != decrimentIndex ; f++) {
	 			sb.append(" ");
	 		}
	 		decrimentIndex -= 2;
	 		// Add ^
	 		sb.append(baseChar);
	 		// Loop for build sequence space after ^
	 		for (int j = 0; j != incrementIndex; j++) {
				sb.append(" ");
	 		}
	 		// On next iteration on two spaces longer.
			incrementIndex += 2;
			// Add ^ and end string.
	 		sb.append(baseChar).append("\n");
	 	}
		return sb.toString();
	}
}
/**
		^
   	   ^ ^ -----1
 	  ^   ^ ----3
 	 ^     ^ ---5
*/