import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Class .
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.04.17
 */
public class TriangleTest {
    /**
     * Test check out to console triangle shape.
     */
    @Test
    public void thenDrawTriangleWhenReturnStringWithTriangle() {
        Paint paint = new Paint();

        final String END_STRING = System.getProperty("line.separator");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        paint.draw(new Triangle());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  *");
        stringBuilder.append(END_STRING);
        stringBuilder.append(" * *");
        stringBuilder.append(END_STRING);
        stringBuilder.append("*   *");

        final String expect = stringBuilder.toString();
        final String result = byteArrayOutputStream.toString();

        assertThat(result, is(expect));

    }
}