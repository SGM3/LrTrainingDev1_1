<#assign liferay_portlet = taglibLiferayHash["/WEB-INF/tld/liferay-portlet.tld"] />
<#assign liferay_security = taglibLiferayHash["/WEB-INF/tld/liferay-security.tld"] />

<#list entries as curPart>
	<div class="part">
		<h4>${curPart.getName(locale)}</h4>
        <ul>
        	<li>Part Number: <strong>${curPart.getPartNumber()}</strong></li>
        	<li>Quantity: <strong>${curPart.getQuantity()}</strong></li>
        	<li>Order Date: <strong>${curPart.getOrderDate()?date}</strong></li>
        	<li>Manufacturer: <strong>${partsPortletDisplayTemplateUtil.getManufacturer(curPart.getManufacturerId()).getName()}</strong></li>
		</ul>
		<#if permissionChecker.hasPermission(curPart.getGroupId(), "com.liferay.training.parts.model.Part", curPart.getPartId(), "UPDATE")>
			<@liferay_portlet["renderURL"] var="editURL">
				<@liferay_portlet["param"] name="mvcPath" value="/html/parts/edit_part.jsp" />
				<@liferay_portlet["param"] name="partId" value="${curPart.getPartId()?string}" />
			</@>
			<button onclick="location.href='${editURL?string}'">Edit</button>
		</#if>
		
		<#if permissionChecker.hasPermission(curPart.getGroupId(), "com.liferay.training.parts.model.Part", curPart.getPartId(), "DELETE")>
			<@liferay_portlet["actionURL"] name="deletePart" var="deleteURL">
				<@liferay_portlet["param"] name="partId" value="${curPart.getPartId()?string}" />
			</@>
			<button onclick="location.href='${deleteURL?string}'">Delete</button>
		</#if>
		
		<#if permissionChecker.hasPermission(curPart.getGroupId(), "com.liferay.training.parts.model.Part", curPart.getPartId(), "PERMISSIONS")>
			<@liferay_security["permissionsURL"]
				modelResource="com.liferay.training.parts.model.Part"
				modelResourceDescription="${curPart.getName(locale)}"
				resourcePrimKey="${curPart.getPartId()?string}"
				var="permissionsURL"
			/>
			<button onclick="location.href='${permissionsURL?string}'">Permissions</button>
		</#if>
	</div>
</#list>