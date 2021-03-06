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

/**
 * <p>
 * {@code TokenGenerator} is responsible for generating shared secret tokens.
 * Provide an implementation of this if an unchanging shared secret is
 * undesirable. A {@code TokenGenerator} can be injected into a
 * {@link SharedSecretAuthentication} bean.
 * </p>
 * 
 * @author Tyler Treat
 * @version 1.0 03/21/12
 * @since 1.0
 */
public interface TokenGenerator {

	/**
	 * Creates a new shared secret token.
	 * 
	 * @return authentication token
	 */
	String generateToken();

}