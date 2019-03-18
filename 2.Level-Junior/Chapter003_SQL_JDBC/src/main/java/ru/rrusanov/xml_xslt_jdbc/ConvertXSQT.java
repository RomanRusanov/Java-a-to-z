package ru.rrusanov.xml_xslt_jdbc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Class convert xml to other xml structure.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.03.19
 */
public class ConvertXSQT {
    /**
     * Logger.
     */
    private static final Logger LOG = LogManager.getLogger(ConvertXSQT.class.getName());
    /**
     * Version for Logger.
     */
    private int version = 1;

    /**
     * The method convert from dest xml file to source xml file, using scheme xsl file.
     * @param source source xml file
     * @param dest destination xml file
     * @param scheme scheme xsl file
     */
    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer(new StreamSource(new FileInputStream(scheme)));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new StreamSource(new FileInputStream(source)),
                    new StreamResult(new File(String.valueOf(dest)))
            );
        } catch (FileNotFoundException | TransformerException e) {
            LOG.error(String.format(
                    "Error transforming, or file operation. Version:%d%n Exception:%s", version, e.toString())
            );
        }
    }

    /**
     * The method parse to System.out sum all entries element.
     * qName - current tag in xml.
     * attribute.getValue(0) - First attribute current tag.
     * @param source source xml file to count and parse.
     */
    public void parse(File source) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            if (source.exists()) {
                try {
                    parser.parse(source,
                        new DefaultHandler() {
                            private Integer sum = 0;
                            @Override
                            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                                if (qName.equals("entry")) {
                                    sum = sum + Integer.valueOf(attributes.getValue(0));
                                }
                            }
                            @Override
                            public void endDocument() {
                                System.out.println(String.format("Sum all entries = %d", sum));
                            }
                        }
                    );
                } catch (IOException e) {
                    LOG.error(String.format(
                            "Error passed file. Version:%d%n Exception:%s", version, e.toString())
                    );
                }
            }
        } catch (ParserConfigurationException | SAXException e) {
            LOG.error(String.format(
                    "Error with parser SAX. Version:%d%n Exception:%s", version, e.toString())
            );
        }
    }
}