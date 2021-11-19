package creational;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class BookCollection {
    protected Set<Book> books;

    public BookCollection() {
        books = new LinkedHashSet<>();
    }

    public void add(Book b) {
        books.add(b);
    }

    public void remove(Book b) {
        books.remove(b);
    }
}
