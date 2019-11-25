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
     
     /*code for navigation bar*/
	.topnav {
		width: 100%;
		overflow: hidden;
		background-color: #0077A2;
		border-bottom: 5px solid white;

	}

	.topnav a {
		float: left;
		color: #f2f2f2;
		text-align: center;
		padding: 14px 25px;
		text-decoration: none;
		font-size: 1.2vw;
	}

	.topnav a:hover {
		background-color: #ddd;
		color: black;
	}

	.topnav a.active {
		background-color: #4CAF50;
		color: white;
	}
	
	.topnav {
		overflow: hidden;
	}

	.dropdown1 {
		float: left;
		overflow: hidden;
	}

	.dropdown1 .dropbtn1 {
		font-size: 1.2vw;
		border: none;
		outline: none;
		color: white;
		padding: 14px 19px;
		background-color: inherit;
		font-family: inherit;
		margin: 0;
	}


	.dropdown-content1 {
		display: none;
		position: absolute;
		background-color: #f9f9f9;
		min-width: 160px;
		box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
		z-index: 1;
	}

	.dropdown-content1 a {
		float: none;
		color: black;
		padding: 12px 16px;
		text-decoration: none;
		display: block;
		text-align: left;
	}

	.dropdown-content1 a:hover {
		background-color: #ddd;
	}

	.dropdown1:hover .dropdown-content1 {
		display: block;
	}
	
	#demo-2 input[type=search] {
		width: 15px;
		padding-left: 10px;
		color: transparent;
		cursor: pointer;
	}

	#demo-2 input[type=search]:hover {
		background-color: #fff;
	}

	#demo-2 input[type=search]:focus {
		padding: 10px 30px;
		width: 130px;
		padding-left: 32px;
		color: #000;
		background-color: #fff;
		cursor: auto;
	}

	#demo-2 input:-moz-placeholder {
		color: transparent;
	}

	#demo-2 input::-webkit-input-placeholder {
		color: transparent;
	}

	input {
		outline: none;
	}

	input[type=search] {
		-webkit-appearance: textfield;
		-webkit-box-sizing: content-box;
		font-family: inherit;
		font-size: 100%;
	}

	input::-webkit-search-decoration,
	input::-webkit-search-cancel-button {
		display: none;
	}


	input[type=search] {

		margin-top: 2px;
		background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
		border-bottom: solid 1px #ccc;
		border-top: solid 1px #ccc;
		border-left: solid 1px #ccc;
		border-right: solid 1px #ccc;
		padding: 15px 0px 9px 0px;
		width: 43px;

		-webkit-border-radius: 10em;
		-moz-border-radius: 10em;
		border-radius: 10em;

		-webkit-transition: all .5s;
		-moz-transition: all .5s;
		transition: all .5s;
	}

	input[type=search]:focus {
		padding: 10px 30px;
		width: 30%;
		background-color: #fff;
		border-color: #66CC75;

		-webkit-box-shadow: 0 0 5px rgba(109, 207, 246, .5);
		-moz-box-shadow: 0 0 5px rgba(109, 207, 246, .5);
		box-shadow: 0 0 5px rgba(109, 207, 246, .5);
	}


	input:-moz-placeholder {
		color: #999;
	}

	input::-webkit-input-placeholder {
		color: #999;
	}
/*end of navigation bar css*/
	
	/*cards & Testimonals css*/
	.testimotionals {
		width: 20%;
		display: inline-block;
		margin-left: 50px;
		margin-top: 50px margin-left:100px;
	}


	.testimotionals .card {
		position: relative;
		overflow: hidden;
		width: 100%;
		height: 535px;
		margin: 0 auto;
		background: #0077A2;
		padding: 20px;
		text-align: center;
		/*	box-shadow: 0 10px 40px rgba(0, 0, 0, .5)*/
	}

	.testimotionals .card .layer {
		/*z-index: 1;*/
		position: absolute;
		top: calc(100% - 2px);
		height: 100%;
		width: 100%;
		left: 0;
		background: linear-gradient(to left, #7FBD2c, #7FBD2c);
		transition: 0.5s;

	}

	.testimotionals .card .content1 {
		/*	z-index: 2;*/
		position: relative;
	}

	.testimotionals .card:hover .layer {
		top: 0;
	}

	.testimotionals .card .content1 p {
		font-size: 14px;
		line-height: 24px;
		color: #fff;
		margin-top: -3px;

	}

	.testimotionals .card .content1 .image {
		width: 100px;
		height: 100px;
		margin: 0 auto;
		border-radius: 50%;
		overflow: hidden;
		border: 4px solid white;
		box-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);

	}

	.testimotionals .card .conte nt .details h2 {
		font-size: 18px;
		color: white;
	}

	.testimotionals .card .content1 .details h2 span {
		font-size: 18px;
		color: purple;
		transition: 0.5s;
	}

	.testimotionals .card:hover .content1 .details h2 span {
		color: white;
		position: relative;
		margin-top: 7px;
	}

	.para {
		height: 110px;
	}

	.boxed {
		background-color: black;
		width: 100%;
		height: 190px;
		margin-bottom: px;
		margin-top: -8px;
	}
/*end of cards & testimanals css*/
	
/*css for text_fundraiser*/	
	.text_fundraiser {
		color: #0077A2;
		font-size: 4vw;
	}
/*end of text_fundraiser*/
	
/*code for section3 */	
	.slideshow-container {
		max-width: 1000px;
		position: relative;
		margin: auto;
		height: 420px;
	}
	
	.text {
		color: #f2f2f2;
		font-size: 15px;
		padding: 8px 12px;
		position: absolute;
		bottom: 8px;
		width: 100%;
		text-align: center;
	}

	/* The dots/bullets/indicators */
	.dot {
		height: 15px;
		width: 15px;
		margin: 0 2px;
		background-color: #bbb;
		border-radius: 50%;
		display: inline-block;
		transition: background-color 0.6s ease;
	}

	.active {
		background-color: #717171;
	}

	/* Fading animation */
	.fade {
		-webkit-animation-name: fade;
		-webkit-animation-duration: 1.5s;
		animation-name: fade;
		animation-duration: 1.5s;
	}

	@-webkit-keyframes fade {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	@keyframes fade {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	/* On smaller screens, decrease text size */
	@media only screen and (max-width: 300px) {
		.text {
			font-size: 11px
		}
	}

	/*section 2 css*/

	.slideshow-container1 {
		max-width: 100%;
		position: relative;
		margin: auto;
	}

	/* Next & previous buttons */
	.prev1,
	.next1 {
		margin-left: 100px;
		cursor: pointer;
		position: absolute;
		top: 50%;
		width: auto;
		padding: 16px;
		margin-top: -22px;
		color: black;
		font-weight: bold;
		font-size: 18px;
		transition: 0.6s ease;
		border-radius: 0 3px 3px 0;
		user-select: none;
	}

	/* Position the "next button" to the right */
	.next1 {
		right: 0;
		border-radius: 3px 0 0 3px;
		margin-right: 100px;
	}

	/* On hover, add a black background color with a little bit see-through */
	.prev:hover1,
	.next:hover1 {
		background-color: rgba(0, 0, 0, 0.8);
	}

	/* Caption text */

	.text_section2 {
		width: auto;
		height: auto;
		font-family: comic sans MS;
		color: black;
		font-size: 15px;
		padding: 0px 32px;
		position: absolute;
		bottom: 0px;
		text-align: center;
		font-size: 2.5vw;
		margin-left: 360px;
		margin-bottom: 60px;
	}

	/* Number text (1/3 etc) */
	.numbertext1 {
		color: #f2f2f2;
		font-size: 12px;
		padding: 8px 12px;
		position: absolute;
		top: 0;
	}

	/* The dots/bullets/indicators */
	.dot1 {
		cursor: pointer;
		height: 15px;
		width: 15px;
		margin: 0 2px;
		background-color: #bbb;
		border-radius: 50%;
		display: inline-block;
		transition: background-color 0.6s ease;
	}

	.active1,
	.dot:hover1 {
		background-color: #717171;
	}

	/* Fading animation */
	.fade1 {
		-webkit-animation-name: fade;
		-webkit-animation-duration: 1.5s;
		animation-name: fade;
		animation-duration: 1.5s;
	}

	@-webkit-keyframes fade1 {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	@keyframes fade1 {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	/* On smaller screens, decrease text size */
	@media only screen and (max-width: 300px) {

		.prev,
		.next,
		.text {
			font-size: 11px
		}
	}

	/*section 2 css end*/

	/*section3(1) css*/

	.section3(1) {
		height: 550px;
		width: 100%;
	}

	/*section3(1) css end*/

	.text_fundraiser {
		color: #0077A2;
		font-size: 4vw;
	}

/*end of section3 css*/	
	
	/*css of liferay */
	body {
		font-family: Verdana, sans-serif;
	}

	.mySlides {
		display: none;
	}

	img {
		vertical-align: middle;
	}

	/*body css*/
	.home_body {
		width: 100%;
		margin-top: -155px;
	}

	/*header css*/
	/*.v1 {
			border-left: 3px solid #0077A2;
			height: 60px;
			margin-left:267px;
			margin-top: -67px;
		}
*/
	.b_text {
		padding: 2px;
		font-family: georgia;
		font-size: 3vw;
		float: left;
		/*padding:50px;*/
		/*margin-top: -50px;
			margin-left: 364px;*/
	}

	/*code for search icon*/
	@import 'https://fonts.googleapis.com/css?family=Catamaran';

	html,
	body {
		width: 100%;
		height: 100%;
		margin: 0;
		padding: 0;
		font-family: 'Catamaran', sans-serif;
	}

	.topnav {
		width: 100%;
		overflow: hidden;
		background-color: #0077A2;
		border-bottom: 5px solid white;

	}

	.topnav a {
		float: left;
		color: #f2f2f2;
		text-align: center;
		padding: 14px 25px;
		text-decoration: none;
		font-size: 1.2vw;
	}

	.topnav a:hover {
		background-color: #ddd;
		color: black;
	}

	.topnav a.active {
		background-color: #4CAF50;
		color: white;
	}

	/*------------------------------------------------------------------------------------------------------------*/
	/*closing of nav bar content*/

	/*start of section2 css*/
	/* Slideshow container */
	.slideshow-container {
		max-width: 1000px;
		position: relative;
		margin: auto;
		height: 420px;
	}

	/* Caption text */
	.text {
		color: #f2f2f2;
		font-size: 15px;
		padding: 8px 12px;
		position: absolute;
		bottom: 8px;
		width: 100%;
		text-align: center;
	}

	/* The dots/bullets/indicators */
	.dot {
		height: 15px;
		width: 15px;
		margin: 0 2px;
		background-color: #bbb;
		border-radius: 50%;
		display: inline-block;
		transition: background-color 0.6s ease;
	}

	.active {
		background-color: #717171;
	}

	/* Fading animation */
	.fade {
		-webkit-animation-name: fade;
		-webkit-animation-duration: 1.5s;
		animation-name: fade;
		animation-duration: 1.5s;
	}

	@-webkit-keyframes fade {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	@keyframes fade {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	/* On smaller screens, decrease text size */
	@media only screen and (max-width: 300px) {
		.text {
			font-size: 11px
		}
	}

	/*section 2 css*/

	.slideshow-container1 {
		max-width: 100%;
		position: relative;
		margin: auto;
	}

	/* Next & previous buttons */
	.prev1,
	.next1 {
		margin-left: 100px;
		cursor: pointer;
		position: absolute;
		top: 50%;
		width: auto;
		padding: 16px;
		margin-top: -22px;
		color: black;
		font-weight: bold;
		font-size: 50px;
		transition: 0.6s ease;
		border-radius: 0 3px 3px 0;
		user-select: none;
	}

	/* Position the "next button" to the right */
	.next1 {
		right: 0;
		border-radius: 3px 0 0 3px;
		margin-right: 100px;
	}

	/* On hover, add a black background color with a little bit see-through */
	.prev:hover1,
	.next:hover1 {
		background-color: rgba(0, 0, 0, 0.8);
	}

	/* Caption text */

	.text_section2 {
		width: auto;
		height: auto;
		font-family: comic sans MS;
		color: black;
		font-size: 15px;
		padding: 0px 80px;
		position: absolute;
		bottom: 0px;
		text-align: center;
		font-size: 2.5vw;
		margin-left: 360px;
		margin-bottom: 60px;
	}

	/* Number text (1/3 etc) */
	.numbertext1 {
		color: #f2f2f2;
		font-size: 12px;
		padding: 8px 12px;
		position: absolute;
		top: 0;
	}

	/* The dots/bullets/indicators */
	.dot1 {
		cursor: pointer;
		height: 15px;
		width: 15px;
		margin: 0 2px;
		background-color: #bbb;
		border-radius: 50%;
		display: inline-block;
		transition: background-color 0.6s ease;
	}

	.active1,
	.dot:hover1 {
		background-color: #717171;
	}

	/* Fading animation */
	.fade1 {
		-webkit-animation-name: fade;
		-webkit-animation-duration: 1.5s;
		animation-name: fade;
		animation-duration: 1.5s;
	}

	@-webkit-keyframes fade1 {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	@keyframes fade1 {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	/* On smaller screens, decrease text size */
	@media only screen and (max-width: 300px) {

		.prev,
		.next,
		.text {
			font-size: 11px
		}
	}

	/*section 2 css end*/

	/*section3(1) css*/

	.section3(1) {
		height: 550px;
		width: 100%;
	}

	/*section3(1) css end*/

	.text_fundraiser {
		color: #0077A2;
		font-size: 4vw;
	}

	/*CARDS CSS*/
	.testimotionals {
		width: 20%;
		display: inline-block;
		margin-left: 50px;
		margin-top: 50px margin-left:100px;
	}


	.testimotionals .card {
		position: relative;
		overflow: hidden;
		width: 400%;
		height: 350px;
		margin: 0 auto;
		background: #0077A2;
		padding: 20px;
		text-align: center;
		/*	box-shadow: 0 10px 40px rgba(0, 0, 0, .5)*/
	}

	.testimotionals .card .layer {
		/*z-index: 1;*/
		position: absolute;
		top: calc(100% - 2px);
		height: 100%;
		width: 100%;
		left: 0;
		background: linear-gradient(to left, #7FBD2c, #7FBD2c);
		transition: 0.5s;

	}

	.testimotionals .card .content1 {
		/*	z-index: 2;*/
		position: relative;
	}

	.testimotionals .card:hover .layer {
		top: 0;
	}

	.testimotionals .card .content1 p {
		font-size: 14px;
		line-height: 24px;
		color: #fff;
		margin-top: -3px;

	}

	.testimotionals .card .content1 .image {
		width: 100px;
		height: 100px;
		margin: 0 auto;
		border-radius: 50%;
		overflow: hidden;
		border: 4px solid white;
		box-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);

	}

	.testimotionals .card .conte nt .details h2 {
		font-size: 18px;
		color: white;
	}

	.testimotionals .card .content1 .details h2 span {
		font-size: 18px;
		color: purple;
		transition: 0.5s;
	}

	.testimotionals .card:hover .content1 .details h2 span {
		color: white;
		position: relative;
		margin-top: 7px;
	}

	.para {
		height: 110px;
	}

	.boxed {
		background-color: black;
		width: 100%;
		height: 190px;
		margin-bottom: px;
		margin-top: -8px;
	}

	/*END OF CARDS CSS*/


	/*section4 css*/
	.section4 {
		height: auto;
		width: 100%;
		text-align: center;
		background-color: #0077A2;
	}

	/*end of section4 css*/

	/*section5 css*/

	.fishes {

		position: relative;
		top: -10px;
		left: 0;
		width: 100%;
	}

	/*start of class tag image with text*/
	.tag {

		float: Center;

		position: absolute;

		left: 50px;

		top: 50px;

		background-color: green;

	}

	/*end*/
	.fish {
		position: absolute;
		top: -18px;
		width: 100%;
	}


	.section5 .content {
		position: absolute;
		bottom: 0;
		background: white;
		/* Fallback color */
		/* background: rgba(0, 0, 0, 0.2);*/
		/* Black background with 0.2 opacity */
		color: #f1f1f1;
		width: 100%;
		padding: 60px;
	}
	}

	/*end of section 5 css*/

	/*start of end carousel set 5 images*/
	.slick-slide {
		margin: 0px 20px;
	}

	.slick-slide img {
		width: 100%;
	}

	.slick-slider {
		position: relative;
		display: block;
		box-sizing: border-box;
		-webkit-user-select: none;
		-moz-user-select: none;
		-ms-user-select: none;
		user-select: none;
		-webkit-touch-callout: none;
		-khtml-user-select: none;
		-ms-touch-action: pan-y;
		touch-action: pan-y;
		-webkit-tap-highlight-color: transparent;
	}

	.slick-list {
		position: relative;
		display: block;
		overflow: hidden;
		margin: 0;
		padding: 0;
	}

	.slick-list:focus {
		outline: none;
	}

	.slick-list.dragging {
		cursor: pointer;
		cursor: hand;
	}

	.slick-slider .slick-track,
	.slick-slider .slick-list {
		-webkit-transform: translate3d(0, 0, 0);
		-moz-transform: translate3d(0, 0, 0);
		-ms-transform: translate3d(0, 0, 0);
		-o-transform: translate3d(0, 0, 0);
		transform: translate3d(0, 0, 0);
	}

	.slick-track {
		position: relative;
		top: 0;
		left: 0;
		display: block;
	}

	.slick-track:before,
	.slick-track:after {
		display: table;
		content: '';
	}

	.slick-track:after {
		clear: both;
	}

	.slick-loading .slick-track {
		visibility: hidden;
	}

	.slick-slide {
		display: none;
		float: left;
		height: 100%;
		min-height: 1px;
	}

	[dir='rtl'] .slick-slide {
		float: right;
	}

	.slick-slide img {
		display: block;
	}

	.slick-slide.slick-loading img {
		display: none;
	}

	.slick-slide.dragging img {
		pointer-events: none;
	}

	.slick-initialized .slick-slide {
		display: block;
	}

	.slick-loading .slick-slide {
		visibility: hidden;
	}

	.slick-vertical .slick-slide {
		display: block;
		height: auto;
		border: 1px solid transparent;
	}

	.slick-arrow.slick-hidden {
		display: none;
	}


	/*start of end carousel set 5 images*/


	/*start of submenunavbar*/

	.topnav {
		overflow: hidden;
	}

	.dropdown1 {
		float: left;
		overflow: hidden;
	}

	.dropdown1 .dropbtn1 {
		font-size: 1.2vw;
		border: none;
		outline: none;
		color: white;
		padding: 14px 19px;
		background-color: inherit;
		font-family: inherit;
		margin: 0;
	}


	.dropdown-content1 {
		display: none;
		position: absolute;
		background-color: #f9f9f9;
		min-width: 160px;
		box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
		z-index: 1;
	}

	.dropdown-content1 a {
		float: none;
		color: black;
		padding: 12px 16px;
		text-decoration: none;
		display: block;
		text-align: left;
	}

	.dropdown-content1 a:hover {
		background-color: #ddd;
	}

	.dropdown1:hover .dropdown-content1 {
		display: block;
	}

	/*end of submenunavbar*/

	/*search icon css*/
	#demo-2 input[type=search] {
		width: 15px;
		padding-left: 10px;
		color: transparent;
		cursor: pointer;
	}

	#demo-2 input[type=search]:hover {
		background-color: #fff;
	}

	#demo-2 input[type=search]:focus {
		padding: 10px 30px;
		width: 130px;
		padding-left: 32px;
		color: #000;
		background-color: #fff;
		cursor: auto;
	}

	#demo-2 input:-moz-placeholder {
		color: transparent;
	}

	#demo-2 input::-webkit-input-placeholder {
		color: transparent;
	}

	input {
		outline: none;
	}

	input[type=search] {
		-webkit-appearance: textfield;
		-webkit-box-sizing: content-box;
		font-family: inherit;
		font-size: 100%;
	}

	input::-webkit-search-decoration,
	input::-webkit-search-cancel-button {
		display: none;
	}


	input[type=search] {

		margin-top: 2px;
		background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
		border-bottom: solid 1px #ccc;
		border-top: solid 1px #ccc;
		border-left: solid 1px #ccc;
		border-right: solid 1px #ccc;
		padding: 9px 0px 9px 0px;
		width: 43px;

		-webkit-border-radius: 10em;
		-moz-border-radius: 10em;
		border-radius: 10em;

		-webkit-transition: all .5s;
		-moz-transition: all .5s;
		transition: all .5s;
	}

	input[type=search]:focus {
		padding: 10px 30px;
		width: 6%;
		background-color: #fff;
		border-color: #66CC75;

		-webkit-box-shadow: 0 0 5px rgba(109, 207, 246, .5);
		-moz-box-shadow: 0 0 5px rgba(109, 207, 246, .5);
		box-shadow: 0 0 5px rgba(109, 207, 246, .5);
	}


	input:-moz-placeholder {
		color: #999;
	}

	input::-webkit-input-placeholder {
		color: #999;
	}

	/*code u may delete*/
	a {
		color: white;
		text-decoration: none;
	}

	a:hover {
		color: #7FBD2C;
	}

	h1 {
		font: 1.7em;
		line-height: 110%;
		color: #000;
	}

	p {
		margin: 0 0 20px;
	}

	/*code for footer*/
	.column {
		float: left;
		width: 25%;
		padding: 45px;
		height: auto;
		text-align: justify;
		/* Should be removed. Only for demonstration */
	}
	.row{
		    margin-bottom: -24px;
	}

	/* Clear floats after the columns */
	.row:after {
		content: "";
		display: table;
		clear: both;
	}

	.addressp {
		color: white;
		font-size: 1.2vw;
	}

	/*code for footer ends*/
	#grad2 {
		height: 500px;
		background-color: red;
		/* For browsers that do not support gradients */
		background-image: linear-gradient(to right, #7FBD2C, #0077A2);
		/* Standard syntax (must be last) */
	}

	/*sticked navbar css*/
	/*.content {
  padding: 16px;
}*/

	.sticky {
		position: fixed;
		top:0px;
		width: 100%;
		z-index: 1;
	}

	.sticky+.content {
		padding-top: 60px;
	}

	/*images responsiveness*/
	@media only screen and (max-width:100%) {

		.fishes,
		.fish,
			{
			height: auto;
		}
	}

	@media only screen and (max-width:100%) {

		.community,
		.rural,
		.senior,
		.animals,
		.disability,
		.emergrncies,
		.welfare,
		.development,
		.citizens,
		.animals1,
		.disability1,
		.emergencies1 {
			height: auto;
		}
	}


	@media only screen and (max-width:100%) {

		.trial,
		.trial1,
		.trial2,
		.logoimg,
		.bannerimg,
			{
			height: auto;
		}
	}
	.logoimg{
		    margin-top: 25px;
	}

	/*end of images responsiveness*/
	/*css of liferay code ends*/

	/*code for carousel offffffffffffffffffffffffffffffffffffffff 5 */
	.slick-slide {
    margin: 0px 20px;
}

.slick-slide img {
    width: 70%;
}

.slick-slider
{
    position: relative;

    display: block;
    box-sizing: border-box;

    -webkit-user-select: none;
       -moz-user-select: none;
        -ms-user-select: none;
            user-select: none;

    -webkit-touch-callout: none;
    -khtml-user-select: none;
    -ms-touch-action: pan-y;
        touch-action: pan-y;
    -webkit-tap-highlight-color: transparent;
}

.slick-list
{
    position: relative;

    display: block;
    overflow: hidden;

    margin: 0;
    padding: 0;
}
.slick-list:focus
{
    outline: none;
}
.slick-list.dragging
{
    cursor: pointer;
    cursor: hand;
}

.slick-slider .slick-track,
.slick-slider .slick-list
{
    -webkit-transform: translate3d(0, 0, 0);
       -moz-transform: translate3d(0, 0, 0);
        -ms-transform: translate3d(0, 0, 0);
         -o-transform: translate3d(0, 0, 0);
            transform: translate3d(0, 0, 0);
}

.slick-track
{
    position: relative;
    top: 0;
    left: 0;

    display: block;
}
.slick-track:before,
.slick-track:after
{
    display: table;

    content: '';
}
.slick-track:after
{
    clear: both;
}
.slick-loading .slick-track
{
    visibility: hidden;
}

.slick-slide
{
    display: none;
    float: left;

    height: 100%;
    min-height: 1px;
}
[dir='rtl'] .slick-slide
{
    float: right;
}
.slick-slide img
{
    display: block;
}
.slick-slide.slick-loading img
{
    display: none;
}
.slick-slide.dragging img
{
    pointer-events: none;
}
.slick-initialized .slick-slide
{
    display: block;
}
.slick-loading .slick-slide
{
    visibility: hidden;
}
.slick-vertical .slick-slide
{
    display: block;

    height: auto;

    border: 1px solid transparent;
}
.slick-arrow.slick-hidden {
    display: none;
}

.portlet-decorate .portlet-content{
    background-color: #FFF;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 0px;

}


.portlet-layout .portlet-header {
    margin-bottom: 3rem;
    visibility: hidden;
    margin-top: -47px;
}

.container::after, .row::after {
	content: "";
	clear: both;
	display: table;
}

.remainingDays {
	margin-bottom: -4%;
	margin-top: -4%;
	color: #b91141;
}

.campaignpagelist {
	/* background-image: url("/portal_content/beckgroundimg2.jpg"); */
	background-repeat: no-repeat;
	padding-top: 24px;
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
	
	<!-- ------------------------------------------------------ Final Change Category  -------------------------------------------------------------------- -->

	<%-- <div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">

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
	</div> --%>
	
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

<div class="footer" style="background-color:#002a3a;"><!--start of footer-->
<div class="row">
<div class="column" style="font-size:1.2vw;color:white">
<a href="about_us.html" style="color:white;">About</a><br />
<a href="about_us.html" style="color:white;">Overview</a><br />
<a href="about_us.html" style="color:white;">Team</a><br />
<a href="PrivacyPolicy.html" style="color:white;">Privacy Policy</a><br />
<a href="Disclaimer.html" style="color:white;">Terms &amp; Conditions</a></div>

<div class="column" style="font-size:1.2vw;color:white">
<a href="Security.html" style="color:white;">Security</a><br />
<a href="#" style="color:white;">Fundraising Tips</a><br />
<a href="#" style="color:white;">Pricing</a><br />
<a href="#" style="color:white;">Fundraising FAQ's</a><br />
<a href="#" style="color:white;">Donate Now</a></div>

<div class="column" style="font-size:1.2vw;color:white"><a href="#" style="color:white;">Start a Fundraiser</a><br />
<a href="#" style="color:white;">ADDRESS</a><br />
&nbsp;
<p class="addressp" style="line-height:1px;font-size:1vw;">184 &amp; 185, EPIP Zone,</p>

<p class="addressp" style="line-height:1px;font-size:1vw;">Whitefield, Bengaluru,</p>

<p class="addressp" style="line-height:1px;font-size:1vw;">Karnataka 560066</p>
</div>

<div class="column" style="font-size:1.2vw;color:white"><a href="#" style="color:white;">CONTACT US</a><br />
&nbsp;
<p class="addressp" style="line-height:1px;font-size:1vw;">Phone: 080818 80033</p>

<p class="addressp" style="line-height:1px;font-size:1vw;">quickdaan@gmail.com</p>
</div>
</div>
</div>	
</body></html>

 