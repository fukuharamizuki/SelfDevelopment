package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ItemDataBeans;

public class ItemDao {

	public List<ItemDataBeans> itemData(String id){

		Connection conn = null;
        List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();


		try {
			conn = DBManager.getConnection();

			 String sql = "SELECT * FROM item WHERE type = ?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1,id);
	            ResultSet rs = pStmt.executeQuery();

	            while (rs.next()) {
	                int id2 = rs.getInt("id");
	                String name = rs.getString("name");
	                String detail = rs.getString("detail");
	                int price = rs.getInt("price");
	                int rPrice = rs.getInt("r_price");
	                String file = rs.getString("file_name");
	                String type = rs.getString("type");
	                ItemDataBeans idb = new ItemDataBeans(id2, name, detail, price, rPrice, file, type);
	                itemList.add(idb);
	            }
	            return itemList;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return itemList;
	}

	public ItemDataBeans itemData(int id) {
		Connection conn = null;
		List<ItemDataBeans> itemData = new ArrayList<ItemDataBeans>();

		try {
			conn = DBManager.getConnection();

            String sql = "SELECT * FROM item WHERE id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int id2 = rs.getInt("id");
                String name = rs.getString("name");
                String detail = rs.getString("detail");
                int price = rs.getInt("price");
                int rPrice = rs.getInt("r_price");
                String fileName = rs.getString("file_name");
                String type = rs.getString("type");

                ItemDataBeans idb = new ItemDataBeans(id2,name,detail,price,rPrice,fileName,type);

                return idb;
            }

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public ItemDataBeans addCart(int id,String buytype,String size,int count) {
		Connection conn = null;
		List<ItemDataBeans> itemData = new ArrayList<ItemDataBeans>();

		try {
			conn = DBManager.getConnection();

            String sql = "SELECT * FROM item WHERE id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int id2 = rs.getInt("id");
                String name = rs.getString("name");
                String detail = rs.getString("detail");
                int price = rs.getInt("price");
                int rPrice = rs.getInt("r_price");
                String fileName = rs.getString("file_name");
                String type = rs.getString("type");

                if(buytype.equals("レンタル")) {
                		int buyType = 1;
                		int subTotal = rPrice * count;
	                	ItemDataBeans addItem = new ItemDataBeans(id2,name,detail,rPrice,fileName,type,size,count,subTotal,buyType);
	                    return addItem;
                }if(buytype.equals("購入")) {
                		int buyType = 2;
                		int subTotal = price * count;
	                	ItemDataBeans addItem = new ItemDataBeans(id2,name,detail,price,fileName,type,size,count,subTotal,buyType);
	                    return addItem;

                }

            }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ItemDataBeans> findItem(){
		Connection conn = null;
		ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM item ";

			 PreparedStatement pStmt = conn.prepareStatement(sql);
	         ResultSet rs = pStmt.executeQuery();

	         while (rs.next()) {
	                int id2 = rs.getInt("id");
	                String name = rs.getString("name");
	                String detail = rs.getString("detail");
	                int price = rs.getInt("price");
	                int rPrice = rs.getInt("r_price");
	                String file = rs.getString("file_name");
	                String type = rs.getString("type");
	                ItemDataBeans idb = new ItemDataBeans(id2, name, detail, price, rPrice, file, type);
	                itemList.add(idb);
	            }
	            return itemList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ItemDataBeans insertItem(String name, int rPrice, int price, String detail, int type) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql ="INSERT INTO item(name,detail,price,r_price,type) VALUES(?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, name);
            pStmt.setString(2, detail);
            pStmt.setInt(3, price);
            pStmt.setInt(4, rPrice);
            pStmt.setInt(5, type);
            pStmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
    }
	public ItemDataBeans updataItem(int id, int rPrice, int price, String detail) {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<ItemDataBeans> updateItem = new ArrayList<ItemDataBeans>();

		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement("UPDATE item SET detail = ?,price = ?,r_price = ? WHERE id = ?");

			st.setString(1, detail);
            st.setInt(2, price);
            st.setInt(3, rPrice);
            st.setInt(4, id);
            st.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public ItemDataBeans deleteItem(int id) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM item WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ItemDataBeans> findItemList(String name, String detail){
		Connection conn = null;
		ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

		try {
			 conn = DBManager.getConnection();
			 String sql = "SELECT * FROM item where id > 0";

			 if(!name.equals("")) {
				 sql += " and name like '%" + name + "%'";
			 }if(!detail.equals("")) {
				 sql += " and detail like '%" + detail + "%'";
			 }

			 System.out.println(sql);

			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name1 = rs.getString("name");
	                String detail1 = rs.getString("detail");
	                int price = rs.getInt("price");
	                int rPrice = rs.getInt("r_price");
	                ItemDataBeans idb = new ItemDataBeans(id, name1, detail1, price, rPrice);

	                itemList.add(idb);
	            }
	            return itemList;


		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ItemDataBeans> searchItem(String search){
		Connection conn = null;
		ArrayList <ItemDataBeans> itemList = new ArrayList <ItemDataBeans>();

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM item where id > 0 and (name like '%search%' or detail like '%search%')";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name1 = rs.getString("name");
	                String detail1 = rs.getString("detail");
	                int price = rs.getInt("price");
	                int rPrice = rs.getInt("r_price");
	                ItemDataBeans idb = new ItemDataBeans(id, name1, detail1, price, rPrice);

	                itemList.add(idb);
	            }
	            return itemList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
