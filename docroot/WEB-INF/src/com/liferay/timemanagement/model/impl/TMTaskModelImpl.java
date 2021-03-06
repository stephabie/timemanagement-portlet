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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.timemanagement.model.TMTask;
import com.liferay.timemanagement.model.TMTaskModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TMTask service. Represents a row in the &quot;timemanagement_TMTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.timemanagement.model.TMTaskModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TMTaskImpl}.
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMTaskImpl
 * @see com.liferay.timemanagement.model.TMTask
 * @see com.liferay.timemanagement.model.TMTaskModel
 * @generated
 */
public class TMTaskModelImpl extends BaseModelImpl<TMTask>
	implements TMTaskModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a t m task model instance should use the {@link com.liferay.timemanagement.model.TMTask} interface instead.
	 */
	public static final String TABLE_NAME = "timemanagement_TMTask";
	public static final Object[][] TABLE_COLUMNS = {
			{ "taskId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "dueDate", Types.TIMESTAMP },
			{ "folderId", Types.BIGINT },
			{ "priority", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "taskName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table timemanagement_TMTask (taskId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,dueDate DATE null,folderId LONG,priority INTEGER,status INTEGER,taskName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table timemanagement_TMTask";
	public static final String ORDER_BY_JPQL = " ORDER BY tmTask.dueDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY timemanagement_TMTask.dueDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.timemanagement.model.TMTask"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.timemanagement.model.TMTask"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.timemanagement.model.TMTask"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long FOLDERID_COLUMN_BITMASK = 2L;
	public static long TASKID_COLUMN_BITMASK = 4L;
	public static long DUEDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.timemanagement.model.TMTask"));

	public TMTaskModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _taskId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTaskId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TMTask.class;
	}

	@Override
	public String getModelClassName() {
		return TMTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("folderId", getFolderId());
		attributes.put("priority", getPriority());
		attributes.put("status", getStatus());
		attributes.put("taskName", getTaskName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}
	}

	@Override
	public long getTaskId() {
		return _taskId;
	}

	@Override
	public void setTaskId(long taskId) {
		_columnBitmask |= TASKID_COLUMN_BITMASK;

		if (!_setOriginalTaskId) {
			_setOriginalTaskId = true;

			_originalTaskId = _taskId;
		}

		_taskId = taskId;
	}

	public long getOriginalTaskId() {
		return _originalTaskId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public Date getDueDate() {
		return _dueDate;
	}

	@Override
	public void setDueDate(Date dueDate) {
		_columnBitmask = -1L;

		_dueDate = dueDate;
	}

	@Override
	public long getFolderId() {
		return _folderId;
	}

	@Override
	public void setFolderId(long folderId) {
		_columnBitmask |= FOLDERID_COLUMN_BITMASK;

		if (!_setOriginalFolderId) {
			_setOriginalFolderId = true;

			_originalFolderId = _folderId;
		}

		_folderId = folderId;
	}

	public long getOriginalFolderId() {
		return _originalFolderId;
	}

	@Override
	public int getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(int priority) {
		_priority = priority;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public String getTaskName() {
		if (_taskName == null) {
			return StringPool.BLANK;
		}
		else {
			return _taskName;
		}
	}

	@Override
	public void setTaskName(String taskName) {
		_taskName = taskName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TMTask.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TMTask toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TMTask)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TMTaskImpl tmTaskImpl = new TMTaskImpl();

		tmTaskImpl.setTaskId(getTaskId());
		tmTaskImpl.setGroupId(getGroupId());
		tmTaskImpl.setCompanyId(getCompanyId());
		tmTaskImpl.setUserId(getUserId());
		tmTaskImpl.setUserName(getUserName());
		tmTaskImpl.setCreateDate(getCreateDate());
		tmTaskImpl.setModifiedDate(getModifiedDate());
		tmTaskImpl.setDueDate(getDueDate());
		tmTaskImpl.setFolderId(getFolderId());
		tmTaskImpl.setPriority(getPriority());
		tmTaskImpl.setStatus(getStatus());
		tmTaskImpl.setTaskName(getTaskName());

		tmTaskImpl.resetOriginalValues();

		return tmTaskImpl;
	}

	@Override
	public int compareTo(TMTask tmTask) {
		int value = 0;

		value = DateUtil.compareTo(getDueDate(), tmTask.getDueDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TMTask)) {
			return false;
		}

		TMTask tmTask = (TMTask)obj;

		long primaryKey = tmTask.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		TMTaskModelImpl tmTaskModelImpl = this;

		tmTaskModelImpl._originalTaskId = tmTaskModelImpl._taskId;

		tmTaskModelImpl._setOriginalTaskId = false;

		tmTaskModelImpl._originalCompanyId = tmTaskModelImpl._companyId;

		tmTaskModelImpl._setOriginalCompanyId = false;

		tmTaskModelImpl._originalFolderId = tmTaskModelImpl._folderId;

		tmTaskModelImpl._setOriginalFolderId = false;

		tmTaskModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TMTask> toCacheModel() {
		TMTaskCacheModel tmTaskCacheModel = new TMTaskCacheModel();

		tmTaskCacheModel.taskId = getTaskId();

		tmTaskCacheModel.groupId = getGroupId();

		tmTaskCacheModel.companyId = getCompanyId();

		tmTaskCacheModel.userId = getUserId();

		tmTaskCacheModel.userName = getUserName();

		String userName = tmTaskCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tmTaskCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tmTaskCacheModel.createDate = createDate.getTime();
		}
		else {
			tmTaskCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tmTaskCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tmTaskCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date dueDate = getDueDate();

		if (dueDate != null) {
			tmTaskCacheModel.dueDate = dueDate.getTime();
		}
		else {
			tmTaskCacheModel.dueDate = Long.MIN_VALUE;
		}

		tmTaskCacheModel.folderId = getFolderId();

		tmTaskCacheModel.priority = getPriority();

		tmTaskCacheModel.status = getStatus();

		tmTaskCacheModel.taskName = getTaskName();

		String taskName = tmTaskCacheModel.taskName;

		if ((taskName != null) && (taskName.length() == 0)) {
			tmTaskCacheModel.taskName = null;
		}

		return tmTaskCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{taskId=");
		sb.append(getTaskId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dueDate=");
		sb.append(getDueDate());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", taskName=");
		sb.append(getTaskName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.liferay.timemanagement.model.TMTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dueDate</column-name><column-value><![CDATA[");
		sb.append(getDueDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskName</column-name><column-value><![CDATA[");
		sb.append(getTaskName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TMTask.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { TMTask.class };
	private long _taskId;
	private long _originalTaskId;
	private boolean _setOriginalTaskId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dueDate;
	private long _folderId;
	private long _originalFolderId;
	private boolean _setOriginalFolderId;
	private int _priority;
	private int _status;
	private String _taskName;
	private long _columnBitmask;
	private TMTask _escapedModel;
}