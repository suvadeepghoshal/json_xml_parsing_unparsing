package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import dao.DetailsDao;
import models.Author;
import models.Book;
import models.Pair;
import utilities.DbUtil;
import utilities.impl.DbUtilImpl;

public class DetailsDaoImpl implements DetailsDao {

    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    @Override
    public void createBooks(Book book) {

        DbUtil dbUtil = new DbUtilImpl();

        final String CREATE_BOOK = "INSERT INTO books(book_id,book_title,book_price) VALUES(?,?,?)";

        try {
            connection = dbUtil.dbConnection(connection);
            preparedStatement = connection.prepareStatement(CREATE_BOOK);
            preparedStatement.setString(1, book.getBookId());
            preparedStatement.setString(2, book.getBookTitle());
            preparedStatement.setString(3, book.getBookPrice());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    @Override
    public void createAuthors(String id, String name) {

        DbUtil dbUtil = new DbUtilImpl();

        final String CREATE_AUTHOR = "INSERT INTO authors(author_id,author_name) VALUES(?,?)";

        try {
            connection = dbUtil.dbConnection(connection);
            preparedStatement = connection.prepareStatement(CREATE_AUTHOR);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    @Override
    public void mapping(Pair<String, String> pair) {
        DbUtil dbUtil = new DbUtilImpl();
        final String MAPPING = "INSERT INTO map(author_id,book_id) VALUES(?,?)";
        try {
            connection = dbUtil.dbConnection(connection);
            preparedStatement = connection.prepareStatement(MAPPING);
            preparedStatement.setString(1, pair.getFirst());
            preparedStatement.setString(2, pair.getSecond());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    @Override
    public List<Book> getGetails() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DbUtil dbUtil = new DbUtilImpl();
        final String FROM_BOOKS = "SELECT book_id, book_title, book_price FROM books";
        List<Book> books = new LinkedList<>();
        try {
            con = dbUtil.dbConnection(con);
            ps = con.prepareStatement(FROM_BOOKS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("book_id"));
                book.setBookTitle(rs.getString("book_title"));
                book.setBookPrice(rs.getString("book_price"));
                book.setAuthors(getAuthorList(book.getBookId()));
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return books;
    }

    private List<Author> getAuthorList(String bookId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String FROM_MAP = "SELECT author_id FROM map WHERE book_id=?";
        final String FROM_AUTHOR = "SELECT author_id, author_name FROM authors WHERE author_id=?";
        // final String GET_AUTHORS = "SELECT a.author_id, a.author_name FROM authors AS
        // a INNER JOIN map AS m ON m.author_id=a.author_id AND m.book_id=?";
        DbUtil dbUtil = new DbUtilImpl();
        List<String> authorIds = new ArrayList<>();
        List<Author> authors = new LinkedList<>();
        try {
            con = dbUtil.dbConnection(con);
            ps = con.prepareStatement(FROM_MAP);
            ps.setString(1, bookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                authorIds.add(rs.getString("author_id"));
            }
            for (String id : authorIds) {
                ps = con.prepareStatement(FROM_AUTHOR);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getString("author_id"));
                    author.setName(rs.getString("author_name"));
                    authors.add(author);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally

        {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return authors;
    }

}
