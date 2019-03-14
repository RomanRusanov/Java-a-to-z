package ru.rrusanov.xml_xslt_jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class StoreXML {

    private File target;

    private static final Logger LOG = LogManager.getLogger(StoreXML.class.getName());

    private int version = 1;

    public StoreXML() {
        String slash = File.separator;
        this.target = new File("." + slash + "files" + slash + "file.xml");
    }

    public StoreXML(File target) {
        this.target = target;
    }

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
