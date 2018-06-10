package EC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ItemDao;

/**
 * Servlet implementation class masterCreateItem
 */
@WebServlet("/masterCreateItem")
public class masterCreateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public masterCreateItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/masterCreateItem.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新しく登録するitem情報取得
		request.setCharacterEncoding("UTF-8");
		String itemName = request.getParameter("itemname");
		int rPrice = Integer.parseInt(request.getParameter("rPrice"));
		int price = Integer.parseInt(request.getParameter("price"));
		String detail = request.getParameter("detail");
		int type = Integer.parseInt(request.getParameter("type"));

		try {
			// DBに登録
			ItemDao.insertItem(itemName,rPrice,price,detail,type);
			response.sendRedirect("masterItemList");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
