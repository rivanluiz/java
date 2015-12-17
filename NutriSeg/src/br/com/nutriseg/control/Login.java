package br.com.nutriseg.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jcommon.encryption.SimpleMD5;

import br.com.nutriseg.model.User;
import br.com.nutriseg.persistence.UserDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			SimpleMD5 md5 = new SimpleMD5(password, "11");
			User user = new User(email, md5.toHexString());
			
			UserDao ud = new UserDao();
			
			String result = ud.login(user);
			if(result.equalsIgnoreCase("SUCCESS")){
				HttpSession session = request.getSession();
				User userLogged = ud.buscarLogin(email);
				
				session.setAttribute("id", userLogged.getIdUser());
				session.setAttribute("login", userLogged.getEmail());
				session.setAttribute("name", userLogged.getName());
				
				response.sendRedirect("admin/");
			}else{
				request.setAttribute("msg", "<div class='alert alert-info'>" + result + 
						"</div>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
