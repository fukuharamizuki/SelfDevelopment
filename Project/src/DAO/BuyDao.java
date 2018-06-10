package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.BuyDataBeans;
import beans.ItemDataBeans;

public class BuyDao {

	/*
	 * 購入アイテム合計
	 * checkBuyItem.java
	 */
	public static int getTotalItemPrice(ArrayList<ItemDataBeans> items) {
		int total = 0;
		for (ItemDataBeans item : items) {
			total += item.getSubTotal();
		}
		return total;
	}

	/*
	 *DB:buyテーブルへ登録
	 *comfirmBuyItem.java
	 */
	public static int insertBuy(int id, BuyDataBeans bdb) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		int autoIncKey = -1;

		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("INSERT INTO buy(user_id,total_price,delivery_id,create_date,t_sale) VALUES(?,?,?,now(),?)",Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, id);
			st.setInt(2, bdb.getTotalPrice());
			st.setInt(3, bdb.getDeliveryId());
			st.setInt(4, bdb.getWaribiki());
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			return autoIncKey;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return autoIncKey;
	}
	/*
	 * 購入したitem,使用した配達方法の取得
	 * buyItemData.java,comfirmBuyItem.java
	 */
	public static BuyDataBeans getBuyDataBeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM buy"
							+ " JOIN delivery_method"
							+ " ON buy.delivery_id = delivery_method.id"
							+ " WHERE buy.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();

			BuyDataBeans bdb = new BuyDataBeans();
			if (rs.next()) {
				bdb.setId(rs.getInt("id"));
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setBuyDate(rs.getTimestamp("create_date"));
				bdb.setDeliveryId(rs.getInt("id"));
				bdb.setUserId(rs.getInt("user_id"));
				bdb.setDeliveryPrice(rs.getInt("delivery_price"));
				bdb.setDeliveryName(rs.getString("delivery_name"));
				bdb.setWaribiki(rs.getInt("t_sale"));
			}
			return bdb;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	/*
	 * userIdから購入itemの情報取得
	 *userData.java
	 */
	public static List<BuyDataBeans> getBuyItemList(int userId){
		Connection conn = null;
		PreparedStatement st = null;
		List<BuyDataBeans> itemList = new ArrayList<BuyDataBeans>();

		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement(
					"SELECT * FROM buy"
							+ " WHERE buy.user_id = ?");
			st.setInt(1, userId);
			ResultSet rs = st.executeQuery();

			 while (rs.next()) {
	                int id = rs.getInt("id");
	                int userId2 = rs.getInt("user_id");
	                int totalPrice = rs.getInt("total_price");
	                int deliveryId = rs.getInt("delivery_id");
	                Date createDate = rs.getDate("create_date");
	                BuyDataBeans bdb = new BuyDataBeans(id, userId2, totalPrice, deliveryId, createDate);
	                itemList.add(bdb);
	            }
	            return itemList;


		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
