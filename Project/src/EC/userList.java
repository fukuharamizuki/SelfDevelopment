package EC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import beans.UserDataBeans;

/**
 * Servlet implementation class userList
 */
@WebServlet("/userList")
public class userList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao =new UserDao();
		List<UserDataBeans> userList = userDao.findAll();

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("username");
		String birthDate1 = request.getParameter("birthdate1");
		String birthDate2 = request.getParameter("birthdate2");

		UserDao userDao = new UserDao();
		ArrayList<UserDataBeans> findUser = userDao.findUser(loginId,name,birthDate1,birthDate2);

		request.setAttribute("userList", findUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userList.jsp");
		dispatcher.forward(request, response);

	}

}
