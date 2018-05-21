package ru.rrusanov.generic;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.05.2018
 *
 * User class.
 */
public class User extends Base{

    /**
     * Default constructor.
     *
     * @param id unique id.
     */
    protected User(String id) {
        super(id);
    }
    @Override
    public String getId(){
        return super.getId();
    }
}
