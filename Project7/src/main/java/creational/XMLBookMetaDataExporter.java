package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

class XMLBookMetadataExporter extends BookMetadataExporter{
    private XMLBookMetadataFormatter XMLBook;

    public XMLBookMetadataExporter(){
        try {
            XMLBook = new XMLBookMetadataFormatter();
            bookMetadataFormatter = XMLBook;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

}
