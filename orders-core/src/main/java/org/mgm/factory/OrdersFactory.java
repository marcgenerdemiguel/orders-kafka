package org.mgm.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mgm.db.*;
import org.mgm.model.Customer;
import org.mgm.model.Order;
import org.mgm.model.Product;
import org.mgm.model.PurchasedProduct;

import java.util.Random;

/**
 * Generate customers.
 *
 */
public class OrdersFactory {

    private static final int MAX_PRODUCTS_ORDER = 25;
    private static final int MAX_ID_PRODUCT = 10000;
    private static final int MAX_QUANTITY_PRODUCTS = 50;
    private static final int MAX_ID_CUSTOMER = 100;

    public void OrdersFactory() {
        CreateTables db = new CreateTables();
        db.create();
        CreateCustomers customers = new CreateCustomers();
        customers.create();
        CreateProducts products = new CreateProducts();
        products.create();
    }

    public String createOrder(long orderNumber) {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        String orderAsString = "";
        try {
            int n_products_order = this.randomNumber(MAX_PRODUCTS_ORDER);
            int id_customer = this.randomNumber(MAX_ID_CUSTOMER);
            Customer customer = new Customer(id_customer);
            order.setCustomer(customer);
            for (int i=1; i<n_products_order; i++) {
                int n_products =  this.randomNumber(MAX_QUANTITY_PRODUCTS);
                int id_product = this.randomNumber(MAX_ID_PRODUCT);
                Product product = new Product(id_product);
                PurchasedProduct purchasedProduct = new PurchasedProduct(product, n_products);
                order.addProduct(objectMapper.writeValueAsString(purchasedProduct));
            }
            orderAsString = objectMapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(orderAsString);
        return orderAsString;

    }

    // generate number from 1 to upperbound
    private int randomNumber(int upperbound) {
        Random rand = new Random(); //instance of random class
        return rand.nextInt(upperbound+1);
    }

}
