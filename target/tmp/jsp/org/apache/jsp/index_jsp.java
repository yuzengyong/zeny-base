package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("<html>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery-1.9.1.js\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>Hello World!</h2>\r\n");
      out.write("userId:<input type=\"text\" name=\"userId\" id=\"userId\"/><br>\r\n");
      out.write("userName:<input type=\"text\" name=\"userName\" id=\"userName\"/><br>\r\n");
      out.write("DATA:<textarea rows=\"10\" cols=\"100\" id=\"data\"></textarea><br>\r\n");
      out.write("<button onclick=\"submit()\">提交</button>\r\n");
      out.write("<div>-----------------------------------------------------<br>\r\n");
      out.write("response:<textarea rows=\"10\" cols=\"100\" id=\"response\"></textarea>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function submit(){\r\n");
      out.write("\t//var data = $('#data').val();\r\n");
      out.write("\t//var url = $('#url').val();\r\n");
      out.write("\t$.ajax({ \r\n");
      out.write("\t\turl: '/onLogin2', \r\n");
      out.write("\t\tdataType:\"json\",  \r\n");
      out.write("\t\ttype:'POST',\r\n");
      out.write("\t\tcontentType:'application/json',\r\n");
      out.write("\t\tdata:JSON.stringify({\r\n");
      out.write("\t\t\tid:$('#userId').val(),\r\n");
      out.write("\t\t\tname:$('#userName').val()\r\n");
      out.write("\t\t}), \r\n");
      out.write("\t\tsuccess: function(rel){\r\n");
      out.write("       \t\t$('#response').val(rel);\r\n");
      out.write("      }\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
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
}
