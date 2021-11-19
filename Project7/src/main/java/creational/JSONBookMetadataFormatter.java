package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    private JSONArray bookList;
    private JSONObject bookObj;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        bookList = new JSONArray();
        bookObj = new JSONObject();
        bookObj.put(Book.class.getSimpleName()+"s",bookList);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = new JSONArray();
        data.addAll(Arrays.asList(b.getAuthors()));
        jsonObject.put(Book.Metadata.ISBN.value,b.getISBN());
        jsonObject.put(Book.Metadata.AUTHORS.value,data);
        jsonObject.put(Book.Metadata.TITLE.value,b.getTitle());
        jsonObject.put(Book.Metadata.PUBLISHER.value,b.getPublisher());
        bookList.add(jsonObject);
        return this;

    }

    @Override
    public String getMetadataString() {
        return bookObj.toString();
    }
}
