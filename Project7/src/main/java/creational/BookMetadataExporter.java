package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    public void export(PrintStream stream) throws ParserConfigurationException, IOException {
        // Please implement this method. You may create additional methods as you see fit.
    }
}
