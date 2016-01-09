package HW10.t02.DAO;

import java.util.List;

public interface BookDAO {

    public List<Book> getAllBooks();

    public boolean create(Book book);
    public Book search(int id);
    public boolean delete(Book book);
}
