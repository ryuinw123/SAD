package creational;

import java.io.PrintStream;
import java.util.Iterator;

public class JSONBookMetadataExporter extends BookMetadataExporter{
    private JSONBookMetadataFormatter JSONBook;
    public JSONBookMetadataExporter() {
        JSONBook = new JSONBookMetadataFormatter();
    }

    @Override
    public void export(PrintStream stream) {
        JSONBook = new JSONBookMetadataFormatter();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext())
        {
            JSONBook.append(bookIterator.next());
        }
        stream.println(JSONBook.getMetadataString());
    }
}
