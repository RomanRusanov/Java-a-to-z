package ru.rrusanov;

/** Exercise 4.3. To build a pyramid in pseudographics.
 * @author Roman Rusanov
 * @since 21.11.2016
 * @version 0.3
 */
public class Paint {
	/** Build Piramid use charecter '^'.
	 * @param h - (int) Heigth of the piramid.
	 * @{value} baseChar - (String) Symbol base to build piramid.
	 * @{value} i,j,k - (int) index of iteration for loop.
	 * @{value} baseCounter - (int) number of spaces in that iteration string of a peramid.
	 * @{value} sb - (StringBuilder) string contain the piramid.
	 * @{value} charSquence - (String) sequene spaces before piramid.
	 * @return String with pyramid.
	 */
	public String piramid(int h) {
		// Initialization of variables.
	 	String baseChar = "^";
	 	String charSquence = " ";
	 	int baseCounter = 0;
		StringBuilder sb = new StringBuilder();
		// Loop build of piramid.
	 	for (int i = 0; i != h; i++) {
	 		//System.out.println(String.format("(loop  i = %d) h=%d ", i, h));
	 		// Bild sequene spaces before piramid.
	 		for (int k = 0; k < h - i; k++) {
	 			charSquence += charSquence;
	 			//System.out.println(String.format("   (loop space before = %d) h=%d baseCounter = %d", k, h,baseCounter));
	 		}
	 		// Chek hight of piramid
	 		// if string 1 base 0, string 2 base 1, string 3 and other (base = base + 2).
			if (i == 0) {
				sb.append(charSquence, 0, h);
			} else if (i == 1) {
				baseCounter += 1;
				sb.append(charSquence, 0, h - i).append(baseChar);
			} else if (i >= 2) {
				baseCounter += 2;
				sb.append(charSquence, 0, h - i).append(baseChar);
			}
			// Build sequnce char base of piramid.
			for (int j = 0; j != baseCounter; j++) {
				sb.append("*");
			}
			// End string.
			sb.append(baseChar).append("\n");
			//System.out.println(String.format("     \n(loop end string = %d) h=%d baseCounter = %d", i, h,baseCounter));
	 	}
		return sb.toString();
	}
}
/**
 		^ ------0
   	   ^ ^ -----1
 	  ^   ^ ----3
 	 ^     ^ ---5
*/