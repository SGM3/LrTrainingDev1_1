package com.liferay.training.parts.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.service.ManufacturerLocalServiceUtil;

public class ManufacturerPermission {

	public static void check(PermissionChecker permissionChecker,
			Manufacturer manufacturer, String actionId) throws PortalException {

		if (!contains(permissionChecker, manufacturer, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker,
			long manufacturerId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, manufacturerId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			Manufacturer manufacturer, String actionId) {

		if (permissionChecker.hasOwnerPermission(manufacturer.getCompanyId(),
				Manufacturer.class.getName(), manufacturer.getManufacturerId(),
				manufacturer.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(manufacturer.getGroupId(),
				Manufacturer.class.getName(), manufacturer.getManufacturerId(),
				actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long manufacturerId, String actionId) throws PortalException,
			SystemException {

		Manufacturer manufacturer = ManufacturerLocalServiceUtil
				.getManufacturer(manufacturerId);

		return contains(permissionChecker, manufacturer, actionId);
	}

}