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
			//選択された配達方法のid取得
			int id = Integer.parseInt(request.getParameter("deliveryType"));
			//配達idから配送情報の取得
			DeliveryMethodDao dmd = new DeliveryMethodDao();
			DeliveryMethodBeans setDelivery = dmd.findDelivery(id);
			//カート取得
			ArrayList<ItemDataBeans> cartIDBList = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			//カート内アイテム合計金額+配送料
			int totalPrice = BuyDao.getTotalItemPrice(cartIDBList) + setDelivery.getDeliveryPrice();

			BuyDataBeans idb = new BuyDataBeans();
			//ログインしているユーザー情報の取得
			UserDataBeans userInfo = (UserDataBeans) session.getAttribute("userInfo");
			//ユーザータイプの取得
			String userType = userInfo.getUserType();
			//ユーザーが講師の場合の割引
			if(userType.equals("講師")) {
				idb.setWaribiki((int)(totalPrice * SALE));
			}
			idb.setTotalPrice(totalPrice - idb.getWaribiki());
			idb.setDeliveryId(setDelivery.getId());
			idb.setDeliveryName(setDelivery.getDeliveryName());
			idb.setDeliveryPrice(setDelivery.getDeliveryPrice());
			//購入予定のアイテム合計、配送方法の保存
			session.setAttribute("idb", idb);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/checkBuyItem.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
