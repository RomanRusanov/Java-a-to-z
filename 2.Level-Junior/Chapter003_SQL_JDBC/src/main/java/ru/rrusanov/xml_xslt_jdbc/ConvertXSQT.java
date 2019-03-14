package ru.rrusanov.xml_xslt_jdbc;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;

public class ConvertXSQT {

    public void convert(File source, File dest, File scheme) {

    }

    public static void main(String[] args) throws TransformerException {
        String xsl = "<?xml version=\"1.0\"?>\n" +
                "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
                "<xsl:template match=\"/\">\n" +
                "<entries>" +
                "   <xsl:for-each select=\"entries/entry\">\n" +
                "       <entry>" +
                "           <xsl:attribute name=\"field\">" +
                "               <xsl:value-of select=\"field\"/>" +
                "           </xsl:attribute>" +
                "       </entry>\n" +
                "   </xsl:for-each>\n" +
                " </entries>\n" +
                "</xsl:template>\n" +
                "</xsl:stylesheet>\n";

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<entries>\n" +
                "   <entry>\n" +
                "       <field>1</field>\n" +
                "   </entry>\n" +
            "       <entry>\n" +
                "       <field>2</field>\n" +
                "   </entry>\n" +
                "</entries>";
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(xsl.getBytes()))
        );
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(xml.getBytes())),
                new StreamResult(System.out)
        );
    }
}
