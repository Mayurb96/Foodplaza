package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DButility.DataConnect;
import com.Dao.CartDao;
import com.pojo.Cart;

public class CartDaoImp implements CartDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;

	@Override
	public boolean addCart(Cart c) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("insert into Cart142(foodId,fName,fquantity,emailId,price,totalprice) values(?,?,?,?,?,?)");
			ps.setInt(1, c.getFoodId());
			ps.setString(2, c.getfName());
			ps.setInt(3, c.getFquantity());
			ps.setString(4, c.getEmailId());
			ps.setFloat(5, c.getPrice());
			ps.setFloat(6, c.getTotalprice());
			row=ps.executeUpdate();
			if(row>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException s) {
			s.printStackTrace();
			
		}
		return false;
	}

	@Override
	public List<Cart> showCart(String EmailId) {
		List<Cart>l=new ArrayList<>();
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select * from Cart142 where emailId=?");
			ps.setString(1, EmailId);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cart c=new Cart();
				c.setCartId(rs.getInt("cartId"));
				c.setFoodId(rs.getInt("foodId"));
				c.setfName(rs.getString("fName"));
				c.setFquantity(rs.getInt("fquantity"));
				c.setEmailId(rs.getString("emailId"));
				c.setPrice(rs.getFloat("price"));
				c.setTotalprice(rs.getFloat("totalprice"));
				l.add(c);
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean deleteCart(int cartId) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("delete from Cart142 where cartId=?");
			ps.setInt(1, cartId);
			row=ps.executeUpdate();
			if(row>0) {
				return true;
			}else {
				return false;
			}
		}catch (SQLException s) {
		     s.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean clearCart(String EmailId) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("delete from Cart142 where emailId=?");
			ps.setString(1, EmailId);
			row=ps.executeUpdate();
			if(row>0) {
				return true;
			}else {
				return false;
			}
		}catch (SQLException s) {
		     s.printStackTrace();
		}
		return false;
	}

}
