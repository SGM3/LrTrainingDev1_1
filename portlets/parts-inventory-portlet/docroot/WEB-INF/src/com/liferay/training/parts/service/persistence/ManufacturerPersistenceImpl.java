/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.training.parts.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.training.parts.NoSuchManufacturerException;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.model.impl.ManufacturerImpl;
import com.liferay.training.parts.model.impl.ManufacturerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the manufacturer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Shanon Mathai
 * @see ManufacturerPersistence
 * @see ManufacturerUtil
 * @generated
 */
public class ManufacturerPersistenceImpl extends BasePersistenceImpl<Manufacturer>
	implements ManufacturerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ManufacturerUtil} to access the manufacturer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ManufacturerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, ManufacturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, ManufacturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, ManufacturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, ManufacturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ManufacturerModelImpl.GROUPID_COLUMN_BITMASK |
			ManufacturerModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the manufacturers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manufacturers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.ManufacturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @return the range of matching manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manufacturers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.ManufacturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Manufacturer> list = (List<Manufacturer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Manufacturer manufacturer : list) {
				if ((groupId != manufacturer.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MANUFACTURER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ManufacturerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Manufacturer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Manufacturer>(list);
				}
				else {
					list = (List<Manufacturer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manufacturer
	 * @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchManufacturerException, SystemException {
		Manufacturer manufacturer = fetchByGroupId_First(groupId,
				orderByComparator);

		if (manufacturer != null) {
			return manufacturer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManufacturerException(msg.toString());
	}

	/**
	 * Returns the first manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Manufacturer> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manufacturer
	 * @throws com.liferay.training.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchManufacturerException, SystemException {
		Manufacturer manufacturer = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (manufacturer != null) {
			return manufacturer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManufacturerException(msg.toString());
	}

	/**
	 * Returns the last manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Manufacturer> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manufacturers before and after the current manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param manufacturerId the primary key of the current manufacturer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manufacturer
	 * @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer[] findByGroupId_PrevAndNext(long manufacturerId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchManufacturerException, SystemException {
		Manufacturer manufacturer = findByPrimaryKey(manufacturerId);

		Session session = null;

		try {
			session = openSession();

			Manufacturer[] array = new ManufacturerImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, manufacturer, groupId,
					orderByComparator, true);

			array[1] = manufacturer;

			array[2] = getByGroupId_PrevAndNext(session, manufacturer, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Manufacturer getByGroupId_PrevAndNext(Session session,
		Manufacturer manufacturer, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MANUFACTURER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ManufacturerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(manufacturer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Manufacturer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the manufacturers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching manufacturers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manufacturers that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.ManufacturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @return the range of matching manufacturers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manufacturers that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.ManufacturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manufacturers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MANUFACTURER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_MANUFACTURER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MANUFACTURER_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ManufacturerModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ManufacturerModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Manufacturer.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ManufacturerImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ManufacturerImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Manufacturer>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the manufacturers before and after the current manufacturer in the ordered set of manufacturers that the user has permission to view where groupId = &#63;.
	 *
	 * @param manufacturerId the primary key of the current manufacturer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manufacturer
	 * @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer[] filterFindByGroupId_PrevAndNext(long manufacturerId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchManufacturerException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(manufacturerId, groupId,
				orderByComparator);
		}

		Manufacturer manufacturer = findByPrimaryKey(manufacturerId);

		Session session = null;

		try {
			session = openSession();

			Manufacturer[] array = new ManufacturerImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, manufacturer,
					groupId, orderByComparator, true);

			array[1] = manufacturer;

			array[2] = filterGetByGroupId_PrevAndNext(session, manufacturer,
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

	protected Manufacturer filterGetByGroupId_PrevAndNext(Session session,
		Manufacturer manufacturer, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MANUFACTURER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_MANUFACTURER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MANUFACTURER_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ManufacturerModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ManufacturerModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Manufacturer.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ManufacturerImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ManufacturerImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(manufacturer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Manufacturer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manufacturers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Manufacturer manufacturer : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(manufacturer);
		}
	}

	/**
	 * Returns the number of manufacturers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MANUFACTURER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	/**
	 * Returns the number of manufacturers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching manufacturers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_MANUFACTURER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Manufacturer.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "manufacturer.groupId = ?";

	public ManufacturerPersistenceImpl() {
		setModelClass(Manufacturer.class);
	}

	/**
	 * Caches the manufacturer in the entity cache if it is enabled.
	 *
	 * @param manufacturer the manufacturer
	 */
	@Override
	public void cacheResult(Manufacturer manufacturer) {
		EntityCacheUtil.putResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerImpl.class, manufacturer.getPrimaryKey(), manufacturer);

		manufacturer.resetOriginalValues();
	}

	/**
	 * Caches the manufacturers in the entity cache if it is enabled.
	 *
	 * @param manufacturers the manufacturers
	 */
	@Override
	public void cacheResult(List<Manufacturer> manufacturers) {
		for (Manufacturer manufacturer : manufacturers) {
			if (EntityCacheUtil.getResult(
						ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
						ManufacturerImpl.class, manufacturer.getPrimaryKey()) == null) {
				cacheResult(manufacturer);
			}
			else {
				manufacturer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all manufacturers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ManufacturerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ManufacturerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the manufacturer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Manufacturer manufacturer) {
		EntityCacheUtil.removeResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerImpl.class, manufacturer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Manufacturer> manufacturers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Manufacturer manufacturer : manufacturers) {
			EntityCacheUtil.removeResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
				ManufacturerImpl.class, manufacturer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new manufacturer with the primary key. Does not add the manufacturer to the database.
	 *
	 * @param manufacturerId the primary key for the new manufacturer
	 * @return the new manufacturer
	 */
	@Override
	public Manufacturer create(long manufacturerId) {
		Manufacturer manufacturer = new ManufacturerImpl();

		manufacturer.setNew(true);
		manufacturer.setPrimaryKey(manufacturerId);

		return manufacturer;
	}

	/**
	 * Removes the manufacturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param manufacturerId the primary key of the manufacturer
	 * @return the manufacturer that was removed
	 * @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer remove(long manufacturerId)
		throws NoSuchManufacturerException, SystemException {
		return remove((Serializable)manufacturerId);
	}

	/**
	 * Removes the manufacturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the manufacturer
	 * @return the manufacturer that was removed
	 * @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer remove(Serializable primaryKey)
		throws NoSuchManufacturerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Manufacturer manufacturer = (Manufacturer)session.get(ManufacturerImpl.class,
					primaryKey);

			if (manufacturer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchManufacturerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(manufacturer);
		}
		catch (NoSuchManufacturerException nsee) {
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
	protected Manufacturer removeImpl(Manufacturer manufacturer)
		throws SystemException {
		manufacturer = toUnwrappedModel(manufacturer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(manufacturer)) {
				manufacturer = (Manufacturer)session.get(ManufacturerImpl.class,
						manufacturer.getPrimaryKeyObj());
			}

			if (manufacturer != null) {
				session.delete(manufacturer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (manufacturer != null) {
			clearCache(manufacturer);
		}

		return manufacturer;
	}

	@Override
	public Manufacturer updateImpl(
		com.liferay.training.parts.model.Manufacturer manufacturer)
		throws SystemException {
		manufacturer = toUnwrappedModel(manufacturer);

		boolean isNew = manufacturer.isNew();

		ManufacturerModelImpl manufacturerModelImpl = (ManufacturerModelImpl)manufacturer;

		Session session = null;

		try {
			session = openSession();

			if (manufacturer.isNew()) {
				session.save(manufacturer);

				manufacturer.setNew(false);
			}
			else {
				session.merge(manufacturer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ManufacturerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((manufacturerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						manufacturerModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { manufacturerModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerImpl.class, manufacturer.getPrimaryKey(), manufacturer);

		return manufacturer;
	}

	protected Manufacturer toUnwrappedModel(Manufacturer manufacturer) {
		if (manufacturer instanceof ManufacturerImpl) {
			return manufacturer;
		}

		ManufacturerImpl manufacturerImpl = new ManufacturerImpl();

		manufacturerImpl.setNew(manufacturer.isNew());
		manufacturerImpl.setPrimaryKey(manufacturer.getPrimaryKey());

		manufacturerImpl.setManufacturerId(manufacturer.getManufacturerId());
		manufacturerImpl.setCompanyId(manufacturer.getCompanyId());
		manufacturerImpl.setGroupId(manufacturer.getGroupId());
		manufacturerImpl.setUserId(manufacturer.getUserId());
		manufacturerImpl.setName(manufacturer.getName());
		manufacturerImpl.setEmailAddress(manufacturer.getEmailAddress());
		manufacturerImpl.setWebsite(manufacturer.getWebsite());
		manufacturerImpl.setPhoneNumber(manufacturer.getPhoneNumber());
		manufacturerImpl.setCreateDate(manufacturer.getCreateDate());
		manufacturerImpl.setModifiedDate(manufacturer.getModifiedDate());
		manufacturerImpl.setUserName(manufacturer.getUserName());

		return manufacturerImpl;
	}

	/**
	 * Returns the manufacturer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the manufacturer
	 * @return the manufacturer
	 * @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchManufacturerException, SystemException {
		Manufacturer manufacturer = fetchByPrimaryKey(primaryKey);

		if (manufacturer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchManufacturerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return manufacturer;
	}

	/**
	 * Returns the manufacturer with the primary key or throws a {@link com.liferay.training.parts.NoSuchManufacturerException} if it could not be found.
	 *
	 * @param manufacturerId the primary key of the manufacturer
	 * @return the manufacturer
	 * @throws com.liferay.training.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer findByPrimaryKey(long manufacturerId)
		throws NoSuchManufacturerException, SystemException {
		return findByPrimaryKey((Serializable)manufacturerId);
	}

	/**
	 * Returns the manufacturer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the manufacturer
	 * @return the manufacturer, or <code>null</code> if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Manufacturer manufacturer = (Manufacturer)EntityCacheUtil.getResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
				ManufacturerImpl.class, primaryKey);

		if (manufacturer == _nullManufacturer) {
			return null;
		}

		if (manufacturer == null) {
			Session session = null;

			try {
				session = openSession();

				manufacturer = (Manufacturer)session.get(ManufacturerImpl.class,
						primaryKey);

				if (manufacturer != null) {
					cacheResult(manufacturer);
				}
				else {
					EntityCacheUtil.putResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
						ManufacturerImpl.class, primaryKey, _nullManufacturer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
					ManufacturerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return manufacturer;
	}

	/**
	 * Returns the manufacturer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param manufacturerId the primary key of the manufacturer
	 * @return the manufacturer, or <code>null</code> if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer fetchByPrimaryKey(long manufacturerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)manufacturerId);
	}

	/**
	 * Returns all the manufacturers.
	 *
	 * @return the manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manufacturers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.ManufacturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @return the range of manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the manufacturers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.ManufacturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Manufacturer> findAll(int start, int end,
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

		List<Manufacturer> list = (List<Manufacturer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MANUFACTURER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MANUFACTURER;

				if (pagination) {
					sql = sql.concat(ManufacturerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Manufacturer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Manufacturer>(list);
				}
				else {
					list = (List<Manufacturer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the manufacturers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Manufacturer manufacturer : findAll()) {
			remove(manufacturer);
		}
	}

	/**
	 * Returns the number of manufacturers.
	 *
	 * @return the number of manufacturers
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

				Query q = session.createQuery(_SQL_COUNT_MANUFACTURER);

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
	 * Initializes the manufacturer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.training.parts.model.Manufacturer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Manufacturer>> listenersList = new ArrayList<ModelListener<Manufacturer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Manufacturer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ManufacturerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MANUFACTURER = "SELECT manufacturer FROM Manufacturer manufacturer";
	private static final String _SQL_SELECT_MANUFACTURER_WHERE = "SELECT manufacturer FROM Manufacturer manufacturer WHERE ";
	private static final String _SQL_COUNT_MANUFACTURER = "SELECT COUNT(manufacturer) FROM Manufacturer manufacturer";
	private static final String _SQL_COUNT_MANUFACTURER_WHERE = "SELECT COUNT(manufacturer) FROM Manufacturer manufacturer WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "manufacturer.manufacturerId";
	private static final String _FILTER_SQL_SELECT_MANUFACTURER_WHERE = "SELECT DISTINCT {manufacturer.*} FROM Inventory_Manufacturer manufacturer WHERE ";
	private static final String _FILTER_SQL_SELECT_MANUFACTURER_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Inventory_Manufacturer.*} FROM (SELECT DISTINCT manufacturer.manufacturerId FROM Inventory_Manufacturer manufacturer WHERE ";
	private static final String _FILTER_SQL_SELECT_MANUFACTURER_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Inventory_Manufacturer ON TEMP_TABLE.manufacturerId = Inventory_Manufacturer.manufacturerId";
	private static final String _FILTER_SQL_COUNT_MANUFACTURER_WHERE = "SELECT COUNT(DISTINCT manufacturer.manufacturerId) AS COUNT_VALUE FROM Inventory_Manufacturer manufacturer WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "manufacturer";
	private static final String _FILTER_ENTITY_TABLE = "Inventory_Manufacturer";
	private static final String _ORDER_BY_ENTITY_ALIAS = "manufacturer.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Inventory_Manufacturer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Manufacturer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Manufacturer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ManufacturerPersistenceImpl.class);
	private static Manufacturer _nullManufacturer = new ManufacturerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Manufacturer> toCacheModel() {
				return _nullManufacturerCacheModel;
			}
		};

	private static CacheModel<Manufacturer> _nullManufacturerCacheModel = new CacheModel<Manufacturer>() {
			@Override
			public Manufacturer toEntityModel() {
				return _nullManufacturer;
			}
		};
}