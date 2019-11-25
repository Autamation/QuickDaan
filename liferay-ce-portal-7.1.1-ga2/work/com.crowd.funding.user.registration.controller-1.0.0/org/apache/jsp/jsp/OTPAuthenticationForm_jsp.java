package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class OTPAuthenticationForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(7);
    _jspx_dependants.add("/jsp/init.jsp");
    _jspx_dependants.add("/META-INF/c.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet_2_0.tld");
    _jspx_dependants.add("/META-INF/liferay-aui.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet-ext.tld");
    _jspx_dependants.add("/META-INF/liferay-theme.tld");
    _jspx_dependants.add("/META-INF/liferay-ui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_validator_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_error_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_form_method_id_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_field$1wrapper_name_label;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_name_label_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id_checked;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_aui_validator_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_error_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_form_method_id_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_field$1wrapper_name_label = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_name_label_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_actionURL_var_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id_checked = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_aui_validator_name_nobody.release();
    _jspx_tagPool_liferay$1ui_error_message_key_nobody.release();
    _jspx_tagPool_aui_form_method_id_action.release();
    _jspx_tagPool_aui_field$1wrapper_name_label.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_aui_input_name_label_cssClass.release();
    _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id.release();
    _jspx_tagPool_portlet_actionURL_var_name_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id_checked.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
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

      out.write("<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\" />\r\n");
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
      out.write("<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("    $(\"#formID\").validate({\r\n");
      out.write("        rules : {\r\n");
      out.write("        \totpReceivingOption : {\r\n");
      out.write("                required : true                 \r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("    });\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name_nobody.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_0.setParent(null);
      _jspx_th_portlet_actionURL_0.setName("emailMobileRegistration");
      _jspx_th_portlet_actionURL_0.setVar("emailMobileRegistrationURL");
      int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
      if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_0);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_0);
      out.write("\r\n");
      out.write("\r\n");
      //  liferay-ui:error
      com.liferay.taglib.ui.ErrorTag _jspx_th_liferay$1ui_error_0 = (com.liferay.taglib.ui.ErrorTag) _jspx_tagPool_liferay$1ui_error_message_key_nobody.get(com.liferay.taglib.ui.ErrorTag.class);
      _jspx_th_liferay$1ui_error_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1ui_error_0.setParent(null);
      _jspx_th_liferay$1ui_error_0.setKey("error-key");
      _jspx_th_liferay$1ui_error_0.setMessage("Your Email Address is already registered. Please login.");
      int _jspx_eval_liferay$1ui_error_0 = _jspx_th_liferay$1ui_error_0.doStartTag();
      if (_jspx_th_liferay$1ui_error_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1ui_error_message_key_nobody.reuse(_jspx_th_liferay$1ui_error_0);
        return;
      }
      _jspx_tagPool_liferay$1ui_error_message_key_nobody.reuse(_jspx_th_liferay$1ui_error_0);
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_aui_form_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
    com.liferay.taglib.aui.FormTag _jspx_th_aui_form_0 = (com.liferay.taglib.aui.FormTag) _jspx_tagPool_aui_form_method_id_action.get(com.liferay.taglib.aui.FormTag.class);
    _jspx_th_aui_form_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_form_0.setParent(null);
    _jspx_th_aui_form_0.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${emailMobileRegistrationURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_form_0.setMethod("post");
    _jspx_th_aui_form_0.setDynamicAttribute(null, "id", new String("formID"));
    int _jspx_eval_aui_form_0 = _jspx_th_aui_form_0.doStartTag();
    if (_jspx_eval_aui_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"OTPAuthentication\" style=\"border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;\">\r\n");
      out.write("<center><h1 style=\"color:#0077A2;margin-left: 0px;\">REGISTRATION FORM </h1> </center>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      if (_jspx_meth_aui_input_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\t");
      if (_jspx_meth_aui_input_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t  ");
      if (_jspx_meth_aui_field$1wrapper_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t  <center><button type=\"submit\" style=\"background-color:#0077A2;border-radius: 22px;color:white;width: 108px;height: 39px;\">Send OTP</button></center>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
    }
    if (_jspx_th_aui_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_form_method_id_action.reuse(_jspx_th_aui_form_0);
      return true;
    }
    _jspx_tagPool_aui_form_method_id_action.reuse(_jspx_th_aui_form_0);
    return false;
  }

  private boolean _jspx_meth_aui_input_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_name_label_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_0.setCssClass("boxborder");
    _jspx_th_aui_input_0.setName("email");
    _jspx_th_aui_input_0.setLabel("Email ID");
    int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
    if (_jspx_eval_aui_input_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_aui_validator_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_0, _jspx_page_context))
        return true;
      if (_jspx_meth_aui_validator_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_0, _jspx_page_context))
        return true;
      out.write(' ');
    }
    if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_name_label_cssClass.reuse(_jspx_th_aui_input_0);
      return true;
    }
    _jspx_tagPool_aui_input_name_label_cssClass.reuse(_jspx_th_aui_input_0);
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
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_1 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_0);
    _jspx_th_aui_validator_1.setName("Email");
    int _jspx_eval_aui_validator_1 = _jspx_th_aui_validator_1.doStartTag();
    if (_jspx_th_aui_validator_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_1);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_1);
    return false;
  }

  private boolean _jspx_meth_aui_input_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_name_label_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_1.setCssClass("boxborder");
    _jspx_th_aui_input_1.setName("mobileNo");
    _jspx_th_aui_input_1.setLabel("Mobile No");
    int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
    if (_jspx_eval_aui_input_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_aui_validator_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_1, _jspx_page_context))
        return true;
      if (_jspx_meth_aui_validator_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_1, _jspx_page_context))
        return true;
    }
    if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_name_label_cssClass.reuse(_jspx_th_aui_input_1);
      return true;
    }
    _jspx_tagPool_aui_input_name_label_cssClass.reuse(_jspx_th_aui_input_1);
    return false;
  }

  private boolean _jspx_meth_aui_validator_2(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_2 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_1);
    _jspx_th_aui_validator_2.setName("required");
    int _jspx_eval_aui_validator_2 = _jspx_th_aui_validator_2.doStartTag();
    if (_jspx_th_aui_validator_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_2);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_2);
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
    _jspx_th_aui_validator_3.setName("number");
    int _jspx_eval_aui_validator_3 = _jspx_th_aui_validator_3.doStartTag();
    if (_jspx_th_aui_validator_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_3);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_3);
    return false;
  }

  private boolean _jspx_meth_aui_field$1wrapper_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:field-wrapper
    com.liferay.taglib.aui.FieldWrapperTag _jspx_th_aui_field$1wrapper_0 = (com.liferay.taglib.aui.FieldWrapperTag) _jspx_tagPool_aui_field$1wrapper_name_label.get(com.liferay.taglib.aui.FieldWrapperTag.class);
    _jspx_th_aui_field$1wrapper_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_field$1wrapper_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_field$1wrapper_0.setName("otpReceivingOption");
    _jspx_th_aui_field$1wrapper_0.setLabel("Please select your preferred option to receive the OTP ");
    int _jspx_eval_aui_field$1wrapper_0 = _jspx_th_aui_field$1wrapper_0.doStartTag();
    if (_jspx_eval_aui_field$1wrapper_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("<br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_aui_input_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_field$1wrapper_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_aui_input_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_field$1wrapper_0, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t    \r\n");
      out.write("\t    ");
    }
    if (_jspx_th_aui_field$1wrapper_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_field$1wrapper_name_label.reuse(_jspx_th_aui_field$1wrapper_0);
      return true;
    }
    _jspx_tagPool_aui_field$1wrapper_name_label.reuse(_jspx_th_aui_field$1wrapper_0);
    return false;
  }

  private boolean _jspx_meth_aui_input_2(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_field$1wrapper_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id_checked.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_field$1wrapper_0);
    _jspx_th_aui_input_2.setInlineLabel("left");
    _jspx_th_aui_input_2.setInlineField(true);
    _jspx_th_aui_input_2.setName("otpReceivingOption");
    _jspx_th_aui_input_2.setId("otpReceivingOption");
    _jspx_th_aui_input_2.setType("radio");
    _jspx_th_aui_input_2.setValue(new String("1"));
    _jspx_th_aui_input_2.setLabel("Email");
    _jspx_th_aui_input_2.setChecked(true);
    int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
    if (_jspx_eval_aui_input_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t    ");
    }
    if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id_checked.reuse(_jspx_th_aui_input_2);
      return true;
    }
    _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id_checked.reuse(_jspx_th_aui_input_2);
    return false;
  }

  private boolean _jspx_meth_aui_input_3(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_field$1wrapper_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_field$1wrapper_0);
    _jspx_th_aui_input_3.setInlineLabel("left");
    _jspx_th_aui_input_3.setInlineField(true);
    _jspx_th_aui_input_3.setName("otpReceivingOption");
    _jspx_th_aui_input_3.setId("otpReceivingOption");
    _jspx_th_aui_input_3.setType("radio");
    _jspx_th_aui_input_3.setValue(new String("0"));
    _jspx_th_aui_input_3.setLabel("Phone");
    int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
    if (_jspx_eval_aui_input_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("       ");
    }
    if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id.reuse(_jspx_th_aui_input_3);
      return true;
    }
    _jspx_tagPool_aui_input_value_type_name_label_inlineLabel_inlineField_id.reuse(_jspx_th_aui_input_3);
    return false;
  }
}
