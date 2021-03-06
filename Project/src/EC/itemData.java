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
 * Servlet implementation class itemData
 */
@WebServlet("/itemData")
public class itemData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public itemData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//選択itemIdの取得
		int id = Integer.parseInt(request.getParameter("id"));
		ItemDao itemDao = new ItemDao();
		//item情報取得
		ItemDataBeans idb = itemDao.itemData(id);
		//item情報セット
		request.setAttribute("idb", idb);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/itemData.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
