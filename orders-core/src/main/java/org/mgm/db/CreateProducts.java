package org.mgm.db;

public class CreateProducts {

    public void create() {
        // insert rows in product table
        int i = 0;
        for (i=0; i<10000; i++) {
            DBOperation.queryInTable("INSERT INTO PRODUCT (" +
                    "ID, " +
                    "NAME, " +
                    "PRICE) " +
                    "VALUES " +
                    "(" + i + "," +
                    "'Product_" + i + "'," +
                    i * 100.0 + ");"
            );
        }
        System.out.println("insert:" +  i + " rows in table: PRODUCT");
    }
}
