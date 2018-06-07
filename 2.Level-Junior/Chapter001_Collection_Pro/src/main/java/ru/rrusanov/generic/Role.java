package ru.rrusanov.generic;

import java.util.Objects;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.05.2018
 *
 * Role class.
 */
public class Role extends Base {
    /**
     * Default constructor.
     *
     * @param id unique id.
     */
    protected Role(String id) {
        super(id);
    }
    /**
     * The method Getter return id.
     * @return id string.
     */
    @Override
    public String getId(){
        return super.getId();
    }
    /**
     * The method compare Role object by field id.
     * @param obj object to compare.
     * @return boolean result.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Role))
            return false;
        Role role = (Role) obj;
        return role.getId().equals(this.getId());
    }
    /**
     * The method return hash of that object.
     * @return int hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
