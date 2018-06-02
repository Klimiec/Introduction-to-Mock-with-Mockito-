package org.mockito.configuration;

import org.mockito.configuration.DefaultMockitoConfiguration;
import org.mockito.internal.stubbing.defaultanswers.ReturnsSmartNulls;
import org.mockito.stubbing.Answer;

public class MockitoConfiguration extends DefaultMockitoConfiguration {

    /**
     * Uncomment to override default Answer for mocks
     */
//    public Answer<Object> getDefaultAnswer() {
//        return new ReturnsSmartNulls();
//    }

}
