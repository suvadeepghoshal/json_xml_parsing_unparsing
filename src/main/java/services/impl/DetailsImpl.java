package services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dao.DetailsDao;
import dao.impl.DetailsDaoImpl;
import models.Author;
import models.Book;
import models.Books;
import models.Pair;
import services.Details;
import utilities.GetXml;
import utilities.impl.GetXmlImpl;
import java.io.StringReader;

public class DetailsImpl implements Details {

    @Override
    public void makeDetails(String data) {
        JsonParser jsonParser = new JsonParser();
        JsonArray books = (JsonArray) jsonParser.parse(data);
        List<Book> bookList = new LinkedList<>();
        Map<String, String> authorMap = new HashMap<>();
        for (Object b : books) {
            JsonObject book = (JsonObject) b;
            String bookId = book.get("id").toString();
            String bookTitle = book.get("title").toString();
            String bookPrice = book.get("price").toString();
            JsonArray authors = (JsonArray) book.get("authors");
            // 1, 2, 3
            List<Author> authorList = new LinkedList<>();
            for (Object a : authors) {
                JsonObject author = (JsonObject) a;
                String authorId = author.get("id").toString();
                String authorName = author.get("name").toString();
                Author aObj = new Author();
                aObj.setId(authorId);
                aObj.setName(authorName);
                if (!authorMap.containsKey(authorId))
                    authorMap.put(authorId, authorName);
                authorList.add(aObj);
            }
            Book bObj = new Book();
            bObj.setBookId(bookId);
            bObj.setBookTitle(bookTitle);
            bObj.setBookPrice(bookPrice);
            bObj.setAuthors(authorList);
            bookList.add(bObj);
        }
        /* Sending to the Database */
        for (Book book : bookList) {
            // DetailsDao detailsDao = new DetailsDaoImpl();
            // detailsDao.createBooks(book);
        }
        for (Map.Entry<String, String> entry : authorMap.entrySet()) {
            // DetailsDao detailsDao = new DetailsDaoImpl();
            // detailsDao.createAuthors(entry.getKey(), entry.getValue());
        }
        GetXml getXml = new GetXmlImpl();
        Books B = new Books();
        B.setBooks(bookList);
        getXml.getXmlData(B);
        for (int i = 0; i < bookList.size(); ++i) {
            for (int j = 0; j < bookList.get(i).getAuthors().size(); ++j) {
                Pair<String, String> pair = new Pair<>();
                pair.setFirst(bookList.get(i).getAuthors().get(j).getId());
                pair.setSecond(bookList.get(i).getBookId());
                // DetailsDao detailsDao = new DetailsDaoImpl();
                // detailsDao.mapping(pair);
            }
        }
    }

    @Override
    public void makeXmlDetails(String data) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Books.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Books books = (Books) unmarshaller.unmarshal(new StringReader(data));
            List<Book> bookList = books.getBooks();
            Map<String, String> authorXmlMap = new HashMap<>();
            for (int i = 0; i < bookList.size(); ++i) {
                DetailsDao detailsDao = new DetailsDaoImpl();
                detailsDao.createBooks(bookList.get(i));
            }
            for (int i = 0; i < bookList.size(); ++i) {
                for (int j = 0; j < bookList.get(i).getAuthors().size(); ++j) {
                    if (!authorXmlMap.containsKey(bookList.get(i).getAuthors().get(j).getId())) {
                        authorXmlMap.put(bookList.get(i).getAuthors().get(j).getId(),
                                bookList.get(i).getAuthors().get(j).getName());
                    }
                }
            }
            for (Map.Entry<String, String> entry : authorXmlMap.entrySet()) {
                DetailsDao detailsDao = new DetailsDaoImpl();
                detailsDao.createAuthors(entry.getKey(), entry.getValue());
            }
            for (int i = 0; i < bookList.size(); ++i) {
                for (int j = 0; j < bookList.get(i).getAuthors().size(); ++j) {
                    Pair<String, String> pair = new Pair<>();
                    pair.setFirst(bookList.get(i).getAuthors().get(j).getId());
                    pair.setSecond(bookList.get(i).getBookId());
                    DetailsDao detailsDao = new DetailsDaoImpl();
                    detailsDao.mapping(pair);
                }
            }
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
