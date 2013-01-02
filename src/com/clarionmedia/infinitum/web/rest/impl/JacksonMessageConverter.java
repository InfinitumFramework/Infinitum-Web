/*
 * Copyright (c) 2012 Tyler Treat
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

import java.io.IOException;

import com.clarionmedia.infinitum.exception.InfinitumRuntimeException;
import com.clarionmedia.infinitum.web.rest.MessageConverter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 * Implementation of {@link MessageConverter} which relies on Jackson to perform
 * object conversions.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 01/01/13
 * @since 1.0
 */
public class JacksonMessageConverter implements MessageConverter {

	private ObjectMapper mMapper;

	/**
	 * Creates a new {@code JacksonMessageConverter} instance.
	 */
	public JacksonMessageConverter() {
		mMapper = new ObjectMapper();
	}

	/**
	 * Creates a new {@code JacksonMessageConverter} instance with the given
	 * {@code ObjectMapper}.
	 * 
	 * @param gson
	 *            the {@code Gson} instance to use for conversion
	 */
	public JacksonMessageConverter(ObjectMapper mapper) {
		mMapper = mapper;
	}

	@Override
	public <T> T convert(Class<T> clazz, RestResponse response) {
		try {
			return mMapper.readValue(response.getResponseDataAsString(), clazz);
		} catch (JsonParseException e) {
			throw new InfinitumRuntimeException("Unable to convert REST response", e);
		} catch (JsonMappingException e) {
			throw new InfinitumRuntimeException("Unable to convert REST response", e);
		} catch (IOException e) {
			throw new InfinitumRuntimeException("Unable to convert REST response", e);
		}
	}

}
