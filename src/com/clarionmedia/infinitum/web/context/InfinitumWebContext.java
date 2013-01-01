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

package com.clarionmedia.infinitum.web.context;

import com.clarionmedia.infinitum.context.InfinitumContext;
import com.clarionmedia.infinitum.context.exception.InfinitumConfigurationException;
import com.clarionmedia.infinitum.di.BeanProvider;
import com.clarionmedia.infinitum.web.rest.AuthenticationStrategy;

/**
 * <p>
 * {@code InfinitumWebContext} is an extension of {@link InfinitumContext} that
 * contains configuration information for the framework web module.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 12/26/12
 * @since 1.0
 */
public interface InfinitumWebContext extends InfinitumContext, BeanProvider {
		
	/**
	 * Sets the {@link AuthenticationStrategy} for this
	 * {@code RestfulConfiguration} based on one of the framework-defined
	 * strategies, such as {@code token}.
	 * 
	 * @param strategy
	 *            the framework-defined strategy to use
	 * @throws InfinitumConfigurationException
	 *             if the given strategy does not exist
	 */
	void setAuthStrategy(String strategy) throws InfinitumConfigurationException;

	/**
	 * Sets the {@link AuthenticationStrategy} for this
	 * {@code RestfulConfiguration}.
	 * 
	 * @param strategy
	 *            the {@code AuthenticationStrategy} to use
	 */
	<T extends AuthenticationStrategy> void setAuthStrategy(T strategy);

	/**
	 * Retrieves the configured {@link AuthenticationStrategy} for this
	 * {@code RestfulConfiguration}.
	 * 
	 * @return the {@code AuthenticationStrategy}
	 */
	AuthenticationStrategy getAuthStrategy();

}
