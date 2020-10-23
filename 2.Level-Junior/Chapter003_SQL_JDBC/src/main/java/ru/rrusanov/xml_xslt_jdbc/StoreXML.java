package ru.rrusanov.xml_xslt_jdbc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;
/**
 * Class convert Entry object into xml structure.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.03.19
 */
public class StoreXML {
    /**
     * The field contain file to store xml output.
     */
    private File target;
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(StoreXML.class.getName());
    /**
     * Version for Logger.
     */
    private int version = 1;

    /**
     * The default constructor. Store output in project_folder/files/file.xml
     */
    public StoreXML() {
        String slash = File.separator;
        this.target = new File("." + slash + "files" + slash + "file.xml");
    }

    /**
     * The constructor take file to store xml.
     * @param target xml file.
     */
    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * The method save Entries from collection to xml file.
     * @param list collection for store in xml.
     */
    public void save(List<Entry> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(new Entries(list), this.target);
        } catch (JAXBException e) {
            LOG.error(String.format(
                "Error create instance JAXB for Entries class. Version:%d%n SQL Exception:%s", version, e.toString())
            );
        }
    }
}