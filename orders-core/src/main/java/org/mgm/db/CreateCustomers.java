package org.mgm.db;

public class CreateCustomers {

    public void create() {
        // insert rows in customer table
        int i=0;
        for (i=0; i<100; i++) {
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
        System.out.println("insert:" +  i + " rows in table: CUSTOMER");
    }
}
