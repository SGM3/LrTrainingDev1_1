package com.liferay.training.parts.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.service.PartLocalServiceUtil;

public class PartPermission {

	public static void check(PermissionChecker permissionChecker, Part part,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, part, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long partId,
			String actionId) throws PortalException, SystemException {

		if (!contains(permissionChecker, partId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			Part part, String actionId) {

		if (permissionChecker.hasOwnerPermission(part.getCompanyId(),
				Part.class.getName(), part.getPartId(), part.getUserId(),
				actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(part.getGroupId(),
				Part.class.getName(), part.getPartId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long partId, String actionId) throws PortalException,
			SystemException {

		Part part = PartLocalServiceUtil.getPart(partId);

		return contains(permissionChecker, part, actionId);
	}

}