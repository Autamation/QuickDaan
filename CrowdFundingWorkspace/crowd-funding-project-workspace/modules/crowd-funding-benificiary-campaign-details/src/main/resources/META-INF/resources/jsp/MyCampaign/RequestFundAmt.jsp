<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DynamicFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundReleaseRegistration"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
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



<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
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
<% List<CategoryRegistration> categoryRegistration = CategoryRegistrationLocalServiceUtil.getCategoryRegistrations(0, CounterLocalServiceUtil.getCountersCount()); %>
<html>
	<body>
	<div class="header">
		<a href="/web/quickdaan-home-page/home"><img src="\portal_content\QuickDaan_Logo.png" class="logoimg" style="width: 50%"></a>
		<div class="topnav" id="navbar">
			<div class="dropdown1"><button class="dropbtn1">Categories <i class="fa fa-caret-down"></i></button>
				
				<div class="dropdown-content1"><a href="#">Community Welfare</a> <a href="#">Rural Development</a> <a href="#">Inclusivity</a> <a href="#">Environmental Sustainability</a> <a href="#">Education</a> <a href="#">Emergencies</a> <a href="#">Medical</a> <a href="#">Animals</a> <a href="#">Children</a> <a href="#">Sports</a> <a href="#">Senior Citizens</a> <a href="#">Women</a> <a href="#">Social Entrepreneurship</a> <a href="#">Others</a></div> 
				<div class="dropdown-content1">
				 <% for(CategoryRegistration categoryDetails : categoryRegistration){
					%>
					<portlet:renderURL var="CategoryURL" windowState="normal">
						<portlet:param name="CategoryId" value="<%= String.valueOf(categoryDetails.getCATEGORY_ID()) %>" />
						<portlet:param name="jspPage"value="/jsp/HomePage/CategoryList.jsp" />
					</portlet:renderURL>
					
					<a href="${CategoryURL}"><%= categoryDetails.getCATEGORY_NAME() %></a>
					
					
					<%	} %>
					</div>
			</div>
			<a href="/web/crowd-funding/fund-raise-request">Start a Fundraisers</a> <a href="#section4">How it works</a> <a href="">Find Fundraisers</a> <a href="/web/crowd-funding/campaigns">Donate now</a>
			<% 
			ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			boolean signedIn = themeDisplayObj.isSignedIn();
			System.out.println("here "+signedIn);
			if(signedIn==false){
			%>
			<a href="/web/customelogin" style="background: #7FBD2C;float:right">LOGIN</a>
			 <a href="/web/customelogin/registration" style="background: #7FBD2C;float:right">SIGNUP</a>
			<%
			}else{
			%>
				<a href="/web/crowd-funding/campaign">My Campaign</a>
				<a href="/c/portal/logout" style="background: #7FBD2C;float:right">LOGOUT</a>
			<%
			}
			%>
			<input type="search" />
		</div>
	</div>


<% 
long ProjectId = Long.parseLong(renderRequest.getParameter("ProjectId"));
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);

float totalDonatedAmt = 0;
float remainingAmt = 0;
float processingFeesAmt = 0;
float paymentChargesAmt = 0;
float projectFeesAmt = 0;
float otherChargesAmt = 0;
float totalAmt = 0;
String categoryName = null;
long currentCategoryId = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
for(FundRegistration fundAmtObj : fundAmtList){
	float donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
	totalDonatedAmt = totalDonatedAmt + donatedAmt;
	remainingAmt = donatedAmt - totalDonatedAmt;
}

List<ProjectFeesRegistration> projectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
if(projectFeesRegistration != null) {
	for(ProjectFeesRegistration feesObj : projectFeesRegistration) {
		if(feesObj.getEND_AMOUNT() == 0) {
			DynamicFeesRegistration dynamicCategoryDetails = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesObj.getCATEGORY_ID());
		
			currentCategoryId = feesObj.getPROJECT_FEES_ID();
			categoryName = dynamicCategoryDetails.getCATEGORY_NAME();
			processingFeesAmt = (dynamicCategoryDetails.getPROCESSING_FEES()*totalDonatedAmt)/100;
			projectFeesAmt = (dynamicCategoryDetails.getPROJECT_FEES()*totalDonatedAmt)/100;
			paymentChargesAmt = (dynamicCategoryDetails.getPAYMENT_GATEWAY_CHARGES()*totalDonatedAmt)/100;
			otherChargesAmt =  (dynamicCategoryDetails.getOTHER_CHARGES()*totalDonatedAmt)/100;
		}
	}
}

List<FundReleaseRegistration> totalFundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
float totalWithdrawAmt = 0; 
for(FundReleaseRegistration fundReleaseObj : totalFundReleaseList){
	totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getTOTAL_WITHDRAW_AMOUNT();
	totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getPROCESSING_FEES() + fundReleaseObj.getPROJECT_FEES() + fundReleaseObj.getPAYMENT_GATEWAY_CHARGES();
}
float remainingtAmt = totalDonatedAmt - totalWithdrawAmt;
totalAmt = totalDonatedAmt - (processingFeesAmt + projectFeesAmt + paymentChargesAmt + otherChargesAmt + totalWithdrawAmt);
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<div class="RequestFundAmt" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;" >
<h1> <center style="color:#0077A2;"><%= projectRegistration.getTITLE() %></center></h1>
<portlet:actionURL name="requestFundWithdraw" var="requestFundWithdrawURL" />

<aui:form action="${requestFundWithdrawURL}" method="post">

<aui:input name="ProjectId" type="hidden" value="<%= projectRegistration.getPROJECT_ID() %>"></aui:input>
<aui:input name="totalAmt" type="hidden" value="<%= totalAmt %>"></aui:input>
<aui:input name="processingFeesAmt" type="hidden" value="<%= processingFeesAmt %>"></aui:input>
<aui:input name="projectFeesAmt" type="hidden" value="<%= projectFeesAmt %>"></aui:input>
<aui:input name="paymentChargesAmt" type="hidden" value="<%= paymentChargesAmt %>"></aui:input>
<aui:input name="currentCategoryId" type="hidden" value="<%= currentCategoryId %>"></aui:input>
	
<div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">
	<div><b><h3 style="font-size: 1.2rem;padding: 2px;color: darkgreen;">Project Details</h3></b><br></div>
	<table cellpadding="15" border="1" style="background-color: #cccccc29; width: 628px;">
		  <tr>
			    <td>Required  Fund Amount :</td>
			    <td><%= String.format("%.0f",projectRegistration.getREQUIRED_FUND_AMOUNT()) %></td>
		  </tr>
		  <tr>
			    <td>Received Fund Amount :</td>
			    <td><%= String.format("%.0f",totalDonatedAmt) %></td>
		  </tr>
		  <tr>
			    <td>Pre withdrawan Amount :</td>
			    <td><%= String.format("%.0f",totalWithdrawAmt)  %></td>
		  </tr>
		  <tr>
			    <td>Remaining Amount :</td>
			    <td><%= String.format("%.0f",remainingtAmt)  %></td>
		  </tr>
		 
	</table>
</div>
		
		<div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">
	
			<div><b><h3 style="font-size: 1.2rem;padding: 2px;color: darkgreen;">Received Amount from Donor</h3></b><br></div>
			
				<%
				float totalCategoryAmtReceive = 0;
				float processingFees = 0;
				float projectFees = 0;
				float paymentGatewayCharges = 0;
				float totalReceivedAmt = 0;
				
				List<DynamicFeesRegistration> dynamicCategoryList = DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrations(0, DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrationsCount());
				for(DynamicFeesRegistration dynamicCategoryDataObj : dynamicCategoryList){
					List<FundRegistration> fundRegistrationCategoryList = FundRegistrationLocalServiceUtil.findByDYNAMIC_PROJECT_CATEGORY_ID(projectRegistration.getPROJECT_ID(), dynamicCategoryDataObj.getCATEGORY_ID());
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
				List<FundReleaseRegistration> fundReleaseRegistrationList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
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
	
	<%
	if(projectRegistration.getREQUEST_STATUS() != CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2){
		if(totalDonatedAmt <= projectRegistration.getREQUIRED_FUND_AMOUNT()){ %>
			<div>
				<aui:input name="btn" label="Continue Campaign and Request Fund Withdraw" type="radio" value="continue" ></aui:input>
				<aui:input name="btn" label="Stop Capaign and Request Fund Withdraw" type="radio" value="stop" ></aui:input>
				<aui:input name="btn" label="Stop Capaign without withdraw Fund" type="radio" value="delete" ></aui:input><br>
			</div>
		<%}%>
	   <aui:button type="submit" value="Request for Withdraw" style="border-radius:22px;background-color:#0077A2;color:white;margin-left: 205px;"/>
	<%} %>
	<aui:button type="cancel" value="cancel" style="border-radius:22px;" onClick="window.history.back();" />
 </aui:form>
 </div>
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