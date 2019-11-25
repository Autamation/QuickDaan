<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL name="NewsletterRegistration" var="NewsletterRegistrationURL" />

<style>
<!--
.newsLetter{
	border-top:3px solid #7FBD2C;
	border-right:3px solid #7FBD2C;
	border: 1px solid #7FBD2C;
    box-shadow: 0 0 10px 1px #7FBD2C;
    border-style: solid;
    border-color:white;
    margin-top: -4px;
    background-color:white;
    margin:40px; 
    padding: 50px;
    max-width: 520px;
    width:100%;
    margin-left: 25%;  
}
.boxField{
    border-radious:12px;
    background-clip: border-box;
    border-color: #7FBD2C;
    border-style: solid;
    border-width: 0.0625rem 0.0625rem 0.0625rem 0.0625rem;
    height: 2.5rem;
    min-width: 0;
    padding-bottom: 0.5rem;
    padding-top: 0.5rem;
    padding-left: 1rem;
    padding-right: 1rem;
    border-radius: 12px;
 	border-bottom:3px solid #7FBD2C;
    }
.label {
    color: #0077A2;
    font-size: 0.875rem;
    font-weight: 600;
    margin-bottom: 0.25rem;
    max-width: 100%;
    word-wrap: break-word;
}
    
-->
</style>
 <aui:form action="${NewsletterRegistrationURL}" method="post" enctype="multipart/form-data">
 
   <div class ="newsLetter" >
   <CENTER><h1 style="color:#0077A2"> POST NEWSLETTER</h1></CENTER>
    <br>
    
	<aui:input cssClass="boxField" name="newslettertitle" label="Title" placeholder="Enter Title " type="text" >
	
    <aui:validator name="required"/>
	</aui:input>
	
	<aui:input cssClass="boxField" name="newsletterdetail" label="Detail"type="textarea">
	<aui:validator name="required"/>
	</aui:input>
	
	<aui:input cssClass="boxField" name="file" label="Attachment" type="file" style="margin-left: 86px; margin-top: -26px;"></aui:input> 
	
	<center><aui:button name="Submit" type="Submit" value="Submit" style="background-color:#0077A2;border-radius: 22px;color:white;width: 108px;height: 39px;"/></center>

</div>	
</aui:form>

