package com.clarionmedia.infinitum.web.context;

import com.clarionmedia.infinitum.context.InfinitumContext;
import com.clarionmedia.infinitum.context.exception.InfinitumConfigurationException;
import com.clarionmedia.infinitum.web.rest.AuthenticationStrategy;

public interface InfinitumWebContext extends InfinitumContext {
		
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
