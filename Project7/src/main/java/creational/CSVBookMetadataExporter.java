package creational;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    private CSVBookMetadataFormatter CSVBook;

    public CSVBookMetadataExporter(){
        try {
            CSVBook = new CSVBookMetadataFormatter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void export(PrintStream stream) throws IOException {
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext())
        {
            CSVBook.append(bookIterator.next());
        }
        stream.print(CSVBook.getMetadataString());
    }

}
