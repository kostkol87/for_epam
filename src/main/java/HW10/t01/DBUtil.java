package HW10.t01;

import java.sql.*;
import java.util.ArrayList;

import static LOGGER.L4jLogger.log;

/**
 * Создайте таблицу в БД и с помощью JDBC выполните следующие действия
 *  извлеките информацию из таблицы с помощью подготовленного запроса;
 *  обновите несколько записей в таблице;
 *  выберите конкретную запись в таблице;
 *  вставьте новую запись в таблицу;
 *  удалите таблицу.
 */

public class DBUtil {
    public Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\HW07\\t01\\sqlite.db");
        return connection;
    }

    public void createTestTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE if not exists 'books' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'title' text, 'author' text);");
            statement.execute("INSERT INTO books ('title', 'author') VALUES ('451 degrees fahrenheit', 'Ray bradbury');");
            statement.execute("INSERT INTO books ('title', 'author') VALUES ('The Martian Chronicles', 'Ray bradbury');");
            statement.execute("INSERT INTO books ('title', 'author') VALUES ('The October Country', 'Ray bradbury');");
            statement.execute("INSERT INTO books ('title', 'author') VALUES ('The Illustrated Man', 'Ray bradbury');");
            statement.execute("INSERT INTO books ('title', 'author') VALUES ('java full reference', 'Gerb Schildt');");
            statement.execute("INSERT INTO books ('title', 'author') VALUES ('effective java', ' Joshua Bloch');");
            statement.execute("INSERT INTO books ('title', 'author') VALUES ('thinking in java', 'Bruce Eckel');");
            statement.execute("INSERT INTO books ('title', 'author') VALUES ('clean code', 'Robert C. Martin');");
            log.debug("table books was created and were append 8 books");
        }
    }

    public ArrayList<String[]> getAllFields(Connection connection) throws SQLException {

        ResultSet resultSet;
        ArrayList<String[]> result;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, title, author FROM books;")) {
            resultSet = preparedStatement.executeQuery();
            result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new String[]{
                        resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author")
                });
            }
            return result;
        }
    }

    public void upadeLine(Connection connection, int id, String title, String author) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE books SET title = ?, author = ? WHERE id=?")) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, id);
            ps.executeUpdate();
            log.debug(("now id:" + id + " is " + title + " " + author));
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBUtil dbUtil = new DBUtil();

        Connection con = dbUtil.getCon();

        ArrayList<String[]> allFields = dbUtil.getAllFields(con);
        for (String[] strs : allFields) {
            for (String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

    }
}
