package ru.rrusanov.collection.generic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.06.2018
 *
 * Class test RoleStore.java class.
 */
public class RoleStoreTest {
    /**
     * Instance RoleStore.
     */
    private RoleStore roleStore = new RoleStore();
    /**
     * Instance new Role.
     */
    private Role expect = new Role("13");
    /**
     * Section execute before each tests.
     */
    @Before
    public void setUp() {
        roleStore.add(expect);
    }
    /**
     * Test replace one role to other.
     */
    @Test (expected = NotFoundException.class)
    public void thenReplaceRoleWhenOldValueNotExist() {
        roleStore.replace("13", new Role("3"));
        roleStore.findById("13");
    }
    /**
     * Test add & findById method.
     */
    @Test
    public void thenRoleExistWhenReturnRole()  {
        Base result = roleStore.findById("13");
        Assert.assertEquals(expect, result);
    }
    /**
     * Test if role not found must throw exception.
     */
    @Test (expected = NotFoundException.class)
    public void thenRoleNotFoundThrowException()  {
        Role expectForException = new Role("10");
        roleStore.add(expectForException);
        Base result = roleStore.findById("11");
        Assert.assertEquals(expectForException, result);
    }
}