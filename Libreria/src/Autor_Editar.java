

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

import beans.AutorBean;

/**
 * Servlet implementation class Autor_Editar
 */
@WebServlet("/Autor_Editar")
public class Autor_Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autor_Editar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String codigo = request.getParameter("codigo");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/libreria";
			Connection con = DriverManager.getConnection(url, "root", "root");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs =
					stmt.executeQuery("select * from autores where id=" + codigo);
			
			if( rs.next() ){
				AutorBean autor = new AutorBean();
				autor.setId( rs.getInt("id") );
				autor.setNombres( rs.getString("nombres") );
				autor.setApellidos( rs.getString("apellidos") );
				autor.setNacionalidad( rs.getString("nacionalidad") );
				
				request.setAttribute("objAutor", autor);
				getServletContext().getRequestDispatcher("/admin/autor_editar.jsp").forward(request, response);
			}else{
				request.setAttribute("mensaje", "Autor no encontrado");
				getServletContext().getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombres");
			String apellido = request.getParameter("apellidos");
			String nacionalidad = request.getParameter("nacionalidad");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/libreria";
			Connection con = DriverManager.getConnection(url, "root", "root");
			
			Statement stmt = con.createStatement();
			
			int filas = stmt.executeUpdate("update autores "
				+ " set nombres='" + nombre + "', "
				+ " apellidos='" + apellido + "', nacionalidad='" + nacionalidad + "' "
				+ " where id=" + id );
			
			if(filas == 1){
				request.setAttribute("mensaje", "Datos actualizados");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			getServletContext().getRequestDispatcher("/admin/resultado.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
