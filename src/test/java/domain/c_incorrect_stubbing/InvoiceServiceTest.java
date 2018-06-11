package domain.c_incorrect_stubbing;

import domain.InvoiceService;
import domain.model.Order;
import domain.model.OrderItem;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.when;

/**
 *  Description: Incorrect way of stubbing.
 *  Mock is not a normal object!
 *  Invoking setter on mock doesn't work as expected.
 *
 *
 *  -Show how not to stub.
 *  Mock is not real object - it a proxy with default behaviour for each method - NULL
 *
 *  - Show hot to properly stub
 *
 *  - Introduce mockito BDD: import static org.mockito.BDDMockito.*;
 *   when(order.getOrderItem()).thenReturn(orderItem);
 *   given(order.getOrderItem()).willReturn(orderItem);
 *
 *   Word 'when' should not appear in section //given
 *
 *   To improve:
 *   Mock return mock - to many mock, hard to concentrate on the most important.
 *
 *
 */



public class InvoiceServiceTest {


    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        InvoiceService invoiceService = new InvoiceService();

        Order order = mock(Order.class, RETURNS_SMART_NULLS);
        OrderItem orderItem = mock(OrderItem.class);
        order.addOrderItem(orderItem);

//        when(order.getOrderItem()).thenReturn(orderItem);
//        when(orderItem.getId()).thenReturn(0l);

//        given(order.getOrderItem()).willReturn(orderItem);
//        given(orderItem.getId()).willReturn(0l);

        //when
        boolean issueInvoiceInvocationResult = invoiceService.issueInvoice(order);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }
}