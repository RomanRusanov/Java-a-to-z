package demonstration;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 24.08.2020
 * email roman9628@gmail.com
 * The class describe simple object.
 */
public class User {
    /**
     * The String field.
     */
    private String name;

    /**
     * The default constructor.
     * @param name String name.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * The class execute when this object destroy of GC.
     * @throws Throwable Exception.
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Destroy object" + this.name);
    }
}