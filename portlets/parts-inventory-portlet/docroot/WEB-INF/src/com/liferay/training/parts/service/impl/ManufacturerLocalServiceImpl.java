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

package com.liferay.training.parts.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.service.base.ManufacturerLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the manufacturer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.parts.service.ManufacturerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Shanon Mathai
 * @see com.liferay.training.parts.service.base.ManufacturerLocalServiceBaseImpl
 * @see com.liferay.training.parts.service.ManufacturerLocalServiceUtil
 */
public class ManufacturerLocalServiceImpl
	extends ManufacturerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.training.parts.service.ManufacturerLocalServiceUtil} to access the manufacturer local service.
	 */
	
	
	/**
	 * Adds the Manufacturer to the database incrementing the primary key
	 * @throws PortalException
	 * 
	 */
	public Manufacturer addManufacturer(Manufacturer newManufacturer,
			long userId) throws SystemException, PortalException {

		long manufacturerId = counterLocalService
				.increment(Manufacturer.class.getName());

        Date now = new Date();
		Manufacturer manufacturer = manufacturerPersistence
				.create(manufacturerId);
		manufacturer.setCompanyId(newManufacturer.getCompanyId());
		manufacturer.setGroupId(newManufacturer.getGroupId());
		manufacturer.setUserId(newManufacturer.getUserId());
		manufacturer.setName(newManufacturer.getName());
		manufacturer.setEmailAddress(newManufacturer.getEmailAddress());
		manufacturer.setWebsite(newManufacturer.getWebsite());
		manufacturer.setPhoneNumber(newManufacturer.getPhoneNumber());
        manufacturer.setCreateDate(now);
        manufacturer.setModifiedDate(now);

		manufacturerPersistence.update(manufacturer);

		resourceLocalService.addResources(manufacturer.getCompanyId(),
						manufacturer.getGroupId(), userId,
						Manufacturer.class.getName(), manufacturerId, false,
						true, true);

		return manufacturer;
	}

	/**
	 * Deletes a manufacturer from the database using the Manufacturer object.
	 */
	public Manufacturer deleteManufacturer(Manufacturer manufacturer)
			throws SystemException {

		try {
			resourceLocalService.deleteResource(manufacturer.getCompanyId(),
					Manufacturer.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					manufacturer.getPrimaryKey());
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return super.deleteManufacturer(manufacturer);
	}

	/**
	 * Deletes a manufacturer from the database using a manufacturer ID.
	 */
	public Manufacturer deleteManufacturer(long manufacturerId) throws PortalException,
			SystemException {

		Manufacturer manufacturer = getManufacturer(manufacturerId);

		return deleteManufacturer(manufacturer);
	}

	/**
	 * Gets a list with all the Manufacturers in a group
	 *
	 */
	public List<Manufacturer> getManufacturersByGroupId(long groupId) throws SystemException {

		return manufacturerPersistence.filterFindByGroupId(groupId);
	}

	/**
	 * Gets a list with a range of Manufacturers from a group
	 *
	 */
	public List<Manufacturer> getManufacturersByGroupId(long groupId, int start, int end) throws SystemException {

		return manufacturerPersistence.filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Gets the number of Manufacturers in a group
	 *
	 */
	public int getManufacturersCountByGroupId(long groupId) throws SystemException {

		return manufacturerPersistence.filterCountByGroupId(groupId);
	}
}