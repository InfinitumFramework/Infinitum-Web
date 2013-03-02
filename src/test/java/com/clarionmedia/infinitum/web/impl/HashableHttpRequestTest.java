/*
 * Copyright (C) 2012 Clarion Media, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clarionmedia.infinitum.web.impl;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.apache.http.Header;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.message.BasicHeader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class HashableHttpRequestTest {

    @Mock
    private RequestWrapper mockRequestWrapper;

    private HashableHttpRequest hashableHttpRequest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        hashableHttpRequest = new HashableHttpRequest(mockRequestWrapper);
    }

    @Test
    public void testGetHeaders() {
        // Setup
        Header header = new BasicHeader("foo", "bar");
        Header[] headers = new Header[] { header };
        when(mockRequestWrapper.getAllHeaders()).thenReturn(headers);

        // Run
        Map<String, String> actual = hashableHttpRequest.getHeaders();

        // Verify
        verify(mockRequestWrapper).getAllHeaders();
        assertEquals("getHeaders result should contain the expected value", "bar", actual.get("foo"));
    }

    // TODO finish unit tests

}
