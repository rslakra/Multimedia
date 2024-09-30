package com.rslakra.melody.iws.framework.filter;

import com.rslakra.appsuite.core.Payload;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @created 3/12/24 11:15 AM
 */
@ExtendWith(SpringExtension.class)
public class FilterTest {

    @Test
    void testFilter() {
        Payload<String, Object> payload = Payload.newBuilder()
                .ofPair(Filter.ID, 100)
                .ofPair("name", "Rohtash")
                .ofPair("isPopular", true);
        FilterImplTest filter = new FilterImplTest(payload);
        assertEquals("Rohtash", filter.asType(AbstractFilter.NAME, String.class));
        assertTrue(filter.asType("isPopular", Boolean.class));
        assertNull(filter.asType("isKey", Boolean.class));
    }
}
