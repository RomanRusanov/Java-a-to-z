package ru.rrusanov.xml_xslt_jdbc;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ConvertXSQT {

    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer(new StreamSource(new FileInputStream(scheme)));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new StreamSource(
                            new ByteArrayInputStream(xml.getBytes())),
                    new StreamResult(System.out)
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
//    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
//            "<entries>\n" +
//            " <entry>\n" +
//            " <field>1</field>\n" +
//            " </entry>\n" +
//            " <entry>\n" +
//            " <field>2</field>\n" +
//            " </entry>\n" +
//            "</entries>";
}
