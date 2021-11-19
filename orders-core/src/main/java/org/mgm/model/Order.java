package org.mgm.model;


import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private long orderNumber;
    private List<String> purchasedProducts;

    public List<String> getPurchasedProducts() {
        return purchasedProducts;
    }

    public Order() {
        purchasedProducts = new ArrayList<String>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public long getOrderNumber() {
        return orderNumber;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void addProduct(String purchasedProduct) {
        purchasedProducts.add(purchasedProduct);
    }

}
