package ocp.jdbc;


import java.sql.*;

/**
 * There is five main JDBC interfaces
 * Driver: Enables connection to database
 * Connection: Sends command to database
 * PreparedStatement: Executes a SQL query
 * CallableStatement: Executes commands stored in the database
 * ResultSet: Reads results of a query
 * All interfaces are in java.sql package
 */

public class JdbcMain {

    final static String URL = "jdbc:postgresql://localhost:5432/coffeeshop";
    final static String SELECT = "select * from coffee_drinks";
    final static String INSERT = "insert into coffee_drinks values ('6','Long Black','Test of Statement')";
    final static String UPDATE = "update coffee_drinks set description='Test of Statement' where id='5'";
    final static String DELETE = "delete from coffee_drinks";
    final static String ST_PROCEDURE = "call read_coffee()";

    public static void main(String[] args) {
        new JdbcMain().executeDelete();
        new JdbcMain().executeSelect();
        new JdbcMain().executeInsert();
        new JdbcMain().executeUpdate();
        new JdbcMain().executeProcedure();
    }

    /**
     * There are two ways to get connection to database:
     * - DataSource (preferably) with connection pool you can reuse
     * - DriveManager
     * Queries:
     * executeQuery() return ResultSet (Select only)
     * execute() return boolean (DML / DDL / Select)
     * executeUpdate() return int (how columns updated/inserted/deleted) (DML/DDL)
     */

    public void executeSelect() {
        try (Connection connection = DriverManager.getConnection(URL, "barista_owner", "271985");
             PreparedStatement statement = connection.prepareStatement(SELECT);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Connected!");
            System.out.format("Schema: %s", connection.getSchema());
            System.out.format("\nQuery output:");
            while (resultSet.next()) {
                System.out.format("\n%s ", resultSet.getString(1));
                System.out.format("\n%s ", resultSet.getString(2));
                System.out.format("\n%s ", resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeInsert() {
        try (Connection connection = DriverManager.getConnection(URL, "barista_owner", "271985");
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            int nums = statement.executeUpdate();
            System.out.println("Connected!");
            System.out.format("Schema: %s", connection.getSchema());
            System.out.format("\nNUmber of rows inserted %s", nums);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeUpdate() {
        try (Connection connection = DriverManager.getConnection(URL, "barista_owner", "271985");
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            int nums = statement.executeUpdate();
            System.out.println("Connected!");
            System.out.format("Schema: %s", connection.getSchema());
            System.out.format("\nNUmber of rows updated %s", nums);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeDelete() {
        try (Connection connection = DriverManager.getConnection(URL, "barista_owner", "271985");
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            int nums = statement.executeUpdate();
            System.out.println("Connected!");
            System.out.format("Schema: %s", connection.getSchema());
            System.out.format("\nNUmber of rows deleted %d", nums);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeProcedure() {
        try (Connection connection = DriverManager.getConnection(URL, "barista_owner", "271985");
             CallableStatement statement = connection.prepareCall(ST_PROCEDURE)) {
            ResultSet nums = statement.executeQuery();
            System.out.println("Connected!");
            System.out.format("\nSchema: %s", connection.getSchema());
            while (nums.next()) {
                System.out.format("Procedure returns %d\n", nums.getString(0));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }


}
