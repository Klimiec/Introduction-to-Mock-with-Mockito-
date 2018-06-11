package domain;

import domain.model.Order;

public class InvoiceService {


    public boolean issueInvoice(Order order) {

        Long id = order.getOrderItem().getId();

        /**
         * Do some useful job to issue an invoice
         */

        return true;
    }

}
