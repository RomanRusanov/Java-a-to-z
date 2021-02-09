package di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.02.2021
 * email roman9628@gmail.com
 * The class describe how work DI context.
 * Register and contain class, after get initialized instances.
 */
public class Context {
    /**
     * The filed contain all instance.
     */
    private Map<String, Object> els = new HashMap<String, Object>();

    /**
     * The method add instance to collection, only if instance have one constructor.
     * @param cl class instance.
     */
    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<Object>();
        for (Class arg : con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Coun't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    /**
     * The getter for instance.
     * @param inst Instance.
     * @param <T> Type.
     * @return Instance from collection.
     */
    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName());
    }
}