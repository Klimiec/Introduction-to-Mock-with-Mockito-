package domain.b_smart_null;

import domain.model.Item;
import domain.ItemService;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;

/**
 *  Description: Missing mock for Organisation.
 *  Make use of smartNull to increase readability.
 */

public class ItemServiceTest implements WithAssertions {


    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        ItemService itemService = new ItemService();
        Item item = mock(Item.class, RETURNS_SMART_NULLS);

        //when
        boolean issueInvoiceInvocationResult = itemService.issueInvoice(item);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }
}