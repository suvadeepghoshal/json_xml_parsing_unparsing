package dao;

import models.Book;
import models.Pair;
import java.util.List;

public interface DetailsDao {
    void createBooks(Book book);

    void createAuthors(String id, String name);

    void mapping(Pair<String, String> pair);

    List<Book> getGetails();
}
