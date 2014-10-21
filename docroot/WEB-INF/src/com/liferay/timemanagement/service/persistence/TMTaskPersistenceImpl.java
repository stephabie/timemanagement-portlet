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

package com.liferay.timemanagement.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.timemanagement.NoSuchTMTaskException;
import com.liferay.timemanagement.model.TMTask;
import com.liferay.timemanagement.model.impl.TMTaskImpl;
import com.liferay.timemanagement.model.impl.TMTaskModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t m task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Istvan Sajtos, Zsolt Szabo
 * @see TMTaskPersistence
 * @see TMTaskUtil
 * @generated
 */
public class TMTaskPersistenceImpl extends BasePersistenceImpl<TMTask>
	implements TMTaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TMTaskUtil} to access the t m task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TMTaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskModelImpl.FINDER_CACHE_ENABLED, TMTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskModelImpl.FINDER_CACHE_ENABLED, TMTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskModelImpl.FINDER_CACHE_ENABLED, TMTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskModelImpl.FINDER_CACHE_ENABLED, TMTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			TMTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			TMTaskModelImpl.GROUPID_COLUMN_BITMASK |
			TMTaskModelImpl.TASKNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the t m tasks where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching t m tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMTask> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t m tasks where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t m tasks
	 * @param end the upper bound of the range of t m tasks (not inclusive)
	 * @return the range of matching t m tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMTask> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t m tasks where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t m tasks
	 * @param end the upper bound of the range of t m tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t m tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMTask> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<TMTask> list = (List<TMTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TMTask tmTask : list) {
				if ((companyId != tmTask.getCompanyId()) ||
						(groupId != tmTask.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TMTASK_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TMTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<TMTask>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TMTask>(list);
				}
				else {
					list = (List<TMTask>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first t m task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t m task
	 * @throws com.liferay.timemanagement.NoSuchTMTaskException if a matching t m task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTMTaskException, SystemException {
		TMTask tmTask = fetchByC_G_First(companyId, groupId, orderByComparator);

		if (tmTask != null) {
			return tmTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTMTaskException(msg.toString());
	}

	/**
	 * Returns the first t m task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t m task, or <code>null</code> if a matching t m task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask fetchByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TMTask> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t m task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t m task
	 * @throws com.liferay.timemanagement.NoSuchTMTaskException if a matching t m task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTMTaskException, SystemException {
		TMTask tmTask = fetchByC_G_Last(companyId, groupId, orderByComparator);

		if (tmTask != null) {
			return tmTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTMTaskException(msg.toString());
	}

	/**
	 * Returns the last t m task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t m task, or <code>null</code> if a matching t m task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask fetchByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<TMTask> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t m tasks before and after the current t m task in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param taskId the primary key of the current t m task
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t m task
	 * @throws com.liferay.timemanagement.NoSuchTMTaskException if a t m task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask[] findByC_G_PrevAndNext(long taskId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTMTaskException, SystemException {
		TMTask tmTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			TMTask[] array = new TMTaskImpl[3];

			array[0] = getByC_G_PrevAndNext(session, tmTask, companyId,
					groupId, orderByComparator, true);

			array[1] = tmTask;

			array[2] = getByC_G_PrevAndNext(session, tmTask, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TMTask getByC_G_PrevAndNext(Session session, TMTask tmTask,
		long companyId, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TMTASK_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TMTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tmTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TMTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the t m tasks where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (TMTask tmTask : findByC_G(companyId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tmTask);
		}
	}

	/**
	 * Returns the number of t m tasks where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching t m tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TMTASK_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "tmTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "tmTask.groupId = ?";

	public TMTaskPersistenceImpl() {
		setModelClass(TMTask.class);
	}

	/**
	 * Caches the t m task in the entity cache if it is enabled.
	 *
	 * @param tmTask the t m task
	 */
	@Override
	public void cacheResult(TMTask tmTask) {
		EntityCacheUtil.putResult(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskImpl.class, tmTask.getPrimaryKey(), tmTask);

		tmTask.resetOriginalValues();
	}

	/**
	 * Caches the t m tasks in the entity cache if it is enabled.
	 *
	 * @param tmTasks the t m tasks
	 */
	@Override
	public void cacheResult(List<TMTask> tmTasks) {
		for (TMTask tmTask : tmTasks) {
			if (EntityCacheUtil.getResult(
						TMTaskModelImpl.ENTITY_CACHE_ENABLED, TMTaskImpl.class,
						tmTask.getPrimaryKey()) == null) {
				cacheResult(tmTask);
			}
			else {
				tmTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t m tasks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TMTaskImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TMTaskImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t m task.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TMTask tmTask) {
		EntityCacheUtil.removeResult(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskImpl.class, tmTask.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TMTask> tmTasks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TMTask tmTask : tmTasks) {
			EntityCacheUtil.removeResult(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
				TMTaskImpl.class, tmTask.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t m task with the primary key. Does not add the t m task to the database.
	 *
	 * @param taskId the primary key for the new t m task
	 * @return the new t m task
	 */
	@Override
	public TMTask create(long taskId) {
		TMTask tmTask = new TMTaskImpl();

		tmTask.setNew(true);
		tmTask.setPrimaryKey(taskId);

		return tmTask;
	}

	/**
	 * Removes the t m task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the t m task
	 * @return the t m task that was removed
	 * @throws com.liferay.timemanagement.NoSuchTMTaskException if a t m task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask remove(long taskId)
		throws NoSuchTMTaskException, SystemException {
		return remove((Serializable)taskId);
	}

	/**
	 * Removes the t m task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t m task
	 * @return the t m task that was removed
	 * @throws com.liferay.timemanagement.NoSuchTMTaskException if a t m task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask remove(Serializable primaryKey)
		throws NoSuchTMTaskException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TMTask tmTask = (TMTask)session.get(TMTaskImpl.class, primaryKey);

			if (tmTask == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTMTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tmTask);
		}
		catch (NoSuchTMTaskException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TMTask removeImpl(TMTask tmTask) throws SystemException {
		tmTask = toUnwrappedModel(tmTask);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tmTask)) {
				tmTask = (TMTask)session.get(TMTaskImpl.class,
						tmTask.getPrimaryKeyObj());
			}

			if (tmTask != null) {
				session.delete(tmTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tmTask != null) {
			clearCache(tmTask);
		}

		return tmTask;
	}

	@Override
	public TMTask updateImpl(com.liferay.timemanagement.model.TMTask tmTask)
		throws SystemException {
		tmTask = toUnwrappedModel(tmTask);

		boolean isNew = tmTask.isNew();

		TMTaskModelImpl tmTaskModelImpl = (TMTaskModelImpl)tmTask;

		Session session = null;

		try {
			session = openSession();

			if (tmTask.isNew()) {
				session.save(tmTask);

				tmTask.setNew(false);
			}
			else {
				session.merge(tmTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TMTaskModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tmTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tmTaskModelImpl.getOriginalCompanyId(),
						tmTaskModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						tmTaskModelImpl.getCompanyId(),
						tmTaskModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}
		}

		EntityCacheUtil.putResult(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
			TMTaskImpl.class, tmTask.getPrimaryKey(), tmTask);

		return tmTask;
	}

	protected TMTask toUnwrappedModel(TMTask tmTask) {
		if (tmTask instanceof TMTaskImpl) {
			return tmTask;
		}

		TMTaskImpl tmTaskImpl = new TMTaskImpl();

		tmTaskImpl.setNew(tmTask.isNew());
		tmTaskImpl.setPrimaryKey(tmTask.getPrimaryKey());

		tmTaskImpl.setTaskId(tmTask.getTaskId());
		tmTaskImpl.setGroupId(tmTask.getGroupId());
		tmTaskImpl.setCompanyId(tmTask.getCompanyId());
		tmTaskImpl.setUserId(tmTask.getUserId());
		tmTaskImpl.setUserName(tmTask.getUserName());
		tmTaskImpl.setCreateDate(tmTask.getCreateDate());
		tmTaskImpl.setModifiedDate(tmTask.getModifiedDate());
		tmTaskImpl.setDescription(tmTask.getDescription());
		tmTaskImpl.setTaskName(tmTask.getTaskName());

		return tmTaskImpl;
	}

	/**
	 * Returns the t m task with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t m task
	 * @return the t m task
	 * @throws com.liferay.timemanagement.NoSuchTMTaskException if a t m task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTMTaskException, SystemException {
		TMTask tmTask = fetchByPrimaryKey(primaryKey);

		if (tmTask == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTMTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tmTask;
	}

	/**
	 * Returns the t m task with the primary key or throws a {@link com.liferay.timemanagement.NoSuchTMTaskException} if it could not be found.
	 *
	 * @param taskId the primary key of the t m task
	 * @return the t m task
	 * @throws com.liferay.timemanagement.NoSuchTMTaskException if a t m task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask findByPrimaryKey(long taskId)
		throws NoSuchTMTaskException, SystemException {
		return findByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns the t m task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t m task
	 * @return the t m task, or <code>null</code> if a t m task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TMTask tmTask = (TMTask)EntityCacheUtil.getResult(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
				TMTaskImpl.class, primaryKey);

		if (tmTask == _nullTMTask) {
			return null;
		}

		if (tmTask == null) {
			Session session = null;

			try {
				session = openSession();

				tmTask = (TMTask)session.get(TMTaskImpl.class, primaryKey);

				if (tmTask != null) {
					cacheResult(tmTask);
				}
				else {
					EntityCacheUtil.putResult(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
						TMTaskImpl.class, primaryKey, _nullTMTask);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TMTaskModelImpl.ENTITY_CACHE_ENABLED,
					TMTaskImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tmTask;
	}

	/**
	 * Returns the t m task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the t m task
	 * @return the t m task, or <code>null</code> if a t m task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMTask fetchByPrimaryKey(long taskId) throws SystemException {
		return fetchByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns all the t m tasks.
	 *
	 * @return the t m tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMTask> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t m tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of t m tasks
	 * @param end the upper bound of the range of t m tasks (not inclusive)
	 * @return the range of t m tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMTask> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t m tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timemanagement.model.impl.TMTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of t m tasks
	 * @param end the upper bound of the range of t m tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t m tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMTask> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TMTask> list = (List<TMTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TMTASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TMTASK;

				if (pagination) {
					sql = sql.concat(TMTaskModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TMTask>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TMTask>(list);
				}
				else {
					list = (List<TMTask>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the t m tasks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TMTask tmTask : findAll()) {
			remove(tmTask);
		}
	}

	/**
	 * Returns the number of t m tasks.
	 *
	 * @return the number of t m tasks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TMTASK);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the t m task persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timemanagement.model.TMTask")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TMTask>> listenersList = new ArrayList<ModelListener<TMTask>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TMTask>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TMTaskImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TMTASK = "SELECT tmTask FROM TMTask tmTask";
	private static final String _SQL_SELECT_TMTASK_WHERE = "SELECT tmTask FROM TMTask tmTask WHERE ";
	private static final String _SQL_COUNT_TMTASK = "SELECT COUNT(tmTask) FROM TMTask tmTask";
	private static final String _SQL_COUNT_TMTASK_WHERE = "SELECT COUNT(tmTask) FROM TMTask tmTask WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tmTask.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TMTask exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TMTask exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TMTaskPersistenceImpl.class);
	private static TMTask _nullTMTask = new TMTaskImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TMTask> toCacheModel() {
				return _nullTMTaskCacheModel;
			}
		};

	private static CacheModel<TMTask> _nullTMTaskCacheModel = new CacheModel<TMTask>() {
			@Override
			public TMTask toEntityModel() {
				return _nullTMTask;
			}
		};
}