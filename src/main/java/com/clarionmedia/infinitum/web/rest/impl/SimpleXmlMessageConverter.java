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

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.clarionmedia.infinitum.exception.InfinitumRuntimeException;
import com.clarionmedia.infinitum.web.rest.MessageConverter;

/**
 * <p>
 * Implementation of {@link MessageConverter} which relies on Simple XML to
 * perform object conversions.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 01/01/13
 * @since 1.0
 */
public class SimpleXmlMessageConverter implements MessageConverter {

	private Serializer mSerializer;

	/**
	 * Creates a new {@code SimpleXmlMessageConverter} instance.
	 */
	public SimpleXmlMessageConverter() {
		mSerializer = new Persister();
	}

	/**
	 * Creates a new {@code SimpleXmlMessageConverter} instance with the given
	 * {@code Serializer}.
	 * 
	 * @param serializer
	 *            the {@code Serializer} to use for conversions
	 */
	public SimpleXmlMessageConverter(Serializer serializer) {
		mSerializer = serializer;
	}

	@Override
	public <T> T convert(Class<T> clazz, RestResponse response) {
		try {
			return mSerializer.read(clazz, response.getResponseDataAsString());
		} catch (Exception e) {
			throw new InfinitumRuntimeException("Unable to convert REST response", e);
		}
	}

}
