//Brand Citozi SDA Academy
package Task1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class JbdcApplication {
//    public static void main(String[] args) throws ClassNotFoundException {
//
//        try (Connection connection = DriverManager.getConnection(Task1.UserUtils.DATABASE_HOST, Task1.UserUtils.DATABASE_USER, Task1.UserUtils.DATABASE_PASSWORD))
//        try (Statement deleteStatement = connection.createStatement()) {
//            deleteStatement.execute("DROP TABLE IF EXISTS MOVIESDA");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try (Statement createTableStatement = conne)
//    }


    public static void main(String[] args) throws ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection(UserUtils.DATABASE_HOST, UserUtils.DATABASE_USER, UserUtils.DATABASE_PASSWORD)) {
            try (Statement deleteStatement = connection.createStatement()) {
                deleteStatement.execute("DROP TABLE IF EXISTS moviesOfSDA");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //create table
//            try (Statement createTableStatement = connection.createStatement()) {
//                String createTableQuery = "CREATE TABLE IF NOT EXISTS MOVIES (id INTEGER AUTO_INCREMENT, " +
//                        "title VARCHAR(255), " +
//                        "genre VARCHAR(255), " +
//                        "yearOfRelease INTEGER, " +
//                        "PRIMARY KEY (id))";
//                createTableStatement.execute(createTableQuery);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

//            //insert record
//            try(Statement insertItemStatement = connection.createStatement();){
//                String insertStarWarsQuery="INSERT INTO MOVIES(title, genre, yearOfRelease) VALUES ('Star Wars',' Action', 2015)";
//                String insertWolfOfWallStreet="INSERT INTO MOVIES(title, genre, yearOfRelease) VALUES ('Wolf Of Wall Street','Comedy/Crime', 2014)";
//                String insertHomeAlone1="INSERT INTO MOVIES(title, genre, yearOfRelease) VALUES ('Home Alone','Comedy/Family', 1990)";
//                String insertSaveChristmas="INSERT INTO MOVIES(title, genre, yearOfRelease) VALUES ('Save Christmas','Comedy/Family', 2020)";
//                String insertMacAndDevin="INSERT INTO MOVIES(title, genre, yearOfRelease) VALUES ('Mac And Devin','Comedy/Teenager', 2012)";
//
//                insertItemStatement.execute(insertStarWarsQuery);
//                insertItemStatement.execute(insertWolfOfWallStreet);
//                insertItemStatement.execute(insertHomeAlone1);
//                insertItemStatement.execute(insertSaveChristmas);
//                insertItemStatement.execute(insertMacAndDevin);
//            }catch (SQLException e) {
//                e.printStackTrace();
//            }
//            //update records
//            try (PreparedStatement updateStatement = connection.prepareStatement("UPDATE MOVIES SET title = ? WHERE id = ?")) {
//                updateStatement.setString(1, "Star Wars Force Awakens");
//                updateStatement.setInt(2, 1);
//                updateStatement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

            //delete records
//            try (Statement deleteItemStatement = connection.createStatement()) {
//                String deleteItemQuery = "DELETE FROM MOVIES WHERE id = 6";
//                deleteItemStatement.execute(deleteItemQuery);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

            //read record
            try (Statement readItemsStatement = connection.createStatement()) {
                String readItemsQuery = "SELECT * FROM MOVIES";
                ResultSet rs = readItemsStatement.executeQuery(readItemsQuery);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String genre = rs.getString("genre");
                    int yearOfRelease = rs.getInt("yearOfRelease");

                    System.out.println("#####################");
                    System.out.println("Id: " + id);
                    System.out.println("Title: " + title);
                    System.out.println("Genre: " + genre);
                    System.out.println("Year of release: " + yearOfRelease);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}