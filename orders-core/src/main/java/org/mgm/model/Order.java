package org.mgm.model;


import java.util.List;

public class Order {

    public Order() {
        orderNumber = 0;
        customer = new Customer();
        purchasedProducts = null;
    }

    private Customer customer;
    private long orderNumber;
    private List<Product> purchasedProducts;

    public Customer getCustomer() {
        return customer;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPurchasedProducts(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

}
