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
		//userId取得
		int userId = Integer.parseInt(request.getParameter("id"));
		try {
			//user情報取得
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
			//user更新情報の取得
			request.setCharacterEncoding("UTF-8");
			String loginId = request.getParameter("loginId");
			String password = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			String name = request.getParameter("name");
			String birthDate = request.getParameter("birthDate");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String usertype = request.getParameter("usertype");

			if (!password.equals(password2)) {

				request.setAttribute("errMsg", "パスワードが一致しません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userUpdataMaster.jsp");
				dispatcher.forward(request, response);

				return;
			}else {
				UserDao userDao = new UserDao();
				//DBのuser情報更新
				UserDataBeans updataUser = userDao.userUpdata(loginId,password,password2,name,birthDate,address,tel,usertype);
				request.setAttribute("updataUser", updataUser);
				response.sendRedirect("userList");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
