package org.mgm.factory;

import org.mgm.db.CreateOrdersDB;
import org.mgm.db.DBOperation;
import org.mgm.model.Customer;

/**
 * Generate customers.
 *
 */
public final class OrdersFactory {

    public static Customer generateCustomer(int id) {
        Customer customer = new Customer();
        CreateOrdersDB db = new CreateOrdersDB();
        db.createDB();
        return DBOperation.selectInTableCustomer(id);
    }
}
