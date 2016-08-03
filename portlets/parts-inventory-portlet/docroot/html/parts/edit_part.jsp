<%@include file="/html/init.jsp"%>

<%
Part part = null;

long partId = ParamUtil.getLong(request, "partId");

if (partId > 0) {
	part = PartLocalServiceUtil.getPart(partId);
}

List<Manufacturer> manufacturers = ManufacturerLocalServiceUtil.getManufacturersByGroupId(scopeGroupId);

String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= part %>" model="<%= Part.class %>" />
<portlet:renderURL var="viewPartURL" />
<portlet:actionURL name='<%= part == null ? "addPart" : "updatePart" %>' var="editPartURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewPartURL %>"
	title='<%= (part != null) ? part.getName(locale) : "new-part" %>'
/>

<aui:form action="<%= editPartURL %>" method="POST" name="fm">
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="partId" value='<%= part == null ? "" : part.getPartId() %>'/>
		
		<liferay-ui:error key="partname-required" message="partname-required"/>
		<aui:input name="name" >
			<aui:validator name="required" errorMessage="You must enter a Part Name"/>
		</aui:input>

		<liferay-ui:error key="partnumber-required" message="partnumber-required"/>
		<aui:input name="partNumber" >
			<aui:validator name="required" errorMessage="You must enter a Part Number"/>
		</aui:input>	
		
		<liferay-ui:error key="orderdate-required" message="orderdate-required"/>
		<aui:input name="orderDate" />
		
		<liferay-ui:error key="quantity-required" message="quantity-required"/>
		<aui:input name="quantity">
			<aui:validator name="required" errorMessage="You must enter a Quantity"/>
		</aui:input>
		
		<liferay-ui:error key="manufacturer-required" message="manufacturer-required"/>
		<aui:select name="manufacturerId" showEmptyOption="<%= true %>" label="Manufacturer" >

	 		<%
				for(Manufacturer manufacturer: manufacturers){
			%>
			<aui:option value="<%= manufacturer.getManufacturerId() %>" selected="<%= part != null && manufacturer.getManufacturerId() == part.getManufacturerId() %>"><%=HtmlUtil.escape(manufacturer.getName())%></aui:option>
			<%
				}
			%>

		</aui:select>
			 

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel" onClick="<%= viewPartURL %>" />
	</aui:button-row>
</aui:form>