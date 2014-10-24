/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.timemanagement.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.timemanagement.model.TMActivitySession;
import com.liferay.timemanagement.service.TMActivitySessionLocalServiceUtil;

/**
 * The extended model base implementation for the TMActivitySession service. Represents a row in the &quot;timemanagement_TMActivitySession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TMActivitySessionImpl}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivitySessionImpl
 * @see com.liferay.timemanagement.model.TMActivitySession
 * @generated
 */
public abstract class TMActivitySessionBaseImpl
	extends TMActivitySessionModelImpl implements TMActivitySession {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a t m activity session model instance should use the {@link TMActivitySession} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TMActivitySessionLocalServiceUtil.addTMActivitySession(this);
		}
		else {
			TMActivitySessionLocalServiceUtil.updateTMActivitySession(this);
		}
	}
}