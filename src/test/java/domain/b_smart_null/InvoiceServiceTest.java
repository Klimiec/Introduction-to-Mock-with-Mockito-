package domain.b_smart_null;

import domain.InvoiceService;
import domain.model.Order;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;

/**
 *  Description: Missing mock for OrderItem.
 *  Make use of smartNull to increase readability.
 *
 *   TODO:
 *
 *
 *  - we can change default behaviour for creating mock - RETURNS_SMART_NULLS  (change default answer)
 *  - default behaviour in mockito 3.0 : https://github.com/mockito/mockito/issues/971
 *
 *  - SmartNulls are great, do we have to wait for version 3.0?
 *    No, we can use global setting for mockito 1.xxxx!
 *    Yep, mockito has global configuration
 *
 *     *   Introduce:
 *   - method template
 *   - class template
 */

public class InvoiceServiceTest {


    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        InvoiceService invoiceService = new InvoiceService();
//        Order order = mock(Order.class, RETURNS_SMART_NULLS);
        Order order = mock(Order.class);

        //when
        boolean issueInvoiceInvocationResult = invoiceService.issueInvoice(order);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }
}