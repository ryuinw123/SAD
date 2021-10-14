package creational;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    private CSVBookMetadataFormatter CSVBook;

    @Override
    public void export(PrintStream stream) throws IOException {
        CSVBook = new CSVBookMetadataFormatter();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext())
        {
            CSVBook.append(bookIterator.next());
        }
        stream.println(CSVBook.getMetadataString());
    }

}
