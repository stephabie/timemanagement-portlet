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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.timemanagement.service.ClpSerializer;
import com.liferay.timemanagement.service.TMActivitySessionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Istvan Sajtos, Zsolt Szabo
 */
public class TMActivitySessionClp extends BaseModelImpl<TMActivitySession>
	implements TMActivitySession {
	public TMActivitySessionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TMActivitySession.class;
	}

	@Override
	public String getModelClassName() {
		return TMActivitySession.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _activitySessionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActivitySessionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activitySessionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activitySessionId", getActivitySessionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("activityId", getActivityId());
		attributes.put("endTime", getEndTime());
		attributes.put("startTime", getStartTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long activitySessionId = (Long)attributes.get("activitySessionId");

		if (activitySessionId != null) {
			setActivitySessionId(activitySessionId);
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

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}
	}

	@Override
	public long getActivitySessionId() {
		return _activitySessionId;
	}

	@Override
	public void setActivitySessionId(long activitySessionId) {
		_activitySessionId = activitySessionId;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setActivitySessionId",
						long.class);

				method.invoke(_tmActivitySessionRemoteModel, activitySessionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_tmActivitySessionRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tmActivitySessionRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tmActivitySessionRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_tmActivitySessionRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_tmActivitySessionRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_tmActivitySessionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getActivityId() {
		return _activityId;
	}

	@Override
	public void setActivityId(long activityId) {
		_activityId = activityId;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityId", long.class);

				method.invoke(_tmActivitySessionRemoteModel, activityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_tmActivitySessionRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_tmActivitySessionRemoteModel != null) {
			try {
				Class<?> clazz = _tmActivitySessionRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_tmActivitySessionRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTMActivitySessionRemoteModel() {
		return _tmActivitySessionRemoteModel;
	}

	public void setTMActivitySessionRemoteModel(
		BaseModel<?> tmActivitySessionRemoteModel) {
		_tmActivitySessionRemoteModel = tmActivitySessionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _tmActivitySessionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_tmActivitySessionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TMActivitySessionLocalServiceUtil.addTMActivitySession(this);
		}
		else {
			TMActivitySessionLocalServiceUtil.updateTMActivitySession(this);
		}
	}

	@Override
	public TMActivitySession toEscapedModel() {
		return (TMActivitySession)ProxyUtil.newProxyInstance(TMActivitySession.class.getClassLoader(),
			new Class[] { TMActivitySession.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TMActivitySessionClp clone = new TMActivitySessionClp();

		clone.setActivitySessionId(getActivitySessionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setActivityId(getActivityId());
		clone.setEndTime(getEndTime());
		clone.setStartTime(getStartTime());

		return clone;
	}

	@Override
	public int compareTo(TMActivitySession tmActivitySession) {
		int value = 0;

		value = DateUtil.compareTo(getStartTime(),
				tmActivitySession.getStartTime());

		value = value * -1;

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

		if (!(obj instanceof TMActivitySessionClp)) {
			return false;
		}

		TMActivitySessionClp tmActivitySession = (TMActivitySessionClp)obj;

		long primaryKey = tmActivitySession.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{activitySessionId=");
		sb.append(getActivitySessionId());
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
		sb.append(", activityId=");
		sb.append(getActivityId());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.timemanagement.model.TMActivitySession");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>activitySessionId</column-name><column-value><![CDATA[");
		sb.append(getActivitySessionId());
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
			"<column><column-name>activityId</column-name><column-value><![CDATA[");
		sb.append(getActivityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _activitySessionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _activityId;
	private Date _endTime;
	private Date _startTime;
	private BaseModel<?> _tmActivitySessionRemoteModel;
}