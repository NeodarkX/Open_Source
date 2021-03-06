

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String correo = request.getParameter("correo");
		String clave1 = request.getParameter("clave1");
		String clave2 = request.getParameter("clave2");
		String sexo = request.getParameter("sexo");
		String carrera = request.getParameter("carrera");
		String interes[] = request.getParameterValues("interes");
		String lenguaje[] = request.getParameterValues("lenguaje");
		String mensaje = request.getParameter("mensaje");
		
		out.print("<p>Dato recibido: " + correo + "</p>");
		out.print("<p>Dato recibido: " + clave1 + "</p>");
		out.print("<p>Dato recibido: " + clave2 + "</p>");
		out.print("<p>Dato recibido: " + sexo + "</p>");
		out.print("<p>Dato recibido: " + carrera + "</p>");
		out.print("<p>Dato recibido: " + mensaje + "</p>");
		
		if(interes!=null){
			for (int i = 0; i < lenguaje.length; i++) {
				out.print("<p>Interes: " + interes[i] + "</p>");
			}
		}else{
			out.print("<p>No ha seleccionado intereses</p>");
		}
		
		if(lenguaje!=null){
			for (int i = 0; i < lenguaje.length; i++) {
				out.print("<p>Lenguaje: " + lenguaje[i] + "</p>");
			}
		}else{
			out.print("<p>No ha seleccionado lenguajes</p>");
		}
		
	}

}
