package ru.rrusanov.hashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.06.2018

 */
public class HashMapTest {

    private HashMap<String, Integer> hashMap = new HashMap<>(2);

    @Before
    public void setUp() {
        hashMap.insert("A", 1);
        hashMap.insert("B", 2);
    }

    @Test
    public void hash() {
    }

    @Test
    public void growAndReHash() {
    }

    @Test
    public void removeNullsElements() {
    }

    @Test
    public void insert() {
        hashMap.insert("C", 3);
    }

    @Test
    public void get() {
        Assert.assertThat(this.hashMap.get("A"), is(1));
        Assert.assertThat(this.hashMap.get("B"), is(2));
        Assert.assertThat(this.hashMap.get("C"), is(3));
    }

    @Test
    public void delete() {
    }

    @Test
    public void iterator() {
        Iterator<Entry<String, Integer>> it = hashMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getKey(), is("A"));

    }
}