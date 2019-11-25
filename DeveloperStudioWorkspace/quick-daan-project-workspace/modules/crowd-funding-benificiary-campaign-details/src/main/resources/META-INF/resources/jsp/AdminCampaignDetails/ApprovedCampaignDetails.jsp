<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException"%>
<%@page import="com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectAcknowledgementRegistration"%>
<%@page import="com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundReleaseRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DynamicFeesRegistration"%>
<%@page import="com.crowd.funding.database.model.ProjectFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectExtentionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectExtentionRegistration"%>
<%@page import="com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DocumentRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectUpdateRegistration"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserOTPRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalService"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<liferay-theme:defineObjects />

<portlet:defineObjects />
<style>

.Header{
    border: 1px solid #7FBD2C;
    border-top:3px solid #7FBD2C;
    border-right:3px solid #7FBD2C;
    box-shadow: 0 0 10px 1px #7FBD2C;
    border-style: solid;
    
    padding: 40px;
    background-color:white;
    width: 923px;
    margin-left: 119px;
 }
 
 h1, .h1 {
    font-size: 1.625rem;
    margin-left: 220px;
     color:#0077A2;
     /* text-shadow: 0px 1px 2px #000; */
    margin-top: -22px;
    }
    
    .text-dark {
    color: #272834 !important;
    margin-left: -11px;
}
   
   .ProjectOwnerDetails{
   border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
   }
   
   .BenificiaryDetails{
   border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
   }
     .story{
    border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
     }
     
     .Documents{
     border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
     }
     
     .ProjectUpdates{
      border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
     }
     
     .ChangeCategory{
         border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
     }
     
     .ExtendDates{
            border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
     }
     
     .RequestForFund{
            border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
     }
     
     .ProjectAcknologement{
                border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
   border: 2px solid #7FBD2C;
   /* box-shadow: 0 0 10px 1px #7FBD2C; */
   border-style: solid;
   border-color:white;
   margin-top: -4px;
   background-color:white;
   margin:40px; 
   padding: 50px;
   width: 820px;
    margin-left: 2%;
     
     }
     
 </style>

<%
long projectID = Long.parseLong(renderRequest.getParameter("projectID"));
ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);

UserRegistration userRegistration = UserRegistrationLocalServiceUtil.findByUSER_ID(projectObj.getUSER_ID());
UserOTPRegistration otpRegistration = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userRegistration.getUSER_OTP_ID());
BenificiaryRegistration benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectObj.getBENIFICIARY_ID());

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

float donatedAmount = 0;
List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());

for(FundRegistration fundAmtObj : fundAmtList){
	donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
}

List<ProjectUpdateRegistration> updateRegistrationList = ProjectUpdateRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
%>

<portlet:actionURL name="adminProjectContent" var="adminProjectContentURL" />
<aui:form action="${adminProjectContentURL}" method="post">

<aui:input name="projectID" type="hidden" value="<%= projectObj.getPROJECT_ID() %>"></aui:input>
	
	<portlet:actionURL var="RejectDetailsURL" name="RejectDetails">
	<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
	</portlet:actionURL>
	<div class="Header">
	
	<!-- ------------------------------------------------------ Title and Image-------------------------------------------------------------------- -->
	 <strong><!-- Title : --></strong><h1 style="color:#0077A2;margin-left:210px;"> <%= projectObj.getTITLE() %></h1>
	
	<strong style="margin-left: 560px;color:#0077A2;font-size:1.1rem;">Creation Date :</strong> <strong style="font-size:1.1rem;"> <%= formatter.format(projectObj.getCREATION_DATE()) %></strong><br>
	<strong style="margin-left: 560px;color:#0077A2;font-size:1.1rem;">End Date :</strong> <strong style="font-size:1.1rem;"> <%= formatter.format(projectObj.getEND_DATE()) %></strong><br><br>
	 
	  <portlet:resourceURL  var="imageResourceURL">
				<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
				<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(projectObj.getPROJECT_ID())  %>"/>
			</portlet:resourceURL>
	<center><img src="${imageResourceURL}" alt="Image" style="width:800px;height:350px;"/></center>
	 <br>
	 <!-- ------------------------------------------------------ Project Owner Details  -------------------------------------------------------------------- -->
	 
	 <div class="ProjectOwnerDetails" style="border:1px solid #90caf9; border-bottom:3px solid #90caf9; border-right:3px solid #90caf9;border-radius: 8px;">
	
	 <div><h3 style="border:1px solid #90caf9;border-color:#90caf9;width: 252px;text-align:center;border-radius:7px;color:#008000;
    margin-left: 10px;margin-top:-70px; padding:10px;border-top:-62px;background-color: white; border-bottom: 0;
    border-radius: 12px;">Project Owner Details</h3></div><br>
	
	 <strong style="color:#0077A2;">Poject Owner Name :</strong> <%= userRegistration.getFULL_NAME() %><br><br>
	 <strong style="color:#0077A2;">Mail ID :</strong> <%= otpRegistration.getMAIL()  %><br><br>
	 <strong style="color:#0077A2;">Mobile No :</strong> <%= otpRegistration.getMOBILE_NO() %>
     </div>
	 <!-- ------------------------------------------------------ Benificiary Details -------------------------------------------------------------------- -->
	 
	 <div class="BenificiaryDetails" style="border-radius: 8px;border:1px solid #90caf9; border-bottom:3px solid #90caf9;border-right:3px solid #90caf9;">
	 
	 <div><h3 style="border:1px solid #90caf9;border-color:#90caf9;width: 252px;text-align:center;border-radius:7px;color:#008000;
    margin-left: 10px;margin-top:-70px; padding:10px;border-top:-62px;background-color: white;    border-bottom: 0;
    border-radius: 12px;">Benificiary Details</h3><br></div>
    
	 
	  <% if(benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){ %>
	  <strong style="color:#0077A2;">Benificiary Name :</strong> <%= userRegistration.getFULL_NAME() %><br><br>
	  <% }if(!benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){ %>
	   <strong style="color:#0077A2;">Benificiary Name :</strong> <%= benificiaryRegistration.getBENIFICIARY_NAME() %><br><br>
	  <% } %>
	  
	  <% if(benificiaryRegistration.getBENIFICIARY_TYPE().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual) || benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){ %>
		 <strong>Age :</strong> <%= benificiaryRegistration.getAGE() %><br><br>
		 <strong>Gender :</strong> <%= benificiaryRegistration.getGENDER() %><br><br>
	 <% } %>

	 <strong style="color:#0077A2;">Benificiary Address :</strong><br> <%= benificiaryRegistration.getADDRESS_LINE1() %>,<%= benificiaryRegistration.getADDRESS_LINE2() %>,<br><%= benificiaryRegistration.getCITY() %>,<%= benificiaryRegistration.getSTATE() %>- <%= benificiaryRegistration.getPINCODE() %>,<br><%= benificiaryRegistration.getCOUNTRY() %><br><br>
	 <strong style="color:#0077A2;">Benificiary Phone No. :</strong> <%= benificiaryRegistration.getCONTACT_NO() %><br><br>
	
	 <strong style="color:#0077A2;">Emergency Contect Details :</strong> <%= benificiaryRegistration.getEMERGENCY_CONTACT_DETAILS() %><br>
	 <strong style="color:#0077A2;">Alternet Contect No. :</strong> <%= benificiaryRegistration.getALTERNATE_CONTACT_NO() %><br>
	 
	 <strong style="color:#0077A2;">Cause Details :</strong> <%= benificiaryRegistration.getCAUSE_DETAILS() %><br><br>
	 <strong style="color:#0077A2;">Benificiary Category :</strong> <%= benificiaryRegistration.getBENIFICIARY_CATEGORY() %><br><br>
	
	<% if(!benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){ %>
	 <strong style="color:#0077A2;">Benificiary Type :</strong> <%= benificiaryRegistration.getBENIFICIARY_TYPE() %><br><br>
	 <% } %>
	 
	 <% if(benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Family) && benificiaryRegistration.getBENIFICIARY_TYPE().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual)){ %>
	 <strong style="color:#0077A2;">Relation :</strong> <%= benificiaryRegistration.getRELATIONSHIP() %>(<%= benificiaryRegistration.getRELATIONSHIP_DETAILS() %>)<br><br>
	 <% } %>
	 
	 </div>
	 
	 <!-- ------------------------------------------------------ Story -------------------------------------------------------------------- -->
	
	
	<div class="story"
	style="border-radius: 8px;border:1px solid #90caf9;border-bottom:3px solid #90caf9;border-right:3px solid #90caf9;">
	
	 <div><h3 style="border:1px solid #90caf9;border-color:#90caf9;width: 252px;text-align:center;border-radius:7px;color:#008000;
    margin-left: 10px;margin-top:-70px; padding:10px; border-top:-62px;background-color: white;border-bottom: 0;
    border-radius: 12px;">Story</h3></div><br>
	 
	 
	<strong style="color:#0077A2;">User Story : </strong><%= projectObj.getDESCRIPTION() %>
	<br>
	
	<!-- ------------------------------------------------------ Documents -------------------------------------------------------------------- -->
	
	<%-- <div class="Documents"style="border:1px solid #90caf9;border-bottom:3px solid #90caf9;border-right:3px solid #90caf9;">
	
	<div><h3 style="border:1px solid #90caf9;border-color:#90caf9;width: 252px;text-align:center;border-radius:7px;color:#008000;
    margin-left: 10px;margin-top: -60px;border-top:-62px;padding:5px;background-color: white;    border-bottom: 0;
    border-radius: 12px;">Documents</h3></div>
	 --%>
	  <strong style="color:#0077A2;">Document :</strong>
	 <%
	  List<DocumentRegistration> documentList = DocumentRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
	  for(DocumentRegistration documentObj : documentList){
	  %>
	  	
		 <portlet:resourceURL  var="ProjectDocumentResourceURL">
			<portlet:param name="serverResourceCall" value="ProjectIDForDocument"/>
			<portlet:param name="ProjectDocumentID" value="<%= String.valueOf(documentObj.getPROJECT_DOCUMENT_ID())  %>"/>
		 </portlet:resourceURL>
      <a href="${ProjectDocumentResourceURL}" alt="Document" /><%= documentObj.getDOCUMENT_NAME() %></a>

  	<% } %>
	</div>
	<!-- ------------------------------------------------------ Project Updates -------------------------------------------------------------------- -->
	
	<div class="ProjectUpdates"
	style="border-radius: 8px;border:1px solid #90caf9;border-bottom:3px solid #90caf9;border-right:3px solid #90caf9;">
	 
	 <div><h3 style="border:1px solid #90caf9;border-color:#90caf9;width: 252px;text-align:center;border-radius:7px;color:#008000;
    margin-left: 10px;margin-top:-70px;border-top:-70px; padding:10px;background-color: white;border-bottom: 0;
    border-radius: 12px;">Project Updates</h3><br></div>
	 
	<%
	int i = 1;
	for(ProjectUpdateRegistration updateRegistration : updateRegistrationList){ %>
	
		<tr>
			<td><strong><b>#<%= i %></b> </strong> <%= updateRegistration.getUPDATE_DETAILS() %></td>
		</tr>
	<%
	i++;
	}if(updateRegistrationList.size() <= 0){%>
		<tr>
			<td><strong><b>No Any Updates.</b></strong></td>
		</tr>
	<% } %>
	</div>
	<%-- <!-- ------------------------------------------------------ Change Category  -------------------------------------------------------------------- -->

	<div class="ChangeCategory"
	style="border-radius: 8px;border:1px solid #90caf9;border-bottom:3px solid #90caf9;border-right:3px solid #90caf9;">

<div><h3 style="border-radius: 8px;border:1px solid #90caf9;border-color:#90caf9;width: 252px;text-align:center;border-radius:7px;color:#008000;
    margin-left: 10px;margin-top:-70px;border-top:-70px; padding:10px;background-color: white;border-bottom: 0;
    border-radius: 12px;">Change Category</h3><br></div>

	<table cellpadding="15" border="1" style="color: #0077A2; background-color: #cccccc29; width: 628px;">
	<tbody>
	
	<%
	List<ProjectFeesRegistration> feesRegistrationList = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
	for(ProjectFeesRegistration feesRegistrationObj : feesRegistrationList){
		DynamicFeesRegistration dynamicFeesObj = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesRegistrationObj.getCATEGORY_ID());
		%>
		 <% if(feesRegistrationObj.getEND_AMOUNT() != 0){ %>
			  <tr >
			    <td style=" border: 1px solid black;">Project Category : </td>
			    <td style=" border: 1px solid black;"><%= dynamicFeesObj.getCATEGORY_NAME() %> </td>
			  </tr  >
			   <tr>
			    <td style=" border: 1px solid black;">Start Amount : </td>
			    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getSTART_AMOUNT() %> </td>
			  </tr>
			  <tr >
			    <td style=" border: 1px solid black;">End Amount :</td>
			    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getEND_AMOUNT() %> </td>
			  </tr>
		  <% }if(feesRegistrationObj.getEND_AMOUNT() == 0){
			  %>
		  		<tr >
		  			<td style=" border: 1px solid black;" colspan='3'><strong>Current Project Category</strong></td>
		  		</tr>
			  <tr >
			    <td style=" border: 1px solid black;">Project Category : </td>
			    <td style=" border: 1px solid black;"><%= dynamicFeesObj.getCATEGORY_NAME() %> </td>
			  </tr>
			  	<tr >
			    <td style=" border: 1px solid black;">Start Amount : </td>
			    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getSTART_AMOUNT() %> </td>
			  </tr>
			  <tr >
			    <td style=" border: 1px solid black;">End Amount :</td>
			    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getEND_AMOUNT() %> </td>
			  </tr> 
		  <% } 
		}
		
		%> 
		</tbody>
		</table>
	</div> --%>
	
	<!-- ------------------------------------------------------ Change Category  -------------------------------------------------------------------- -->

	<div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">

	<div><b><h3 style="font-size: 1.2rem;padding: 2px;color: darkgreen;">Change Category</h3></b><br></div>

	<table cellpadding="15" border="1" style="color: #0077A2; background-color: #cccccc29; width: 628px;">
	<tbody>
	<%
	List<ProjectFeesRegistration> feesRegistrationList = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
	for(ProjectFeesRegistration feesRegistrationObj : feesRegistrationList){
		DynamicFeesRegistration dynamicFeesObj = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesRegistrationObj.getCATEGORY_ID());
		%>
		 <% if(feesRegistrationObj.getEND_AMOUNT() != 0){ %>
			  <tr >
			    <td style=" border: 1px solid black;">Project Category : </td>
			    <td style=" border: 1px solid black;"><%= dynamicFeesObj.getCATEGORY_NAME() %> </td>
			  </tr  >
			   <tr>
			    <td style=" border: 1px solid black;">Start Amount : </td>
			    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getSTART_AMOUNT() %> </td>
			  </tr>
			  <tr >
			    <td style=" border: 1px solid black;">End Amount :</td>
			    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getEND_AMOUNT() %> </td>
			  </tr>
		  <% }if(feesRegistrationObj.getEND_AMOUNT() == 0){
			  %>
		  		<tr >
		  			<td style=" border: 1px solid black;" colspan='3'><strong><center>Current Project Category</center></strong></td><br>
		  		</tr>
			  <tr >
			    <td style=" border: 1px solid black;">Project Category : </td>
			    <td style=" border: 1px solid black;"><%= dynamicFeesObj.getCATEGORY_NAME() %> </td>
			  </tr>
			  	<tr >
			    <td style=" border: 1px solid black;">Start Amount : </td>
			    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getSTART_AMOUNT() %> </td>
			  </tr>
			  <tr >
			    <td style=" border: 1px solid black;">End Amount :</td>
			    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getEND_AMOUNT() %> </td>
			  </tr> 
		  <% } 
		}
		
		%> 
		</tbody>
		</table>
	</div>
	
	<%-- <!-- ------------------------------------------------------ Requested for Fund Withdraw -------------------------------------------------------------------- -->
	
	<div class="RequestForFund"
	style="border-radius: 8px;border:1px solid #90caf9;border-bottom:3px solid #90caf9;border-right:3px solid #90caf9;">
	
	<div><h3 style="border:1px solid #90caf9;border-color:#90caf9;width: 262px;text-align:center;border-radius: 7px;color:#008000;
    margin-left: 10px;margin-top:-70px;border-top: -70px; padding:10px;background-color: white;    border-bottom: 0;
    border-radius: 12px;">Request For Fund Withdraw</h3><br></div>
	
	
	<strong style="color:#0077A2;">Campaign Fund Amount : </strong><%= String.format("%.0f",projectObj.getREQUIRED_FUND_AMOUNT()) %><br><br>
	<strong style="color:#0077A2;">Donated Amount Rs: </strong><%= String.format("%.0f",donatedAmount) %><br>
	
	
	<% 
		List<FundReleaseRegistration> fundReleaseRegistrationList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
		for(FundReleaseRegistration fundReleaseRegistration : fundReleaseRegistrationList){
	%>
	
		<tr>
			<td></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		
	<% } %>
	</div> --%>
	
	<!-- ------------------------------------------------------ Requested for Fund Withdraw -------------------------------------------------------------------- -->
	
	<div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">
	
	<div><b><h3 style="font-size: 1.2rem;padding: 2px;color: darkgreen;">Request For Fund Withdraw</h3></b><br></div>
	
	
	<strong style="color:#0077A2;">Campaign Required Fund Amount : </strong><%= String.format("%.0f",projectObj.getREQUIRED_FUND_AMOUNT()) %><br><br>
	<strong style="color:#0077A2;">Donated Amount Rs: </strong><%= donatedAmount %><br><br>
	
		<%
		float totalCategoryAmtReceive = 0;
		float processingFees = 0;
		float projectFees = 0;
		float paymentGatewayCharges = 0;
		float totalReceivedAmt = 0;
		
		List<DynamicFeesRegistration> dynamicCategoryList = DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrations(0, DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrationsCount());
		for(DynamicFeesRegistration dynamicCategoryDataObj : dynamicCategoryList){
			List<FundRegistration> fundRegistrationCategoryList = FundRegistrationLocalServiceUtil.findByDYNAMIC_PROJECT_CATEGORY_ID(projectObj.getPROJECT_ID(), dynamicCategoryDataObj.getCATEGORY_ID());
			for(FundRegistration fundRegistrationCategoryObj : fundRegistrationCategoryList){
				
				totalCategoryAmtReceive = totalCategoryAmtReceive + fundRegistrationCategoryObj.getDONATED_AMOUNT();
				processingFees = (totalCategoryAmtReceive * dynamicCategoryDataObj.getPROCESSING_FEES())/100;
				projectFees = (totalCategoryAmtReceive * dynamicCategoryDataObj.getPROJECT_FEES())/100;
				paymentGatewayCharges =(totalCategoryAmtReceive * dynamicCategoryDataObj.getPAYMENT_GATEWAY_CHARGES())/100;
				totalReceivedAmt = (totalCategoryAmtReceive - (processingFees + projectFees + paymentGatewayCharges));
			}
			%>
			<table cellpadding="15" border="1" style="color: darkgreen; background-color: #cccccc29; width: 628px;">
				<tr>
				    <td>Category Name</td>
				    <td>Received Amount</td>
				    <td>Processing Fees(<%= dynamicCategoryDataObj.getPROCESSING_FEES() %>)%</td>
				    <td>Project Fees(<%= dynamicCategoryDataObj.getPROJECT_FEES() %>)%</td>
				    <td>Payment Getway Charges(<%= dynamicCategoryDataObj.getPAYMENT_GATEWAY_CHARGES() %>)%</td>
				    <td>Total Received Fund Amount(including All charges)</td>
				</tr>
				<tr>
				    <td><%= dynamicCategoryDataObj.getCATEGORY_NAME() %></td>
				    <td><%= Math.floor(totalCategoryAmtReceive) %></td>
				    <td><%= Math.floor(processingFees) %></td>
				    <td><%= Math.floor(projectFees) %></td>
				    <td><%= Math.floor(paymentGatewayCharges) %></td>
				    <td><%= Math.floor(totalReceivedAmt) %></td>
				 </tr>
			</table>
			<br>
			<br>
			<%
			totalCategoryAmtReceive = 0;
			processingFees = 0;
			projectFees = 0;
			paymentGatewayCharges = 0;
			totalReceivedAmt = 0;
		}
		
	%>
	
	<br><br>
	
	<% 
		List<FundReleaseRegistration> fundReleaseRegistrationList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
		for(FundReleaseRegistration fundReleaseRegistration : fundReleaseRegistrationList){
			ProjectFeesRegistration releaseProjectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_FEES_ID(fundReleaseRegistration.getPROJECT_FEES_ID()); 
			DynamicFeesRegistration dynamicFeesRegistration = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(releaseProjectFeesRegistration.getCATEGORY_ID());
			
			float totalRequestedAmt = fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT() + fundReleaseRegistration.getPROCESSING_FEES() + fundReleaseRegistration.getPROJECT_FEES() + fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES();
			if( Validator.isNull(fundReleaseRegistration.getRELEASE_DATE()) == false){
				%>
					<strong style="color:#0077A2;">Release Fund Details</strong><br>
					<table cellpadding="15" border="1" style="color: darkgreen; background-color: #cccccc29; width: 628px;">
						  <tr>
						    <td>Release Date :</td>
						    <td><%= formatter.format(fundReleaseRegistration.getRELEASE_DATE()) %></td>
						  </tr>
						  <tr>
						  	<td>Requested Withdraw Amount : </td>
						  	<td><%= Math.floor(totalRequestedAmt) %></td>
						  </tr>
						  <tr>
						    <td>Processing Fees :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPROCESSING_FEES()) %></td>
						 </tr>
						 <tr>
						    <td>Project Fees :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPROJECT_FEES()) %></td>
						  </tr>
						   <tr>
						    <td>Payment Getway Charges :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES()) %></td>
						  </tr>
						   <tr>
						    <td>Total Fund Realase Amount(including All charges) :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT()) %></td>
						  </tr>
					</table>
				<%
			}
			if(Validator.isNull(fundReleaseRegistration.getRELEASE_DATE()) == true){
				%>
					<strong style="color:#0077A2;">Requested Fund Withdraw Amount</strong>
					<table cellpadding="15" border="1" style="color: tomato; background-color: #cccccc29; width: 628px;">
						 <tr>
						    <td>Requested Date :</td>
						    <td><%= formatter.format(fundReleaseRegistration.getREQUEST_DATE()) %></td>
						  </tr>
						  <tr>
						  	<td>Requested Withdraw Amount : </td>
						  	<td><%= Math.floor(totalRequestedAmt) %></td>
						  </tr>
						  <tr>
						    <td>Processing Fees :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPROCESSING_FEES()) %></td>
						 </tr>
						 <tr>
						    <td>Project Fees :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPROJECT_FEES()) %></td>
						  </tr>
						   <tr>
						    <td>Payment Getway Charges :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES()) %></td>
						  </tr>
						   <tr>
						    <td>Total Fund Realase Amount(including All charges) :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT()) %></td>
						  </tr>
					</table>
				<%
			}
		} %>
	</div>
	

		<!-- ------------------------------------------------------ Extended Dates -------------------------------------------------------------------- -->
	
	
	
	 <% List<ProjectExtentionRegistration> extentionRegistrationDetailsList = ProjectExtentionRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
	  	for(ProjectExtentionRegistration extentionRegistration : extentionRegistrationDetailsList){
	  %>
	  <div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">
	
		<div><b><h3 style="font-size: 1.2rem;padding: 2px;color: darkgreen;">Extend Dates</h3></b><br></div>
		  <tr>
		  		<td><strong>Extended Days</strong></td>
		  </tr>
		  <tr>
		  		<td>Start Date : <%= extentionRegistration.getDATE() %></td>
		  </tr>
		  <tr>
		   		<td>Extended Date : <%= extentionRegistration.getEXTENTION_DATE() %></td>
		  </tr>
	  </div>
	  <% } %>
	
	
	<!-- ------------------------------------------------------ Project Acknowlegement -------------------------------------------------------------------- -->
	
	
	
	<% 
	try{
		ProjectAcknowledgementRegistration acknowledgementRegistration = ProjectAcknowledgementRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
		
		%>
		<div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">
	
			<div><b><h3 style="font-size: 1.2rem;padding: 2px;color: darkgreen;">Project Acknowlegement</h3></b><br></div>
			<tr>
				<td>Details : <%= acknowledgementRegistration.getDETAILS() %></td>
			</tr>	
			<tr>
				<td>
					<portlet:resourceURL  var="NormalProjectImageResourceURL">
						<portlet:param name="serverResourceCall" value="AcnowledgmentIDForProjectVideo"/>
						<portlet:param name="AcnowledgmentIDForProjectVideo" value="<%= String.valueOf(acknowledgementRegistration.getPROJECT_ID())  %>"/>
					</portlet:resourceURL>
					
					<video autoplay id="myVideo" controls style="max-width: 50%;">
					<source src="${NormalProjectImageResourceURL}" type="<%= acknowledgementRegistration.getVIDEO_TYPE() %>">
					</video>
				</td>
			</tr>
			<tr>
				<td>
					 <portlet:resourceURL  var="acknowledgementDocumentResourceURL">
							<portlet:param name="serverResourceCall" value="acknowledgementIDForDocument"/>
							<portlet:param name="acknowledgementDocumentID" value="<%= String.valueOf(acknowledgementRegistration.getACKNOWLEDGMENT_ID())  %>"/>
					 </portlet:resourceURL>
				      <a href="${acknowledgementDocumentResourceURL}" alt="Document" /><%= acknowledgementRegistration.getDOCUMENT_NAME() %></a>
				</td>
			</tr>
		</div>
			<% }catch(NoSuchProjectAcknowledgementRegistrationException e){
				
		} %>
		
		
			<br>
		<center><aui:button type="cancel" value="cancel" onClick="window.history.back();" style="color:white;background-color:#0077A2;border-radius:22px;"/></center>

</aui:form>

 