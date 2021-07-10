package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Solve_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/Login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"login\">\n");
      out.write("            <div class=\"left\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Left.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"homeMid\">\n");
      out.write("                <div class=\"homeTilte\"><h2>RequestID:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2> </div>\n");
      out.write("                <div class=\"Solve\">\n");
      out.write("                    <form action=\"Solve\" method=\"POST\">\n");
      out.write("                    <div class=\"department\" >Request to department <input type=\"text\" name=\"department\"></div>\n");
      out.write("                    <div class=\"studentID\" >Student ID <input  type=\"text\" name=\"studentID\"></div>\n");
      out.write("                    <div class=\"studentName\" >Student name <input type=\"text\" name=\"studentName\"></div>\n");
      out.write("                    <div class=\"dateCreated\" >Date created <input type=\"text\" name=\"dateCreated\"></div>\n");
      out.write("                    <div class=\"requestTitle\" >Request title <input type=\"text\" name=\"requestTitle\"></div>\n");
      out.write("                    <div class=\"requestContent\" ><p>Request content</p> <textarea style=\"margin: 0px; width: 300px; height: 50px;\" name=\"requestContent\"></textarea></div>\n");
      out.write("                    <div class=\"requestState\" >Request State <input id=\"Approved\" type=\"radio\" name=\"state\"><label class=\"Approved\" for=\"Approved\">Approved</label> <input id=\"Reject\" type=\"radio\" name=\"state\"> <label class=\"Reject\" for=\"Reject\">Reject</label> </div>\n");
      out.write("                    <div class=\"closeDate\" >Close date <input type=\"text\" name=\"closeDate\"></div>\n");
      out.write("                    <div class=\"admin\" >Solve by <input type=\"text\" name=\"admin\"></div>\n");
      out.write("                    <div class=\"solution\" ><p>School solution</p> <textarea required=\"required\" pattern=\"\\w{0,10}\" style=\"margin: 0px; width: 300px; height: 50px;\" name=\"solution\"></textarea></div>\n");
      out.write("                    <input type=\"submit\" value=\"Save\">\n");
      out.write("                </form>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
