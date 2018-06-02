package domain.c_incorrect_stubbing;

import domain.ItemService;
import domain.model.Item;
import domain.model.Organisation;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;

/**
 *  Description: Incorrect way of stubbing.
 *  Mock is not a normal object!
 *  Invoking setter on mock doesn't work as expected.
 */

public class ItemServiceTest implements WithAssertions {


    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        ItemService itemService = new ItemService();

        Item item = mock(Item.class, RETURNS_SMART_NULLS);
        Organisation organisation = mock(Organisation.class);
        item.setOrganisation(organisation);
        
        //when
        boolean issueInvoiceInvocationResult = itemService.issueInvoice(item);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }
}