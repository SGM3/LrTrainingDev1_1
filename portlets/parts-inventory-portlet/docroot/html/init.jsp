<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="com.liferay.portal.kernel.template.TemplateHandler" %>
<%@ page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.liferay.training.parts.model.Part"%>
<%@ page import="com.liferay.training.parts.model.Manufacturer"%>
<%@ page import="com.liferay.training.parts.service.PartLocalServiceUtil"%>
<%@ page import="com.liferay.training.parts.service.ManufacturerLocalServiceUtil"%>

<%@ page import="com.liferay.training.parts.service.permission.InventoryPermission"%>
<%@ page import="com.liferay.training.parts.service.permission.ManufacturerPermission"%>
<%@ page import="com.liferay.training.parts.service.permission.PartPermission"%>

<%@ page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil" %>
<%@ page import="com.liferay.training.template.PartsPortletDisplayTemplateUtil" %>
		

<liferay-theme:defineObjects />

<portlet:defineObjects />