package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.document.library.kernel.exception.FileSizeException;
import com.liferay.document.library.kernel.util.DLValidatorUtil;
import com.liferay.exportimport.constants.ExportImportPortletKeys;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerKeys;
import com.liferay.exportimport.kernel.staging.LayoutStagingUtil;
import com.liferay.exportimport.kernel.staging.StagingUtil;
import com.liferay.frontend.taglib.servlet.taglib.util.EmptyResultMessageKeys;
import com.liferay.layout.admin.web.internal.constants.LayoutAdminWebKeys;
import com.liferay.layout.admin.web.internal.display.context.DisplayPageDisplayContext;
import com.liferay.layout.admin.web.internal.display.context.FragmentsEditorDisplayContext;
import com.liferay.layout.admin.web.internal.display.context.LayoutPageTemplateCollectionsDisplayContext;
import com.liferay.layout.admin.web.internal.display.context.LayoutPageTemplateDisplayContext;
import com.liferay.layout.admin.web.internal.display.context.LayoutPrototypeDisplayContext;
import com.liferay.layout.admin.web.internal.display.context.LayoutsAdminDisplayContext;
import com.liferay.layout.admin.web.internal.display.context.OrphanPortletsDisplayContext;
import com.liferay.layout.admin.web.internal.display.context.SelectLayoutPageTemplateEntryDisplayContext;
import com.liferay.layout.admin.web.internal.display.context.SelectThemeDisplayContext;
import com.liferay.layout.admin.web.internal.security.permission.resource.LayoutPageTemplateCollectionPermission;
import com.liferay.layout.admin.web.internal.security.permission.resource.LayoutPageTemplateEntryPermission;
import com.liferay.layout.page.template.constants.LayoutPageTemplateActionKeys;
import com.liferay.layout.page.template.constants.LayoutPageTemplateEntryTypeConstants;
import com.liferay.layout.page.template.exception.DuplicateLayoutPageTemplateCollectionException;
import com.liferay.layout.page.template.exception.LayoutPageTemplateCollectionNameException;
import com.liferay.layout.page.template.exception.RequiredLayoutPageTemplateEntryException;
import com.liferay.layout.page.template.model.LayoutPageTemplateCollection;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.layout.page.template.service.LayoutPageTemplateCollectionLocalServiceUtil;
import com.liferay.layout.page.template.service.LayoutPageTemplateCollectionServiceUtil;
import com.liferay.layout.page.template.service.LayoutPageTemplateEntryServiceUtil;
import com.liferay.layouts.admin.kernel.model.LayoutTypePortletConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.exception.GroupInheritContentException;
import com.liferay.portal.kernel.exception.ImageTypeException;
import com.liferay.portal.kernel.exception.LayoutFriendlyURLException;
import com.liferay.portal.kernel.exception.LayoutFriendlyURLsException;
import com.liferay.portal.kernel.exception.LayoutNameException;
import com.liferay.portal.kernel.exception.LayoutTypeException;
import com.liferay.portal.kernel.exception.NoSuchGroupException;
import com.liferay.portal.kernel.exception.NoSuchLayoutException;
import com.liferay.portal.kernel.exception.NoSuchRoleException;
import com.liferay.portal.kernel.exception.RequiredLayoutException;
import com.liferay.portal.kernel.exception.RequiredLayoutPrototypeException;
import com.liferay.portal.kernel.exception.SitemapChangeFrequencyException;
import com.liferay.portal.kernel.exception.SitemapIncludeException;
import com.liferay.portal.kernel.exception.SitemapPagePriorityException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UnicodeLanguageUtil;
import com.liferay.portal.kernel.layoutconfiguration.util.RuntimePageUtil;
import com.liferay.portal.kernel.model.ColorScheme;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutBranch;
import com.liferay.portal.kernel.model.LayoutBranchConstants;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutPrototype;
import com.liferay.portal.kernel.model.LayoutRevision;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.LayoutSetBranch;
import com.liferay.portal.kernel.model.LayoutSetBranchConstants;
import com.liferay.portal.kernel.model.LayoutSetPrototype;
import com.liferay.portal.kernel.model.LayoutTemplate;
import com.liferay.portal.kernel.model.LayoutTemplateConstants;
import com.liferay.portal.kernel.model.LayoutType;
import com.liferay.portal.kernel.model.LayoutTypeController;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.model.ThemeSetting;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.plugin.PluginPackage;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutPrototypeLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutPrototypeServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetBranchLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutTemplateLocalServiceUtil;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.service.ThemeLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.GroupPermissionUtil;
import com.liferay.portal.kernel.service.permission.LayoutPermissionUtil;
import com.liferay.portal.kernel.service.permission.LayoutPrototypePermissionUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.ServletContextPool;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorConstants;
import com.liferay.portal.kernel.template.StringTemplateResource;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webserver.WebServerServletTokenUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.impl.LayoutPrototypeImpl;
import com.liferay.portal.util.LayoutDescription;
import com.liferay.portal.util.LayoutTypeControllerTracker;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.RobotsUtil;
import com.liferay.sites.kernel.util.SitesUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

public final class edit_005flayout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(16);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/META-INF/c.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet_2_0.tld");
    _jspx_dependants.add("/META-INF/liferay-asset.tld");
    _jspx_dependants.add("/META-INF/liferay-aui.tld");
    _jspx_dependants.add("/META-INF/liferay-clay.tld");
    _jspx_dependants.add("/META-INF/liferay-editor.tld");
    _jspx_dependants.add("/META-INF/liferay-expando.tld");
    _jspx_dependants.add("/META-INF/liferay-frontend.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet-ext.tld");
    _jspx_dependants.add("/META-INF/liferay-security.tld");
    _jspx_dependants.add("/META-INF/resources/soy.tld");
    _jspx_dependants.add("/META-INF/liferay-theme.tld");
    _jspx_dependants.add("/META-INF/liferay-ui.tld");
    _jspx_dependants.add("/META-INF/liferay-util.tld");
    _jspx_dependants.add("/init-ext.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_arguments_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_error_exception;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_type_name_href_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_type_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_edit$1form_name_method_enctype_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script_use;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_success_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_name_id_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_form$1navigator_showButtons_id_formModelBean_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_error_message_exception_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_edit$1form$1body;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_edit$1form$1footer;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button$1row;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_portlet_actionURL_var_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_arguments_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_error_exception = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_type_name_href_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_type_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_edit$1form_name_method_enctype_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script_use = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_success_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_name_id_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_form$1navigator_showButtons_id_formModelBean_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_error_message_exception_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_edit$1form$1body = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_edit$1form$1footer = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button$1row = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_portlet_actionURL_var_name.release();
    _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_liferay$1ui_error_exception.release();
    _jspx_tagPool_aui_button_type_name_href_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_aui_button_type_nobody.release();
    _jspx_tagPool_liferay$1frontend_edit$1form_name_method_enctype_action.release();
    _jspx_tagPool_aui_input_type_name_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_aui_script_use.release();
    _jspx_tagPool_liferay$1ui_success_message_key_nobody.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_aui_button_value_name_id_nobody.release();
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_aui_button_value_name_id_cssClass_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_nobody.release();
    _jspx_tagPool_liferay$1frontend_form$1navigator_showButtons_id_formModelBean_nobody.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_error_message_exception_nobody.release();
    _jspx_tagPool_liferay$1frontend_edit$1form$1body.release();
    _jspx_tagPool_liferay$1frontend_edit$1form$1footer.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.release();
    _jspx_tagPool_aui_button$1row.release();
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

LayoutsAdminDisplayContext layoutsAdminDisplayContext = new LayoutsAdminDisplayContext(liferayPortletRequest, liferayPortletResponse);
LayoutPrototypeDisplayContext layoutPrototypeDisplayContext = new LayoutPrototypeDisplayContext(renderRequest, renderResponse, request);

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

String redirect = ParamUtil.getString(request, "redirect");

String backURL = ParamUtil.getString(request, "backURL", redirect);

if (Validator.isNull(backURL)) {
	backURL = PortalUtil.getLayoutFullURL(layoutsAdminDisplayContext.getSelLayout(), themeDisplay);
}

String portletResource = ParamUtil.getString(request, "portletResource");

Group selGroup = (Group)request.getAttribute(WebKeys.GROUP);

Group group = layoutsAdminDisplayContext.getGroup();

Layout selLayout = layoutsAdminDisplayContext.getSelLayout();

PortletURL redirectURL = layoutsAdminDisplayContext.getRedirectURL();

long refererPlid = ParamUtil.getLong(request, "refererPlid", LayoutConstants.DEFAULT_PLID);

Set<Long> parentPlids = new HashSet<Long>();

long parentPlid = refererPlid;

while (parentPlid > 0) {
	try {
		Layout parentLayout = LayoutLocalServiceUtil.getLayout(parentPlid);

		if (parentLayout.isRootLayout()) {
			break;
		}

		parentPlid = parentLayout.getParentPlid();

		parentPlids.add(parentPlid);
	}
	catch (Exception e) {
		break;
	}
}

LayoutRevision layoutRevision = LayoutStagingUtil.getLayoutRevision(selLayout);

String layoutSetBranchName = StringPool.BLANK;

boolean incomplete = false;

if (layoutRevision != null) {
	long layoutSetBranchId = layoutRevision.getLayoutSetBranchId();

	incomplete = StagingUtil.isIncomplete(selLayout, layoutSetBranchId);

	if (incomplete) {
		LayoutSetBranch layoutSetBranch = LayoutSetBranchLocalServiceUtil.getLayoutSetBranch(layoutSetBranchId);

		layoutSetBranchName = layoutSetBranch.getName();

		if (LayoutSetBranchConstants.MASTER_BRANCH_NAME.equals(layoutSetBranchName)) {
			layoutSetBranchName = LanguageUtil.get(request, layoutSetBranchName);
		}

		portletDisplay.setShowStagingIcon(false);
	}
}

if (Validator.isNotNull(backURL)) {
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(backURL);
}

renderResponse.setTitle(selLayout.getName(locale));

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('	');
if (
 incomplete ) {
      out.write("\n");
      out.write("\t\t");
      //  liferay-ui:message
      com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
      _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1ui_message_0.setParent(null);
      _jspx_th_liferay$1ui_message_0.setArguments( new Object[] {HtmlUtil.escape(selLayout.getName(locale)), HtmlUtil.escape(layoutSetBranchName)} );
      _jspx_th_liferay$1ui_message_0.setKey("the-page-x-is-not-enabled-in-x,-but-is-available-in-other-pages-variations");
      _jspx_th_liferay$1ui_message_0.setTranslateArguments( false );
      int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
      if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_0);
        return;
      }
      _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_0);
      out.write("\n");
      out.write("\n");
      out.write("\t\t");
      //  aui:button-row
      com.liferay.taglib.aui.ButtonRowTag _jspx_th_aui_button$1row_0 = (com.liferay.taglib.aui.ButtonRowTag) _jspx_tagPool_aui_button$1row.get(com.liferay.taglib.aui.ButtonRowTag.class);
      _jspx_th_aui_button$1row_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_button$1row_0.setParent(null);
      int _jspx_eval_aui_button$1row_0 = _jspx_th_aui_button$1row_0.doStartTag();
      if (_jspx_eval_aui_button$1row_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n");
        out.write("\t\t\t");
        //  aui:button
        com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_name_id_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
        _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
        _jspx_th_aui_button_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_button$1row_0);
        _jspx_th_aui_button_0.setId("enableLayoutButton");
        _jspx_th_aui_button_0.setName("enableLayout");
        _jspx_th_aui_button_0.setValue( LanguageUtil.format(request, "enable-in-x", HtmlUtil.escape(layoutSetBranchName), false) );
        int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
        if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_button_value_name_id_nobody.reuse(_jspx_th_aui_button_0);
          return;
        }
        _jspx_tagPool_aui_button_value_name_id_nobody.reuse(_jspx_th_aui_button_0);
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t");
        //  portlet:actionURL
        com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
        _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
        _jspx_th_portlet_actionURL_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_button$1row_0);
        _jspx_th_portlet_actionURL_0.setName("/layout/enable_layout");
        _jspx_th_portlet_actionURL_0.setVar("enableLayoutURL");
        int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
        if (_jspx_eval_portlet_actionURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n");
          out.write("\t\t\t\t");
          //  portlet:param
          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_0 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
          _jspx_th_portlet_param_0.setPageContext(_jspx_page_context);
          _jspx_th_portlet_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
          _jspx_th_portlet_param_0.setName("redirect");
          _jspx_th_portlet_param_0.setValue( redirectURL.toString() );
          int _jspx_eval_portlet_param_0 = _jspx_th_portlet_param_0.doStartTag();
          if (_jspx_th_portlet_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
            return;
          }
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
          out.write("\n");
          out.write("\t\t\t\t");
          //  portlet:param
          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_1 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
          _jspx_th_portlet_param_1.setPageContext(_jspx_page_context);
          _jspx_th_portlet_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
          _jspx_th_portlet_param_1.setName("incompleteLayoutRevisionId");
          _jspx_th_portlet_param_1.setValue( String.valueOf(layoutRevision.getLayoutRevisionId()) );
          int _jspx_eval_portlet_param_1 = _jspx_th_portlet_param_1.doStartTag();
          if (_jspx_th_portlet_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
            return;
          }
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
          out.write("\n");
          out.write("\t\t\t");
        }
        if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
          return;
        }
        _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
        java.lang.String enableLayoutURL = null;
        enableLayoutURL = (java.lang.String) _jspx_page_context.findAttribute("enableLayoutURL");
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t");
        //  aui:script
        com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_0 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script_use.get(com.liferay.taglib.aui.ScriptTag.class);
        _jspx_th_aui_script_0.setPageContext(_jspx_page_context);
        _jspx_th_aui_script_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_button$1row_0);
        _jspx_th_aui_script_0.setUse("aui-base");
        int _jspx_eval_aui_script_0 = _jspx_th_aui_script_0.doStartTag();
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_aui_script_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_aui_script_0.doInitBody();
          }
          do {
            out.write("\n");
            out.write("\t\t\t\tAUI.$('#");
            if (_jspx_meth_portlet_namespace_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_0, _jspx_page_context))
              return;
            out.write("enableLayoutButton').on(\n");
            out.write("\t\t\t\t\t'click',\n");
            out.write("\t\t\t\t\tfunction(event) {\n");
            out.write("\t\t\t\t\t\tsubmitForm(document.hrefFm, '");
            out.print( enableLayoutURL );
            out.write("');\n");
            out.write("\t\t\t\t\t}\n");
            out.write("\t\t\t\t);\n");
            out.write("\t\t\t");
            int evalDoAfterBody = _jspx_th_aui_script_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_aui_script_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_script_use.reuse(_jspx_th_aui_script_0);
          return;
        }
        _jspx_tagPool_aui_script_use.reuse(_jspx_th_aui_script_0);
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t");
        if (_jspx_meth_aui_button_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_button$1row_0, _jspx_page_context))
          return;
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t");
        //  portlet:actionURL
        com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_1 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
        _jspx_th_portlet_actionURL_1.setPageContext(_jspx_page_context);
        _jspx_th_portlet_actionURL_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_button$1row_0);
        _jspx_th_portlet_actionURL_1.setName("/layout/delete_layout");
        _jspx_th_portlet_actionURL_1.setVar("deleteLayoutURL");
        int _jspx_eval_portlet_actionURL_1 = _jspx_th_portlet_actionURL_1.doStartTag();
        if (_jspx_eval_portlet_actionURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n");
          out.write("\t\t\t\t");
          //  portlet:param
          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_2 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
          _jspx_th_portlet_param_2.setPageContext(_jspx_page_context);
          _jspx_th_portlet_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_1);
          _jspx_th_portlet_param_2.setName("redirect");
          _jspx_th_portlet_param_2.setValue( HttpUtil.addParameter(redirectURL.toString(), liferayPortletResponse.getNamespace() + "selPlid", selLayout.getParentPlid()) );
          int _jspx_eval_portlet_param_2 = _jspx_th_portlet_param_2.doStartTag();
          if (_jspx_th_portlet_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
            return;
          }
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
          out.write("\n");
          out.write("\t\t\t\t");
          //  portlet:param
          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_3 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
          _jspx_th_portlet_param_3.setPageContext(_jspx_page_context);
          _jspx_th_portlet_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_1);
          _jspx_th_portlet_param_3.setName("selPlid");
          _jspx_th_portlet_param_3.setValue( String.valueOf(layoutsAdminDisplayContext.getSelPlid()) );
          int _jspx_eval_portlet_param_3 = _jspx_th_portlet_param_3.doStartTag();
          if (_jspx_th_portlet_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
            return;
          }
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
          out.write("\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_portlet_param_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_actionURL_1, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t\t\t");
          //  portlet:param
          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_5 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
          _jspx_th_portlet_param_5.setPageContext(_jspx_page_context);
          _jspx_th_portlet_param_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_1);
          _jspx_th_portlet_param_5.setName("selPlid");
          _jspx_th_portlet_param_5.setValue( String.valueOf(selLayout.getParentPlid()) );
          int _jspx_eval_portlet_param_5 = _jspx_th_portlet_param_5.doStartTag();
          if (_jspx_th_portlet_param_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
            return;
          }
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
          out.write("\n");
          out.write("\t\t\t");
        }
        if (_jspx_th_portlet_actionURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_1);
          return;
        }
        _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_1);
        java.lang.String deleteLayoutURL = null;
        deleteLayoutURL = (java.lang.String) _jspx_page_context.findAttribute("deleteLayoutURL");
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t");
        //  aui:script
        com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_1 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script_use.get(com.liferay.taglib.aui.ScriptTag.class);
        _jspx_th_aui_script_1.setPageContext(_jspx_page_context);
        _jspx_th_aui_script_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_button$1row_0);
        _jspx_th_aui_script_1.setUse("aui-base");
        int _jspx_eval_aui_script_1 = _jspx_th_aui_script_1.doStartTag();
        if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_th_aui_script_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_aui_script_1.doInitBody();
          }
          do {
            out.write("\n");
            out.write("\t\t\t\tAUI.$('#");
            if (_jspx_meth_portlet_namespace_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_script_1, _jspx_page_context))
              return;
            out.write("deleteLayoutButton').on(\n");
            out.write("\t\t\t\t\t'click',\n");
            out.write("\t\t\t\t\tfunction(event) {\n");
            out.write("\t\t\t\t\t\tsubmitForm(document.hrefFm, '");
            out.print( deleteLayoutURL );
            out.write("');\n");
            out.write("\t\t\t\t\t}\n");
            out.write("\t\t\t\t);\n");
            out.write("\t\t\t");
            int evalDoAfterBody = _jspx_th_aui_script_1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_aui_script_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
        }
        if (_jspx_th_aui_script_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_script_use.reuse(_jspx_th_aui_script_1);
          return;
        }
        _jspx_tagPool_aui_script_use.reuse(_jspx_th_aui_script_1);
        out.write("\n");
        out.write("\t\t");
      }
      if (_jspx_th_aui_button$1row_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_button$1row.reuse(_jspx_th_aui_button$1row_0);
        return;
      }
      _jspx_tagPool_aui_button$1row.reuse(_jspx_th_aui_button$1row_0);
      out.write('\n');
      out.write('	');
      out.write('\n');
      out.write('	');
}
else {
      out.write("\n");
      out.write("\t\t");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_2 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_2.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_2.setParent(null);
      _jspx_th_portlet_actionURL_2.setName("/layout/edit_layout");
      _jspx_th_portlet_actionURL_2.setVar("editLayoutURL");
      int _jspx_eval_portlet_actionURL_2 = _jspx_th_portlet_actionURL_2.doStartTag();
      if (_jspx_eval_portlet_actionURL_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n");
        out.write("\t\t\t");
        if (_jspx_meth_portlet_param_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_actionURL_2, _jspx_page_context))
          return;
        out.write("\n");
        out.write("\t\t");
      }
      if (_jspx_th_portlet_actionURL_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_2);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_2);
      java.lang.String editLayoutURL = null;
      editLayoutURL = (java.lang.String) _jspx_page_context.findAttribute("editLayoutURL");
      out.write("\n");
      out.write("\n");
      out.write("\t\t");
      //  liferay-frontend:edit-form
      com.liferay.frontend.taglib.servlet.taglib.EditFormTag _jspx_th_liferay$1frontend_edit$1form_0 = (com.liferay.frontend.taglib.servlet.taglib.EditFormTag) _jspx_tagPool_liferay$1frontend_edit$1form_name_method_enctype_action.get(com.liferay.frontend.taglib.servlet.taglib.EditFormTag.class);
      _jspx_th_liferay$1frontend_edit$1form_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1frontend_edit$1form_0.setParent(null);
      _jspx_th_liferay$1frontend_edit$1form_0.setAction( HttpUtil.addParameter(editLayoutURL, "refererPlid", plid) );
      _jspx_th_liferay$1frontend_edit$1form_0.setDynamicAttribute(null, "enctype", new String("multipart/form-data"));
      _jspx_th_liferay$1frontend_edit$1form_0.setMethod("post");
      _jspx_th_liferay$1frontend_edit$1form_0.setName("editLayoutFm");
      int _jspx_eval_liferay$1frontend_edit$1form_0 = _jspx_th_liferay$1frontend_edit$1form_0.doStartTag();
      if (_jspx_eval_liferay$1frontend_edit$1form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_0.setName("redirect");
        _jspx_th_aui_input_0.setType("hidden");
        _jspx_th_aui_input_0.setValue( redirect );
        int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
        if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_1.setName("backURL");
        _jspx_th_aui_input_1.setType("hidden");
        _jspx_th_aui_input_1.setValue( backURL );
        int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
        if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_1);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_1);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_2.setName("portletResource");
        _jspx_th_aui_input_2.setType("hidden");
        _jspx_th_aui_input_2.setValue( portletResource );
        int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
        if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_2);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_2);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_3.setName("groupId");
        _jspx_th_aui_input_3.setType("hidden");
        _jspx_th_aui_input_3.setValue( layoutsAdminDisplayContext.getGroupId() );
        int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
        if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_3);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_3);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_4 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_4.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_4.setName("liveGroupId");
        _jspx_th_aui_input_4.setType("hidden");
        _jspx_th_aui_input_4.setValue( layoutsAdminDisplayContext.getLiveGroupId() );
        int _jspx_eval_aui_input_4 = _jspx_th_aui_input_4.doStartTag();
        if (_jspx_th_aui_input_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_5 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_5.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_5.setName("stagingGroupId");
        _jspx_th_aui_input_5.setType("hidden");
        _jspx_th_aui_input_5.setValue( layoutsAdminDisplayContext.getStagingGroupId() );
        int _jspx_eval_aui_input_5 = _jspx_th_aui_input_5.doStartTag();
        if (_jspx_th_aui_input_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_5);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_5);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_6 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_6.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_6.setName("selPlid");
        _jspx_th_aui_input_6.setType("hidden");
        _jspx_th_aui_input_6.setValue( layoutsAdminDisplayContext.getSelPlid() );
        int _jspx_eval_aui_input_6 = _jspx_th_aui_input_6.doStartTag();
        if (_jspx_th_aui_input_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_6);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_6);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_7 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_7.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_7.setName("privateLayout");
        _jspx_th_aui_input_7.setType("hidden");
        _jspx_th_aui_input_7.setValue( layoutsAdminDisplayContext.isPrivateLayout() );
        int _jspx_eval_aui_input_7 = _jspx_th_aui_input_7.doStartTag();
        if (_jspx_th_aui_input_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_7);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_7);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_8 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_8.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_8.setName("layoutId");
        _jspx_th_aui_input_8.setType("hidden");
        _jspx_th_aui_input_8.setValue( layoutsAdminDisplayContext.getLayoutId() );
        int _jspx_eval_aui_input_8 = _jspx_th_aui_input_8.doStartTag();
        if (_jspx_th_aui_input_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_8);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_8);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_9 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_9.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_9.setName("type");
        _jspx_th_aui_input_9.setType("hidden");
        _jspx_th_aui_input_9.setValue( selLayout.getType() );
        int _jspx_eval_aui_input_9 = _jspx_th_aui_input_9.doStartTag();
        if (_jspx_th_aui_input_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_9);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_9);
        out.write("\n");
        out.write("\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_10 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_10.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        _jspx_th_aui_input_10.setName( PortletDataHandlerKeys.SELECTED_LAYOUTS );
        _jspx_th_aui_input_10.setType("hidden");
        int _jspx_eval_aui_input_10 = _jspx_th_aui_input_10.doStartTag();
        if (_jspx_th_aui_input_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_type_name_nobody.reuse(_jspx_th_aui_input_10);
          return;
        }
        _jspx_tagPool_aui_input_type_name_nobody.reuse(_jspx_th_aui_input_10);
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t");
        //  liferay-frontend:edit-form-body
        com.liferay.frontend.taglib.servlet.taglib.EditFormBodyTag _jspx_th_liferay$1frontend_edit$1form$1body_0 = (com.liferay.frontend.taglib.servlet.taglib.EditFormBodyTag) _jspx_tagPool_liferay$1frontend_edit$1form$1body.get(com.liferay.frontend.taglib.servlet.taglib.EditFormBodyTag.class);
        _jspx_th_liferay$1frontend_edit$1form$1body_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1frontend_edit$1form$1body_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        int _jspx_eval_liferay$1frontend_edit$1form$1body_0 = _jspx_th_liferay$1frontend_edit$1form$1body_0.doStartTag();
        if (_jspx_eval_liferay$1frontend_edit$1form$1body_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_liferay$1ui_success_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1frontend_edit$1form$1body_0, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t");
          //  liferay-ui:error
          com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_0 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
          _jspx_th_liferay$1ui_error_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_error_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
          _jspx_th_liferay$1ui_error_0.setException( LayoutTypeException.class );
          int _jspx_eval_liferay$1ui_error_0 = _jspx_th_liferay$1ui_error_0.doStartTag();
          if (_jspx_eval_liferay$1ui_error_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            java.lang.Object errorException = null;
            if (_jspx_eval_liferay$1ui_error_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_liferay$1ui_error_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_liferay$1ui_error_0.doInitBody();
            }
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            do {
              out.write("\n");
              out.write("\n");
              out.write("\t\t\t\t\t");

					LayoutTypeException lte = (LayoutTypeException)errorException;

					String type = BeanParamUtil.getString(selLayout, request, "type");
					
              out.write("\n");
              out.write("\n");
              out.write("\t\t\t\t\t");
if (
 lte.getType() == LayoutTypeException.FIRST_LAYOUT ) {
              out.write("\n");
              out.write("\t\t\t\t\t\t");
              //  liferay-ui:message
              com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_1 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
              _jspx_th_liferay$1ui_message_1.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_0);
              _jspx_th_liferay$1ui_message_1.setArguments( Validator.isNull(lte.getLayoutType()) ? type : "layout.types." + lte.getLayoutType() );
              _jspx_th_liferay$1ui_message_1.setKey("the-first-page-cannot-be-of-type-x");
              int _jspx_eval_liferay$1ui_message_1 = _jspx_th_liferay$1ui_message_1.doStartTag();
              if (_jspx_th_liferay$1ui_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_1);
                return;
              }
              _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_1);
              out.write("\n");
              out.write("\t\t\t\t\t");
}
              out.write("\n");
              out.write("\n");
              out.write("\t\t\t\t\t");
if (
 lte.getType() == LayoutTypeException.FIRST_LAYOUT_PERMISSION ) {
              out.write("\n");
              out.write("\t\t\t\t\t\t");
              if (_jspx_meth_liferay$1ui_message_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_error_0, _jspx_page_context))
                return;
              out.write("\n");
              out.write("\t\t\t\t\t");
}
              out.write("\n");
              out.write("\n");
              out.write("\t\t\t\t\t");
if (
 lte.getType() == LayoutTypeException.NOT_INSTANCEABLE ) {
              out.write("\n");
              out.write("\t\t\t\t\t\t");
              //  liferay-ui:message
              com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_3 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
              _jspx_th_liferay$1ui_message_3.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_message_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_0);
              _jspx_th_liferay$1ui_message_3.setArguments( type );
              _jspx_th_liferay$1ui_message_3.setKey("pages-of-type-x-cannot-be-selected");
              int _jspx_eval_liferay$1ui_message_3 = _jspx_th_liferay$1ui_message_3.doStartTag();
              if (_jspx_th_liferay$1ui_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_3);
                return;
              }
              _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_3);
              out.write("\n");
              out.write("\t\t\t\t\t");
}
              out.write("\n");
              out.write("\n");
              out.write("\t\t\t\t\t");
if (
 lte.getType() == LayoutTypeException.NOT_PARENTABLE ) {
              out.write("\n");
              out.write("\t\t\t\t\t\t");
              //  liferay-ui:message
              com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_4 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
              _jspx_th_liferay$1ui_message_4.setPageContext(_jspx_page_context);
              _jspx_th_liferay$1ui_message_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_0);
              _jspx_th_liferay$1ui_message_4.setArguments( type );
              _jspx_th_liferay$1ui_message_4.setKey("pages-of-type-x-cannot-have-child-pages");
              int _jspx_eval_liferay$1ui_message_4 = _jspx_th_liferay$1ui_message_4.doStartTag();
              if (_jspx_th_liferay$1ui_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_4);
                return;
              }
              _jspx_tagPool_liferay$1ui_message_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_4);
              out.write("\n");
              out.write("\t\t\t\t\t");
}
              out.write("\n");
              out.write("\t\t\t\t");
              int evalDoAfterBody = _jspx_th_liferay$1ui_error_0.doAfterBody();
              errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_liferay$1ui_error_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_liferay$1ui_error_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_0);
            return;
          }
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_0);
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t");
          //  liferay-ui:error
          com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_1 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_exception_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
          _jspx_th_liferay$1ui_error_1.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_error_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
          _jspx_th_liferay$1ui_error_1.setException( LayoutNameException.class );
          _jspx_th_liferay$1ui_error_1.setMessage("please-enter-a-valid-name");
          int _jspx_eval_liferay$1ui_error_1 = _jspx_th_liferay$1ui_error_1.doStartTag();
          if (_jspx_th_liferay$1ui_error_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_1);
            return;
          }
          _jspx_tagPool_liferay$1ui_error_message_exception_nobody.reuse(_jspx_th_liferay$1ui_error_1);
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t");
          //  liferay-ui:error
          com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_2 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_exception.get(com.liferay.taglib.ui.ErrorTag.class);
          _jspx_th_liferay$1ui_error_2.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_error_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
          _jspx_th_liferay$1ui_error_2.setException( RequiredLayoutException.class );
          int _jspx_eval_liferay$1ui_error_2 = _jspx_th_liferay$1ui_error_2.doStartTag();
          if (_jspx_eval_liferay$1ui_error_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            java.lang.Object errorException = null;
            if (_jspx_eval_liferay$1ui_error_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_liferay$1ui_error_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_liferay$1ui_error_2.doInitBody();
            }
            errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
            do {
              out.write("\n");
              out.write("\n");
              out.write("\t\t\t\t\t");

					RequiredLayoutException rle = (RequiredLayoutException)errorException;
					
              out.write("\n");
              out.write("\n");
              out.write("\t\t\t\t\t");
if (
 rle.getType() == RequiredLayoutException.AT_LEAST_ONE ) {
              out.write("\n");
              out.write("\t\t\t\t\t\t");
              if (_jspx_meth_liferay$1ui_message_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_error_2, _jspx_page_context))
                return;
              out.write("\n");
              out.write("\t\t\t\t\t");
}
              out.write("\n");
              out.write("\t\t\t\t");
              int evalDoAfterBody = _jspx_th_liferay$1ui_error_2.doAfterBody();
              errorException = (java.lang.Object) _jspx_page_context.findAttribute("errorException");
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_liferay$1ui_error_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_liferay$1ui_error_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_2);
            return;
          }
          _jspx_tagPool_liferay$1ui_error_exception.reuse(_jspx_th_liferay$1ui_error_2);
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t");
if (
 layoutRevision != null ) {
          out.write("\n");
          out.write("\t\t\t\t\t");
          //  aui:input
          com.liferay.taglib.aui.InputTag _jspx_th_aui_input_11 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
          _jspx_th_aui_input_11.setPageContext(_jspx_page_context);
          _jspx_th_aui_input_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
          _jspx_th_aui_input_11.setName("layoutSetBranchId");
          _jspx_th_aui_input_11.setType("hidden");
          _jspx_th_aui_input_11.setValue( layoutRevision.getLayoutSetBranchId() );
          int _jspx_eval_aui_input_11 = _jspx_th_aui_input_11.doStartTag();
          if (_jspx_th_aui_input_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_11);
            return;
          }
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_11);
          out.write("\n");
          out.write("\t\t\t\t");
}
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t");
if (
 !group.isLayoutPrototype() && (selLayout != null) ) {
          out.write("\n");
          out.write("\t\t\t\t\t");
if (
 selGroup.hasLocalOrRemoteStagingGroup() && !selGroup.isStagingGroup() ) {
          out.write("\n");
          out.write("\t\t\t\t\t\t<div class=\"alert alert-warning\">\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_liferay$1ui_message_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1frontend_edit$1form$1body_0, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t");
}
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t\t");

					Group selLayoutGroup = selLayout.getGroup();
					
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t\t");
          out.write("\n");
          out.write("\t\t\t\t\t\t");
if (
 !SitesUtil.isLayoutUpdateable(selLayout) ) {
          out.write("\n");
          out.write("\t\t\t\t\t\t\t<div class=\"alert alert-warning\">\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_liferay$1ui_message_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1frontend_edit$1form$1body_0, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t");
          out.write("\n");
          out.write("\t\t\t\t\t\t");
}
else if (
 !SitesUtil.isLayoutDeleteable(selLayout) ) {
          out.write("\n");
          out.write("\t\t\t\t\t\t\t<div class=\"alert alert-warning\">\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_liferay$1ui_message_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1frontend_edit$1form$1body_0, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t");
          out.write("\n");
          out.write("\t\t\t\t\t");
}
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t\t");
if (
 (selLayout.getGroupId() != layoutsAdminDisplayContext.getGroupId()) && selLayoutGroup.isUserGroup() ) {
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t\t\t");

						UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(selLayoutGroup.getClassPK());
						
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t\t\t<div class=\"alert alert-warning\">\n");
          out.write("\t\t\t\t\t\t\t");
          //  liferay-ui:message
          com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_9 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.get(com.liferay.taglib.ui.MessageTag.class);
          _jspx_th_liferay$1ui_message_9.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_message_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
          _jspx_th_liferay$1ui_message_9.setArguments( HtmlUtil.escape(userGroup.getName()) );
          _jspx_th_liferay$1ui_message_9.setKey("this-page-cannot-be-modified-because-it-belongs-to-the-user-group-x");
          _jspx_th_liferay$1ui_message_9.setTranslateArguments( false );
          int _jspx_eval_liferay$1ui_message_9 = _jspx_th_liferay$1ui_message_9.doStartTag();
          if (_jspx_th_liferay$1ui_message_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_9);
            return;
          }
          _jspx_tagPool_liferay$1ui_message_translateArguments_key_arguments_nobody.reuse(_jspx_th_liferay$1ui_message_9);
          out.write("\n");
          out.write("\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t");
}
          out.write("\n");
          out.write("\t\t\t\t");
}
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t");
          //  liferay-frontend:form-navigator
          com.liferay.frontend.taglib.servlet.taglib.FormNavigatorTag _jspx_th_liferay$1frontend_form$1navigator_0 = (com.liferay.frontend.taglib.servlet.taglib.FormNavigatorTag) _jspx_tagPool_liferay$1frontend_form$1navigator_showButtons_id_formModelBean_nobody.get(com.liferay.frontend.taglib.servlet.taglib.FormNavigatorTag.class);
          _jspx_th_liferay$1frontend_form$1navigator_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1frontend_form$1navigator_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
          _jspx_th_liferay$1frontend_form$1navigator_0.setFormModelBean( selLayout );
          _jspx_th_liferay$1frontend_form$1navigator_0.setId( FormNavigatorConstants.FORM_NAVIGATOR_ID_LAYOUT );
          _jspx_th_liferay$1frontend_form$1navigator_0.setShowButtons( false );
          int _jspx_eval_liferay$1frontend_form$1navigator_0 = _jspx_th_liferay$1frontend_form$1navigator_0.doStartTag();
          if (_jspx_th_liferay$1frontend_form$1navigator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1frontend_form$1navigator_showButtons_id_formModelBean_nobody.reuse(_jspx_th_liferay$1frontend_form$1navigator_0);
            return;
          }
          _jspx_tagPool_liferay$1frontend_form$1navigator_showButtons_id_formModelBean_nobody.reuse(_jspx_th_liferay$1frontend_form$1navigator_0);
          out.write("\n");
          out.write("\t\t\t");
        }
        if (_jspx_th_liferay$1frontend_edit$1form$1body_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1frontend_edit$1form$1body.reuse(_jspx_th_liferay$1frontend_edit$1form$1body_0);
          return;
        }
        _jspx_tagPool_liferay$1frontend_edit$1form$1body.reuse(_jspx_th_liferay$1frontend_edit$1form$1body_0);
        out.write("\n");
        out.write("\n");
        out.write("\t\t\t");
        //  liferay-frontend:edit-form-footer
        com.liferay.frontend.taglib.servlet.taglib.EditFormFooterTag _jspx_th_liferay$1frontend_edit$1form$1footer_0 = (com.liferay.frontend.taglib.servlet.taglib.EditFormFooterTag) _jspx_tagPool_liferay$1frontend_edit$1form$1footer.get(com.liferay.frontend.taglib.servlet.taglib.EditFormFooterTag.class);
        _jspx_th_liferay$1frontend_edit$1form$1footer_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1frontend_edit$1form$1footer_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form_0);
        int _jspx_eval_liferay$1frontend_edit$1form$1footer_0 = _jspx_th_liferay$1frontend_edit$1form$1footer_0.doStartTag();
        if (_jspx_eval_liferay$1frontend_edit$1form$1footer_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\n");
          out.write("\t\t\t\t");
if (
 (selLayout.getGroupId() == layoutsAdminDisplayContext.getGroupId()) && SitesUtil.isLayoutUpdateable(selLayout) && LayoutPermissionUtil.contains(permissionChecker, selLayout, ActionKeys.UPDATE) ) {
          out.write("\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_aui_button_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1frontend_edit$1form$1footer_0, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t\t");
if (
 Validator.isNotNull(backURL) ) {
          out.write("\n");
          out.write("\t\t\t\t\t\t");
          //  aui:button
          com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_3 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_type_name_href_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
          _jspx_th_aui_button_3.setPageContext(_jspx_page_context);
          _jspx_th_aui_button_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1footer_0);
          _jspx_th_aui_button_3.setHref( backURL );
          _jspx_th_aui_button_3.setName("cancelButton");
          _jspx_th_aui_button_3.setType("cancel");
          int _jspx_eval_aui_button_3 = _jspx_th_aui_button_3.doStartTag();
          if (_jspx_th_aui_button_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_aui_button_type_name_href_nobody.reuse(_jspx_th_aui_button_3);
            return;
          }
          _jspx_tagPool_aui_button_type_name_href_nobody.reuse(_jspx_th_aui_button_3);
          out.write("\n");
          out.write("\t\t\t\t\t");
}
          out.write("\n");
          out.write("\t\t\t\t");
}
          out.write("\n");
          out.write("\t\t\t");
        }
        if (_jspx_th_liferay$1frontend_edit$1form$1footer_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1frontend_edit$1form$1footer.reuse(_jspx_th_liferay$1frontend_edit$1form$1footer_0);
          return;
        }
        _jspx_tagPool_liferay$1frontend_edit$1form$1footer.reuse(_jspx_th_liferay$1frontend_edit$1form$1footer_0);
        out.write("\n");
        out.write("\t\t");
      }
      if (_jspx_th_liferay$1frontend_edit$1form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1frontend_edit$1form_name_method_enctype_action.reuse(_jspx_th_liferay$1frontend_edit$1form_0);
        return;
      }
      _jspx_tagPool_liferay$1frontend_edit$1form_name_method_enctype_action.reuse(_jspx_th_liferay$1frontend_edit$1form_0);
      out.write('\n');
      out.write('	');
      out.write('\n');
}
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

  private boolean _jspx_meth_portlet_namespace_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_0 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
    int _jspx_eval_portlet_namespace_0 = _jspx_th_portlet_namespace_0.doStartTag();
    if (_jspx_th_portlet_namespace_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
    return false;
  }

  private boolean _jspx_meth_aui_button_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_button$1row_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_1 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_name_id_cssClass_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_button$1row_0);
    _jspx_th_aui_button_1.setCssClass("remove-layout");
    _jspx_th_aui_button_1.setId("deleteLayoutButton");
    _jspx_th_aui_button_1.setName("deleteLayout");
    _jspx_th_aui_button_1.setValue("delete-in-all-pages-variations");
    int _jspx_eval_aui_button_1 = _jspx_th_aui_button_1.doStartTag();
    if (_jspx_th_aui_button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_name_id_cssClass_nobody.reuse(_jspx_th_aui_button_1);
      return true;
    }
    _jspx_tagPool_aui_button_value_name_id_cssClass_nobody.reuse(_jspx_th_aui_button_1);
    return false;
  }

  private boolean _jspx_meth_portlet_param_4(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_actionURL_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_4 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_4.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_1);
    _jspx_th_portlet_param_4.setName("layoutSetBranchId");
    _jspx_th_portlet_param_4.setValue("0");
    int _jspx_eval_portlet_param_4 = _jspx_th_portlet_param_4.doStartTag();
    if (_jspx_th_portlet_param_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_script_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_1 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_1.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_1);
    int _jspx_eval_portlet_namespace_1 = _jspx_th_portlet_namespace_1.doStartTag();
    if (_jspx_th_portlet_namespace_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
    return false;
  }

  private boolean _jspx_meth_portlet_param_6(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_actionURL_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_6 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_6.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_2);
    _jspx_th_portlet_param_6.setName("mvcRenderCommandName");
    _jspx_th_portlet_param_6.setValue("/layout/edit_layout");
    int _jspx_eval_portlet_param_6 = _jspx_th_portlet_param_6.doStartTag();
    if (_jspx_th_portlet_param_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_success_0(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1frontend_edit$1form$1body_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:success
    com.liferay.taglib.ui.SuccessTag _jspx_th_liferay$1ui_success_0 = (com.liferay.taglib.ui.SuccessTag) _jspx_tagPool_liferay$1ui_success_message_key_nobody.get(com.liferay.taglib.ui.SuccessTag.class);
    _jspx_th_liferay$1ui_success_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_success_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
    _jspx_th_liferay$1ui_success_0.setKey("layoutAdded");
    _jspx_th_liferay$1ui_success_0.setMessage("the-page-was-created-succesfully");
    int _jspx_eval_liferay$1ui_success_0 = _jspx_th_liferay$1ui_success_0.doStartTag();
    if (_jspx_th_liferay$1ui_success_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_success_message_key_nobody.reuse(_jspx_th_liferay$1ui_success_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_success_message_key_nobody.reuse(_jspx_th_liferay$1ui_success_0);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_2(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_error_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_2 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_2.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_0);
    _jspx_th_liferay$1ui_message_2.setKey("you-cannot-delete-this-page-because-the-next-page-is-not-vieweable-by-unathenticated-users-and-so-cannot-be-the-first-page");
    int _jspx_eval_liferay$1ui_message_2 = _jspx_th_liferay$1ui_message_2.doStartTag();
    if (_jspx_th_liferay$1ui_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_2);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_2);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_5(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_error_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_5 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_5.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_error_2);
    _jspx_th_liferay$1ui_message_5.setKey("you-must-have-at-least-one-page");
    int _jspx_eval_liferay$1ui_message_5 = _jspx_th_liferay$1ui_message_5.doStartTag();
    if (_jspx_th_liferay$1ui_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_5);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_5);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_6(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1frontend_edit$1form$1body_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_6 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_6.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
    _jspx_th_liferay$1ui_message_6.setKey("changes-are-immediately-available-to-end-users");
    int _jspx_eval_liferay$1ui_message_6 = _jspx_th_liferay$1ui_message_6.doStartTag();
    if (_jspx_th_liferay$1ui_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_6);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_6);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_7(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1frontend_edit$1form$1body_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_7 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_7.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
    _jspx_th_liferay$1ui_message_7.setKey("this-page-cannot-be-modified-because-it-is-associated-to-a-site-template-does-not-allow-modifications-to-it");
    int _jspx_eval_liferay$1ui_message_7 = _jspx_th_liferay$1ui_message_7.doStartTag();
    if (_jspx_th_liferay$1ui_message_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_7);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_7);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_message_8(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1frontend_edit$1form$1body_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:message
    com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_8 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
    _jspx_th_liferay$1ui_message_8.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_message_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1body_0);
    _jspx_th_liferay$1ui_message_8.setKey("this-page-cannot-be-deleted-and-cannot-have-child-pages-because-it-is-associated-to-a-site-template");
    int _jspx_eval_liferay$1ui_message_8 = _jspx_th_liferay$1ui_message_8.doStartTag();
    if (_jspx_th_liferay$1ui_message_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_8);
      return true;
    }
    _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_8);
    return false;
  }

  private boolean _jspx_meth_aui_button_2(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1frontend_edit$1form$1footer_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_2 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_type_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1frontend_edit$1form$1footer_0);
    _jspx_th_aui_button_2.setType("submit");
    int _jspx_eval_aui_button_2 = _jspx_th_aui_button_2.doStartTag();
    if (_jspx_th_aui_button_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_type_nobody.reuse(_jspx_th_aui_button_2);
      return true;
    }
    _jspx_tagPool_aui_button_type_nobody.reuse(_jspx_th_aui_button_2);
    return false;
  }
}
