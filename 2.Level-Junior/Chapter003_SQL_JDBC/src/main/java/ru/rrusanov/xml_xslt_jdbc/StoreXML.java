package ru.rrusanov.xml_xslt_jdbc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StoreXML {

    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) {

    }

    public static void main(String[] args) {

//        Entry entry = new Entry();
//        entry.setField(1);

        try {
            String fs = File.separator;
            String filepath = "." + fs + "2.Level-Junior" + fs + "Chapter003_SQL_JDBC" + fs + "files" + fs + "file.xml";
            File file = new File(filepath);
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(new Entry(1), file);
            jaxbMarshaller.marshal(new Entry(1), System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
