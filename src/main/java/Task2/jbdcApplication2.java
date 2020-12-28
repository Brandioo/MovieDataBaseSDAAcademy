package Task2;

import Task1.UserUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jbdcApplication2 {


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(UserUtils.DATABASE_HOST, UserUtils.DATABASE_USER, UserUtils.DATABASE_PASSWORD)) {
            final MovieDAOImpl movieDAOImpl = new MovieDAOImpl(connection);
            movieDAOImpl.createTable();
            movieDAOImpl.createMovie(new Movie("Back to the futureee with typo", "Fantasy", 1985));
            movieDAOImpl.createMovie(new Movie("Alien", "Fantasy", 1980));
            System.out.println("Display Movie By ID");
            movieDAOImpl.findMovieById(1).ifPresent(System.out::println); // displayed one record
            movieDAOImpl.updateMoviesTitle(1, "Back to the future");
           movieDAOImpl.findAll().forEach(System.out::println); // displayed two records
            // movieDAOImpl.deleteMovie(2);
            //System.out.println(movieDAOImpl.findAll().size()); // one row left in the table
          // movieDAOImpl.deleteTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

