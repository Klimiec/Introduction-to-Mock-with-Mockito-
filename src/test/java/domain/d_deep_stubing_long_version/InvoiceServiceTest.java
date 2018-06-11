package domain.d_deep_stubing_long_version;

import domain.model.Order;
import domain.model.OrderItem;
import domain.InvoiceService;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.when;

/**
 *  Description: Verbose stubbing
 */
public class InvoiceServiceTest {


    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        InvoiceService invoiceService = new InvoiceService();


        Order order = mock(Order.class, RETURNS_SMART_NULLS);
        OrderItem orderItem = mock(OrderItem.class);

        when(order.getOrderItem()).thenReturn(orderItem);
        when(orderItem.getId()).thenReturn(0l);

        
        //when
        boolean issueInvoiceInvocationResult = invoiceService.issueInvoice(order);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }
}