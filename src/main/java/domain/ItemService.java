package domain;

import domain.model.Item;

public class ItemService {


    public boolean issueInvoice(Item item) {

        Long organisationId = item.getOrganisation().getOrganisationId();

        /**
         * Do some useful job to issue an invoice
         */

        return true;
    }

}
