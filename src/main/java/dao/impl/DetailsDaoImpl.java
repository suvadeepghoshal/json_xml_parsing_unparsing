package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.DetailsDao;
import models.Book;
import models.Pair;
import utilities.DbUtil;
import utilities.impl.DbUtilImpl;

public class DetailsDaoImpl implements DetailsDao {

    Connection connection = null;

    PreparedStatement preparedStatement = null;

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

}
