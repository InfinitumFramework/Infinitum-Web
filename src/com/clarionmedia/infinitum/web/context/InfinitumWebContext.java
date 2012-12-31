/*
 * Copyright (c) 2012 Tyler Treat
 * 
 * This file is part of Infinitum Framework.
 *
 * Infinitum Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Infinitum Framework is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Infinitum Framework.  If not, see <http://www.gnu.org/licenses/>.
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
