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

package com.liferay.timemanagement.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TMActivityLocalService}.
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMActivityLocalService
 * @generated
 */
public class TMActivityLocalServiceWrapper implements TMActivityLocalService,
	ServiceWrapper<TMActivityLocalService> {
	public TMActivityLocalServiceWrapper(
		TMActivityLocalService tmActivityLocalService) {
		_tmActivityLocalService = tmActivityLocalService;
	}

	/**
	* Adds the t m activity to the database. Also notifies the appropriate model listeners.
	*
	* @param tmActivity the t m activity
	* @return the t m activity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivity addTMActivity(
		com.liferay.timemanagement.model.TMActivity tmActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.addTMActivity(tmActivity);
	}

	/**
	* Creates a new t m activity with the primary key. Does not add the t m activity to the database.
	*
	* @param activityId the primary key for the new t m activity
	* @return the new t m activity
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivity createTMActivity(
		long activityId) {
		return _tmActivityLocalService.createTMActivity(activityId);
	}

	/**
	* Deletes the t m activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityId the primary key of the t m activity
	* @return the t m activity that was removed
	* @throws PortalException if a t m activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivity deleteTMActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.deleteTMActivity(activityId);
	}

	/**
	* Deletes the t m activity from the database. Also notifies the appropriate model listeners.
	*
	* @param tmActivity the t m activity
	* @return the t m activity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivity deleteTMActivity(
		com.liferay.timemanagement.model.TMActivity tmActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.deleteTMActivity(tmActivity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tmActivityLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.timemanagement.model.TMActivity fetchTMActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.fetchTMActivity(activityId);
	}

	/**
	* Returns the t m activity with the primary key.
	*
	* @param activityId the primary key of the t m activity
	* @return the t m activity
	* @throws PortalException if a t m activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivity getTMActivity(
		long activityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.getTMActivity(activityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the t m activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t m activities
	* @param end the upper bound of the range of t m activities (not inclusive)
	* @return the range of t m activities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.timemanagement.model.TMActivity> getTMActivities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.getTMActivities(start, end);
	}

	/**
	* Returns the number of t m activities.
	*
	* @return the number of t m activities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTMActivitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.getTMActivitiesCount();
	}

	/**
	* Updates the t m activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tmActivity the t m activity
	* @return the t m activity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timemanagement.model.TMActivity updateTMActivity(
		com.liferay.timemanagement.model.TMActivity tmActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.updateTMActivity(tmActivity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tmActivityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tmActivityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tmActivityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.timemanagement.model.TMActivity addTMActivity(
		long companyId, long userId, java.lang.String activityName,
		long classNameId, long classPK, java.lang.String classUuid,
		java.lang.String description, java.util.Date endDate, int priority,
		java.util.Date reminderDate, java.util.Date scheduledDate,
		java.util.Date startDate, boolean visible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.addTMActivity(companyId, userId,
			activityName, classNameId, classPK, classUuid, description,
			endDate, priority, reminderDate, scheduledDate, startDate, visible,
			serviceContext);
	}

	@Override
	public void addTMActivityResources(
		com.liferay.timemanagement.model.TMActivity tmActivity,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tmActivityLocalService.addTMActivityResources(tmActivity,
			addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addTMActivityResources(
		com.liferay.timemanagement.model.TMActivity tmActivity,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tmActivityLocalService.addTMActivityResources(tmActivity,
			groupPermissions, guestPermissions);
	}

	@Override
	public int countByC_G(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.countByC_G(companyId, groupId);
	}

	@Override
	public java.util.List<com.liferay.timemanagement.model.TMActivity> getTMActivitiesByC_G(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.getTMActivitiesByC_G(companyId, groupId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.timemanagement.model.TMActivity> getTMActivitiesByC_G(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.getTMActivitiesByC_G(companyId, groupId,
			start, end, orderByComparator);
	}

	@Override
	public com.liferay.timemanagement.model.TMActivity updateTMActivity(
		long activityId, java.lang.String activityName, long classNameId,
		long classPK, java.lang.String classUuid, java.lang.String description,
		java.util.Date endDate, int priority, java.util.Date reminderDate,
		java.util.Date scheduledDate, java.util.Date startDate,
		boolean visible,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tmActivityLocalService.updateTMActivity(activityId,
			activityName, classNameId, classPK, classUuid, description,
			endDate, priority, reminderDate, scheduledDate, startDate, visible,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TMActivityLocalService getWrappedTMActivityLocalService() {
		return _tmActivityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTMActivityLocalService(
		TMActivityLocalService tmActivityLocalService) {
		_tmActivityLocalService = tmActivityLocalService;
	}

	@Override
	public TMActivityLocalService getWrappedService() {
		return _tmActivityLocalService;
	}

	@Override
	public void setWrappedService(TMActivityLocalService tmActivityLocalService) {
		_tmActivityLocalService = tmActivityLocalService;
	}

	private TMActivityLocalService _tmActivityLocalService;
}