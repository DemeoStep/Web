import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class Calc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        try {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Calculator</title>");
            writer.println("</head>");
            writer.println("<body>");

            double value1, value2;

            String oper = req.getParameter("oper");
            try {
                value1 = Double.parseDouble(req.getParameter("value1"));
                value2 = Double.parseDouble(req.getParameter("value2"));

                CalcOperations calc = new CalcOperations(value1, value2);

                switch (oper) {
                    case "add" : writer.println(calc.getOne() + " + " + calc.getTwo() + " = " + calc.add());
                        break;
                    case "sub": writer.println(calc.getOne() + " - " + calc.getTwo() + " = " + calc.sub());
                        break;
                    case "mult": writer.println(calc.getOne() + " * " + calc.getTwo() + " = " + calc.mult());
                        break;
                    case "div":
                        try {
                            writer.println(calc.getOne() + " / " + calc.getTwo() + " = " + calc.div());
                        } catch (ArithmeticException e) {
                            writer.println(e.getMessage());
                        }
                        break;
                    default: throw new Exception();
                }

            } catch (NumberFormatException e) {
                writer.println("Wrong input " + e.getMessage().toLowerCase(Locale.ROOT));
            }

        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            writer.println("</body");
            writer.println("</html>");
            writer.close();
        }

    }


}
