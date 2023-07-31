package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DButility.DataConnect;
import com.Dao.FoodDao;
import com.pojo.Food;

public class FoodDaoImp implements FoodDao{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;

	@Override
	public boolean addFood(Food f) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("Insert into Food142(fName,fType,fQuantity,price) values(?,?,?,?)");
			ps.setString(1, f.getfName());
			ps.setString(2,f.getfType());
			ps.setInt(3,f.getfQuantity());
			ps.setFloat(4,f.getPrice());
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
	public boolean updateFoodById(Food f) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("update Food142 set fName=?,fType=?,fQuantity=?,price=? where foodId=?");
			ps.setString(1, f.getfName());
			ps.setString(2,f.getfType());
			ps.setInt(3,f.getfQuantity());
			ps.setFloat(4,f.getPrice());
			ps.setInt(5,f.getFoodId());
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
	public boolean deleteFoodById(int foodId) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("delete from Food142 where foodId=?");
			ps.setInt(1,foodId);
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
	public List<Food> getAllFood() {
		List<Food>l=new ArrayList<>();
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("Select * from Food142");
			rs=ps.executeQuery();
			while(rs.next()) {
				Food f=new Food();
				f.setFoodId(rs.getInt("foodId"));
				f.setfName(rs.getString("fName"));
				f.setfType(rs.getString("fType"));
				f.setfQuantity(rs.getInt("fQuantity"));
				f.setPrice(rs.getFloat("price"));

				l.add(f);
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return l;
	}

	@Override
	public Food searchFoodById(int foodId) {
		Food f=null;
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("Select * from Food142 where foodId=?");
			ps.setInt(1, foodId);
			rs=ps.executeQuery();
			if(rs.next()) {
				 f=new Food();
				f.setFoodId(rs.getInt("foodId"));
				f.setfName(rs.getString("fName"));
				f.setfType(rs.getString("fType"));
				f.setfQuantity(rs.getInt("fQuantity"));
				f.setPrice(rs.getFloat("price"));
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return f;
	}

}
