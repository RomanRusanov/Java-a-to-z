package ru.rrusanov.search;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 03.03.2018
 *
 * Class test Task class.
 */
public class TaskTest {
    /**
     * Test for method getDesc.
     */
    @Test
    public void thenNewTaskCreateWhenGetterDescReturnSameValue() {
        String desc = "Desc";
        Task task = new Task(desc, 1);
        Assert.assertThat(task.getDesc(), is(desc));
    }
    /**
     * Test for method getPriority.
     */
    @Test
    public void thenNewTaskCreateWhenGetterPriorityReturnSameValue() {
        int priority = 1;
        Task task = new Task("desc", priority);
        Assert.assertThat(task.getPriority(), is(priority));
    }
}