package com.example.web;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<link rel=\"stylesheet\" href=\"css/css.css\">");
        writer.println("</head>");
            writer.println("<body width=\"50%\">");
            writer.println("<div>");
                writer.println("<h1 class=\"title\">" + "Секретный документ" + "</h1>");
                writer.println("<img src=\"img/java.png\" align=\"left\" hspace=\"40\" style=\"margin-right:50px; margin-left:20px\">");
                writer.println("<table border=\"1\" cellpadding=\"7\" cellspacing=\"0\">");
                    writer.println("<tr>");
                        writer.println("<td align=\"left\" width=\"200\"><h1 class=\"table-title\">Имя</h1></td>");
                        writer.println("<td align=\"left\" width=\"200\"><h1 class=\"table-title\">Телефон</h1></td>");
                    writer.println("</tr>");
                    writer.println("<tr>");
                        writer.println("<td align=\"left\" width=\"200\"><h1 class=\"table-entity\">Петр</h1></td>");
                        writer.println("<td align=\"left\" width=\"200\"><h1 class=\"table-entity\">555444</h1></td>");
                    writer.println("</tr>");
                writer.println("<tr>");
                    writer.println("<td align=\"left\" width=\"200\"><h1 class=\"table-entity\">Иван</h1></td>");
                    writer.println("<td align=\"left\" width=\"200\"><h1 class=\"table-entity\">111222</h1></td>");
                writer.println("</tr>");
                writer.println("</table>");
                writer.println("<br>");
                writer.println("<table border=\"0\">");
                    writer.println("<tr><td align=\"left\"><ul style=\"padding-left: 20px;\">");
                        for (int i = 1; i <= 3; i++) {
                            writer.println("<li> <h1 class=\"table-entity\">Текстовый документ " + i + "</h1></li>");
                        }
                    writer.println("</ul></td></tr>");
                writer.println("</table>");
                writer.println("</div>");
            writer.println("</body>");
        writer.println("</html>");
    }

}