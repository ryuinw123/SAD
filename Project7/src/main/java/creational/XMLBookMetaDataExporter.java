package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.PrintStream;
import java.util.Iterator;

public class XMLBookMetaDataExporter extends BookMetadataExporter{
    private XMLBookMetadataFormatter XMLBook;

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
