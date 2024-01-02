package backend;

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
        String query = "SELECT * FROM " + tableName;
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
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
}
