package org.mgm.db;

import org.mgm.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBOperation {

    protected static void queryInTable(String sentence_sql) {
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate(sentence_sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("operation database successfully");
    }

    public static Customer selectInTableCustomer(int id) {

        Connection c;
        Statement stmt;
        Customer customer = new Customer();

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE ID = " + id);

            if (rs.next()) {
                customer = new Customer();
                customer.setId(id);
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setMail(rs.getString("mail"));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return customer;
    }


}
