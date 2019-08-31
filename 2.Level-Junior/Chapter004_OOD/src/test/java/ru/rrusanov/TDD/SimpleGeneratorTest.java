package ru.rrusanov.TDD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 29.08.2019
 *
 * The class test behavior SimpleGenerator.java class.
 */
public class SimpleGeneratorTest {
    /**
     * The field contain instance of test class.
     */
    private SimpleGenerator simpleGenerator;

    /**
     * The method executes before each test.
     */
    @Before
    public void setUp() {
        this.simpleGenerator = new SimpleGenerator();
    }

    /**
     * The test check behavior process method. Use 2 pairs.
     */
    @Test
    public void whenPassStringWhitKeysWhenKeysReplaysInString() {
        this.simpleGenerator.addPair("name", "Petr");
        this.simpleGenerator.addPair("subject", "you");
        this.simpleGenerator.setInputString("I am a ${name}, Who are ${subject}?");
        String result = simpleGenerator.process();
        Assert.assertThat(result, is("I am a Petr, Who are you?"));
    }
    /**
     * The test check behavior process method. Use 1 repeated pair.
     */
    @Test
    public void whenPassStringWhitKeysWhenKeysReplaysInString2() {
        this.simpleGenerator.addPair("sos", "Aaa");
        this.simpleGenerator.setInputString(" Help, ${sos}, ${sos}, ${sos}");
        String result = simpleGenerator.process();
        Assert.assertThat(result, is(" Help, Aaa, Aaa, Aaa"));
    }
    /**
     * The test check if map not contain match key, must throw exception.
     */
    @Test (expected = IllegalStateException.class)
    public void whenKeysNotExistInMapWhenMethodThrowException() {
        this.simpleGenerator.setInputString(" Help, ${sos}, ${sos}, ${sos}");
        String result = simpleGenerator.process();
    }
    /**
     * The test check if map contain not used keys, must throw exception.
     */
    @Test (expected = IllegalStateException.class)
    public void whenKeysNotExistInInputStringWhenMethodThrowException() {
        this.simpleGenerator.addPair("scream", "Aaa");
        this.simpleGenerator.setInputString(" Help, ${sos}");
        String result = simpleGenerator.process();
    }
}