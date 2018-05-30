package EC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ItemDao;
import beans.ItemDataBeans;

/**
 * Servlet implementation class masterItemList
 */
@WebServlet("/masterItemList")
public class masterItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public masterItemList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao itemDao = new ItemDao();
		ArrayList<ItemDataBeans> itemList = itemDao.findItem();
		request.setAttribute("itemList", itemList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/masterItemList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name =request.getParameter("name");
		String detail = request.getParameter("detail");

		try {
			ItemDao itemDao = new ItemDao();
			ArrayList<ItemDataBeans> itemList = itemDao.findItemList(name,detail);
			request.setAttribute("itemList", itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/masterItemList.jsp");
		dispatcher.forward(request, response);
	}

}
