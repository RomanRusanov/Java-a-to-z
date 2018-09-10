package ru.rrusanov;

/** Exercise 4.3. To build a pyramid in pseudographics.
 * @author Roman Rusanov
 * @since 21.11.2016
 * @version 0.3
 */
public class Paint {
	/** Build Piramid use charecter '^'.
	 * @param h (int) Heigth of the piramid.
	 *  baseChar - (String) Symbol base to build piramid.
	 *  i,j,k - (int) index of iteration for loop.
	 *  baseCounter - (int) number of spaces in that iteration string of a peramid.
	 *  sb - (StringBuilder) string contain the piramid.
	 *  charSquence - (String) sequene spaces before piramid.
	 *
	 *  		^ ------0
	 *    	   ^ ^ -----1
	 *  	  ^   ^ ----3
	 *  	 ^     ^ ---5
	 *
	 * @return String with pyramid.
	 */
	public String pyramid(int h) {
		// Initialization of variables.
	 	String baseChar = "^";
	 	String charSequence = " ";
	 	int baseCounter = 0;
		StringBuilder sb = new StringBuilder();
		// Loop build of pyramid.
	 	for (int i = 0; i != h; i++) {
	 		//System.out.println(String.format("(loop  i = %d) h=%d ", i, h));
	 		// Build sequence spaces before pyramid.
	 		for (int k = 0; k < h - i; k++) {
	 			charSequence += charSequence;
	 			//System.out.println(String.format("   (loop space before = %d) h=%d baseCounter = %d", k, h,baseCounter));
	 		}
	 		// Check height of pyramid
	 		// if string 1 base 0, string 2 base 1, string 3 and other (base = base + 2).
			if (i == 0) {
				sb.append(charSequence, 0, h);
			} else if (i == 1) {
				baseCounter += 1;
				sb.append(charSequence, 0, h - i).append(baseChar);
			} else if (i > 2) {
				baseCounter += 2;
				sb.append(charSequence, 0, h - i).append(baseChar);
			}
			// Build sequence char base of pyramid.
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