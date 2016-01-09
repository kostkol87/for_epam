package HW10.t02;

import HW10.t02.DAO.BookDAOImpl;

/**
 * Спроектируйте БД, хранящую информацию, например, о домашней библиотеке.
 * Реализуйте функциональность добавления, поиска и удаления разнообразной информации из
 * этой БД. При реализации используйте (напишите) пул соединений и DAO.
 */
public class Library {
    public static void main(String[] args) {
        BookDAOImpl bookDAO = BookDAOImpl.getInstance();

//        Book newBook = new Book();
//        newBook.setTitle("Test Title");
//        newBook.setAuthor("Test Author");
//        System.out.println(bookDAO.create(newBook));

//        List<Book> allBooks = bookDAO.getAllBooks();
//
//        for (Book book : allBooks) {
//            System.out.println(book);
//        }

//        System.out.println(bookDAO.search(3));

//        bookDAO.delete(bookDAO.getAllBooks().get(7));
//        for (Book book:bookDAO.getAllBooks()){
//            System.out.println(book);
//        }
    }
}
