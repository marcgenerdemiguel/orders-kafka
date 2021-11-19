package org.mgm.db;

public class CreateTables {

    public void create() {
        createTablesIfNotExists();
        deleteTables();
    }

    private void createTablesIfNotExists() {
        DBOperation.queryInTable("CREATE TABLE IF NOT EXISTS CUSTOMER (ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL, SURNAME TEXT NOT NULL, MAIL TEXT NOT NULL)");
        System.out.println("create table: CUSTOMER");
        DBOperation.queryInTable("CREATE TABLE IF NOT EXISTS PRODUCT (ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL, PRICE REAL NOT NULL)");
        System.out.println("create table: PRODUCT");
    }

    private void deleteTables() {
        DBOperation.queryInTable("DELETE FROM CUSTOMER;");
        System.out.println("delete table CUSTOMER");
        DBOperation.queryInTable("DELETE FROM PRODUCT;");
        System.out.println("delete table PRODUCT");
    }

}
