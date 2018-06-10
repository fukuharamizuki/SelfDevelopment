package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.DeliveryMethodBeans;

public class DeliveryMethodDao {

	/*
	 * 配送方法の取得
	 * buyItem.java
	 */
	public static ArrayList <DeliveryMethodBeans> getAll() throws SQLException{
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement("SELECT * FROM delivery_method");

			ResultSet rs = st.executeQuery();

			ArrayList<DeliveryMethodBeans> deliveryMethodDataBeansList = new ArrayList<DeliveryMethodBeans>();
			while (rs.next()) {
				DeliveryMethodBeans dmdb = new DeliveryMethodBeans();
				dmdb.setId(rs.getInt("id"));
				dmdb.setDeliveryName(rs.getString("delivery_name"));
				dmdb.setDeliveryPrice(rs.getInt("delivery_price"));
				deliveryMethodDataBeansList.add(dmdb);
			}

			return deliveryMethodDataBeansList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}
	/*
	 * idから配送情報の取得
	 * checkBuyItem.java
	 */
	public DeliveryMethodBeans findDelivery(int id) {
		Connection conn = null;
		List<DeliveryMethodBeans> findDelivery = new ArrayList<DeliveryMethodBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM delivery_method WHERE id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int id2 = rs.getInt("id");
                String deliveryName = rs.getString("delivery_name");
                int deliveryPrice = rs.getInt("delivery_price");
                DeliveryMethodBeans dmb = new DeliveryMethodBeans(id2, deliveryName, deliveryPrice);

                return dmb;
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;


	}

}
