package EC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ItemDao;
import beans.ItemDataBeans;

/**
 * Servlet implementation class addCartDelete
 */
@WebServlet("/addCartDelete")
public class addCartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCartDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		ItemDao itemDao = new ItemDao();
		ItemDataBeans deleteItem = itemDao.itemData(id);
		request.setAttribute("deleteItem", deleteItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/addCartDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			int id = Integer.parseInt(request.getParameter("id"));
			for (ItemDataBeans cartInItem : cart) {
				if (cartInItem.getId() == id) {
					cart.remove(cartInItem);
					break;
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/addCart.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
