

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		
		getServletContext().getRequestDispatcher("/admin/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String usuario = request.getParameter("usuario");
			String clave = request.getParameter("clave");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/libreria";
			Connection con = DriverManager.getConnection(url, "root", "root");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from administradores "
					+ " where usuario='"+usuario+"' and clave='"+clave+"'");
			
			if(rs.next()){
				HttpSession sesion = request.getSession();
				sesion.setAttribute("nombre", rs.getString("nombre") );
				
				getServletContext().getRequestDispatcher("/admin/principal.jsp").forward(request, response);
				
			}else{
				request.setAttribute("mensaje", "Datos incorrectos");
				getServletContext().getRequestDispatcher("/admin/login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
