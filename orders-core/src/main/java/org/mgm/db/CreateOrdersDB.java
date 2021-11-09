package org.mgm.db;

public class CreateOrdersDB {

    private void createTablesIfNotExists() {
        DBOperation.queryInTable("CREATE TABLE IF NOT EXISTS CUSTOMER (ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL, SURNAME TEXT NOT NULL, MAIL TEXT NOT NULL)");
        //queryInTable("CREATE TABLE PRODUCT ");
        //queryInTable("CREATE TABLE ORDER ");
    }

    private void deleteTables() {
        System.out.println("delete tables");
        DBOperation.queryInTable("DELETE FROM CUSTOMER;");
    }

    private void insertRows() {
        // insert rows in customers table
        for (int i=0; i<100; i++) {
            DBOperation.queryInTable("INSERT INTO CUSTOMER (" +
                    "ID, " +
                    "NAME, " +
                    "SURNAME, " +
                    "MAIL) " +
                    "VALUES " +
                    "(" + i + "," +
                    "'Customer_" + i + "'," +
                    "'Surname_" + i + "'," +
                    "'customer_" + i + "@hotmail.com');"
            );
        }
    }

    public void createDB() {
        createTablesIfNotExists();
        deleteTables();
        insertRows();
    }

}
