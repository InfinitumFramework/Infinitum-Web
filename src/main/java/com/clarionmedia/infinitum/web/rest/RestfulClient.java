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

package com.clarionmedia.infinitum.web.rest;

import java.io.InputStream;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.HttpParams;

import com.clarionmedia.infinitum.web.rest.impl.RestResponse;

/**
 * <p>
 * Provides an interface for communicating with a RESTful web service.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 07/06/12
 * @since 1.0
 */
public interface RestfulClient {

	/**
	 * Executes an HTTP GET request to the given URI.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @return HTTP response
	 */
	RestResponse executeGet(String uri);

	/**
	 * Executes an HTTP GET request to the given URI
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param headers
	 *            the headers to send with the request
	 * @return HTTP response
	 */
	RestResponse executeGet(String uri, Map<String, String> headers);

	/**
	 * Executes an HTTP POST request to the given URI using the given content
	 * type and message body.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param messageBody
	 *            the message body
	 * @param contentType
	 *            the content type of the message body
	 * @return HTTP response
	 */
	RestResponse executePost(String uri, String messageBody, String contentType);

	/**
	 * Executes an HTTP POST request to the given URI using the given content
	 * type, message body, and headers.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param messageBody
	 *            the message body
	 * @param contentType
	 *            the content type of the message body
	 * @param headers
	 *            the headers to send with the request
	 * 
	 * @return HTTP response
	 */
	RestResponse executePost(String uri, String messageBody, String contentType, Map<String, String> headers);

	/**
	 * Executes an HTTP POST request to the given URI using the given
	 * {@link HttpEntity}.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param httpEntity
	 *            the {@code HttpEntity}
	 * @return HTTP response
	 */
	RestResponse executePost(String uri, HttpEntity httpEntity);

	/**
	 * Executes an HTTP POST request to the given URI using the given
	 * {@link HttpEntity} and headers.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param httpEntity
	 *            the {@code HttpEntity}
	 * @param headers
	 *            the headers to send with the request
	 * 
	 * @return HTTP response
	 */
	RestResponse executePost(String uri, HttpEntity httpEntity, Map<String, String> headers);

	/**
	 * Executes an HTTP POST request to the given URI using the given content
	 * type and message body.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param messageBody
	 *            the message body
	 * @param messageBodyLength
	 *            the length of the message body
	 * @param contentType
	 *            the content type of the message body
	 * @return HTTP response
	 */
	RestResponse executePost(String uri, InputStream messageBody, int messageBodyLength, String contentType);

	/**
	 * Executes an HTTP POST request to the given URI using the given content
	 * type, message body, and headers.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param messageBody
	 *            the message body
	 * @param messageBodyLength
	 *            the length of the message body
	 * @param contentType
	 *            the content type of the message body
	 * @param headers
	 *            the headers to send with the request
	 * @return HTTP response
	 */
	RestResponse executePost(String uri, InputStream messageBody, int messageBodyLength, String contentType, Map<String, String> headers);

	/**
	 * Executes an HTTP DELETE request to the given URI.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @return HTTP response
	 */
	RestResponse executeDelete(String uri);

	/**
	 * Executes an HTTP DELETE request to the given URI using the given headers.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param headers
	 *            the headers to send with the request
	 * @return HTTP response
	 */
	RestResponse executeDelete(String uri, Map<String, String> headers);

	/**
	 * Executes an HTTP PUT request to the given URI using the given content
	 * type and message body.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param messageBody
	 *            the message body
	 * @param contentType
	 *            the content type of the message body
	 * @return HTTP response
	 */
	RestResponse executePut(String uri, String messageBody, String contentType);

	/**
	 * Executes an HTTP PUT request to the given URI using the given content
	 * type, message body, and headers.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param messageBody
	 *            the message body
	 * @param contentType
	 *            the content type of the message body
	 * @param headers
	 *            the headers to send with the request
	 * 
	 * @return HTTP response
	 */
	RestResponse executePut(String uri, String messageBody, String contentType, Map<String, String> headers);

	/**
	 * Executes an HTTP PUT request to the given URI using the given
	 * {@link HttpEntity}.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param httpEntity
	 *            the {@code HttpEntity}
	 * @return HTTP response
	 */
	RestResponse executePut(String uri, HttpEntity httpEntity);

	/**
	 * Executes an HTTP PUT request to the given URI using the given
	 * {@link HttpEntity} and headers.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param httpEntity
	 *            the {@code HttpEntity}
	 * @param headers
	 *            the headers to send with the request
	 * 
	 * @return HTTP response
	 */
	RestResponse executePut(String uri, HttpEntity httpEntity, Map<String, String> headers);

	/**
	 * Executes an HTTP PUT request to the given URI using the given content
	 * type and message body.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param messageBody
	 *            the message body
	 * @param messageBodyLength
	 *            the length of the message body
	 * @param contentType
	 *            the content type of the message body
	 * @return HTTP response
	 */
	RestResponse executePut(String uri, InputStream messageBody, int messageBodyLength, String contentType);

	/**
	 * Executes an HTTP PUT request to the given URI using the given content
	 * type, message body, and headers.
	 * 
	 * @param uri
	 *            the URI to execute the request for
	 * @param messageBody
	 *            the message body
	 * @param messageBodyLength
	 *            the length of the message body
	 * @param contentType
	 *            the content type of the message body
	 * @param headers
	 *            the headers to send with the request
	 * @return HTTP response
	 */
	RestResponse executePut(String uri, InputStream messageBody, int messageBodyLength, String contentType, Map<String, String> headers);

	/**
	 * Executes the given {@link HttpUriRequest}.
	 * 
	 * @param request
	 *            the request to execute
	 * @return HTTP response
	 */
	RestResponse executeRequest(HttpUriRequest request);

	/**
	 * Sets the connection timeout in milliseconds. This is the timeout used
	 * until a connection is established with the web service.
	 * 
	 * @param timeout
	 *            the timeout to set in milliseconds
	 */
	void setConnectionTimeout(int timeout);

	/**
	 * Sets the response timeout in milliseconds. This is the timeout for
	 * waiting for data from the web service. A timeout of zero is interpreted
	 * as an infinite timeout.
	 * 
	 * @param timeout
	 *            the timeout to set in milliseconds
	 */
	void setResponseTimeout(int timeout);

	/**
	 * Sets the {@link HttpParams} for this {@code RestfulClient}.
	 * 
	 * @param httpParams
	 *            the {@code HttpParams} to set
	 */
	void setHttpParams(HttpParams httpParams);

	/**
	 * Sets the {@link AuthenticationStrategy} to use for requests.
	 * 
	 * @param authStrategy
	 *            the {@code AuthenticationStrategy} to use or {@code null} if
	 *            there should be none
	 */
	void setAuthStrategy(AuthenticationStrategy authStrategy);

}
