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

import org.apache.http.impl.client.RequestWrapper;

/**
 * <p>
 * Describes how web service requests are authenticated. This should be
 * implemented for specific web service authentication strategies. If using
 * token or shared-secret authentication, {@link SharedSecretAuthentication}
 * should be used.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 03/21/12
 * @since 1.0
 */
public interface AuthenticationStrategy {

	/**
	 * Adds the necessary authentication information to the given
	 * {@link RequestWrapper}.
	 * 
	 * @param request
	 *            the request to authenticate
	 */
	void authenticate(RequestWrapper request);

}
