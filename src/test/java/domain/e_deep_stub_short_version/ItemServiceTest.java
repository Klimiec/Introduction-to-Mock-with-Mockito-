package domain.e_deep_stub_short_version;

import domain.ItemService;
import domain.model.Item;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.when;

public class ItemServiceTest implements WithAssertions {


    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        ItemService itemService = new ItemService();


        Item item = mock(Item.class, RETURNS_DEEP_STUBS);
        when(item.getOrganisation().getOrganisationId()).thenReturn(0l);
        
        //when
        boolean issueInvoiceInvocationResult = itemService.issueInvoice(item);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }
}