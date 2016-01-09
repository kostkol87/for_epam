package HW10.t02.DAO;

import HW10.t02.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin on 09.01.2016.
 */
public class BookDAOImpl implements BookDAO {
    private static BookDAOImpl INSTANCE;

    public static BookDAOImpl getInstance() {

        if (INSTANCE == null)
            synchronized (BookDAOImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BookDAOImpl();
                }
            }

        return INSTANCE;
    }
    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        ConnectionPool instance = ConnectionPool.getInstance();
        Connection connection = instance.getConnection();
        try(PreparedStatement ps = connection.prepareStatement("SELECT id, title, author FROM books")){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                books.add(book);
            }
            instance.free(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
//
//    @Override
//    public Book getStudent(int id) {
//        Book book = new Book();
//        ConnectionPool instance = ConnectionPool.getInstance();
//        Connection connection = instance.getConnection();
//        try(PreparedStatement ps = connection.prepareStatement("SELECT id, title, author FROM books WHERE id = ?")){
//            ps.setInt(1, id);
//            ResultSet resultSet = ps.executeQuery();
//
//            book.setId(resultSet.getInt(1));
//            book.setTitle(resultSet.getString(2));
//            book.setAuthor(resultSet.getString(3));
//
//            instance.free(connection);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return book;
//    }

    @Override
    public boolean create(Book book) {
        ConnectionPool instance = ConnectionPool.getInstance();
        Connection connection = instance.getConnection();
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO books ('title', 'author') VALUES (?, ?);")){
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.execute();
            instance.free(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Book search(int id) {
        List<Book> allBooks = getAllBooks();
        Book result = null;
        for (Book currBook : allBooks){
            if (currBook.getId() == id){
                result = currBook;
            }
        }
        return result;
    }

    @Override
    public boolean delete(Book book) {
        ConnectionPool instance = ConnectionPool.getInstance();
        Connection connection = instance.getConnection();
        try(PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE id=?")){
            ps.setInt(1, book.getId());
            ps.execute();
            instance.free(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
