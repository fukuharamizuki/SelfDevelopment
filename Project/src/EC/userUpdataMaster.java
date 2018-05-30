package EC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import beans.UserDataBeans;

/**
 * Servlet implementation class userUpdataMaster
 */
@WebServlet("/userUpdataMaster")
public class userUpdataMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdataMaster() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));

		try {
			UserDataBeans userData = UserDao.findData(userId);
			request.setAttribute("userData", userData);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userUpdataMaster.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String loginId = request.getParameter("loginId");
			String password = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			String name = request.getParameter("name");
			String birthDate = request.getParameter("birthDate");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");

			UserDao userDao = new UserDao();
			UserDataBeans updataUser = userDao.userUpdata(loginId,password,password2,name,birthDate,address,tel);
			request.setAttribute("updataUser", updataUser);

			if (!password.equals(password2)) {

				request.setAttribute("errMsg", "入力された内容は正しくありません");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
				dispatcher.forward(request, response);
				return;
			}else {
				response.sendRedirect("userList");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
