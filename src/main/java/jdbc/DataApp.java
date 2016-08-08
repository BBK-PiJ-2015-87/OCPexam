package jdbc;

import java.sql.*;

/**
 * Created by vladimirsivanovs on 08/08/2016.
 */
public class DataApp {
    public static void main(String[] args) {
        try (Connection connection = DBConnector.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");

            System.out.println("ID" + "\t" + "NAME" +"\t" + "SURNAME");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name") + "\t" + resultSet.getString("surname"));
            }
            statement.close();

            statement = connection.createStatement();
            statement.executeUpdate("Create table numbers (id int primary key, name varchar(20))");
            statement.close();

            statement = connection.createStatement();

            for (int num = 0; num <10; num ++) {
                String query = "INSERT INTO numbers (id, name) values (" + num + ", " + "\'Name" + num + "\');";
                System.out.println(query);
                statement.executeUpdate(query);

            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

class DBConnector{
    public static Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/";
        String database = "vlad";
        return DriverManager.getConnection(url + database);
    }
}



