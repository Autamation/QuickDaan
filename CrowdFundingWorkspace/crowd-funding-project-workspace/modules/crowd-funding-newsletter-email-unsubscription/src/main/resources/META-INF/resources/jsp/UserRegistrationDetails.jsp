<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ include file="/jsp/init.jsp" %>
<portlet:defineObjects />

<%
/* long UserOtpId = Long.parseLong(renderRequest.getParameter("UserOtpId")); */
long UserOtpId = 0;
%> 

<portlet:actionURL name="userRegistration" var="userRegistrationURL">
</portlet:actionURL>contactNo

<aui:form action="${userRegistrationURL}" method="post" >
	
	<aui:input name="UserOtpId" type="hidden" value="<%= UserOtpId %>" />
	<aui:input name="firstName" label="First Name" />
	<aui:input name="lastName" label="Last Name" />
	<aui:input type="password" name="password" label="Password" />
	<aui:select label="Gender" name="gender" >
		<aui:option label="Male" value="Male" />
		<aui:option label="Female" value="Female" />
	</aui:select>
	
	<aui:button name="submit" type="submit" value="submit" />
	
</aui:form>