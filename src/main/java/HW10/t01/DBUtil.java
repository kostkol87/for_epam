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
    /**
     * getting connection via JDBC
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getCon() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\HW07\\t01\\sqlite.db");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * Methods creates table in case if it is not exists
     *
     * @param connection
     */
    public void createTestTable(Connection connection) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * this method gets all sample table
     *
     * @param connection
     * @return
     */
    public ArrayList<String[]> getAllFields(Connection connection) {

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * updates sigle line by id
     *
     * @param connection
     * @param id
     * @param title
     * @param author
     */
    public void upadeLine(Connection connection, int id, String title, String author) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE books SET title = ?, author = ? WHERE id=?")) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, id);
            ps.executeUpdate();
            log.debug(("now id:" + id + " is " + title + " " + author));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * gets single line by id
     *
     * @param connection
     * @param id
     * @return
     */
    public String getLine(Connection connection, int id) {

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT id, title, author FROM books WHERE id=" + id);
            String result = rs.getString("id") + " " + rs.getString("title") + " " + rs.getString("author");
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * inserts single line
     *
     * @param connection
     * @param title
     * @param author
     */
    public void insertLine(Connection connection, String title, String author) {

        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO books ('title', 'author') VALUES (?, ?);")) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection drops table with name:
     * @param table
     */
    public void dropTable(Connection connection, String table) {
        try (Statement st = connection.createStatement()) {
            st.execute(String.format("DROP TABLE IF EXISTS %s", table));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

