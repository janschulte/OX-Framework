/**
 * ﻿Copyright (C) 2012-2014 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2 as publishedby the Free
 * Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of the
 * following licenses, the combination of the program with the linked library is
 * not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed under
 * the aforementioned licenses, is permitted by the copyright holders if the
 * distribution is compliant with both the GNU General Public License version 2
 * and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 */
package org.n52.oxf.xmlbeans.parser;

import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlValidationError;

/**
 * Interface for providing exceptional cases
 * in XML validation (e.g. substitution groups).
 * 
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 *
 */
public interface LaxValidationCase {
	
	/**
	 * @param validationError the validation error
	 * @return true, if this lax case embodies an exceptional
	 * validation case on the given error
	 */
	boolean shouldPass(XmlError validationError);
	
	/**
	 * @deprecated no longer called, due to the fact that errors can also be XmlError (the supertype).
	 * 	Use {@link #shouldPass(XmlError)} instead and cast if needed.
	 * @param validationError the validation error
	 * @return true, if this lax case embodies an exceptional validation case on the given error
	 */
	@Deprecated
	boolean shouldPass(XmlValidationError validationError);
	
}