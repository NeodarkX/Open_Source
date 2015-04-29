
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GeneroBean;
import beans.EditorialBean;
/**
 * Servlet implementation class Agregar_Libro
 */
@WebServlet("/Agregar_Libro")
public class Agregar_Libro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Agregar_Libro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/libreria";
			Connection con = DriverManager.getConnection(url, "root", "root");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idgenero, nombre, descripcion from genero");
	
			Vector<GeneroBean> generos = new Vector<GeneroBean>();
			
			GeneroBean genero = null;
			while(rs.next()){
				genero = new GeneroBean();
				genero.setId(rs.getInt("idgenero"));
				genero.setNombres(rs.getString("nombre"));
				genero.setDescripcion(rs.getString("descripcion"));
				generos.add(genero);
	
			}
			
			
			ResultSet rss = stmt.executeQuery("select ideditorial, nombres from editorial");
			Vector<EditorialBean> editorials = new Vector<EditorialBean>();
			EditorialBean editorial = null;
			while(rss.next()){
				editorial = new EditorialBean();
				editorial.setId(rss.getInt("ideditorial"));
				editorial.setNombres(rss.getString("nombres"));				
				editorials.add(editorial);
	
			}
			request.setAttribute("listaeditorials", editorials);
			request.setAttribute("listageneros", generos);

			
			getServletContext().getRequestDispatcher("/admin/libro_agregar.jsp").forward(request, response);
			
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
			String[] genero = request.getParameterValues("genero");
			String[] editorial = request.getParameterValues("editorial");
			String titulo = request.getParameter("titulos");
			String isbn = request.getParameter("ISBN");
			String sinopsis = request.getParameter("sinopsis");
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/libreria";
			Connection con = DriverManager.getConnection(url, "root", "root");
			
			Statement stmt = con.createStatement();
			
			int filas = stmt.executeUpdate("insert into libro"
					+ " (genero,editorial, titulo, isbn,sinopsis) "
					+ " values ('"+genero[0]+"', '"+editorial[0]+"', '"+titulo+"', '"+isbn+"', '"+sinopsis+"')");
			
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
