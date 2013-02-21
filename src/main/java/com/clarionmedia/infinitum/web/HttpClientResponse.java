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

/**
 * <p>
 * Encapsulates an HTTP response message sent back from a server.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 08/15/12
 * @since 1.0
 */
public interface HttpClientResponse extends HttpClientMessage {

	/**
	 * Returns the HTTP status code that was included with the response.
	 * 
	 * @return status code
	 */
	int getStatusCode();

	/**
	 * Returns the response message data as it was received from the server.
	 * 
	 * @return message data as a byte array
	 */
	byte[] getResponseData();

	/**
	 * Returns the response message data as a {@link String}.
	 * 
	 * @return message data {@code String}
	 */
	String getResponseDataAsString();

	/**
	 * Returns the cookies that were included with the response.
	 * 
	 * @return {@link Map} containing cookies
	 */
	Map<String, String> getCookies();

}
