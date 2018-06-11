package domain.e_deep_stub_short_version;

import domain.InvoiceService;
import domain.model.Order;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.when;


/**
 *  Introduce deep stubing with: RETURNS_DEEP_STUBS  (change default answer)
 *
 *  - mock return mock is code smell: https://static.javadoc.io/org.mockito/mockito-core/1.10.19/org/mockito/Mockito.html#RETURNS_DEEP_STUBS
 *  - remove one mock creation and one stubbing (mock return mock)
 */

public class InvoiceServiceTest implements WithAssertions {


    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        InvoiceService invoiceService = new InvoiceService();


        Order order = mock(Order.class, RETURNS_DEEP_STUBS);
        when(order.getOrderItem().getId()).thenReturn(0l);
        
        //when
        boolean issueInvoiceInvocationResult = invoiceService.issueInvoice(order);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }
}