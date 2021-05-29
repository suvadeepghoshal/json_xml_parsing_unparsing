package models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    private String bookId;
    private String bookTitle;
    String bookPrice;
    private List<Author> authors;

    public Book() {
        super();
    }

    public Book(String bookId, String bookTitle, String bookPrice, List<Author> authors) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.authors = authors;
    }

    @XmlElement(name = "book_id")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @XmlElement(name = "book_title")
    public String getBookTitle() {
        return bookTitle;
    }

    
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @XmlElement(name = "book_price")
    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    @XmlElement(name = "author")
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book [authors=" + authors + ", bookId=" + bookId + ", bookPrice=" + bookPrice + ", bookTitle="
                + bookTitle + "]";
    }

}
