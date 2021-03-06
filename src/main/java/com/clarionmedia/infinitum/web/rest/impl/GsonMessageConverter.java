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

package com.clarionmedia.infinitum.web.rest.impl;

import com.clarionmedia.infinitum.web.rest.MessageConverter;
import com.google.gson.Gson;

/**
 * <p>
 * Implementation of {@link MessageConverter} which relies on Gson to perform
 * object conversions.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 12/23/12
 * @since 1.0
 */
public class GsonMessageConverter implements MessageConverter {

	private Gson mGson;

	/**
	 * Creates a new {@code GsonMessageConverter} instance.
	 */
	public GsonMessageConverter() {
		mGson = new Gson();
	}

	/**
	 * Creates a new {@code GsonMessageConverter} instance with the given
	 * {@code Gson}.
	 * 
	 * @param gson
	 *            the {@code Gson} instance to use for conversion
	 */
	public GsonMessageConverter(Gson gson) {
		mGson = gson;
	}

	@Override
	public <T> T convert(Class<T> clazz, RestResponse response) {
		return mGson.fromJson(response.getResponseDataAsString(), clazz);
	}

}
