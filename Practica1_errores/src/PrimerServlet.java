

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet("/PrimerServlet")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter salida = response.getWriter();
		
		salida.print("<p>Mensaje desde metodo Post</p>");
		
		String dato = request.getParameter("dato");
		String dato1 = request.getParameter("otro");
		
		salida.print("<p>Dato recibido: " + dato + "</p>");
		salida.print("<p>Dato recibido: " + dato1 + "</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter salida = response.getWriter();
		
		salida.print("<p>Mensaje desde metodo Post</p>");
		
		String usuario = request.getParameter("usuario");
		String clave =  request.getParameter("clave");
		
		salida.print("<p>Usuario ingresado "+usuario+"</p>");
		salida.print("Contraseņa ingresada "+clave+"</p>");
		
	}

}
