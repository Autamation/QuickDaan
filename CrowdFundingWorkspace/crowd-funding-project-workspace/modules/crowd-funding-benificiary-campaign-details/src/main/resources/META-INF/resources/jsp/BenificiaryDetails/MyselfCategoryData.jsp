<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
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
  
.portlet-decorate .portlet-content{
    background-color: #f7f8f9;
    border: 1px solid #f1f2f5;
}

.mayborderForm {
    background-color: #5d5d5d29;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 24px;
}

 .portlet-contentImg{
   margin-left:100px;
   margin-top:10px;
}

.switch1 {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

.switch1 input { 
  opacity: 0;
  width: 0;
  height: 0;
}

.slider1 {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider1:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider1 {
  background-color: #2196F3;
}

input:focus + .slider1 {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider1:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider1.round {
  border-radius: 34px;
}

.slider1.round:before {
  border-radius: 50%;
}
</style>


<script type="text/javascript">
$(function() {
	  $('#colors').click(function(){
	    $('#' + $(this).val()).show();
	  });
	});
	
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}


	
function myFunction() {
	  // Get the checkbox
	  var checkBox = document.getElementById("myCheck");
	  // Get the output text
	  var text1 = document.getElementById("text1");
	  var text2 = document.getElementById("text2");

	  // If the checkbox is checked, display the output text
	  if (checkBox.checked == true){
	    text1.style.display = "none";
	    text2.style.display = "block";
	  } else {
	    text1.style.display = "block";
	    text2.style.display = "none";
	  }
	}
	
</script>

<%
String Myself = renderRequest.getParameter("Myself");
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

UserRegistration userData = UserRegistrationLocalServiceUtil.findByUSER_ID(td.getUserId());
%>

<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>
				

<portlet:actionURL name="BenificiaryRelationMyself" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">
	
	<h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U>   Myself   </U></a></div></h3>
	<hr>
	<div class="MyselfCategory">
	<h5>Myself</h5>
	<hr>
	
	<img src="/portal_content/download.jpg" alt="img" id ="blah" class="avatar">
	<div style=" margin-left:202px; margin-top:-139px;">
	<aui:input  name="image" type="file" accept="image/*" label="Display Photo " onchange="readURL(this);"  style="margin-right: -9px;">
	<aui:validator name="required"></aui:validator>
	</aui:input></div>
	<br>
	<br>
	<hr>
	
	<aui:input cssClass="borderForm" name="name:" label="Name  "  readonly="true"  value="<%= userData.getFULL_NAME() %>"><aui:validator name="required" /></aui:input>
	
	<div>
	<strong>If Benificiary Age is less than 1 </strong>
	<label class="switch1">
	  <input type="checkbox" id="myCheck" onclick="myFunction()" ></input>
	  <span class="slider1 round"></span>
	</label>
	</div>
	
	<div id="text1" >
		<strong>Benificiary Age Year :  </strong>
		<aui:select cssClass="borderForm" name="ageYear" label="">
			<% for(int i=1; i<=100; i++){ %>
				<aui:option value="<%= i %>" ><%= i %></aui:option>
			<% } %>
		</aui:select>
	</div>
	
	<div id="text2" style="display:none">
		<strong>Benificiary Age Month :</strong>
		<aui:select cssClass="borderForm" name="ageMonth" label="">
			<% for(int i=1; i<=12; i++){ %>
				<aui:option value="<%= i %>" ><%= i %></aui:option>
			<% } %>
		</aui:select>
	</div>
	
	<aui:input  cssClass="borderForm" name="Gender" label="Gender  "  readonly="true" value="<%= userData.getGENDER() %>" ><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
	
	<aui:input cssClass="borderForm" name="location" label="Location  " pattern="[a-zA-Z\s]+"  placeholder="Ex.Bangaluru">
	<aui:validator name="required" />
	<%-- <aui:validator name="alpha"/> --%></aui:input>
	
	<div style="margin-left: 235px;"><aui:button type="submit"style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"value="Next" ></aui:button>
	<aui:button type="cancel" value="cancel"style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
	</div>
	</aui:form>