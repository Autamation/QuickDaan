package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.configuration.admin.category.ConfigurationCategory;
import com.liferay.configuration.admin.display.ConfigurationFormRenderer;
import com.liferay.configuration.admin.display.ConfigurationScreen;
import com.liferay.configuration.admin.web.internal.constants.ConfigurationAdminWebKeys;
import com.liferay.configuration.admin.web.internal.display.ConfigurationCategoryDisplay;
import com.liferay.configuration.admin.web.internal.display.ConfigurationCategoryMenuDisplay;
import com.liferay.configuration.admin.web.internal.display.ConfigurationCategorySectionDisplay;
import com.liferay.configuration.admin.web.internal.display.ConfigurationEntry;
import com.liferay.configuration.admin.web.internal.display.ConfigurationScopeDisplay;
import com.liferay.configuration.admin.web.internal.model.ConfigurationModel;
import com.liferay.configuration.admin.web.internal.util.ConfigurationCategoryUtil;
import com.liferay.configuration.admin.web.internal.util.ConfigurationEntryRetriever;
import com.liferay.configuration.admin.web.internal.util.ConfigurationModelIterator;
import com.liferay.configuration.admin.web.internal.util.ResourceBundleLoaderProvider;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.persistence.listener.ConfigurationModelListenerException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.servlet.PipingServletResponse;
import java.util.List;
import java.util.ResourceBundle;
import javax.portlet.PortletURL;
import org.osgi.service.metatype.AttributeDefinition;

public final class view_005ffactory_005finstances_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/init.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_breadcrumb_showParentGroups_showLayout_showGuestGroup_showCurrentGroup_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container_total_iteratorURL_emptyResultsMessage;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_a_href;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_className;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_renderURL_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_resourceURL_var_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1iterator_searchResultCssClass_markupView_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1util_include_servletContext_page_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass_align;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_portlet_actionURL_var_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_breadcrumb_showParentGroups_showLayout_showGuestGroup_showCurrentGroup_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container_total_iteratorURL_emptyResultsMessage = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_a_href = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_className = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_renderURL_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_resourceURL_var_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1iterator_searchResultCssClass_markupView_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1util_include_servletContext_page_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass_align = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_portlet_actionURL_var_name.release();
    _jspx_tagPool_liferay$1ui_breadcrumb_showParentGroups_showLayout_showGuestGroup_showCurrentGroup_nobody.release();
    _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction_cssClass.release();
    _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1container_total_iteratorURL_emptyResultsMessage.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.release();
    _jspx_tagPool_aui_a_href.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody.release();
    _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction.release();
    _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_className.release();
    _jspx_tagPool_portlet_renderURL_var.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_portlet_resourceURL_var_id.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1iterator_searchResultCssClass_markupView_nobody.release();
    _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.release();
    _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass_align.release();
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      //  liferay-frontend:defineObjects
      com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag _jspx_th_liferay$1frontend_defineObjects_0 = (com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag) _jspx_tagPool_liferay$1frontend_defineObjects_nobody.get(com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag.class);
      _jspx_th_liferay$1frontend_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1frontend_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1frontend_defineObjects_0 = _jspx_th_liferay$1frontend_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1frontend_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1frontend_defineObjects_nobody.reuse(_jspx_th_liferay$1frontend_defineObjects_0);
        return;
      }
      _jspx_tagPool_liferay$1frontend_defineObjects_nobody.reuse(_jspx_th_liferay$1frontend_defineObjects_0);
      java.lang.String currentURL = null;
      javax.portlet.PortletURL currentURLObj = null;
      java.util.ResourceBundle resourceBundle = null;
      javax.portlet.WindowState windowState = null;
      currentURL = (java.lang.String) _jspx_page_context.findAttribute("currentURL");
      currentURLObj = (javax.portlet.PortletURL) _jspx_page_context.findAttribute("currentURLObj");
      resourceBundle = (java.util.ResourceBundle) _jspx_page_context.findAttribute("resourceBundle");
      windowState = (javax.portlet.WindowState) _jspx_page_context.findAttribute("windowState");
      out.write('\n');
      out.write('\n');
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
      out.write('\n');
      out.write('\n');
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
      out.write('\n');
      out.write('\n');

String redirect = ParamUtil.getString(request, "redirect", String.valueOf(renderResponse.createRenderURL()));

ConfigurationModel configurationModel = (ConfigurationModel)request.getAttribute(ConfigurationAdminWebKeys.FACTORY_CONFIGURATION_MODEL);
ConfigurationModelIterator configurationModelIterator = (ConfigurationModelIterator)request.getAttribute(ConfigurationAdminWebKeys.CONFIGURATION_MODEL_ITERATOR);

PortalUtil.addPortletBreadcrumbEntry(request, portletDisplay.getPortletDisplayName(), String.valueOf(renderResponse.createRenderURL()));

ConfigurationCategoryMenuDisplay configurationCategoryMenuDisplay = (ConfigurationCategoryMenuDisplay)request.getAttribute(ConfigurationAdminWebKeys.CONFIGURATION_CATEGORY_MENU_DISPLAY);

ConfigurationCategoryDisplay configurationCategoryDisplay = configurationCategoryMenuDisplay.getConfigurationCategoryDisplay();

String categoryDisplayName = HtmlUtil.escape(configurationCategoryDisplay.getCategoryLabel(locale));

String viewCategoryHREF = ConfigurationCategoryUtil.getHREF(configurationCategoryMenuDisplay, liferayPortletResponse, renderRequest, renderResponse);

PortalUtil.addPortletBreadcrumbEntry(request, categoryDisplayName, viewCategoryHREF);

ResourceBundleLoaderProvider resourceBundleLoaderProvider = (ResourceBundleLoaderProvider)request.getAttribute(ConfigurationAdminWebKeys.RESOURCE_BUNDLE_LOADER_PROVIDER);

ResourceBundleLoader resourceBundleLoader = resourceBundleLoaderProvider.getResourceBundleLoader(configurationModel.getBundleSymbolicName());

ResourceBundle componentResourceBundle = resourceBundleLoader.loadResourceBundle(PortalUtil.getLocale(request));

String factoryConfigurationModelName = (componentResourceBundle != null) ? LanguageUtil.get(componentResourceBundle, configurationModel.getName()) : configurationModel.getName();

PortalUtil.addPortletBreadcrumbEntry(request, factoryConfigurationModelName, null);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(categoryDisplayName);

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container-fluid container-fluid-max-xl\">\n");
      out.write("\t<div class=\"col-12\">\n");
      out.write("\t\t");
      //  liferay-ui:breadcrumb
      com.liferay.taglib.ui.BreadcrumbTag _jspx_th_liferay$1ui_breadcrumb_0 = (com.liferay.taglib.ui.BreadcrumbTag) _jspx_tagPool_liferay$1ui_breadcrumb_showParentGroups_showLayout_showGuestGroup_showCurrentGroup_nobody.get(com.liferay.taglib.ui.BreadcrumbTag.class);
      _jspx_th_liferay$1ui_breadcrumb_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1ui_breadcrumb_0.setParent(null);
      _jspx_th_liferay$1ui_breadcrumb_0.setShowCurrentGroup( false );
      _jspx_th_liferay$1ui_breadcrumb_0.setShowGuestGroup( false );
      _jspx_th_liferay$1ui_breadcrumb_0.setShowLayout( false );
      _jspx_th_liferay$1ui_breadcrumb_0.setShowParentGroups( false );
      int _jspx_eval_liferay$1ui_breadcrumb_0 = _jspx_th_liferay$1ui_breadcrumb_0.doStartTag();
      if (_jspx_th_liferay$1ui_breadcrumb_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1ui_breadcrumb_showParentGroups_showLayout_showGuestGroup_showCurrentGroup_nobody.reuse(_jspx_th_liferay$1ui_breadcrumb_0);
        return;
      }
      _jspx_tagPool_liferay$1ui_breadcrumb_showParentGroups_showLayout_showGuestGroup_showCurrentGroup_nobody.reuse(_jspx_th_liferay$1ui_breadcrumb_0);
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"container-fluid container-fluid-max-xl\">\n");
      out.write("\t<div class=\"row\">\n");
      out.write("\t\t<div class=\"col-md-3\">\n");
      out.write("\t\t\t");
      //  liferay-util:include
      com.liferay.taglib.util.IncludeTag _jspx_th_liferay$1util_include_0 = (com.liferay.taglib.util.IncludeTag) _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.get(com.liferay.taglib.util.IncludeTag.class);
      _jspx_th_liferay$1util_include_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1util_include_0.setParent(null);
      _jspx_th_liferay$1util_include_0.setPage("/configuration_category_menu.jsp");
      _jspx_th_liferay$1util_include_0.setServletContext( application );
      int _jspx_eval_liferay$1util_include_0 = _jspx_th_liferay$1util_include_0.doStartTag();
      if (_jspx_th_liferay$1util_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.reuse(_jspx_th_liferay$1util_include_0);
        return;
      }
      _jspx_tagPool_liferay$1util_include_servletContext_page_nobody.reuse(_jspx_th_liferay$1util_include_0);
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"col-md-9\">\n");
      out.write("\t\t\t<div class=\"sheet sheet-lg\">\n");
      out.write("\t\t\t\t<div class=\"autofit-row\">\n");
      out.write("\t\t\t\t\t<div class=\"autofit-col\">\n");
      out.write("\t\t\t\t\t\t<h2>");
      out.print( factoryConfigurationModelName );
      out.write("</h2>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t");
if (
 configurationModelIterator.getTotal() > 0 ) {
      out.write("\n");
      out.write("\t\t\t\t\t\t<div class=\"autofit-col\">\n");
      out.write("\t\t\t\t\t\t\t");
      //  liferay-ui:icon-menu
      com.liferay.taglib.ui.IconMenuTag _jspx_th_liferay$1ui_icon$1menu_0 = (com.liferay.taglib.ui.IconMenuTag) _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction_cssClass.get(com.liferay.taglib.ui.IconMenuTag.class);
      _jspx_th_liferay$1ui_icon$1menu_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1ui_icon$1menu_0.setParent(null);
      _jspx_th_liferay$1ui_icon$1menu_0.setCssClass("float-right");
      _jspx_th_liferay$1ui_icon$1menu_0.setDirection("right");
      _jspx_th_liferay$1ui_icon$1menu_0.setMarkupView("lexicon");
      _jspx_th_liferay$1ui_icon$1menu_0.setShowWhenSingleIcon( true );
      int _jspx_eval_liferay$1ui_icon$1menu_0 = _jspx_th_liferay$1ui_icon$1menu_0.doStartTag();
      if (_jspx_eval_liferay$1ui_icon$1menu_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_liferay$1ui_icon$1menu_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_liferay$1ui_icon$1menu_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_liferay$1ui_icon$1menu_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t\t\t");
          //  portlet:resourceURL
          com.liferay.taglib.portlet.ResourceURLTag _jspx_th_portlet_resourceURL_0 = (com.liferay.taglib.portlet.ResourceURLTag) _jspx_tagPool_portlet_resourceURL_var_id.get(com.liferay.taglib.portlet.ResourceURLTag.class);
          _jspx_th_portlet_resourceURL_0.setPageContext(_jspx_page_context);
          _jspx_th_portlet_resourceURL_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_0);
          _jspx_th_portlet_resourceURL_0.setId("export");
          _jspx_th_portlet_resourceURL_0.setVar("exportEntriesURL");
          int _jspx_eval_portlet_resourceURL_0 = _jspx_th_portlet_resourceURL_0.doStartTag();
          if (_jspx_eval_portlet_resourceURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t");
            //  portlet:param
            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_0 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
            _jspx_th_portlet_param_0.setPageContext(_jspx_page_context);
            _jspx_th_portlet_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_0);
            _jspx_th_portlet_param_0.setName("redirect");
            _jspx_th_portlet_param_0.setValue( currentURL );
            int _jspx_eval_portlet_param_0 = _jspx_th_portlet_param_0.doStartTag();
            if (_jspx_th_portlet_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
              return;
            }
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t");
            //  portlet:param
            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_1 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
            _jspx_th_portlet_param_1.setPageContext(_jspx_page_context);
            _jspx_th_portlet_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_0);
            _jspx_th_portlet_param_1.setName("factoryPid");
            _jspx_th_portlet_param_1.setValue( configurationModel.getFactoryPid() );
            int _jspx_eval_portlet_param_1 = _jspx_th_portlet_param_1.doStartTag();
            if (_jspx_th_portlet_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
              return;
            }
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t");
          }
          if (_jspx_th_portlet_resourceURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_resourceURL_var_id.reuse(_jspx_th_portlet_resourceURL_0);
            return;
          }
          _jspx_tagPool_portlet_resourceURL_var_id.reuse(_jspx_th_portlet_resourceURL_0);
          java.lang.String exportEntriesURL = null;
          exportEntriesURL = (java.lang.String) _jspx_page_context.findAttribute("exportEntriesURL");
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t\t\t\t\t");
          //  liferay-ui:icon
          com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_0 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.get(com.liferay.taglib.ui.IconTag.class);
          _jspx_th_liferay$1ui_icon_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_icon_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_0);
          _jspx_th_liferay$1ui_icon_0.setMessage("export-entries");
          _jspx_th_liferay$1ui_icon_0.setMethod("get");
          _jspx_th_liferay$1ui_icon_0.setUrl( exportEntriesURL );
          int _jspx_eval_liferay$1ui_icon_0 = _jspx_th_liferay$1ui_icon_0.doStartTag();
          if (_jspx_th_liferay$1ui_icon_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.reuse(_jspx_th_liferay$1ui_icon_0);
            return;
          }
          _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.reuse(_jspx_th_liferay$1ui_icon_0);
          out.write("\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_liferay$1ui_icon$1menu_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_liferay$1ui_icon$1menu_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_liferay$1ui_icon$1menu_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction_cssClass.reuse(_jspx_th_liferay$1ui_icon$1menu_0);
        return;
      }
      _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction_cssClass.reuse(_jspx_th_liferay$1ui_icon$1menu_0);
      out.write("\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t");
}
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t<h3 class=\"autofit-row sheet-subtitle\">\n");
      out.write("\t\t\t\t\t<span class=\"autofit-col autofit-col-expand\">\n");
      out.write("\t\t\t\t\t\t<span class=\"heading-text\">\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_liferay$1ui_message_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t<span class=\"autofit-col\">\n");
      out.write("\t\t\t\t\t\t<span class=\"heading-end\">\n");
      out.write("\t\t\t\t\t\t\t");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_0 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_0.setParent(null);
      _jspx_th_portlet_renderURL_0.setVar("createFactoryConfigURL");
      int _jspx_eval_portlet_renderURL_0 = _jspx_th_portlet_renderURL_0.doStartTag();
      if (_jspx_eval_portlet_renderURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_portlet_param_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_0, _jspx_page_context))
          return;
        out.write("\n");
        out.write("\t\t\t\t\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_3 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_3.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
        _jspx_th_portlet_param_3.setName("redirect");
        _jspx_th_portlet_param_3.setValue( currentURL );
        int _jspx_eval_portlet_param_3 = _jspx_th_portlet_param_3.doStartTag();
        if (_jspx_th_portlet_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
        out.write("\n");
        out.write("\t\t\t\t\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_4 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_4.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
        _jspx_th_portlet_param_4.setName("factoryPid");
        _jspx_th_portlet_param_4.setValue( configurationModel.getID() );
        int _jspx_eval_portlet_param_4 = _jspx_th_portlet_param_4.doStartTag();
        if (_jspx_th_portlet_param_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
        out.write("\n");
        out.write("\t\t\t\t\t\t\t");
      }
      if (_jspx_th_portlet_renderURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_var.reuse(_jspx_th_portlet_renderURL_0);
        return;
      }
      _jspx_tagPool_portlet_renderURL_var.reuse(_jspx_th_portlet_renderURL_0);
      java.lang.String createFactoryConfigURL = null;
      createFactoryConfigURL = (java.lang.String) _jspx_page_context.findAttribute("createFactoryConfigURL");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<a class=\"btn btn-secondary btn-sm\" href=\"");
      out.print( createFactoryConfigURL );
      out.write('"');
      out.write('>');
      if (_jspx_meth_liferay$1ui_message_1(_jspx_page_context))
        return;
      out.write("</a>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t</h3>\n");
      out.write("\n");
      out.write("\t\t\t\t");

				PortletURL iteratorURL = renderResponse.createRenderURL();

				iteratorURL.setParameter("mvcRenderCommandName", "/view_factory_instances");
				iteratorURL.setParameter("factoryPid", configurationModel.getFactoryPid());
				
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t");
      //  liferay-ui:search-container
      com.liferay.taglib.ui.SearchContainerTag _jspx_th_liferay$1ui_search$1container_0 = (com.liferay.taglib.ui.SearchContainerTag) _jspx_tagPool_liferay$1ui_search$1container_total_iteratorURL_emptyResultsMessage.get(com.liferay.taglib.ui.SearchContainerTag.class);
      _jspx_th_liferay$1ui_search$1container_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1ui_search$1container_0.setParent(null);
      _jspx_th_liferay$1ui_search$1container_0.setEmptyResultsMessage( LanguageUtil.format(request, "no-entries-for-x-have-been-added-yet", factoryConfigurationModelName) );
      _jspx_th_liferay$1ui_search$1container_0.setIteratorURL( iteratorURL );
      _jspx_th_liferay$1ui_search$1container_0.setTotal( configurationModelIterator.getTotal() );
      int _jspx_eval_liferay$1ui_search$1container_0 = _jspx_th_liferay$1ui_search$1container_0.doStartTag();
      if (_jspx_eval_liferay$1ui_search$1container_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        java.lang.Integer total = null;
        com.liferay.portal.kernel.dao.search.SearchContainer searchContainer = null;
        total = (java.lang.Integer) _jspx_page_context.findAttribute("total");
        searchContainer = (com.liferay.portal.kernel.dao.search.SearchContainer) _jspx_page_context.findAttribute("searchContainer");
        out.write("\n");
        out.write("\t\t\t\t\t");
        //  liferay-ui:search-container-results
        java.util.List results = null;
        java.lang.Integer deprecatedTotal = null;
        com.liferay.taglib.ui.SearchContainerResultsTag _jspx_th_liferay$1ui_search$1container$1results_0 = (com.liferay.taglib.ui.SearchContainerResultsTag) _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody.get(com.liferay.taglib.ui.SearchContainerResultsTag.class);
        _jspx_th_liferay$1ui_search$1container$1results_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_search$1container$1results_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container_0);
        _jspx_th_liferay$1ui_search$1container$1results_0.setResults( configurationModelIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) );
        int _jspx_eval_liferay$1ui_search$1container$1results_0 = _jspx_th_liferay$1ui_search$1container$1results_0.doStartTag();
        results = (java.util.List) _jspx_page_context.findAttribute("results");
        deprecatedTotal = (java.lang.Integer) _jspx_page_context.findAttribute("deprecatedTotal");
        if (_jspx_th_liferay$1ui_search$1container$1results_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1results_0);
          return;
        }
        results = (java.util.List) _jspx_page_context.findAttribute("results");
        deprecatedTotal = (java.lang.Integer) _jspx_page_context.findAttribute("deprecatedTotal");
        _jspx_tagPool_liferay$1ui_search$1container$1results_results_nobody.reuse(_jspx_th_liferay$1ui_search$1container$1results_0);
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t\t\t");
        //  liferay-ui:search-container-row
        com.liferay.taglib.ui.SearchContainerRowTag _jspx_th_liferay$1ui_search$1container$1row_0 = (com.liferay.taglib.ui.SearchContainerRowTag) _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_className.get(com.liferay.taglib.ui.SearchContainerRowTag.class);
        _jspx_th_liferay$1ui_search$1container$1row_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_search$1container$1row_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container_0);
        _jspx_th_liferay$1ui_search$1container$1row_0.setClassName("com.liferay.configuration.admin.web.internal.model.ConfigurationModel");
        _jspx_th_liferay$1ui_search$1container$1row_0.setKeyProperty("ID");
        _jspx_th_liferay$1ui_search$1container$1row_0.setModelVar("curConfigurationModel");
        int _jspx_eval_liferay$1ui_search$1container$1row_0 = _jspx_th_liferay$1ui_search$1container$1row_0.doStartTag();
        if (_jspx_eval_liferay$1ui_search$1container$1row_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.Integer index = null;
          com.liferay.configuration.admin.web.internal.model.ConfigurationModel curConfigurationModel = null;
          com.liferay.portal.kernel.dao.search.ResultRow row = null;
          if (_jspx_eval_liferay$1ui_search$1container$1row_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_liferay$1ui_search$1container$1row_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_liferay$1ui_search$1container$1row_0.doInitBody();
          }
          index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
          curConfigurationModel = (com.liferay.configuration.admin.web.internal.model.ConfigurationModel) _jspx_page_context.findAttribute("curConfigurationModel");
          row = (com.liferay.portal.kernel.dao.search.ResultRow) _jspx_page_context.findAttribute("row");
          do {
            out.write("\n");
            out.write("\t\t\t\t\t\t");
            //  portlet:renderURL
            com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_1 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
            _jspx_th_portlet_renderURL_1.setPageContext(_jspx_page_context);
            _jspx_th_portlet_renderURL_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
            _jspx_th_portlet_renderURL_1.setVar("editFactoryInstanceURL");
            int _jspx_eval_portlet_renderURL_1 = _jspx_th_portlet_renderURL_1.doStartTag();
            if (_jspx_eval_portlet_renderURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              out.write("\n");
              out.write("\t\t\t\t\t\t\t");
              if (_jspx_meth_portlet_param_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_1, _jspx_page_context))
                return;
              out.write("\n");
              out.write("\t\t\t\t\t\t\t");
              //  portlet:param
              com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_6 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
              _jspx_th_portlet_param_6.setPageContext(_jspx_page_context);
              _jspx_th_portlet_param_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
              _jspx_th_portlet_param_6.setName("redirect");
              _jspx_th_portlet_param_6.setValue( currentURL );
              int _jspx_eval_portlet_param_6 = _jspx_th_portlet_param_6.doStartTag();
              if (_jspx_th_portlet_param_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
                return;
              }
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
              out.write("\n");
              out.write("\t\t\t\t\t\t\t");
              //  portlet:param
              com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_7 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
              _jspx_th_portlet_param_7.setPageContext(_jspx_page_context);
              _jspx_th_portlet_param_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
              _jspx_th_portlet_param_7.setName("factoryPid");
              _jspx_th_portlet_param_7.setValue( curConfigurationModel.getFactoryPid() );
              int _jspx_eval_portlet_param_7 = _jspx_th_portlet_param_7.doStartTag();
              if (_jspx_th_portlet_param_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
                return;
              }
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
              out.write("\n");
              out.write("\t\t\t\t\t\t\t");
              //  portlet:param
              com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_8 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
              _jspx_th_portlet_param_8.setPageContext(_jspx_page_context);
              _jspx_th_portlet_param_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
              _jspx_th_portlet_param_8.setName("pid");
              _jspx_th_portlet_param_8.setValue( curConfigurationModel.getID() );
              int _jspx_eval_portlet_param_8 = _jspx_th_portlet_param_8.doStartTag();
              if (_jspx_th_portlet_param_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_8);
                return;
              }
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_8);
              out.write("\n");
              out.write("\t\t\t\t\t\t");
            }
            if (_jspx_th_portlet_renderURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_portlet_renderURL_var.reuse(_jspx_th_portlet_renderURL_1);
              return;
            }
            _jspx_tagPool_portlet_renderURL_var.reuse(_jspx_th_portlet_renderURL_1);
            java.lang.String editFactoryInstanceURL = null;
            editFactoryInstanceURL = (java.lang.String) _jspx_page_context.findAttribute("editFactoryInstanceURL");
            out.write("\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t");

						String columnLabel = "entry";

						String labelAttribute = curConfigurationModel.getLabelAttribute();

						if (labelAttribute != null) {
							AttributeDefinition attributeDefinition = curConfigurationModel.getExtendedAttributeDefinition(labelAttribute);

							if (attributeDefinition != null) {
								columnLabel = attributeDefinition.getName();
							}
						}
						
            out.write("\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t");
            //  liferay-ui:search-container-column-text
            com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_0 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
            _jspx_th_liferay$1ui_search$1container$1column$1text_0.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_search$1container$1column$1text_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
            _jspx_th_liferay$1ui_search$1container$1column$1text_0.setName( columnLabel );
            int _jspx_eval_liferay$1ui_search$1container$1column$1text_0 = _jspx_th_liferay$1ui_search$1container$1column$1text_0.doStartTag();
            if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                out = _jspx_page_context.pushBody();
                _jspx_th_liferay$1ui_search$1container$1column$1text_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                _jspx_th_liferay$1ui_search$1container$1column$1text_0.doInitBody();
              }
              do {
                out.write("\n");
                out.write("\t\t\t\t\t\t\t");
                //  aui:a
                com.liferay.taglib.aui.ATag _jspx_th_aui_a_0 = (com.liferay.taglib.aui.ATag) _jspx_tagPool_aui_a_href.get(com.liferay.taglib.aui.ATag.class);
                _jspx_th_aui_a_0.setPageContext(_jspx_page_context);
                _jspx_th_aui_a_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_0);
                _jspx_th_aui_a_0.setHref( editFactoryInstanceURL );
                int _jspx_eval_aui_a_0 = _jspx_th_aui_a_0.doStartTag();
                if (_jspx_eval_aui_a_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  out.write("<strong>");
                  out.print( HtmlUtil.escape(curConfigurationModel.getLabel()) );
                  out.write("</strong>");
                }
                if (_jspx_th_aui_a_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_aui_a_href.reuse(_jspx_th_aui_a_0);
                  return;
                }
                _jspx_tagPool_aui_a_href.reuse(_jspx_th_aui_a_0);
                out.write("\n");
                out.write("\t\t\t\t\t\t");
                int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1column$1text_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
              if (_jspx_eval_liferay$1ui_search$1container$1column$1text_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                out = _jspx_page_context.popBody();
            }
            if (_jspx_th_liferay$1ui_search$1container$1column$1text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_0);
              return;
            }
            _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_0);
            out.write("\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t");
            //  liferay-ui:search-container-column-text
            com.liferay.taglib.ui.SearchContainerColumnTextTag _jspx_th_liferay$1ui_search$1container$1column$1text_1 = (com.liferay.taglib.ui.SearchContainerColumnTextTag) _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass_align.get(com.liferay.taglib.ui.SearchContainerColumnTextTag.class);
            _jspx_th_liferay$1ui_search$1container$1column$1text_1.setPageContext(_jspx_page_context);
            _jspx_th_liferay$1ui_search$1container$1column$1text_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1row_0);
            _jspx_th_liferay$1ui_search$1container$1column$1text_1.setAlign("right");
            _jspx_th_liferay$1ui_search$1container$1column$1text_1.setCssClass("entry-action");
            _jspx_th_liferay$1ui_search$1container$1column$1text_1.setName("");
            int _jspx_eval_liferay$1ui_search$1container$1column$1text_1 = _jspx_th_liferay$1ui_search$1container$1column$1text_1.doStartTag();
            if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                out = _jspx_page_context.pushBody();
                _jspx_th_liferay$1ui_search$1container$1column$1text_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                _jspx_th_liferay$1ui_search$1container$1column$1text_1.doInitBody();
              }
              do {
                out.write("\n");
                out.write("\t\t\t\t\t\t\t");
                //  liferay-ui:icon-menu
                com.liferay.taglib.ui.IconMenuTag _jspx_th_liferay$1ui_icon$1menu_1 = (com.liferay.taglib.ui.IconMenuTag) _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction.get(com.liferay.taglib.ui.IconMenuTag.class);
                _jspx_th_liferay$1ui_icon$1menu_1.setPageContext(_jspx_page_context);
                _jspx_th_liferay$1ui_icon$1menu_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container$1column$1text_1);
                _jspx_th_liferay$1ui_icon$1menu_1.setDirection("down");
                _jspx_th_liferay$1ui_icon$1menu_1.setMarkupView("lexicon");
                _jspx_th_liferay$1ui_icon$1menu_1.setShowWhenSingleIcon( true );
                int _jspx_eval_liferay$1ui_icon$1menu_1 = _jspx_th_liferay$1ui_icon$1menu_1.doStartTag();
                if (_jspx_eval_liferay$1ui_icon$1menu_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  if (_jspx_eval_liferay$1ui_icon$1menu_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                    out = _jspx_page_context.pushBody();
                    _jspx_th_liferay$1ui_icon$1menu_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                    _jspx_th_liferay$1ui_icon$1menu_1.doInitBody();
                  }
                  do {
                    out.write("\n");
                    out.write("\t\t\t\t\t\t\t\t");
                    //  liferay-ui:icon
                    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_1 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.get(com.liferay.taglib.ui.IconTag.class);
                    _jspx_th_liferay$1ui_icon_1.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_icon_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_1);
                    _jspx_th_liferay$1ui_icon_1.setMessage("edit");
                    _jspx_th_liferay$1ui_icon_1.setMethod("post");
                    _jspx_th_liferay$1ui_icon_1.setUrl( editFactoryInstanceURL );
                    int _jspx_eval_liferay$1ui_icon_1 = _jspx_th_liferay$1ui_icon_1.doStartTag();
                    if (_jspx_th_liferay$1ui_icon_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.reuse(_jspx_th_liferay$1ui_icon_1);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.reuse(_jspx_th_liferay$1ui_icon_1);
                    out.write("\n");
                    out.write("\n");
                    out.write("\t\t\t\t\t\t\t\t");
if (
 curConfigurationModel.hasConfiguration() ) {
                    out.write("\n");
                    out.write("\t\t\t\t\t\t\t\t\t");
                    //  portlet:actionURL
                    com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
                    _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
                    _jspx_th_portlet_actionURL_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_1);
                    _jspx_th_portlet_actionURL_0.setName("deleteConfiguration");
                    _jspx_th_portlet_actionURL_0.setVar("deleteConfigActionURL");
                    int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
                    if (_jspx_eval_portlet_actionURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t\t\t\t");
                      //  portlet:param
                      com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_9 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                      _jspx_th_portlet_param_9.setPageContext(_jspx_page_context);
                      _jspx_th_portlet_param_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
                      _jspx_th_portlet_param_9.setName("redirect");
                      _jspx_th_portlet_param_9.setValue( currentURL );
                      int _jspx_eval_portlet_param_9 = _jspx_th_portlet_param_9.doStartTag();
                      if (_jspx_th_portlet_param_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_9);
                        return;
                      }
                      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_9);
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t\t\t\t");
                      //  portlet:param
                      com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_10 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                      _jspx_th_portlet_param_10.setPageContext(_jspx_page_context);
                      _jspx_th_portlet_param_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
                      _jspx_th_portlet_param_10.setName("factoryPid");
                      _jspx_th_portlet_param_10.setValue( curConfigurationModel.getFactoryPid() );
                      int _jspx_eval_portlet_param_10 = _jspx_th_portlet_param_10.doStartTag();
                      if (_jspx_th_portlet_param_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_10);
                        return;
                      }
                      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_10);
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t\t\t\t");
                      //  portlet:param
                      com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_11 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                      _jspx_th_portlet_param_11.setPageContext(_jspx_page_context);
                      _jspx_th_portlet_param_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
                      _jspx_th_portlet_param_11.setName("pid");
                      _jspx_th_portlet_param_11.setValue( curConfigurationModel.getID() );
                      int _jspx_eval_portlet_param_11 = _jspx_th_portlet_param_11.doStartTag();
                      if (_jspx_th_portlet_param_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_11);
                        return;
                      }
                      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_11);
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
                      return;
                    }
                    _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
                    java.lang.String deleteConfigActionURL = null;
                    deleteConfigActionURL = (java.lang.String) _jspx_page_context.findAttribute("deleteConfigActionURL");
                    out.write("\n");
                    out.write("\n");
                    out.write("\t\t\t\t\t\t\t\t\t");
                    //  liferay-ui:icon
                    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_2 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.get(com.liferay.taglib.ui.IconTag.class);
                    _jspx_th_liferay$1ui_icon_2.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_icon_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_1);
                    _jspx_th_liferay$1ui_icon_2.setMessage("delete");
                    _jspx_th_liferay$1ui_icon_2.setMethod("post");
                    _jspx_th_liferay$1ui_icon_2.setUrl( deleteConfigActionURL );
                    int _jspx_eval_liferay$1ui_icon_2 = _jspx_th_liferay$1ui_icon_2.doStartTag();
                    if (_jspx_th_liferay$1ui_icon_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.reuse(_jspx_th_liferay$1ui_icon_2);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.reuse(_jspx_th_liferay$1ui_icon_2);
                    out.write("\n");
                    out.write("\n");
                    out.write("\t\t\t\t\t\t\t\t\t");
                    //  portlet:resourceURL
                    com.liferay.taglib.portlet.ResourceURLTag _jspx_th_portlet_resourceURL_1 = (com.liferay.taglib.portlet.ResourceURLTag) _jspx_tagPool_portlet_resourceURL_var_id.get(com.liferay.taglib.portlet.ResourceURLTag.class);
                    _jspx_th_portlet_resourceURL_1.setPageContext(_jspx_page_context);
                    _jspx_th_portlet_resourceURL_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_1);
                    _jspx_th_portlet_resourceURL_1.setId("export");
                    _jspx_th_portlet_resourceURL_1.setVar("exportURL");
                    int _jspx_eval_portlet_resourceURL_1 = _jspx_th_portlet_resourceURL_1.doStartTag();
                    if (_jspx_eval_portlet_resourceURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t\t\t\t");
                      //  portlet:param
                      com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_12 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                      _jspx_th_portlet_param_12.setPageContext(_jspx_page_context);
                      _jspx_th_portlet_param_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_1);
                      _jspx_th_portlet_param_12.setName("factoryPid");
                      _jspx_th_portlet_param_12.setValue( curConfigurationModel.getFactoryPid() );
                      int _jspx_eval_portlet_param_12 = _jspx_th_portlet_param_12.doStartTag();
                      if (_jspx_th_portlet_param_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_12);
                        return;
                      }
                      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_12);
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t\t\t\t");
                      //  portlet:param
                      com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_13 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
                      _jspx_th_portlet_param_13.setPageContext(_jspx_page_context);
                      _jspx_th_portlet_param_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_1);
                      _jspx_th_portlet_param_13.setName("pid");
                      _jspx_th_portlet_param_13.setValue( curConfigurationModel.getID() );
                      int _jspx_eval_portlet_param_13 = _jspx_th_portlet_param_13.doStartTag();
                      if (_jspx_th_portlet_param_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_13);
                        return;
                      }
                      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_13);
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t\t\t");
                    }
                    if (_jspx_th_portlet_resourceURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_portlet_resourceURL_var_id.reuse(_jspx_th_portlet_resourceURL_1);
                      return;
                    }
                    _jspx_tagPool_portlet_resourceURL_var_id.reuse(_jspx_th_portlet_resourceURL_1);
                    java.lang.String exportURL = null;
                    exportURL = (java.lang.String) _jspx_page_context.findAttribute("exportURL");
                    out.write("\n");
                    out.write("\n");
                    out.write("\t\t\t\t\t\t\t\t\t");
                    //  liferay-ui:icon
                    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_3 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.get(com.liferay.taglib.ui.IconTag.class);
                    _jspx_th_liferay$1ui_icon_3.setPageContext(_jspx_page_context);
                    _jspx_th_liferay$1ui_icon_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_1);
                    _jspx_th_liferay$1ui_icon_3.setMessage("export");
                    _jspx_th_liferay$1ui_icon_3.setMethod("get");
                    _jspx_th_liferay$1ui_icon_3.setUrl( exportURL );
                    int _jspx_eval_liferay$1ui_icon_3 = _jspx_th_liferay$1ui_icon_3.doStartTag();
                    if (_jspx_th_liferay$1ui_icon_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.reuse(_jspx_th_liferay$1ui_icon_3);
                      return;
                    }
                    _jspx_tagPool_liferay$1ui_icon_url_method_message_nobody.reuse(_jspx_th_liferay$1ui_icon_3);
                    out.write("\n");
                    out.write("\t\t\t\t\t\t\t\t");
}
                    out.write("\n");
                    out.write("\t\t\t\t\t\t\t");
                    int evalDoAfterBody = _jspx_th_liferay$1ui_icon$1menu_1.doAfterBody();
                    if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                      break;
                  } while (true);
                  if (_jspx_eval_liferay$1ui_icon$1menu_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                    out = _jspx_page_context.popBody();
                }
                if (_jspx_th_liferay$1ui_icon$1menu_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction.reuse(_jspx_th_liferay$1ui_icon$1menu_1);
                  return;
                }
                _jspx_tagPool_liferay$1ui_icon$1menu_showWhenSingleIcon_markupView_direction.reuse(_jspx_th_liferay$1ui_icon$1menu_1);
                out.write("\n");
                out.write("\t\t\t\t\t\t");
                int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1column$1text_1.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
              if (_jspx_eval_liferay$1ui_search$1container$1column$1text_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                out = _jspx_page_context.popBody();
            }
            if (_jspx_th_liferay$1ui_search$1container$1column$1text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass_align.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_1);
              return;
            }
            _jspx_tagPool_liferay$1ui_search$1container$1column$1text_name_cssClass_align.reuse(_jspx_th_liferay$1ui_search$1container$1column$1text_1);
            out.write("\n");
            out.write("\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_liferay$1ui_search$1container$1row_0.doAfterBody();
            index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
            curConfigurationModel = (com.liferay.configuration.admin.web.internal.model.ConfigurationModel) _jspx_page_context.findAttribute("curConfigurationModel");
            row = (com.liferay.portal.kernel.dao.search.ResultRow) _jspx_page_context.findAttribute("row");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_liferay$1ui_search$1container$1row_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_liferay$1ui_search$1container$1row_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_className.reuse(_jspx_th_liferay$1ui_search$1container$1row_0);
          return;
        }
        _jspx_tagPool_liferay$1ui_search$1container$1row_modelVar_keyProperty_className.reuse(_jspx_th_liferay$1ui_search$1container$1row_0);
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_liferay$1ui_search$1iterator_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_search$1container_0, _jspx_page_context))
          return;
        out.write("\n");
        out.write("\t\t\t\t");
      }
      if (_jspx_th_liferay$1ui_search$1container_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1ui_search$1container_total_iteratorURL_emptyResultsMessage.reuse(_jspx_th_liferay$1ui_search$1container_0);
        return;
      }
      _jspx_tagPool_liferay$1ui_search$1container_total_iteratorURL_emptyResultsMessage.reuse(_jspx_th_liferay$1ui_search$1container_0);
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>");
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

  private boolean _jspx_meth_liferay$1ui_message_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_0.setParent(null);
    _jspx_th_liferay$1ui_message_0.setKey("configuration-entries");
    int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
    if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
    return false;
  }

  private boolean _jspx_meth_portlet_param_2(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_2 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_2.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
    _jspx_th_portlet_param_2.setName("mvcRenderCommandName");
    _jspx_th_portlet_param_2.setValue("/edit_configuration");
    int _jspx_eval_portlet_param_2 = _jspx_th_portlet_param_2.doStartTag();
    if (_jspx_th_portlet_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_1 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_1.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_1.setParent(null);
    _jspx_th_liferay$1ui_message_1.setKey("add");
    int _jspx_eval_liferay$1ui_message_1 = _jspx_th_liferay$1ui_message_1.doStartTag();
    if (_jspx_th_liferay$1ui_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_1);
    return false;
  }

  private boolean _jspx_meth_portlet_param_5(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_5 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_5.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
    _jspx_th_portlet_param_5.setName("mvcRenderCommandName");
    _jspx_th_portlet_param_5.setValue("/edit_configuration");
    int _jspx_eval_portlet_param_5 = _jspx_th_portlet_param_5.doStartTag();
    if (_jspx_th_portlet_param_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_search$1iterator_0(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_search$1container_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:search-iterator
    com.liferay.taglib.ui.SearchIteratorTag _jspx_th_liferay$1ui_search$1iterator_0 = (com.liferay.taglib.ui.SearchIteratorTag) _jspx_tagPool_liferay$1ui_search$1iterator_searchResultCssClass_markupView_nobody.get(com.liferay.taglib.ui.SearchIteratorTag.class);
    _jspx_th_liferay$1ui_search$1iterator_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_search$1iterator_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_search$1container_0);
    _jspx_th_liferay$1ui_search$1iterator_0.setMarkupView("lexicon");
    _jspx_th_liferay$1ui_search$1iterator_0.setSearchResultCssClass("show-quick-actions-on-hover table table-autofit");
    int _jspx_eval_liferay$1ui_search$1iterator_0 = _jspx_th_liferay$1ui_search$1iterator_0.doStartTag();
    if (_jspx_th_liferay$1ui_search$1iterator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_search$1iterator_searchResultCssClass_markupView_nobody.reuse(_jspx_th_liferay$1ui_search$1iterator_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_search$1iterator_searchResultCssClass_markupView_nobody.reuse(_jspx_th_liferay$1ui_search$1iterator_0);
    return false;
  }
}
