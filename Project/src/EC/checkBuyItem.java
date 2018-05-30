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
import DAO.DeliveryMethodDao;
import beans.BuyDataBeans;
import beans.DeliveryMethodBeans;
import beans.ItemDataBeans;
import beans.UserDataBeans;

/**
 * Servlet implementation class checkBuyItem
 */
@WebServlet("/checkBuyItem")
public class checkBuyItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final double SALE = 0.2;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkBuyItem() {
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
			int id = Integer.parseInt(request.getParameter("deliveryType"));

			DeliveryMethodDao dmd = new DeliveryMethodDao();
			DeliveryMethodBeans setDelivery = dmd.findDelivery(id);

			ArrayList<ItemDataBeans> cartIDBList = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			int totalPrice = BuyDao.getTotalItemPrice(cartIDBList) + setDelivery.getDeliveryPrice();

			BuyDataBeans idb = new BuyDataBeans();

			UserDataBeans userInfo = (UserDataBeans) session.getAttribute("userInfo");
			String userType = userInfo.getUserType();
			if(userType.equals("講師")) {
				idb.setWaribiki((int)(totalPrice * SALE));
			}

			idb.setTotalPrice(totalPrice - idb.getWaribiki());
			idb.setDeliveryId(setDelivery.getId());
			idb.setDeliveryName(setDelivery.getDeliveryName());
			idb.setDeliveryPrice(setDelivery.getDeliveryPrice());

			session.setAttribute("idb", idb);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/checkBuyItem.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
