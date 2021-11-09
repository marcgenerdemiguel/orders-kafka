package org.mgm.factory;

import org.mgm.model.Customer;

/**
 * Generate customers.
 *
 */
public final class CustomerFactory {

    public static Customer generateCustomer() {
        Customer customer = new Customer();
        customer.setName("Marc");
        customer.setSurname("Gener");
        customer.setMail("marcgener@hotmail.com");
        return customer;
    }
}
