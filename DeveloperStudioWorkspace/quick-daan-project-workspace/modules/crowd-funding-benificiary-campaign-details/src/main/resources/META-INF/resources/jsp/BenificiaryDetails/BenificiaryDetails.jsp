<%-- <%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
   <style>
 a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
      width: 572px;
          margin-left: 298px;
}

 h1{
         color:#9c3353;
         margin-left: 186px;
        }
</style>

<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="BenificiaryDetails" var="BenificiaryDetailsURL" />

<aui:form action="${BenificiaryDetailsURL}" method="post" enctype="multipart/form-data">
<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<div class ="BenificiaryDetails">
       <h1>Benificiary Details</h1>
       <br>
       <hr>
<aui:input cssClass="borderForm" name="addressline1" label="AddressLine1  "  ><aui:validator name="required" /></aui:input>
<aui:input cssClass="borderForm" name="addressline2" label="AddressLine2  "><aui:validator name="required" /></aui:input>

 <aui:input cssClass="borderForm" name="city" label="City  " ><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
  <aui:input cssClass="borderForm" name="state" label="State  " ><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
  <aui:input cssClass="borderForm" name="pincode" label="Pincode  " pattern="^\d{6}$" maxlength="6" ><aui:validator name="required" /><aui:validator name="maxLength">6</aui:validator></aui:input>
 <aui:input cssClass="borderForm" name="Country" label="Country  " ><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
 
<aui:input type="textarea" cssClass="borderForm" name="emergencyContact" label="Emergency Contact Details  "  pattern="^\d{10}$"maxlength="10"><aui:validator name="required" /></aui:input>
<aui:input cssClass="borderForm" name="mobileNo" label="Mobile No"  onkeypress="phoneno()" maxlength="10"pattern="[6-9]{1}[0-9]{9}"> 
<aui:validator name="required"  />
<aui:validator name="number" />
</aui:input>

<aui:input name="emergencyContactNumber" label="Alternet Contact Number : " style="border-radius: 14px; background-color: white;width: 313px;margin-left: 189px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="minLength">10</aui:validator></aui:input>

<div style="margin-left: 235px;"><aui:button type="submit" value="Next" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;" ></aui:button>
<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
</div>
</aui:form> --%>



<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

  <style>
.bordercity{
	border-radius: 9px;
	border: 1px solid #7FBD2C;
	border-bottom: 3px solid #7FBD2C;
	background-color:#e7e7ed
	height: 43px;
	width: 704px;  
	margin-top: 1px;
	height: 43px;
    background-color: whitesmoke;
    
    
    
    strong {
    color: #0077A2;
    font-size: 13px;
    }
</style>

<style>    
    .portlet-decorate .portlet-content {
    background-color: #5d5d5d29;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 24px;
}
    
    
</style>


<script>
 $(document).ready(function(){
	    $("#inputTextBox1").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});
 
 
 $(document).ready(function(){
	    $("#inputTextBox2").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});

 
 
 $(document).ready(function(){
	    $("#inputTextBox3").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});

 
 
 
</script> 


<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="BenificiaryDetails" var="BenificiaryDetailsURL" />

<aui:form action="${BenificiaryDetailsURL}" method="post" enctype="multipart/form-data">
<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<div class ="BenificiaryDetails">
       <h1>Benificiary Details</h1>
       <br>
       <hr>
       
<aui:input cssClass="borderForm" name="addressline1" label="AddressLine1"  >
<aui:validator name="required" />
</aui:input>

<aui:input cssClass="borderForm" name="addressline2" label="AddressLine2">
<aui:validator name="required" />
</aui:input>


 <%-- <aui:input type="text" cssClass="borderForm" id="inputTextBox" name="city" label="City" >
 <aui:validator name="required" />
 <aui:validator name="alpha"/>
 </aui:input>
  --%>
  
 <strong>City</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox1" required="required"  name="<portlet:namespace/>city" style="padding: 5px;"  >
	 </input>
	 <br>
	 <br>
 
 
 <%-- <aui:input cssClass="borderForm" name="state" label="State " pattern="[a-zA-Z\s]+" >
 <aui:validator name="required" />
 <aui:validator name="alpha"/>
 </aui:input>
  --%>
  
  <strong>State </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox2" required="required"  name="<portlet:namespace/>state" label="State " style="padding: 5px;" >
	 </input>
	 <br>
     <br>

  <aui:input cssClass="borderForm" name="pincode" label="Pincode " onkeypress="pincode()" minlength="6" maxlength="6" pattern="^\d{6}$" title="Format: Minium of 6 numbers is required">
  <aui:validator name="required"/>
  <aui:validator name="number"/>
  </aui:input>
  
 <%-- <aui:input cssClass="borderForm" name="Country" label="Country  " pattern="[a-zA-Z\s]+">
 <aui:validator name="required" />
 <aui:validator name="alphanumeric"/> 
 </aui:input> --%>
 
 
  <strong>Country </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox3" required="required"  name="<portlet:namespace/>Country" label="Country " style="padding: 5px;" >
	 </input>
	 <br>
	 <br>
 
 
 
<aui:input type="textarea" cssClass="borderForm" name="emergencyContact" label="Emergency Contact Details" >
<aui:validator name="required" /></aui:input>

<%-- <aui:input cssClass="borderForm" name="mobileNo" label="Mobile No"  onkeypress="phoneno()" maxlength="10"pattern="[6-9]{1}[0-9]{9}"> 
<aui:validator name="required"  />
<aui:validator name="number" />
</aui:input> --%>

 <aui:input cssClass="borderForm" name="emergencyContactNumber" label="Alternet Contact Number:" onkeypress="phoneno()" minlength="10" maxlength="10" pattern="[0-9]{1}[0-9]{9}" title="Format:Minimum of 10 number is required">
<aui:validator name="required"/>
<aui:validator name="minLength" />
<aui:validator name="number"></aui:validator>
</aui:input>

<div style="margin-left: 235px;"><aui:button type="submit" value="Next" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;" ></aui:button>

<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
</div>
</aui:form>
