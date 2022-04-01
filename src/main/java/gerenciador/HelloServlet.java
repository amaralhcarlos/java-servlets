package gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Hello Servlet</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<P>Hello Servlet - Alura</P>");
		out.println("</BODY>");
		out.println("</HTML>");

	}

}
