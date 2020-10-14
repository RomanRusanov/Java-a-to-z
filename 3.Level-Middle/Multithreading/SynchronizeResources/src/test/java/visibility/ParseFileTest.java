package visibility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The class test ParseFile.java.
 */
class ParseFileTest {
    /**
     * The path with unicode symbols file.
     */
    private final Path fileWithUnicode = Path.of(
            "src/test/resources/fileWithUnicodeSymbols.txt");
    /**
     * The path with out unicode symbols file.
     */
    private final Path fileWithoutUnicode = Path.of(
            "src/test/resources/fileWithoutUnicodeSymbols.txt");
    /**
     * The instance of test class.
     */
    private final ParseFile parseFile = new ParseFile();
    /**
     * The string with symbol line separator.
     */
    private static final  String NEW_LINE = System.getProperty("line.separator");
    /**
     * The instance temp folder.
     */
    @TempDir
    static Path tempFolder;
    /**
     * The string contain that class must parse with unicode symbols.
     */
    private final String contentWithUnicode = "✓\t 2713 check mark" + NEW_LINE
            + "✗\t 2717 cross mark" + NEW_LINE
            + "〃\t 3003 ditto" + NEW_LINE
            + "§\t 00A7 section" + NEW_LINE
            + "¶\t 00B6 paragraph" + NEW_LINE
            + "☐\t 2610 ballot box" + NEW_LINE
            + "☑\t 2611 ballot box with check" + NEW_LINE
            + "☒\t 2612 ballot box with X" + NEW_LINE
            + "☛\t 261B black right pointing finger" + NEW_LINE
            + "☞\t 261E white right pointing finger" + NEW_LINE
            + "⚜\t 269C fleur-de-lys" + NEW_LINE
            + "★\t 2605 starf, bigstar, black star" + NEW_LINE
            + "☆\t 2606 white star" + NEW_LINE
            + "□\t 25A1 square" + NEW_LINE
            + "⛤\t 26E4 pentagram" + NEW_LINE;
    /**
     * The string contain that class must parse with out unicode symbols.
     */
    private final String contentWithoutUnicode = "\t 2713 check mark" + NEW_LINE
            + "\t 2717 cross mark" + NEW_LINE
            + "\t 3003 ditto" + NEW_LINE
            + "\t 00A7 section" + NEW_LINE
            + "\t 00B6 paragraph" + NEW_LINE
            + "\t 2610 ballot box" + NEW_LINE
            + "\t 2611 ballot box with check" + NEW_LINE
            + "\t 2612 ballot box with X" + NEW_LINE
            + "\t 261B black right pointing finger" + NEW_LINE
            + "\t 261E white right pointing finger" + NEW_LINE
            + "\t 269C fleur-de-lys" + NEW_LINE
            + "\t 2605 starf, bigstar, black star" + NEW_LINE
            + "\t 2606 white star" + NEW_LINE
            + "\t 25A1 square" + NEW_LINE
            + "\t 26E4 pentagram" + NEW_LINE;

    /**
     * The method call each test.
     */
    @BeforeEach
    public void setup() {
        this.parseFile.setFile(this.fileWithUnicode.toFile());
    }

    /**
     * The test check how parse with out unicode symbols.
     */
    @Test
    void whenParseWithOutSymbolsThenTheyNotPresent() {
        assertEquals(this.contentWithoutUnicode, this.parseFile.getContentWithoutUnicode());
    }

    /**
     * The test check how parse with unicode symbols.
     */
    @Test
    void whenParseWithSymbolsThenTheyExist() {
        ParseFile parseFile = new ParseFile();
        parseFile.setFile(fileWithoutUnicode.toFile());
        assertEquals(this.contentWithoutUnicode, parseFile.getContent());
    }

    /**
     * The test check save process.
     */
    @Test
    void whenSaveContentThenItSameWhatParse() {
        String parseResult = this.parseFile.getContentWithoutUnicode();
        this.parseFile.setFile(tempFolder.resolve("test.txt").toFile());
        this.parseFile.saveContent(parseResult);
        assertEquals(this.contentWithoutUnicode, this.parseFile.getContent());
    }
}