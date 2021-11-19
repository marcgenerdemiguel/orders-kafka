package org.mgm.model;

public class PurchasedProduct {

    Product product;
    int quantity;
    double total;

    public PurchasedProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return this.quantity * this.product.getPrice();
    }

}
