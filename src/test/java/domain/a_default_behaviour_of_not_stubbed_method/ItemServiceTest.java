package domain.a_default_behaviour_of_not_stubbed_method;

import domain.ItemService;
import domain.model.Item;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 *  Description: Missing mock for Organisation.
 *  No smartNull returned hence readability is poor.
 */
public class ItemServiceTest {

    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        ItemService itemService = new ItemService();
        Item item = mock(Item.class);

        //when
        boolean issueInvoiceInvocationResult = itemService.issueInvoice(item);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }


}