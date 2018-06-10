package EC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ItemDao;
import beans.ItemDataBeans;

/**
 * Servlet implementation class masterItemUpdata
 */
@WebServlet("/masterItemUpdata")
public class masterItemUpdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public masterItemUpdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//itemId取得
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			//item情報取得
			ItemDao itemDao = new ItemDao();
			ItemDataBeans idb = itemDao.itemData(id);
			request.setAttribute("idb", idb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/masterItemUpdata.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//更新情報の取得
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int rPrice = Integer.parseInt(request.getParameter("rPrice"));
		int price = Integer.parseInt(request.getParameter("price"));
		String detail = request.getParameter("detail");

		try {
			//DBのitem情報更新
			ItemDao itemDao = new ItemDao();
			ItemDataBeans itemUpData = itemDao.updataItem(id,rPrice,price,detail);

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("masterItemList");

	}

}
