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

package com.liferay.timemanagement.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TMTask service. Represents a row in the &quot;timemanagement_TMTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.timemanagement.model.impl.TMTaskImpl}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMTask
 * @see com.liferay.timemanagement.model.impl.TMTaskImpl
 * @see com.liferay.timemanagement.model.impl.TMTaskModelImpl
 * @generated
 */
public interface TMTaskModel extends BaseModel<TMTask>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a t m task model instance should use the {@link TMTask} interface instead.
	 */

	/**
	 * Returns the primary key of this t m task.
	 *
	 * @return the primary key of this t m task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this t m task.
	 *
	 * @param primaryKey the primary key of this t m task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the task ID of this t m task.
	 *
	 * @return the task ID of this t m task
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this t m task.
	 *
	 * @param taskId the task ID of this t m task
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the group ID of this t m task.
	 *
	 * @return the group ID of this t m task
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this t m task.
	 *
	 * @param groupId the group ID of this t m task
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this t m task.
	 *
	 * @return the company ID of this t m task
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this t m task.
	 *
	 * @param companyId the company ID of this t m task
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this t m task.
	 *
	 * @return the user ID of this t m task
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this t m task.
	 *
	 * @param userId the user ID of this t m task
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this t m task.
	 *
	 * @return the user uuid of this t m task
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this t m task.
	 *
	 * @param userUuid the user uuid of this t m task
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this t m task.
	 *
	 * @return the user name of this t m task
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this t m task.
	 *
	 * @param userName the user name of this t m task
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this t m task.
	 *
	 * @return the create date of this t m task
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this t m task.
	 *
	 * @param createDate the create date of this t m task
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this t m task.
	 *
	 * @return the modified date of this t m task
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this t m task.
	 *
	 * @param modifiedDate the modified date of this t m task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the due date of this t m task.
	 *
	 * @return the due date of this t m task
	 */
	public Date getDueDate();

	/**
	 * Sets the due date of this t m task.
	 *
	 * @param dueDate the due date of this t m task
	 */
	public void setDueDate(Date dueDate);

	/**
	 * Returns the folder ID of this t m task.
	 *
	 * @return the folder ID of this t m task
	 */
	public long getFolderId();

	/**
	 * Sets the folder ID of this t m task.
	 *
	 * @param folderId the folder ID of this t m task
	 */
	public void setFolderId(long folderId);

	/**
	 * Returns the priority of this t m task.
	 *
	 * @return the priority of this t m task
	 */
	public int getPriority();

	/**
	 * Sets the priority of this t m task.
	 *
	 * @param priority the priority of this t m task
	 */
	public void setPriority(int priority);

	/**
	 * Returns the status of this t m task.
	 *
	 * @return the status of this t m task
	 */
	public int getStatus();

	/**
	 * Sets the status of this t m task.
	 *
	 * @param status the status of this t m task
	 */
	public void setStatus(int status);

	/**
	 * Returns the task name of this t m task.
	 *
	 * @return the task name of this t m task
	 */
	@AutoEscape
	public String getTaskName();

	/**
	 * Sets the task name of this t m task.
	 *
	 * @param taskName the task name of this t m task
	 */
	public void setTaskName(String taskName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(TMTask tmTask);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TMTask> toCacheModel();

	@Override
	public TMTask toEscapedModel();

	@Override
	public TMTask toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}