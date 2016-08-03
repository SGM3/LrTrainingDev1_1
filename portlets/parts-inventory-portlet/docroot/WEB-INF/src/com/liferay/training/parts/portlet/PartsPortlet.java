package com.liferay.training.parts.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.service.PartLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class PartsPortlet
 */
public class PartsPortlet extends MVCPortlet {

	/**
	 * Adds a new part to the database.
	 * 
	 */
	public void addPart(ActionRequest request, ActionResponse response)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		if (themeDisplay.getPermissionChecker().hasPermission(groupId,
				"com.liferay.training.parts.model", groupId, "ADD_PART")) {
			
			Part part = PartLocalServiceUtil.createPart(0);
			
			part.setPartId(ParamUtil.getLong(request, "partId"));
			
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
					request, "name");
			part.setNameMap(nameMap);
			
			part.setPartNumber(ParamUtil.getString(request, "partNumber"));
			
			int orderDateMonth = ParamUtil.getInteger(request, "orderDateMonth");
			int orderDateDay = ParamUtil.getInteger(request, "orderDateDay");
			int orderDateYear = ParamUtil.getInteger(request, "orderDateYear");
			Date orderDate = PortalUtil.getDate(orderDateMonth, orderDateDay,
					orderDateYear);
			part.setOrderDate(orderDate);
			
			part.setQuantity(ParamUtil.getInteger(request, "quantity"));
			part.setManufacturerId(ParamUtil.getLong(request, "manufacturerId"));
			part.setCompanyId(themeDisplay.getCompanyId());
			part.setGroupId(themeDisplay.getScopeGroupId());
			part.setUserId(themeDisplay.getUserId());

			List<String> errors = new ArrayList<String>();

			if (PartValidator.validatePart(part, errors)) {

				long userId = themeDisplay.getUserId();

				PartLocalServiceUtil.addPart(part, userId);

				SessionMessages.add(request, "part-added");

				sendRedirect(request, response);
			} else {
				for (String error : errors) {
					SessionErrors.add(request, error);
				}

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/html/parts/edit_part.jsp");
			}
		} else {
			SessionErrors.add(request, "permission-error");
			sendRedirect(request, response);
		}
	}

	/**
	 * Deletes a part from the database.
	 * 
	 */
	public void deletePart(ActionRequest request, ActionResponse response)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		long partId = ParamUtil.getLong(request, "partId");

		if (themeDisplay.getPermissionChecker().hasPermission(groupId,
				"com.liferay.training.parts.model.Part",
				partId, "DELETE")) {

			if (Validator.isNotNull(partId)) {
				PartLocalServiceUtil.deletePart(partId);

				SessionMessages.add(request, "part-deleted");

				sendRedirect(request, response);
			} else {
				SessionErrors.add(request, "deletion-error");
			}
		} else {
			SessionErrors.add(request, "permission-error");
			sendRedirect(request, response);
		}
	}

	/**
	 * Updates the database record of an existing part.
	 * 
	 */
	public void updatePart(ActionRequest request, ActionResponse response)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		long partId = ParamUtil.getLong(request, "partId");
		Part part = null;
		
		try {
			part = PartLocalServiceUtil
					.fetchPart(partId);
		} catch (SystemException se) {
			_log.error(se);
			return;
		}

		if (themeDisplay.getPermissionChecker().hasPermission(groupId,
				"com.liferay.training.parts.model.Part",
				part.getPartId(), "UPDATE")) {
			
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
					request, "name");
			part.setNameMap(nameMap);
			
			part.setPartNumber(ParamUtil.getString(request, "partNumber"));
			
			int orderDateMonth = ParamUtil.getInteger(request, "orderDateMonth");
			int orderDateDay = ParamUtil.getInteger(request, "orderDateDay");
			int orderDateYear = ParamUtil.getInteger(request, "orderDateYear");
			Date orderDate = PortalUtil.getDate(orderDateMonth, orderDateDay,
					orderDateYear);
			part.setOrderDate(orderDate);
			
			part.setQuantity(ParamUtil.getInteger(request, "quantity"));
			part.setManufacturerId(ParamUtil.getLong(request, "manufacturerId"));

			List<String> errors = new ArrayList<String>();

			if (PartValidator.validatePart(part, errors)) {
				
				PartLocalServiceUtil.updatePart(part);

				SessionMessages.add(request, "part-updated");

				sendRedirect(request, response);
			} else {
				for (String error : errors) {
					SessionErrors.add(request, error);
				}

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/html/parts/edit_part.jsp");
			}
		} else {
			SessionErrors.add(request, "permission-error");
			sendRedirect(request, response);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PartsPortlet.class);

}
