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

import com.clarionmedia.infinitum.web.rest.impl.RestResponse;

/**
 * <p>
 * Converts {@link RestResponse} messages to objects.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 12/23/12
 * @since 1.0
 */
public interface MessageConverter {

	/**
	 * Reads an object of the given type form the given input message and
	 * returns it.
	 * 
	 * @param clazz
	 *            the type of the object to return
	 * @param response
	 *            the response to convert
	 * @return converted object
	 */
	<T> T convert(Class<T> clazz, RestResponse response);

}
