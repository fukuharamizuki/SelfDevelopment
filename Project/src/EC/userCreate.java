package EC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;

/**
 * Servlet implementation class userCreate
 */
@WebServlet("/userCreate")
public class userCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("Id");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birthdate");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String usertype = request.getParameter("usertype");

		if (!password.equals(password2)) {

			request.setAttribute("errMsg", "パスワードが一致しません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userCreate.jsp");
			dispatcher.forward(request, response);
			return;

		}else if(loginId.equals("") || password.equals("") || password2.equals("") || name.equals("") || birthdate.equals("") || address.equals("") || tel.equals("")) {

			request.setAttribute("errMsg", "すべての項目を入力してください");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userCreate.jsp");
			dispatcher.forward(request, response);
			return;

		}else {
			UserDao.registrationUser(loginId,password,password2,name,birthdate,address,tel,usertype);
			response.sendRedirect("login");
		}
	}
}
