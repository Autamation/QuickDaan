package org.apache.jsp.jsp.FundRequestWithdraw;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.portal.kernel.util.Validator;
import com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.FundReleaseRegistration;
import com.crowd.funding.database.model.DynamicFeesRegistration;
import com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.ProjectFeesRegistration;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundAccountRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.CommentRegistration;
import com.crowd.funding.database.model.FundAccountRegistration;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.FundRegistration;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService;
import com.crowd.funding.database.model.ProjectPriorityRegistration;
import java.util.Collections;
import com.liferay.portal.kernel.util.ListUtil;
import java.util.List;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.ProjectRegistration;

public final class AdminReleaseCampaignDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(7);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/META-INF/c.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet_2_0.tld");
    _jspx_dependants.add("/META-INF/liferay-aui.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet-ext.tld");
    _jspx_dependants.add("/META-INF/liferay-theme.tld");
    _jspx_dependants.add("/META-INF/liferay-ui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_type_style_onClick_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_portlet_actionURL_var_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_type_style_onClick_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_portlet_actionURL_var_name.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_aui_button_value_type_style_onClick_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      //  liferay-theme:defineObjects
      com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_0 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
      _jspx_th_liferay$1theme_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1theme_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1theme_defineObjects_0 = _jspx_th_liferay$1theme_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1theme_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_0);
        return;
      }
      _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_0);
      com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay = null;
      com.liferay.portal.kernel.model.Company company = null;
      com.liferay.portal.kernel.model.Account account = null;
      com.liferay.portal.kernel.model.User user = null;
      com.liferay.portal.kernel.model.User realUser = null;
      com.liferay.portal.kernel.model.Contact contact = null;
      com.liferay.portal.kernel.model.Layout layout = null;
      java.util.List layouts = null;
      java.lang.Long plid = null;
      com.liferay.portal.kernel.model.LayoutTypePortlet layoutTypePortlet = null;
      java.lang.Long scopeGroupId = null;
      com.liferay.portal.kernel.security.permission.PermissionChecker permissionChecker = null;
      java.util.Locale locale = null;
      java.util.TimeZone timeZone = null;
      com.liferay.portal.kernel.model.Theme theme = null;
      com.liferay.portal.kernel.model.ColorScheme colorScheme = null;
      com.liferay.portal.kernel.theme.PortletDisplay portletDisplay = null;
      java.lang.Long portletGroupId = null;
      themeDisplay = (com.liferay.portal.kernel.theme.ThemeDisplay) _jspx_page_context.findAttribute("themeDisplay");
      company = (com.liferay.portal.kernel.model.Company) _jspx_page_context.findAttribute("company");
      account = (com.liferay.portal.kernel.model.Account) _jspx_page_context.findAttribute("account");
      user = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("user");
      realUser = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("realUser");
      contact = (com.liferay.portal.kernel.model.Contact) _jspx_page_context.findAttribute("contact");
      layout = (com.liferay.portal.kernel.model.Layout) _jspx_page_context.findAttribute("layout");
      layouts = (java.util.List) _jspx_page_context.findAttribute("layouts");
      plid = (java.lang.Long) _jspx_page_context.findAttribute("plid");
      layoutTypePortlet = (com.liferay.portal.kernel.model.LayoutTypePortlet) _jspx_page_context.findAttribute("layoutTypePortlet");
      scopeGroupId = (java.lang.Long) _jspx_page_context.findAttribute("scopeGroupId");
      permissionChecker = (com.liferay.portal.kernel.security.permission.PermissionChecker) _jspx_page_context.findAttribute("permissionChecker");
      locale = (java.util.Locale) _jspx_page_context.findAttribute("locale");
      timeZone = (java.util.TimeZone) _jspx_page_context.findAttribute("timeZone");
      theme = (com.liferay.portal.kernel.model.Theme) _jspx_page_context.findAttribute("theme");
      colorScheme = (com.liferay.portal.kernel.model.ColorScheme) _jspx_page_context.findAttribute("colorScheme");
      portletDisplay = (com.liferay.portal.kernel.theme.PortletDisplay) _jspx_page_context.findAttribute("portletDisplay");
      portletGroupId = (java.lang.Long) _jspx_page_context.findAttribute("portletGroupId");
      out.write("\r\n");
      out.write("\r\n");
      //  portlet:defineObjects
      com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_0 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
      _jspx_th_portlet_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_defineObjects_0.setParent(null);
      int _jspx_eval_portlet_defineObjects_0 = _jspx_th_portlet_defineObjects_0.doStartTag();
      if (_jspx_th_portlet_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_0);
        return;
      }
      _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_0);
      javax.portlet.ActionRequest actionRequest = null;
      javax.portlet.ActionResponse actionResponse = null;
      javax.portlet.EventRequest eventRequest = null;
      javax.portlet.EventResponse eventResponse = null;
      com.liferay.portal.kernel.portlet.LiferayPortletRequest liferayPortletRequest = null;
      com.liferay.portal.kernel.portlet.LiferayPortletResponse liferayPortletResponse = null;
      javax.portlet.PortletConfig portletConfig = null;
      java.lang.String portletName = null;
      javax.portlet.PortletPreferences portletPreferences = null;
      java.util.Map portletPreferencesValues = null;
      javax.portlet.PortletSession portletSession = null;
      java.util.Map portletSessionScope = null;
      javax.portlet.RenderRequest renderRequest = null;
      javax.portlet.RenderResponse renderResponse = null;
      javax.portlet.ResourceRequest resourceRequest = null;
      javax.portlet.ResourceResponse resourceResponse = null;
      actionRequest = (javax.portlet.ActionRequest) _jspx_page_context.findAttribute("actionRequest");
      actionResponse = (javax.portlet.ActionResponse) _jspx_page_context.findAttribute("actionResponse");
      eventRequest = (javax.portlet.EventRequest) _jspx_page_context.findAttribute("eventRequest");
      eventResponse = (javax.portlet.EventResponse) _jspx_page_context.findAttribute("eventResponse");
      liferayPortletRequest = (com.liferay.portal.kernel.portlet.LiferayPortletRequest) _jspx_page_context.findAttribute("liferayPortletRequest");
      liferayPortletResponse = (com.liferay.portal.kernel.portlet.LiferayPortletResponse) _jspx_page_context.findAttribute("liferayPortletResponse");
      portletConfig = (javax.portlet.PortletConfig) _jspx_page_context.findAttribute("portletConfig");
      portletName = (java.lang.String) _jspx_page_context.findAttribute("portletName");
      portletPreferences = (javax.portlet.PortletPreferences) _jspx_page_context.findAttribute("portletPreferences");
      portletPreferencesValues = (java.util.Map) _jspx_page_context.findAttribute("portletPreferencesValues");
      portletSession = (javax.portlet.PortletSession) _jspx_page_context.findAttribute("portletSession");
      portletSessionScope = (java.util.Map) _jspx_page_context.findAttribute("portletSessionScope");
      renderRequest = (javax.portlet.RenderRequest) _jspx_page_context.findAttribute("renderRequest");
      renderResponse = (javax.portlet.RenderResponse) _jspx_page_context.findAttribute("renderResponse");
      resourceRequest = (javax.portlet.ResourceRequest) _jspx_page_context.findAttribute("resourceRequest");
      resourceResponse = (javax.portlet.ResourceResponse) _jspx_page_context.findAttribute("resourceResponse");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      //  liferay-theme:defineObjects
      com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_1 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
      _jspx_th_liferay$1theme_defineObjects_1.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1theme_defineObjects_1.setParent(null);
      int _jspx_eval_liferay$1theme_defineObjects_1 = _jspx_th_liferay$1theme_defineObjects_1.doStartTag();
      if (_jspx_th_liferay$1theme_defineObjects_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_1);
        return;
      }
      _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_1);
      themeDisplay = (com.liferay.portal.kernel.theme.ThemeDisplay) _jspx_page_context.findAttribute("themeDisplay");
      company = (com.liferay.portal.kernel.model.Company) _jspx_page_context.findAttribute("company");
      account = (com.liferay.portal.kernel.model.Account) _jspx_page_context.findAttribute("account");
      user = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("user");
      realUser = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("realUser");
      contact = (com.liferay.portal.kernel.model.Contact) _jspx_page_context.findAttribute("contact");
      layout = (com.liferay.portal.kernel.model.Layout) _jspx_page_context.findAttribute("layout");
      layouts = (java.util.List) _jspx_page_context.findAttribute("layouts");
      plid = (java.lang.Long) _jspx_page_context.findAttribute("plid");
      layoutTypePortlet = (com.liferay.portal.kernel.model.LayoutTypePortlet) _jspx_page_context.findAttribute("layoutTypePortlet");
      scopeGroupId = (java.lang.Long) _jspx_page_context.findAttribute("scopeGroupId");
      permissionChecker = (com.liferay.portal.kernel.security.permission.PermissionChecker) _jspx_page_context.findAttribute("permissionChecker");
      locale = (java.util.Locale) _jspx_page_context.findAttribute("locale");
      timeZone = (java.util.TimeZone) _jspx_page_context.findAttribute("timeZone");
      theme = (com.liferay.portal.kernel.model.Theme) _jspx_page_context.findAttribute("theme");
      colorScheme = (com.liferay.portal.kernel.model.ColorScheme) _jspx_page_context.findAttribute("colorScheme");
      portletDisplay = (com.liferay.portal.kernel.theme.PortletDisplay) _jspx_page_context.findAttribute("portletDisplay");
      portletGroupId = (java.lang.Long) _jspx_page_context.findAttribute("portletGroupId");
      out.write("\r\n");
      out.write("\r\n");
      //  portlet:defineObjects
      com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_1 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
      _jspx_th_portlet_defineObjects_1.setPageContext(_jspx_page_context);
      _jspx_th_portlet_defineObjects_1.setParent(null);
      int _jspx_eval_portlet_defineObjects_1 = _jspx_th_portlet_defineObjects_1.doStartTag();
      if (_jspx_th_portlet_defineObjects_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_1);
        return;
      }
      _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_1);
      actionRequest = (javax.portlet.ActionRequest) _jspx_page_context.findAttribute("actionRequest");
      actionResponse = (javax.portlet.ActionResponse) _jspx_page_context.findAttribute("actionResponse");
      eventRequest = (javax.portlet.EventRequest) _jspx_page_context.findAttribute("eventRequest");
      eventResponse = (javax.portlet.EventResponse) _jspx_page_context.findAttribute("eventResponse");
      liferayPortletRequest = (com.liferay.portal.kernel.portlet.LiferayPortletRequest) _jspx_page_context.findAttribute("liferayPortletRequest");
      liferayPortletResponse = (com.liferay.portal.kernel.portlet.LiferayPortletResponse) _jspx_page_context.findAttribute("liferayPortletResponse");
      portletConfig = (javax.portlet.PortletConfig) _jspx_page_context.findAttribute("portletConfig");
      portletName = (java.lang.String) _jspx_page_context.findAttribute("portletName");
      portletPreferences = (javax.portlet.PortletPreferences) _jspx_page_context.findAttribute("portletPreferences");
      portletPreferencesValues = (java.util.Map) _jspx_page_context.findAttribute("portletPreferencesValues");
      portletSession = (javax.portlet.PortletSession) _jspx_page_context.findAttribute("portletSession");
      portletSessionScope = (java.util.Map) _jspx_page_context.findAttribute("portletSessionScope");
      renderRequest = (javax.portlet.RenderRequest) _jspx_page_context.findAttribute("renderRequest");
      renderResponse = (javax.portlet.RenderResponse) _jspx_page_context.findAttribute("renderResponse");
      resourceRequest = (javax.portlet.ResourceRequest) _jspx_page_context.findAttribute("resourceRequest");
      resourceResponse = (javax.portlet.ResourceResponse) _jspx_page_context.findAttribute("resourceResponse");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
String projectID = renderRequest.getParameter("ProjectId");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

float totalDonatedAmt = 0;
float remainingAmt = 0;
long fundReleaseID = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
for(FundRegistration fundAmtObj : fundAmtList){
	float donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
	totalDonatedAmt = totalDonatedAmt + donatedAmt;
}

List<FundReleaseRegistration> totalFundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
float totalWithdrawAmt = 0; 
for(FundReleaseRegistration fundReleaseObj : totalFundReleaseList){
	if(Validator.isNull(fundReleaseObj.getRELEASE_DATE()) == false){
		totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getTOTAL_WITHDRAW_AMOUNT();
		totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getPROCESSING_FEES() + fundReleaseObj.getPROJECT_FEES() + fundReleaseObj.getPAYMENT_GATEWAY_CHARGES();
	}
	if(Validator.isNull(fundReleaseObj.getRELEASE_DATE()) == true){
		fundReleaseID = fundReleaseObj.getFUND_RELEASE_ID();
	}
}

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date currentDate = new Date();


      out.write("\r\n");
      out.write("\r\n");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_0.setParent(null);
      _jspx_th_portlet_actionURL_0.setName("approveFundRequestWithdraw");
      _jspx_th_portlet_actionURL_0.setVar("approveFundRequestWithdrawURL");
      int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
      if (_jspx_eval_portlet_actionURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_0 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_0.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
        _jspx_th_portlet_param_0.setName("ProjectId");
        _jspx_th_portlet_param_0.setValue(String.valueOf(projectRegistration.getPROJECT_ID()) );
        int _jspx_eval_portlet_param_0 = _jspx_th_portlet_param_0.doStartTag();
        if (_jspx_th_portlet_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
        out.write("\r\n");
        out.write("\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_1 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_1.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
        _jspx_th_portlet_param_1.setName("fundReleaseID");
        _jspx_th_portlet_param_1.setValue(String.valueOf(fundReleaseID) );
        int _jspx_eval_portlet_param_1 = _jspx_th_portlet_param_1.doStartTag();
        if (_jspx_th_portlet_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
        out.write('\r');
        out.write('\n');
      }
      if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
      java.lang.String approveFundRequestWithdrawURL = null;
      approveFundRequestWithdrawURL = (java.lang.String) _jspx_page_context.findAttribute("approveFundRequestWithdrawURL");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<h1><center> ");
      out.print( projectRegistration.getTITLE() );
      out.write("</center></h1>\r\n");
      out.write("\t<br><br>\r\n");
      out.write(" \r\n");
      out.write("<h1>Project Details</h1>\r\n");
      out.write("<table cellpadding=\"15\" border=\"1\" style=\"color: darkgreen; background-color: #cccccc29; width: 628px;\">\r\n");
      out.write("\t\t\t");

			remainingAmt = totalDonatedAmt - totalWithdrawAmt;
			
      out.write("\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td>Required  Fund Amount :</td>\r\n");
      out.write("\t\t    <td>");
      out.print( String.format("%.0f",projectRegistration.getREQUIRED_FUND_AMOUNT()) );
      out.write("</td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td>Received Fund Amount :</td>\r\n");
      out.write("\t\t    <td>");
      out.print( totalDonatedAmt );
      out.write("</td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td>Pre withdrawan Amount :</td>\r\n");
      out.write("\t\t    <td>");
      out.print( totalWithdrawAmt );
      out.write("</td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t    <td>Remaining Amount :</td>\r\n");
      out.write("\t\t    <td>");
      out.print( remainingAmt );
      out.write("</td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<h2 style=\"color: brown;\">Received Amount from Donor </h2>\r\n");
      out.write("\t\t\t");

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
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<table cellpadding=\"15\" border=\"1\" style=\"color: darkgreen; background-color: #cccccc29; width: 628px;\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Category Name</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>Received Amount</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>Processing Fees(");
      out.print( dynamicCategoryDataObj.getPROCESSING_FEES() );
      out.write(")%</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>Project Fees(");
      out.print( dynamicCategoryDataObj.getPROJECT_FEES() );
      out.write(")%</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>Payment Getway Charges(");
      out.print( dynamicCategoryDataObj.getPAYMENT_GATEWAY_CHARGES() );
      out.write(")%</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>Total Received Fund Amount(including All charges)</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( dynamicCategoryDataObj.getCATEGORY_NAME() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(totalCategoryAmtReceive) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(processingFees) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(projectFees) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(paymentGatewayCharges) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(totalReceivedAmt) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t </tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t");

					totalCategoryAmtReceive = 0;
					processingFees = 0;
					projectFees = 0;
					paymentGatewayCharges = 0;
					totalReceivedAmt = 0;
				}
				
			
      out.write("\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t \t<h2 style=\"color: brown;\">Release Fund Details</h1>\r\n");
      out.write("\t\t");

		List<FundReleaseRegistration> fundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
		for(FundReleaseRegistration fundReleaseRegistration : fundReleaseList){
			
			ProjectFeesRegistration projectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_FEES_ID(fundReleaseRegistration.getPROJECT_FEES_ID()); 
			DynamicFeesRegistration dynamicFeesRegistration = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(projectFeesRegistration.getCATEGORY_ID());
			
			float totalRequestedAmt = fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT() + fundReleaseRegistration.getPROCESSING_FEES() + fundReleaseRegistration.getPROJECT_FEES() + fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES();
			if( Validator.isNull(fundReleaseRegistration.getRELEASE_DATE()) == false){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<table cellpadding=\"15\" border=\"1\" style=\"color: darkgreen; background-color: #cccccc29; width: 628px;\">\r\n");
      out.write("\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Release Date :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( formatter.format(fundReleaseRegistration.getRELEASE_DATE()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t  \t<td>Requested Withdraw Amount : </td>\r\n");
      out.write("\t\t\t\t\t\t  \t<td>");
      out.print( Math.floor(totalRequestedAmt) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Processing Fees :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(fundReleaseRegistration.getPROCESSING_FEES()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t </tr>\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Project Fees :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(fundReleaseRegistration.getPROJECT_FEES()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t   <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Payment Getway Charges :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t   <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Total Fund Realase Amount(including All charges) :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t");

			}
			if(Validator.isNull(fundReleaseRegistration.getRELEASE_DATE()) == true){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<h1>Requested Fund Withdraw Amount </h1>\r\n");
      out.write("\t\t\t\t\t<table cellpadding=\"15\" border=\"1\" style=\"color: tomato; background-color: #cccccc29; width: 628px;\">\r\n");
      out.write("\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Requested Date :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( formatter.format(fundReleaseRegistration.getREQUEST_DATE()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t  \t<td>Requested Withdraw Amount : </td>\r\n");
      out.write("\t\t\t\t\t\t  \t<td>");
      out.print( Math.floor(totalRequestedAmt) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Processing Fees :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(fundReleaseRegistration.getPROCESSING_FEES()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t </tr>\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Project Fees :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(fundReleaseRegistration.getPROJECT_FEES()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t   <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Payment Getway Charges :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t\t   <tr>\r\n");
      out.write("\t\t\t\t\t\t    <td>Total Fund Realase Amount(including All charges) :</td>\r\n");
      out.write("\t\t\t\t\t\t    <td>");
      out.print( Math.floor(fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t");

			}
		}
		
      out.write("\r\n");
      out.write("<br>   \r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      if (_jspx_meth_aui_button_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</center>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_aui_button_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_style_onClick_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_0.setParent(null);
    _jspx_th_aui_button_0.setType("cancel");
    _jspx_th_aui_button_0.setValue("cancel");
    _jspx_th_aui_button_0.setOnClick("window.history.back();");
    _jspx_th_aui_button_0.setDynamicAttribute(null, "style", new String("border-radius:22px;"));
    int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
    if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_style_onClick_nobody.reuse(_jspx_th_aui_button_0);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_style_onClick_nobody.reuse(_jspx_th_aui_button_0);
    return false;
  }
}
