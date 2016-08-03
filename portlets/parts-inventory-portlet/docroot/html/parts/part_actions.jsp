<%@include file="/html/init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Part part = (Part) row.getObject();

	long groupId = part.getGroupId();
	String name = Part.class.getName();
	long partId = part.getPartId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<c:if
		test="<%= PartPermission.contains(permissionChecker, partId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="mvcPath" value="/html/parts/edit_part.jsp" />
			<portlet:param name="partId" value="<%= String.valueOf(partId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />
	</c:if>

	<c:if
		test="<%= PartPermission.contains(permissionChecker, partId, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deletePart" var="deleteURL">
			<portlet:param name="partId" value="<%= String.valueOf(partId) %>" />
			<portlet:param name="redirect"
				value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
	</c:if>

	<c:if test="<%= PartPermission.contains(permissionChecker, partId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Part.class.getName() %>"
			modelResourceDescription="<%= part.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(partId) %>"
			var="permissionsURL"
		/>

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
</liferay-ui:icon-menu>