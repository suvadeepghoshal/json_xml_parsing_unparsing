package models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "books")
public class Books {
    private List<Book> booksList;

    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return booksList;
    }

    public void setBooks(List<Book> booksList) {
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return "Books [booksList=" + booksList + "]";
    }
    
}
