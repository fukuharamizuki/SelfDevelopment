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
import beans.UserDataBeans;
import common.Common;

public class UserDao {

	public UserDataBeans findLogin (String loginId, String password) {
		List<UserDataBeans> userList = new ArrayList<UserDataBeans>();

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement("SELECT * FROM user WHERE login_id = ? and login_pass = ?");

			st.setString(1, loginId);
	        st.setString(2, Common.password(password));
	        ResultSet rs = st.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String address = rs.getString("address");
	            String tel = rs.getString("tel");
	            Date birthDate = rs.getDate("birth_date");
	            String loginId1 = rs.getString("login_id");
	            String loginPassword = rs.getString("login_pass");
	            String userType = rs.getString("user_type");
	            UserDataBeans loginUser = new UserDataBeans(id, name, address, tel, birthDate, loginId1, loginPassword,userType);
	            return loginUser;
	        }
		}catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
		return null;
    }
	public static UserDataBeans findData(int userId) {
		Connection conn = null;
		 List<UserDataBeans> userList = new ArrayList<UserDataBeans>();

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,userId);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String tel = rs.getString("tel");
                Date birthDate = rs.getDate("birth_date");
                String loginId = rs.getString("login_id");
                String loginPassword = rs.getString("login_pass");
                String userType = rs.getString("user_type");
                UserDataBeans udb2 = new UserDataBeans(id, name, address, tel, birthDate, loginId, loginPassword,userType);
                return udb2;
            }

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
	public static void registrationUser(String loginId, String password, String password2, String name,
			String birthDate, String address, String tel, String userType) {

		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql ="INSERT INTO user(name,address,tel,birth_date, login_id,login_pass,user_type) VALUES(?,?,?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, name);
            pStmt.setString(2, address);
            pStmt.setString(3, tel);
            pStmt.setString(4, birthDate);
            pStmt.setString(5, loginId);
            pStmt.setString(6, Common.password(password));
            pStmt.setString(7, userType);

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
    }
	public List<UserDataBeans> findAll() {
        Connection conn = null;
        List<UserDataBeans> userList = new ArrayList<UserDataBeans>();

        try {

            conn = DBManager.getConnection();

            String sql = "SELECT * FROM user where login_id not in ('admin')";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String tel = rs.getString("tel");
                Date birthDate = rs.getDate("birth_date");
                String loginId = rs.getString("login_id");
                String password = rs.getString("login_pass");
                String userType = rs.getString("user_type");
                UserDataBeans user = new UserDataBeans(id, name, address, tel, birthDate, loginId, password,userType);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	public UserDataBeans userUpdata(String loginId ,String password ,String password2,String name,String birthDate,String address,String tel) {
		List<UserDataBeans> userUpdata = new ArrayList<UserDataBeans>();

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement("UPDATE user SET name = ?,address = ?,tel = ?,birth_date = ?,login_pass = ? WHERE login_id = ?");

			st.setString(1, name);
            st.setString(2, address);
            st.setString(3, tel);
            st.setString(4, birthDate);
            st.setString(5, Common.password(password));
            st.setString(6, loginId);
            st.executeUpdate();

            st = conn.prepareStatement("SELECT * FROM user WHERE login_id = ?");
            st.setString(1, loginId);
	        ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
	            String name1 = rs.getString("name");
	            String address1 = rs.getString("address");
	            String tel1 = rs.getString("tel");
	            Date birthDate1 = rs.getDate("birth_date");
	            String loginId1 = rs.getString("login_id");
	            String loginPassword = rs.getString("login_pass");
	            String userType = rs.getString("user_type");
	            UserDataBeans udb = new UserDataBeans(id, name1, address1, tel1, birthDate1, loginId1, loginPassword,userType);
	            return udb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 public static UserDataBeans deleteData(int id) {
	        Connection conn = null;
	        List<UserDataBeans> userList = new ArrayList<UserDataBeans>();

	        try {
	            conn = DBManager.getConnection();

	            String sql = "DELETE FROM user WHERE id = ?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setInt(1,id);
	            pStmt.executeUpdate();

	            return null;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	    }

	 public ArrayList<UserDataBeans> findUser(String loginId, String userName, String birthDate1, String birthDate2){
		 Connection conn = null;
		 ArrayList<UserDataBeans> findUserData = new ArrayList<UserDataBeans>();

		 try {
			 conn = DBManager.getConnection();

			 String sql = "SELECT * FROM user where login_id not in ('admin')";

			 if(!loginId.equals("")) {
				 sql += "and login_id like '%" + loginId + "%'";
			 }if(!userName.equals("")) {
				 sql += "and name like '%" + userName + "%'";
			 }if(!birthDate1.equals("") && !birthDate2.equals("")) {
				 sql += "and birth_date >= '" + birthDate1 + "' and birth_date < '" + birthDate2 + "'";
			 }

	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String address = rs.getString("address");
	                String tel = rs.getString("tel");
	                Date birthDate = rs.getDate("birth_date");
	                String loginId1 = rs.getString("login_id");
	                String password = rs.getString("login_pass");
	                String userType = rs.getString("user_type");
	                UserDataBeans finduser = new UserDataBeans(id, name, address, tel, birthDate, loginId1, password, userType);

	                findUserData.add(finduser);
	            }
	            return findUserData;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	 }


}
