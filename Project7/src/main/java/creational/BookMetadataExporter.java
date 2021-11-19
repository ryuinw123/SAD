package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

public abstract class BookMetadataExporter extends BookCollection {
    BookMetadataFormatter bookMetadataFormatter;

    public void export(PrintStream stream) throws ParserConfigurationException, IOException {
        for (Book b : books){
            bookMetadataFormatter.append(b);
        }
        stream.print(bookMetadataFormatter.getMetadataString());
    }
}
