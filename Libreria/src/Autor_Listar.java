

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

import beans.AutorBean;

/**
 * Servlet implementation class Autor_Listar
 */
@WebServlet("/Autor_Listar")
public class Autor_Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autor_Listar() {
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
			
			ResultSet rs = stmt.executeQuery("select id, nombres, apellidos from autores");
			
			//Vector<Integer> ids = new Vector<Integer>();
			//Vector<String> nombres = new Vector<String>();
			//Vector<String> apellidos = new Vector<String>();
			
			Vector<AutorBean> autores = new Vector<AutorBean>();
			AutorBean autor = null;
			while(rs.next()){
				autor = new AutorBean();
				autor.setId(rs.getInt("id"));
				autor.setNombres(rs.getString("nombres"));
				autor.setApellidos(rs.getString("apellidos"));
				
				autores.add(autor);
				//ids.add( rs.getInt("id") );
				//nombres.add( rs.getString("nombres") );
				//apellidos.add( rs.getString("apellidos") );
			}
			request.setAttribute("listaAutores", autores);
			//request.setAttribute("nombres", nombres);
			//request.setAttribute("apellidos", apellidos);
			
			getServletContext().getRequestDispatcher("/admin/autor_listar.jsp").forward(request, response);
			
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
	}

}
