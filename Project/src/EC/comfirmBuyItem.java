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

import DAO.BuyDao;
import DAO.BuyDetailDao;
import beans.BuyDataBeans;
import beans.BuyDetailBeans;
import beans.ItemDataBeans;
import beans.UserDataBeans;

/**
 * Servlet implementation class comfirmBuyItem
 */
@WebServlet("/comfirmBuyItem")
public class comfirmBuyItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public comfirmBuyItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			BuyDataBeans idb = (BuyDataBeans) session.getAttribute("idb");
			UserDataBeans userInfo = (UserDataBeans) session.getAttribute("userInfo");

			int buyId = BuyDao.insertBuy(userInfo.getId(),idb);

			for (ItemDataBeans cartInItem : cart) {

				BuyDetailBeans bdb = new BuyDetailBeans();
				bdb.setBuyId(buyId);
				bdb.setItemId(cartInItem.getId());
				bdb.setSize(cartInItem.getSize());
				bdb.setItemCount(cartInItem.getCount());
				bdb.setBuyType(cartInItem.getBuyType());
				BuyDetailDao.insertBuyDetail(bdb);

			}

			BuyDataBeans resultBDB = BuyDao.getBuyDataBeansByBuyId(buyId);
			request.setAttribute("resultBDB", resultBDB);

			for (ItemDataBeans cartInItem : cart) {
				ArrayList<ItemDataBeans> buyIDBList = BuyDetailDao.getItemDataBeansListByBuyId(buyId,cartInItem.getBuyType());
				request.setAttribute("buyIDBList", buyIDBList);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/confirmBuyItem.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
