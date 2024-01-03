package backend;

import utility.Comment;
import utility.Tuple;

import java.sql.*;

/**
 * Connection to the postgresql database, relying on the postgres jdbc driver
 */
public class ConnectionModel {
    private final String url = "jdbc:postgresql://localhost/elden_ring";
    private final String user = "my_user";
    private final String password = "root";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    /* Utilities */

    /**
     * Performs a SELECT * from TABLE_NAME
     * @param tableName the name of the table in the database
     * @param numberOfRows can be removed
     * @param numberOfColumns the number of columns in the table
     * @return a Tuple whose matrix represents all the entries in the table
     */
    public Tuple getDataFromDB(String tableName, int numberOfRows, int numberOfColumns) {
        if(numberOfRows == 0)
            return null;
        String query = "SELECT * FROM " + tableName +";";
        Tuple data = new Tuple(numberOfRows, numberOfColumns); //efectiv unlucky bozo
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query))
        {
            data.setWidth(numberOfColumns);
            while(rs.next()) {
                for(int columnNumber = 1; columnNumber <= numberOfColumns; columnNumber++)
                        data.setDataValue(rs.getString(columnNumber), data.getLength(), columnNumber - 1);
                data.incrementLength(1);
                if(data.getLength() == numberOfRows)
                    break;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    /**
     * Counts the number of rows in a table
     * @param tableName the name of the table in the database
     * @return the number of rows in the table
     */
    public int getNumberOfRows(String tableName) { //TODO handle exception tableName does not exist
        String query = "SELECT COUNT(*) FROM " + tableName;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query))
        {
            rs.next();
            return rs.getInt("count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    /**
     * Inserts a comment inside the database
     * @param comment is the comment to be inserted in the database if no flag is set
     */
    public void handleInsert(Comment comment) {
        String query = "INSERT INTO comments (item_id, comment) VALUES ('"
                         + comment.getId() + "','" + comment.getCommentText() + "')";
        //TODO if item key does not exist
        //TODO db fks to all items
        try (Connection conn = connect(); //TBI maybe useless because i create connection before in screen
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query))
        {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("insert good");
    }
}
