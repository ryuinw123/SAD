package creational;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

public class JSONBookMetadataExporter extends BookMetadataExporter{
    private JSONBookMetadataFormatter JSONBook;

    public JSONBookMetadataExporter() {
        JSONBook = new JSONBookMetadataFormatter();
        bookMetadataFormatter = JSONBook;
    }
}
