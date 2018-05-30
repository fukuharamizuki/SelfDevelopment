package EC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BuyDao;
import DAO.BuyDetailDao;
import beans.BuyDataBeans;
import beans.ItemDataBeans;

/**
 * Servlet implementation class buyItemData
 */
@WebServlet("/buyItemData")
public class buyItemData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyItemData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int buyId = Integer.parseInt(request.getParameter("id"));

		try {
			ArrayList<ItemDataBeans> itemdetailList = BuyDetailDao.getItemDetail(buyId);
			request.setAttribute("itemdetailList", itemdetailList);

			BuyDataBeans resultBDB = BuyDao.getBuyDataBeansByBuyId(buyId);
			request.setAttribute("resultBDB", resultBDB);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/buyItemData.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
