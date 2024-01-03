package backend;

import utility.Comment;
import utility.Tuple;

import java.sql.*;

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

    public Tuple getDataFromDB(String tableName,int numberOfRows, int numberOfColumns) {
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
    public int getNumberOfRows(String tableName) {
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
    public void handleInsert(Comment comment) {
        String query = "INSERT INTO comments (item_id, comment) VALUES ('"
                         + comment.getId() + "','" + comment.getCommentText() + "')";
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
