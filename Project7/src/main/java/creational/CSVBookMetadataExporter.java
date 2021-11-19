package creational;

import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    private CSVBookMetadataFormatter CSVBook;

    public CSVBookMetadataExporter(){
        try {
            CSVBook = new CSVBookMetadataFormatter();
            bookMetadataFormatter = CSVBook;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
