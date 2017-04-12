import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class .
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.04.17
 */
public class SquareTest {
    /**
     * Test check out to console square shape.
     */
    @Test
    public void thenDrawSquareWhenReturnStringWithSquare() {
        Paint paint = new Paint();

        final String END_STRING = System.getProperty("line.separator");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        paint.draw(new Square());

        StringBuilder stringBuilder = new StringBuilder("____");
        stringBuilder.append(END_STRING);
        stringBuilder.append("|  |");
        stringBuilder.append(END_STRING);
        stringBuilder.append("|  |");
        stringBuilder.append(END_STRING);
        stringBuilder.append("----");

        final String expect = stringBuilder.toString();
        final String result = byteArrayOutputStream.toString();

        assertThat(result, is(expect));
    }

}