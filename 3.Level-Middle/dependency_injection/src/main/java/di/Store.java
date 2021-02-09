package di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 09.02.2021
 * email roman9628@gmail.com
 * The class contain collection for example.
 */
@Scope("prototype")
@Component
public class Store {
    /**
     * The field contain collection of Strings.
     */
    private List<String> data = new ArrayList<String>();

    /**
     * The method add String to collection.
     * @param value String.
     */
    public void add(String value) {
        data.add(value);
    }

    /**
     * The method return all Strings.
     * @return Strings.
     */
    public List<String> getAll() {
        return data;
    }
}