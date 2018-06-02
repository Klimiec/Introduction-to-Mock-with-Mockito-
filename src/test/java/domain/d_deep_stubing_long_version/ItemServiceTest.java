package domain.d_deep_stubing_long_version;

import domain.model.Item;
import domain.model.Organisation;
import domain.ItemService;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.when;

/**
 *  Description: Verbose stubbing
 */
public class ItemServiceTest implements WithAssertions {


    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        ItemService itemService = new ItemService();


        Item item = mock(Item.class, RETURNS_SMART_NULLS);
        Organisation organisation = mock(Organisation.class);

        when(item.getOrganisation()).thenReturn(organisation);
        when(organisation.getOrganisationId()).thenReturn(0l);

        
        //when
        boolean issueInvoiceInvocationResult = itemService.issueInvoice(item);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }
}