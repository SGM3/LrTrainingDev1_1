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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.training.parts.model.Part;

/**
 * The persistence interface for the part service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Shanon Mathai
 * @see PartPersistenceImpl
 * @see PartUtil
 * @generated
 */
public interface PartPersistence extends BasePersistence<Part> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PartUtil} to access the part persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the parts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @return the range of matching parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first part in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching part
	* @throws com.liferay.training.parts.NoSuchPartException if a matching part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Returns the first part in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching part, or <code>null</code> if a matching part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last part in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching part
	* @throws com.liferay.training.parts.NoSuchPartException if a matching part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Returns the last part in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching part, or <code>null</code> if a matching part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parts before and after the current part in the ordered set where groupId = &#63;.
	*
	* @param partId the primary key of the current part
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next part
	* @throws com.liferay.training.parts.NoSuchPartException if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part[] findByGroupId_PrevAndNext(
		long partId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Returns all the parts that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching parts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parts that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @return the range of matching parts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parts that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching parts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parts before and after the current part in the ordered set of parts that the user has permission to view where groupId = &#63;.
	*
	* @param partId the primary key of the current part
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next part
	* @throws com.liferay.training.parts.NoSuchPartException if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part[] filterFindByGroupId_PrevAndNext(
		long partId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Removes all the parts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parts that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching parts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the parts where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @return the matching parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findByManufacturer(
		long manufacturerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parts where manufacturerId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @return the range of matching parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findByManufacturer(
		long manufacturerId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parts where manufacturerId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findByManufacturer(
		long manufacturerId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first part in the ordered set where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching part
	* @throws com.liferay.training.parts.NoSuchPartException if a matching part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part findByManufacturer_First(
		long manufacturerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Returns the first part in the ordered set where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching part, or <code>null</code> if a matching part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part fetchByManufacturer_First(
		long manufacturerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last part in the ordered set where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching part
	* @throws com.liferay.training.parts.NoSuchPartException if a matching part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part findByManufacturer_Last(
		long manufacturerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Returns the last part in the ordered set where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching part, or <code>null</code> if a matching part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part fetchByManufacturer_Last(
		long manufacturerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parts before and after the current part in the ordered set where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param partId the primary key of the current part
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next part
	* @throws com.liferay.training.parts.NoSuchPartException if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part[] findByManufacturer_PrevAndNext(
		long partId, long manufacturerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Returns all the parts that the user has permission to view where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @return the matching parts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> filterFindByManufacturer(
		long manufacturerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parts that the user has permission to view where manufacturerId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @return the range of matching parts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> filterFindByManufacturer(
		long manufacturerId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parts that the user has permissions to view where manufacturerId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching parts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> filterFindByManufacturer(
		long manufacturerId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parts before and after the current part in the ordered set of parts that the user has permission to view where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param partId the primary key of the current part
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next part
	* @throws com.liferay.training.parts.NoSuchPartException if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part[] filterFindByManufacturer_PrevAndNext(
		long partId, long manufacturerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Removes all the parts where manufacturerId = &#63; and groupId = &#63; from the database.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByManufacturer(long manufacturerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parts where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @return the number of matching parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByManufacturer(long manufacturerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parts that the user has permission to view where manufacturerId = &#63; and groupId = &#63;.
	*
	* @param manufacturerId the manufacturer ID
	* @param groupId the group ID
	* @return the number of matching parts that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByManufacturer(long manufacturerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the part in the entity cache if it is enabled.
	*
	* @param part the part
	*/
	public void cacheResult(com.liferay.training.parts.model.Part part);

	/**
	* Caches the parts in the entity cache if it is enabled.
	*
	* @param parts the parts
	*/
	public void cacheResult(
		java.util.List<com.liferay.training.parts.model.Part> parts);

	/**
	* Creates a new part with the primary key. Does not add the part to the database.
	*
	* @param partId the primary key for the new part
	* @return the new part
	*/
	public com.liferay.training.parts.model.Part create(long partId);

	/**
	* Removes the part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partId the primary key of the part
	* @return the part that was removed
	* @throws com.liferay.training.parts.NoSuchPartException if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part remove(long partId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	public com.liferay.training.parts.model.Part updateImpl(
		com.liferay.training.parts.model.Part part)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the part with the primary key or throws a {@link com.liferay.training.parts.NoSuchPartException} if it could not be found.
	*
	* @param partId the primary key of the part
	* @return the part
	* @throws com.liferay.training.parts.NoSuchPartException if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part findByPrimaryKey(long partId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.parts.NoSuchPartException;

	/**
	* Returns the part with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param partId the primary key of the part
	* @return the part, or <code>null</code> if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.parts.model.Part fetchByPrimaryKey(long partId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the parts.
	*
	* @return the parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @return the range of parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of parts
	* @param end the upper bound of the range of parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.parts.model.Part> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the parts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parts.
	*
	* @return the number of parts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}