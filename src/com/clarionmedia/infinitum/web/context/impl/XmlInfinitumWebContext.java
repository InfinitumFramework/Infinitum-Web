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

package com.clarionmedia.infinitum.web.context.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;

import com.clarionmedia.infinitum.context.InfinitumContext;
import com.clarionmedia.infinitum.context.RestfulContext;
import com.clarionmedia.infinitum.context.exception.InfinitumConfigurationException;
import com.clarionmedia.infinitum.context.impl.XmlApplicationContext;
import com.clarionmedia.infinitum.context.impl.XmlRestfulContext;
import com.clarionmedia.infinitum.context.impl.XmlRestfulContext.Authentication;
import com.clarionmedia.infinitum.di.AbstractBeanDefinition;
import com.clarionmedia.infinitum.di.BeanDefinitionBuilder;
import com.clarionmedia.infinitum.di.BeanFactory;
import com.clarionmedia.infinitum.di.impl.GenericBeanDefinitionBuilder;
import com.clarionmedia.infinitum.web.context.InfinitumWebContext;
import com.clarionmedia.infinitum.web.rest.AuthenticationStrategy;
import com.clarionmedia.infinitum.web.rest.TokenGenerator;
import com.clarionmedia.infinitum.web.rest.impl.SharedSecretAuthentication;

/**
 * <p>
 * Implementation of {@link InfinitumWebContext} which is initialized through
 * XML as a child of an {@link XmlApplicationContext} instance.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 12/26/12
 * @since 1.0
 * 
 */
public class XmlInfinitumWebContext implements InfinitumWebContext {
	
	private XmlApplicationContext mParentContext;
	private List<InfinitumContext> mChildContexts;

	/**
	 * Creates a new {@code XmlInfinitumWebContext} instance as a child of the
	 * given {@link XmlApplicationContext}.
	 * 
	 * @param parentContext
	 *            the parent of this context
	 */
	public XmlInfinitumWebContext(XmlApplicationContext parentContext) {
		mParentContext = parentContext;
		mChildContexts = new ArrayList<InfinitumContext>();
	}
	
	@Override
	public void postProcess(Context context) {
		registerWebComponents();
	}

	@Override
	public boolean isDebug() {
		return mParentContext.isDebug();
	}

	@Override
	public Context getAndroidContext() {
		return mParentContext.getAndroidContext();
	}

	@Override
	public BeanFactory getBeanFactory() {
		return mParentContext.getBeanFactory();
	}

	@Override
	public Object getBean(String name) {
		return mParentContext.getBean(name);
	}

	@Override
	public <T> T getBean(String name, Class<T> clazz) {
		return mParentContext.getBean(name, clazz);
	}

	@Override
	public boolean isComponentScanEnabled() {
		return mParentContext.isComponentScanEnabled();
	}

	@Override
	public List<InfinitumContext> getChildContexts() {
		return mChildContexts;
	}

	@Override
	public void addChildContext(InfinitumContext context) {
		mChildContexts.add(context);
	}

	@Override
	public InfinitumContext getParentContext() {
		return mParentContext.getParentContext();
	}

	@Override
	public RestfulContext getRestContext() {
		return mParentContext.getRestContext();
	}

	@Override
	public void setAuthStrategy(String strategy) throws InfinitumConfigurationException {
		XmlRestfulContext restContext = mParentContext.getRestContext();
		Authentication auth = restContext.getAuthentication();
		if (auth == null)
			auth = new Authentication();
		if ("token".equalsIgnoreCase(strategy))
			auth.setStrategy("token");
		else
			throw new InfinitumConfigurationException("Unrecognized authentication strategy '" + strategy + "'.");
	}

	@Override
	public AuthenticationStrategy getAuthStrategy() {
		XmlRestfulContext restContext = mParentContext.getRestContext();
		Authentication auth = restContext.getAuthentication();
		if (auth == null)
			return null;
		if (auth.getAuthBean() != null) {
			return mParentContext.getBean(auth.getAuthBean(), AuthenticationStrategy.class);
		}
		String strategy = auth.getStrategy();
		if ("token".equalsIgnoreCase(strategy)) {
			SharedSecretAuthentication strat = new SharedSecretAuthentication();
			strat.setHeader(auth.isHeader());
			Map<String, String> props = auth.getAuthProperties();
			if (props.containsKey("tokenName"))
				strat.setTokenName(props.get("tokenName"));
			if (props.containsKey("token"))
				strat.setToken(props.get("token"));
			if (auth.getGenerator() != null)
				strat.setTokenGenerator(mParentContext.getBean(auth.getGenerator(), TokenGenerator.class));
			return strat;
		} else
			throw new InfinitumConfigurationException("Unrecognized authentication strategy '" + strategy + "'.");
	}

	@Override
	public <T extends AuthenticationStrategy> void setAuthStrategy(T strategy) {
		XmlRestfulContext restContext = mParentContext.getRestContext();
		Authentication auth = restContext.getAuthentication();
		if (auth == null)
			auth = new Authentication();
		setAuthStrategy(strategy.getClass().getSimpleName());
	}
	
	private void registerWebComponents() {
		BeanFactory beanFactory = mParentContext.getBeanFactory();
		BeanDefinitionBuilder beanDefinitionBuilder = new GenericBeanDefinitionBuilder(beanFactory);
		AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.setName("$WebContext").setType(XmlInfinitumWebContext.class).build();
		beanFactory.registerBean(beanDefinition);
	}

}
