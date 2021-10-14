package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

public class XMLBookMetadataExporter extends BookMetadataExporter{
    private XMLBookMetadataFormatter XMLBook;

    public XMLBookMetadataExporter(){
        try {
            XMLBook = new XMLBookMetadataFormatter();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void export(PrintStream stream) throws ParserConfigurationException {
        XMLBook = new XMLBookMetadataFormatter();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext())
        {
            XMLBook.append(bookIterator.next());
        }
        stream.println(XMLBook.getMetadataString());
    }
}
