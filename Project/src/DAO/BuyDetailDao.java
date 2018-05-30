package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyDetailBeans;
import beans.ItemDataBeans;

public class BuyDetailDao {

	public static void insertBuyDetail(BuyDetailBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO buy_detail(buy_id,item_id,count,buy_type,size) VALUES(?,?,?,?,?)");
			st.setInt(1, bdb.getBuyId());
			st.setInt(2, bdb.getItemId());
			st.setInt(3, bdb.getcount());
			st.setInt(4, bdb.getBuyType());
			st.setString(5, bdb.getSize());
			st.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<ItemDataBeans> getItemDataBeansListByBuyId(int buyId,int buytype) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM buy_detail"
							+ " JOIN item"
							+ " ON buy_detail.item_id = item.id"
							+ " WHERE buy_detail.buy_id = ?");

			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<ItemDataBeans> buyDetailItemList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {

				if(buytype == 1) {
					ItemDataBeans idb = new ItemDataBeans();
					idb.setId(rs.getInt("id"));
					idb.setName(rs.getString("name"));
					idb.setCount(rs.getInt("count"));
					idb.setSubTotal(rs.getInt("r_price")*rs.getInt("count"));
					idb.setSize(rs.getString("size"));
					buyDetailItemList.add(idb);
				}
				if(buytype == 2) {
					ItemDataBeans idb = new ItemDataBeans();
					idb.setId(rs.getInt("id"));
					idb.setName(rs.getString("name"));
					idb.setCount(rs.getInt("count"));
					idb.setSubTotal(rs.getInt("price")*rs.getInt("count"));
					idb.setSize(rs.getString("size"));
					buyDetailItemList.add(idb);
				}
			}
			return buyDetailItemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<ItemDataBeans> getItemDetail(int buyId){
		ArrayList<ItemDataBeans> buyDetailItemList = new ArrayList<ItemDataBeans>();

		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM buy_detail"
							+ " JOIN item"
							+ " ON buy_detail.item_id = item.id"
							+ " JOIN buy"
							+ " ON buy_detail.buy_id = buy.id"
							+ " JOIN delivery_method"
							+ " ON buy.delivery_id = delivery_method.id"
							+ " WHERE buy_detail.buy_id = ?");

			st.setInt(1, buyId);
			ResultSet rs = st.executeQuery();

			ArrayList<ItemDataBeans> buyDetailList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				if(rs.getInt("buy_type") == 1) {
					ItemDataBeans idb = new ItemDataBeans();
					idb.setId(rs.getInt("id"));
					idb.setName(rs.getString("name"));
					idb.setCount(rs.getInt("count"));
					idb.setSize(rs.getString("size"));
					idb.setSubTotal(rs.getInt("r_price")*rs.getInt("count"));
					idb.setBuyType(rs.getInt("buy_type"));
					buyDetailList.add(idb);
				}if(rs.getInt("buy_type") == 2) {
					ItemDataBeans idb = new ItemDataBeans();
					idb.setId(rs.getInt("id"));
					idb.setName(rs.getString("name"));
					idb.setCount(rs.getInt("count"));
					idb.setSize(rs.getString("size"));
					idb.setBuyType(rs.getInt("buy_type"));
					idb.setSubTotal(rs.getInt("price")*rs.getInt("count"));
					buyDetailList.add(idb);
				}
			}
			return buyDetailList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
