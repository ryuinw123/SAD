package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Current usage
//        BookMetadataFormatter formatter = null;
//        try {
//            formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.JSON);
//            formatter.append(TestData.dragonBook);
//            formatter.append(TestData.dinosaurBook);
//            formatter.reset();
//            formatter.append(TestData.GoFBook);
//            System.out.print(formatter.getMetadataString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }

        // Expected usage
        BookMetadataExporter exporter = new JSONBookMetadataExporter();
        try{
            exporter.add(TestData.dinosaurBook);
            exporter.add(TestData.dragonBook);
            exporter.export(System.out);
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
