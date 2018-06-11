package domain.a_default_behaviour_of_not_stubbed_method;

import domain.InvoiceService;
import domain.model.Order;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 *  Description: Missing mock for OrderItem.
 *  No smartNull returned hence readability is poor.
 *
 *  Problem:
 *  - what do we test
 *  - what is expected outcome?
 *  - we test: zatwierdzenie faktury dla nowego zamowienia, korekta, testowanie odrzucenia? - no scenario context
 *  Method name:
 *  - method name should be focus on behaviour. Test behaviour not method !!!!!!!!!!!
 *  - method name = testing scenario + expected result  --> behaviour
 *  - production method = one test (common mistake). It's one to many relation.
 *
 *   - method name should NOT start from word 'test'
 *   - word 'should' helps focus on behaviour
 *   - do not start with 'testShould" word test is useless here, show example.
 *
 *   - notation with _ is better then camelCase. Test method should be readable, they are not used in production code.
 *
 *   Explain:
 *   //given //when //then  : kazdy test ma, wstep, rozwiniecie, zakonczenie
 *
 *   - section //given - a lot o mess in our application
 *   - sction //then uses AsssertJ
 *   - explain difference between AssertJ and JUnit
 *
 *   Why assertJ
 *   - http://joel-costigliola.github.io/assertj/
 *   - fluent assertion
 *   - better error message (show example)
 *
 *   - Google truth: http://google.github.io/truth/
 *   - http://google.github.io/truth/comparison
 *
 *
 */
public class InvoiceServiceTest {

    @Test
    public void shouldIssueAnInvoiceWithSuccess() {
        //given
        InvoiceService invoiceService = new InvoiceService();
        Order order = mock(Order.class);

        //when
        boolean issueInvoiceInvocationResult = invoiceService.issueInvoice(order);

        //then
        assertThat(issueInvoiceInvocationResult).isTrue();
    }


}