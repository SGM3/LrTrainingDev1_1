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

package com.liferay.training.parts.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Part. This utility wraps
 * {@link com.liferay.training.parts.service.impl.PartLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Shanon Mathai
 * @see PartLocalService
 * @see com.liferay.training.parts.service.base.PartLocalServiceBaseImpl
 * @see com.liferay.training.parts.service.impl.PartLocalServiceImpl
 * @generated
 */
public class PartLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.parts.service.impl.PartLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the part to the database. Also notifies the appropriate model listeners.
	*
	* @param part the part
	* @return the part that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.parts.model.Part addPart(
		com.liferay.training.parts.model.Part part)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPart(part);
	}

	/**
	* Creates a new part with the primary key. Does not add the part to the database.
	*
	* @param partId the primary key for the new part
	* @return the new part
	*/
	public static com.liferay.training.parts.model.Part createPart(long partId) {
		return getService().createPart(partId);
	}

	/**
	* Deletes the part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partId the primary key of the part
	* @return the part that was removed
	* @throws PortalException if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.parts.model.Part deletePart(long partId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePart(partId);
	}

	/**
	* Deletes the part from the database. Also notifies the appropriate model listeners.
	*
	* @param part the part
	* @return the part that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.parts.model.Part deletePart(
		com.liferay.training.parts.model.Part part)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePart(part);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.parts.model.impl.PartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.training.parts.model.Part fetchPart(long partId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPart(partId);
	}

	/**
	* Returns the part with the primary key.
	*
	* @param partId the primary key of the part
	* @return the part
	* @throws PortalException if a part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.parts.model.Part getPart(long partId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPart(partId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<com.liferay.training.parts.model.Part> getParts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getParts(start, end);
	}

	/**
	* Returns the number of parts.
	*
	* @return the number of parts
	* @throws SystemException if a system exception occurred
	*/
	public static int getPartsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsCount();
	}

	/**
	* Updates the part in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param part the part
	* @return the part that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.parts.model.Part updatePart(
		com.liferay.training.parts.model.Part part)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePart(part);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Adds the Part to the database incrementing the primary key
	*
	* @throws PortalException
	*/
	public static com.liferay.training.parts.model.Part addPart(
		com.liferay.training.parts.model.Part newPart, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addPart(newPart, userId);
	}

	/**
	* Gets a list with all the Parts in a group
	*/
	public static java.util.List<com.liferay.training.parts.model.Part> getPartsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsByGroupId(groupId);
	}

	/**
	* Gets a list with a range of Parts from a group
	*/
	public static java.util.List<com.liferay.training.parts.model.Part> getPartsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsByGroupId(groupId, start, end);
	}

	/**
	* Gets the number of Parts in a group
	*/
	public static int getPartsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsCountByGroupId(groupId);
	}

	/**
	* Gets a list of Parts from a Manufacturer
	*/
	public static java.util.List<com.liferay.training.parts.model.Part> getPartsByManufacturer(
		long manufacturerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsByManufacturer(manufacturerId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PartLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PartLocalService.class.getName());

			if (invokableLocalService instanceof PartLocalService) {
				_service = (PartLocalService)invokableLocalService;
			}
			else {
				_service = new PartLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PartLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PartLocalService service) {
	}

	private static PartLocalService _service;
}