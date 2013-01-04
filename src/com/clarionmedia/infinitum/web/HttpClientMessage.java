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

package com.clarionmedia.infinitum.web;

import java.util.Map;

import org.apache.http.HttpMessage;

/**
 * <p>
 * Encapsulates an HTTP message, either a request or response.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 08/15/12
 * @since 1.0
 */
public interface HttpClientMessage {
	
	/**
	 * Returns the wrapped {@link HttpMessage}.
	 * 
	 * @return {@code HttpMessage}
	 */
	HttpMessage unwrap();

	/**
	 * Returns the headers that were included with the response.
	 * 
	 * @return {@link Map} containing headers
	 */
	Map<String, String> getHeaders();

	/**
	 * Returns the value for the given header.
	 * 
	 * @param header
	 *            the header to retrieve
	 * @return header value
	 */
	String getHeader(String header);

}
