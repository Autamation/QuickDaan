<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.crowd.funding.database.model.FundReleaseRegistration"%>
<%@page import="com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/jsp/init.jsp" %>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
<portlet:renderURL var="FilteredReoprtURL" windowState="normal">
	<portlet:param name="jspPage" value="/jsp/FilteredReportOptions.jsp"/>
</portlet:renderURL>
<aui:button name="submit" onClick="${FilteredReoprtURL}" value="Filtered Report" /> </BR></BR></BR></BR>

 <%
 int counter = 1;
 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
 String selectCause = ParamUtil.getString(renderRequest, "selectCause");
 String selectBeneficieryCategory = ParamUtil.getString(renderRequest,"selectBeneficieryCategory");
 String selectStatus = ParamUtil.getString(renderRequest,"selectStatus");
 String campaignStartDate = ParamUtil.getString(renderRequest,"campaignStartDate");
 String selectWithdrawType = ParamUtil.getString(renderRequest,"selectWithdrawType");
 String campaignFromDate =ParamUtil.getString(renderRequest,"campaigFromDate");
 String campaignToDate = ParamUtil.getString(renderRequest,"campaignToDate");
 int count = 2;
 List<BenificiaryRegistration> benificiaryList = null;
 List<ProjectRegistration> projectList = null;
 List<List<ProjectRegistration>> projectArrayList = new ArrayList<List<ProjectRegistration>>();
 List<FundReleaseRegistration> fundList = null;
 List<FundReleaseRegistration> fundCombinationList = null;
 ProjectRegistration projectObj = null;
 ProjectRegistration projectCombinationObj = null;
 Set<ProjectRegistration> projectlistObj = new HashSet<ProjectRegistration>();

 if(((selectCause.isEmpty()== false) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== false) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== false) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== false) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== false && campaignToDate.isEmpty()== false) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== false && campaignToDate.isEmpty()== false) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== false)))
 { 	count = 0;
 }else if((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)){
 	count = 2;
 }else{
	 count= 1;
 }
 	if(count == 0) {
		if(selectStatus.isEmpty() == false){
				if(Integer.parseInt(selectStatus) == 6){
					projectList = ProjectRegistrationLocalServiceUtil.findByREQUEST_STATUS(2);
				}
				else if(Integer.parseInt(selectStatus) == 7){
					projectList = ProjectRegistrationLocalServiceUtil.findByREQUEST_STATUS(3);
				}
				else{
					projectList = ProjectRegistrationLocalServiceUtil.findBySTATUS(Integer.parseInt(selectStatus));
				}
		}else if(selectCause.isEmpty() == false){
			benificiaryList = BenificiaryRegistrationLocalServiceUtil.findByCAUSE_DETAILS(selectCause);
		}else if(selectBeneficieryCategory.isEmpty() == false){
			benificiaryList = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_CATEGORY(selectBeneficieryCategory);
		}else if(campaignStartDate.isEmpty() == false){
		 	projectList = ProjectRegistrationLocalServiceUtil.findByProjectCreationDate(campaignStartDate);	
		}else if((campaignFromDate.isEmpty() == false) && (campaignToDate.isEmpty() == false)){
		 	projectList = ProjectRegistrationLocalServiceUtil.findProjectBetweenCreationDateQuery(campaignFromDate, campaignToDate);	
		}else if(selectWithdrawType.isEmpty() == false){
			fundList = FundReleaseRegistrationLocalServiceUtil.findBySTATUS(Integer.parseInt(selectWithdrawType));
		}
	}else if(count == 1) {
		if(selectCause.isEmpty() == false && selectBeneficieryCategory.isEmpty() == false) {
			System.out.println("Nirav1");
			 benificiaryList = BenificiaryRegistrationLocalServiceUtil.findByCAUSE_BENIFICIARY_CATEGORY(selectCause, selectBeneficieryCategory);
			 System.out.println("Niravlist1" +benificiaryList.size());
		}else if(selectCause.isEmpty() == false) {
			System.out.println("Nirav2");
			 benificiaryList =	BenificiaryRegistrationLocalServiceUtil.findByCAUSE_DETAILS(selectCause);
			 System.out.println("Niravlist2" +benificiaryList.size());
		}else if(selectBeneficieryCategory.isEmpty() == false) {
			System.out.println("Nirav3");
			 benificiaryList =	BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_CATEGORY(selectBeneficieryCategory);
			 System.out.println("Niravlist3" +benificiaryList.size());
		}else if(selectCause.isEmpty() == true && selectBeneficieryCategory.isEmpty() == true){
			benificiaryList = null;	
			System.out.println("Nirav4");
			//System.out.println("Niravlist4" +benificiaryList.size());
		}
		if(benificiaryList != null ) {
		if(selectStatus.isEmpty() == true && campaignStartDate.isEmpty() == true) {
			System.out.println("Nirav5");
			for(BenificiaryRegistration benificiaryObj : benificiaryList) {
				projectList = ProjectRegistrationLocalServiceUtil.findByBENIFICIARY_ID(benificiaryObj.getBENIFICIARY_ID());
				projectArrayList.add(projectList);
				System.out.println("Niravlist5" +projectList.size());
			}
			System.out.println("Niravlist111:" +projectArrayList.size());
		}else if(selectStatus.isEmpty() == false && campaignStartDate.isEmpty() == false) {
			System.out.println("Nirav6");
			for(BenificiaryRegistration benificiaryObj : benificiaryList) {
				projectList = ProjectRegistrationLocalServiceUtil.findprojectByBenificiaryIdStatusCreationDate(benificiaryObj.getBENIFICIARY_ID(), 
						Integer.parseInt(selectStatus), campaignStartDate);
				projectArrayList.add(projectList);
				System.out.println("Niravlist6" +projectList.size());
			}
		}else if(selectStatus.isEmpty() == false) {
			System.out.println("Nirav7");
			for(BenificiaryRegistration benificiaryObj : benificiaryList) {
				projectList = ProjectRegistrationLocalServiceUtil.findByBENIFICIARY_ID_STATUS(benificiaryObj.getBENIFICIARY_ID(), Integer.parseInt(selectStatus));
				projectArrayList.add(projectList);
				System.out.println("Niravlist7" +projectList.size());
			}
		}else if(campaignStartDate.isEmpty() == false) {
			System.out.println("Nirav8");
			for(BenificiaryRegistration benificiaryObj : benificiaryList) {
				projectList = ProjectRegistrationLocalServiceUtil.findprojectByBenificiaryIdCreationDate(benificiaryObj.getBENIFICIARY_ID(), campaignStartDate);
				projectArrayList.add(projectList);
				System.out.println("Niravlist8" +projectList.size());
			}
		}
		}else if(benificiaryList == null ){
			if(selectStatus.isEmpty() == false && campaignStartDate.isEmpty() == false) {
				System.out.println("Nirav9");
				projectList = ProjectRegistrationLocalServiceUtil.findprojectByStatusCreationDate(Integer.parseInt(selectStatus), campaignStartDate);
				projectArrayList.add(projectList);
				System.out.println("Niravlist9" +projectList.size());
				/* if(selectWithdrawType.isEmpty() == false) {
					System.out.println("Nirav10");
					for(ProjectRegistration projectObject : projectList) {
						System.out.println("Nirav11");
						fundCombinationList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObject.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
						System.out.println("Niravlist11" +fundCombinationList.size());
						for(FundReleaseRegistration fundObj : fundCombinationList) {
							System.out.println("Nirav12");
							ProjectRegistration projectCombinationObject = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundObj.getPROJECT_ID());
							projectlistObj.add(projectCombinationObject);
							System.out.println("Niravlist12" +projectlistObj.size());
						}
					}
				} */
			}else if(selectStatus.isEmpty() == false) {
				System.out.println("Nirav13");
				projectList = ProjectRegistrationLocalServiceUtil.findBySTATUS(Integer.parseInt(selectStatus));
				projectArrayList.add(projectList);
				System.out.println("Niravlist13" +projectList.size());
				/* if(selectWithdrawType.isEmpty() == false) {
					System.out.println("Nirav14");
					for(ProjectRegistration projectObject : projectList) {
						System.out.println("Nirav15");
						fundCombinationList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObject.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
						System.out.println("Niravlist15" +fundCombinationList.size());
						for(FundReleaseRegistration fundObj : fundCombinationList) {
							System.out.println("Nirav16");
							ProjectRegistration projectCombinationObject = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundObj.getPROJECT_ID());
							projectlistObj.add(projectCombinationObject);
							System.out.println("Niravlist16" +projectlistObj.size());
						}
					}
				} */
			}else if(campaignStartDate.isEmpty() == false) {
				System.out.println("Nirav17");
				projectList = ProjectRegistrationLocalServiceUtil.findByProjectCreationDate(campaignStartDate);
				projectArrayList.add(projectList);
				System.out.println("Niravlist17" +projectList.size());
				/* if(selectWithdrawType.isEmpty() == false) {
					System.out.println("Nirav18");
					for(ProjectRegistration projectObject : projectList) {
						System.out.println("Nirav19");
						fundCombinationList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObject.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
						System.out.println("Niravlist19" +fundCombinationList.size());
						for(FundReleaseRegistration fundObj : fundCombinationList) {
							System.out.println("Nirav20");
							ProjectRegistration projectCombinationObject = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundObj.getPROJECT_ID());
							projectlistObj.add(projectCombinationObject);
							System.out.println("Niravlist20" +projectlistObj.size());
						}
					}
				} */
			}else
				System.out.println("List is empty");
		}
		if(projectArrayList!= null) {
		if(selectWithdrawType.isEmpty() == false) {
			System.out.println("Nirav21");
			for(List<ProjectRegistration> projectObjectList : projectArrayList) {
				for(ProjectRegistration projectObject: projectObjectList){
				System.out.println("Nirav22");
				fundCombinationList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObject.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
				System.out.println("Niravlist22" +fundCombinationList.size());
				for(FundReleaseRegistration fundObj : fundCombinationList) {
					System.out.println("Nirav23");
					ProjectRegistration projectCombinationObject = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundObj.getPROJECT_ID());
					projectlistObj.add(projectCombinationObject);
					System.out.println("Niravlist23" +projectlistObj.size());
				}
			}
			}
		}
		}
		}
 	else if(count == 2){
 		System.out.println("Nirav0");
		projectList = ProjectRegistrationLocalServiceUtil.getProjectRegistrations(0, CounterLocalServiceUtil.getCountersCount());
		System.out.println("Niravlist0" +projectList.size());
 	}
 %>
 <table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>No.</th>
				<th>Project Title</th>
				<th>Creation Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
			<tbody>
			<%    
			if(count == 0){
				if((selectCause.isEmpty() == false) || (selectBeneficieryCategory.isEmpty() == false)){
					for(BenificiaryRegistration benificiaryRegistrationCategoryObj : benificiaryList ) {
						projectList = ProjectRegistrationLocalServiceUtil.findByBENIFICIARY_ID(benificiaryRegistrationCategoryObj.getBENIFICIARY_ID());
					for(ProjectRegistration projectRegistrationObj : projectList ) {
					%>
					<tr>
					<portlet:renderURL var="projectDetailForBeneficieryUrl" windowState="normal">
						<portlet:param name="ProjectId" value="<%= String.valueOf(projectRegistrationObj.getPROJECT_ID()) %>" />
					 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
					  </portlet:renderURL>
						<td><%= counter %></td>
						 <td><%= projectRegistrationObj.getTITLE()%></td>
						 <td><%= formatter.format(projectRegistrationObj.getCREATION_DATE()) %></td>
						 <td><%= projectRegistrationObj.getSTATUS() %></td>
						 <td><aui:button name="submit" onClick="${projectDetailForBeneficieryUrl}" value="Details" /></td>
						 </tr>
					<%
					   counter++;
					}
					}
					}
				else if(selectWithdrawType.isEmpty() == false){
					for(FundReleaseRegistration fundReleaseObj : fundList ) {
						projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundReleaseObj.getPROJECT_ID());
					%>
					<tr>
					<portlet:renderURL var="projectDetailForWithdrawTypeUrl" windowState="normal">
					<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
				  </portlet:renderURL>
						<td><%= counter %></td>
						 <td><%= projectObj.getTITLE()%></td>
						 <td><%= formatter.format(projectObj.getCREATION_DATE()) %></td>
						 <td><%= projectObj.getSTATUS() %></td>
						 <td><aui:button name="submit" onClick="${projectDetailForWithdrawTypeUrl}" value="Details" /></td>
						 </tr>
					<%
					   counter++;
					}
				}
				else{
					for(ProjectRegistration projectRegistrationObj : projectList ) {
					%>
					<tr>
					<portlet:renderURL var="projectDetailForOthersUrl" windowState="normal">
						<portlet:param name="ProjectId" value="<%= String.valueOf(projectRegistrationObj.getPROJECT_ID()) %>" />
					 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
					 	</portlet:renderURL>
						<td><%= counter %></td>
						 <td><%= projectRegistrationObj.getTITLE()%></td>
						 <td><%= formatter.format(projectRegistrationObj.getCREATION_DATE()) %></td>
						 <td><%= projectRegistrationObj.getSTATUS() %></td>
						 <td><aui:button name="submit" onClick="${projectDetailForOthersUrl}" value="Details" /></td>
						 </tr>
					<%
					   counter++;
				}
				}
			}else if(count == 1){
				if(fundCombinationList!= null){
				 for(ProjectRegistration projectObject : projectlistObj) {
					 
				%>
				<tr>
			<portlet:renderURL var="projectDetailForCombinationOfWithdrawTypeUrl" windowState="normal">
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObject.getPROJECT_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
			 	</portlet:renderURL>
				<td><%= counter %></td>
				 <td><%= projectObject.getTITLE()%></td>
				 <td><%= formatter.format(projectObject.getCREATION_DATE()) %></td>
				 <td><%= projectObject.getSTATUS() %></td>
				 <td><aui:button name="submit" onClick="${projectDetailForCombinationOfWithdrawTypeUrl}" value="Details" /></td>
				 </tr>
				<% 
				counter++;
			}
			}
			else{
			for(List<ProjectRegistration> projectRegistrationObj : projectArrayList ) {
				for(ProjectRegistration projectlistOfObj : projectRegistrationObj){
			%>
			<tr>
			<portlet:renderURL var="projectDetailForOtherssUrl" windowState="normal">
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectlistOfObj.getPROJECT_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
			 	</portlet:renderURL>
				<td><%= counter %></td>
				 <td><%= projectlistOfObj.getTITLE()%></td>
				 <td><%= formatter.format(projectlistOfObj.getCREATION_DATE()) %></td>
				 <td><%= projectlistOfObj.getSTATUS() %></td>
				 <td><aui:button name="submit" onClick="${projectDetailForOtherssUrl}" value="Details" /></td>
				 </tr>
			<%
			   counter++;
		}
		}
		}
		}else if(count == 2){
			for(ProjectRegistration projectRegistrationObj : projectList ) {
				%>
				<tr>
				<portlet:renderURL var="projectDetailForOthersssUrl" windowState="normal">
					<portlet:param name="ProjectId" value="<%= String.valueOf(projectRegistrationObj.getPROJECT_ID()) %>" />
				 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
				 	</portlet:renderURL>
					<td><%= counter %></td>
					 <td><%= projectRegistrationObj.getTITLE()%></td>
					 <td><%= formatter.format(projectRegistrationObj.getCREATION_DATE()) %></td>
					 <td><%= projectRegistrationObj.getSTATUS() %></td>
					 <td><aui:button name="submit" onClick="${projectDetailForOthersssUrl}" value="Details" /></td>
					 </tr>
				<%
				   counter++;
			}
			}
		%>
	</tbody>
</table> 