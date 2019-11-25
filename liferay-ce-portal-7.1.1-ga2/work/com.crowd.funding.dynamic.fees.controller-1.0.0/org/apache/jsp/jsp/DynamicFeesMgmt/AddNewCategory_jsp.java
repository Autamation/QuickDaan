package org.apache.jsp.jsp.DynamicFeesMgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddNewCategory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/init.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_form_method_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_type_pattern_name_label_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_validator_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_validator_name_errorMessage_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_type_style_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_validator_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_type_name_label_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_type_style_onClick_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_aui_form_method_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_type_pattern_name_label_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_validator_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_validator_name_errorMessage_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_type_style_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_validator_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_actionURL_var_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_type_name_label_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_type_style_onClick_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_aui_form_method_action.release();
    _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.release();
    _jspx_tagPool_aui_validator_name_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_aui_validator_name_errorMessage_nobody.release();
    _jspx_tagPool_aui_button_value_type_style_nobody.release();
    _jspx_tagPool_aui_validator_name.release();
    _jspx_tagPool_portlet_actionURL_var_name_nobody.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_aui_input_type_name_label_cssClass.release();
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
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".AddNewCategory{\r\n");
      out.write(" border: 1px solid #7FBD2C;\r\n");
      out.write(" box-shadow: 0 0 10px 1px #7FBD2C;\r\n");
      out.write(" border-style: solid;\r\n");
      out.write(" border-color:white;\r\n");
      out.write(" margin-top: -4px;\r\n");
      out.write(" background-color:white;\r\n");
      out.write(" margin:40px; \r\n");
      out.write(" padding: 50px;\r\n");
      out.write(" width: 520px;\r\n");
      out.write(" margin-left: 25%\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".box{\r\n");
      out.write("border-color: #7FBD2C; \r\n");
      out.write("border-radius:12px; \r\n");
      out.write("border-bottom:3px solid #7FBD2C;\r\n");
      out.write("}\r\n");
      out.write("</style>\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("<div class=\"AddNewCategory\">\r\n");
      out.write("<center><h1 style=\"color:#0077A2;\">DYNAMIC FEE REGISTRATION</h1></center></br>\r\n");
      out.write("\r\n");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name_nobody.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_0.setParent(null);
      _jspx_th_portlet_actionURL_0.setName("CreateCategoryDetails");
      _jspx_th_portlet_actionURL_0.setVar("CreateCategoryDetailsURL");
      int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
      if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_0);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_0);
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_aui_form_0(_jspx_page_context))
        return;
      out.write("\r\n");
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

  private boolean _jspx_meth_aui_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:form
    com.liferay.taglib.aui.FormTag _jspx_th_aui_form_0 = (com.liferay.taglib.aui.FormTag) _jspx_tagPool_aui_form_method_action.get(com.liferay.taglib.aui.FormTag.class);
    _jspx_th_aui_form_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_form_0.setParent(null);
    _jspx_th_aui_form_0.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${CreateCategoryDetailsURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_form_0.setMethod("post");
    int _jspx_eval_aui_form_0 = _jspx_th_aui_form_0.doStartTag();
    if (_jspx_eval_aui_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_input_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      if (_jspx_meth_aui_input_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      if (_jspx_meth_aui_input_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      if (_jspx_meth_aui_input_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      if (_jspx_meth_aui_button_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_button_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\r\n");
    }
    if (_jspx_th_aui_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_form_method_action.reuse(_jspx_th_aui_form_0);
      return true;
    }
    _jspx_tagPool_aui_form_method_action.reuse(_jspx_th_aui_form_0);
    return false;
  }

  private boolean _jspx_meth_aui_input_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_type_name_label_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_0.setCssClass("box");
    _jspx_th_aui_input_0.setType("text");
    _jspx_th_aui_input_0.setName("categoryName");
    _jspx_th_aui_input_0.setLabel("Category Name");
    int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
    if (_jspx_eval_aui_input_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_aui_validator_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
    }
    if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_type_name_label_cssClass.reuse(_jspx_th_aui_input_0);
      return true;
    }
    _jspx_tagPool_aui_input_type_name_label_cssClass.reuse(_jspx_th_aui_input_0);
    return false;
  }

  private boolean _jspx_meth_aui_validator_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_0 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_0);
    _jspx_th_aui_validator_0.setName("required");
    int _jspx_eval_aui_validator_0 = _jspx_th_aui_validator_0.doStartTag();
    if (_jspx_th_aui_validator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_0);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_0);
    return false;
  }

  private boolean _jspx_meth_aui_validator_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_1 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_errorMessage_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_0);
    _jspx_th_aui_validator_1.setName("alpha");
    _jspx_th_aui_validator_1.setErrorMessage("Enter only charaters.");
    int _jspx_eval_aui_validator_1 = _jspx_th_aui_validator_1.doStartTag();
    if (_jspx_th_aui_validator_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_errorMessage_nobody.reuse(_jspx_th_aui_validator_1);
      return true;
    }
    _jspx_tagPool_aui_validator_name_errorMessage_nobody.reuse(_jspx_th_aui_validator_1);
    return false;
  }

  private boolean _jspx_meth_aui_input_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_1.setCssClass("box");
    _jspx_th_aui_input_1.setDynamicAttribute(null, "pattern", new String("^100(\\.0{1,2})?$"));
    _jspx_th_aui_input_1.setType("number");
    _jspx_th_aui_input_1.setName("processFees");
    _jspx_th_aui_input_1.setLabel("Processing Fees(%)");
    int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
    if (_jspx_eval_aui_input_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_1, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_aui_validator_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_1, _jspx_page_context))
        return true;
      out.write("    \r\n");
      out.write("    ");
      if (_jspx_meth_aui_validator_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_1, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
    }
    if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.reuse(_jspx_th_aui_input_1);
      return true;
    }
    _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.reuse(_jspx_th_aui_input_1);
    return false;
  }

  private boolean _jspx_meth_aui_validator_2(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_2 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_errorMessage_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_1);
    _jspx_th_aui_validator_2.setName("required");
    _jspx_th_aui_validator_2.setErrorMessage("Enter only one point");
    int _jspx_eval_aui_validator_2 = _jspx_th_aui_validator_2.doStartTag();
    if (_jspx_th_aui_validator_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_errorMessage_nobody.reuse(_jspx_th_aui_validator_2);
      return true;
    }
    _jspx_tagPool_aui_validator_name_errorMessage_nobody.reuse(_jspx_th_aui_validator_2);
    return false;
  }

  private boolean _jspx_meth_aui_validator_3(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_3 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_3.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_1);
    _jspx_th_aui_validator_3.setName("digit");
    int _jspx_eval_aui_validator_3 = _jspx_th_aui_validator_3.doStartTag();
    if (_jspx_th_aui_validator_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_3);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_3);
    return false;
  }

  private boolean _jspx_meth_aui_validator_4(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_4 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_4.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_1);
    _jspx_th_aui_validator_4.setName("range");
    int _jspx_eval_aui_validator_4 = _jspx_th_aui_validator_4.doStartTag();
    if (_jspx_eval_aui_validator_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_aui_validator_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_aui_validator_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_aui_validator_4.doInitBody();
      }
      do {
        out.write("[0,100]");
        int evalDoAfterBody = _jspx_th_aui_validator_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_aui_validator_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_aui_validator_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_4);
      return true;
    }
    _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_4);
    return false;
  }

  private boolean _jspx_meth_aui_input_2(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_2.setCssClass("box");
    _jspx_th_aui_input_2.setDynamicAttribute(null, "pattern", new String("^100(\\.0{1,2})?$"));
    _jspx_th_aui_input_2.setType("number");
    _jspx_th_aui_input_2.setName("projectFees");
    _jspx_th_aui_input_2.setLabel("Project Fees(%)");
    int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
    if (_jspx_eval_aui_input_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_2, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_aui_validator_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_2, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_aui_validator_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_2, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
    }
    if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.reuse(_jspx_th_aui_input_2);
      return true;
    }
    _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.reuse(_jspx_th_aui_input_2);
    return false;
  }

  private boolean _jspx_meth_aui_validator_5(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_5 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_errorMessage_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_5.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_2);
    _jspx_th_aui_validator_5.setName("required");
    _jspx_th_aui_validator_5.setErrorMessage("Enter only one point");
    int _jspx_eval_aui_validator_5 = _jspx_th_aui_validator_5.doStartTag();
    if (_jspx_th_aui_validator_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_errorMessage_nobody.reuse(_jspx_th_aui_validator_5);
      return true;
    }
    _jspx_tagPool_aui_validator_name_errorMessage_nobody.reuse(_jspx_th_aui_validator_5);
    return false;
  }

  private boolean _jspx_meth_aui_validator_6(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_6 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_6.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_2);
    _jspx_th_aui_validator_6.setName("digit");
    int _jspx_eval_aui_validator_6 = _jspx_th_aui_validator_6.doStartTag();
    if (_jspx_th_aui_validator_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_6);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_6);
    return false;
  }

  private boolean _jspx_meth_aui_validator_7(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_7 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_7.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_2);
    _jspx_th_aui_validator_7.setName("range");
    int _jspx_eval_aui_validator_7 = _jspx_th_aui_validator_7.doStartTag();
    if (_jspx_eval_aui_validator_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_aui_validator_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_aui_validator_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_aui_validator_7.doInitBody();
      }
      do {
        out.write("[0,100]");
        int evalDoAfterBody = _jspx_th_aui_validator_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_aui_validator_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_aui_validator_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_7);
      return true;
    }
    _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_7);
    return false;
  }

  private boolean _jspx_meth_aui_input_3(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_3.setCssClass("box");
    _jspx_th_aui_input_3.setDynamicAttribute(null, "pattern", new String("^100(\\.0{1,2})?$"));
    _jspx_th_aui_input_3.setType("number");
    _jspx_th_aui_input_3.setName("paymentGateway");
    _jspx_th_aui_input_3.setLabel("Payment Gateway(%)");
    int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
    if (_jspx_eval_aui_input_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_3, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_aui_validator_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_3, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_aui_validator_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_3, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
    }
    if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.reuse(_jspx_th_aui_input_3);
      return true;
    }
    _jspx_tagPool_aui_input_type_pattern_name_label_cssClass.reuse(_jspx_th_aui_input_3);
    return false;
  }

  private boolean _jspx_meth_aui_validator_8(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_8 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_errorMessage_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_8.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_3);
    _jspx_th_aui_validator_8.setName("required");
    _jspx_th_aui_validator_8.setErrorMessage("Enter only one point");
    int _jspx_eval_aui_validator_8 = _jspx_th_aui_validator_8.doStartTag();
    if (_jspx_th_aui_validator_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_errorMessage_nobody.reuse(_jspx_th_aui_validator_8);
      return true;
    }
    _jspx_tagPool_aui_validator_name_errorMessage_nobody.reuse(_jspx_th_aui_validator_8);
    return false;
  }

  private boolean _jspx_meth_aui_validator_9(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_9 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_9.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_3);
    _jspx_th_aui_validator_9.setName("digit ");
    int _jspx_eval_aui_validator_9 = _jspx_th_aui_validator_9.doStartTag();
    if (_jspx_th_aui_validator_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_9);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_9);
    return false;
  }

  private boolean _jspx_meth_aui_validator_10(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_10 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_10.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_3);
    _jspx_th_aui_validator_10.setName("range");
    int _jspx_eval_aui_validator_10 = _jspx_th_aui_validator_10.doStartTag();
    if (_jspx_eval_aui_validator_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_aui_validator_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_aui_validator_10.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_aui_validator_10.doInitBody();
      }
      do {
        out.write("[0,100]");
        int evalDoAfterBody = _jspx_th_aui_validator_10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_aui_validator_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_aui_validator_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_10);
      return true;
    }
    _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_10);
    return false;
  }

  private boolean _jspx_meth_aui_button_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_style_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_button_0.setType("submit");
    _jspx_th_aui_button_0.setValue("Submit");
    _jspx_th_aui_button_0.setDynamicAttribute(null, "style", new String("background-color: #0077A2;margin-left: 35%; border-radius:22px"));
    int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
    if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_style_nobody.reuse(_jspx_th_aui_button_0);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_style_nobody.reuse(_jspx_th_aui_button_0);
    return false;
  }

  private boolean _jspx_meth_aui_button_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_1 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_style_onClick_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_button_1.setType("cancel");
    _jspx_th_aui_button_1.setValue("cancel");
    _jspx_th_aui_button_1.setOnClick("window.history.back();");
    _jspx_th_aui_button_1.setDynamicAttribute(null, "style", new String("border-radius:22px;"));
    int _jspx_eval_aui_button_1 = _jspx_th_aui_button_1.doStartTag();
    if (_jspx_th_aui_button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_style_onClick_nobody.reuse(_jspx_th_aui_button_1);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_style_onClick_nobody.reuse(_jspx_th_aui_button_1);
    return false;
  }
}
