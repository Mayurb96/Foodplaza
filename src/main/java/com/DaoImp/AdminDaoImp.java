package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DButility.DataConnect;
import com.Dao.AdminDao;

public class AdminDaoImp implements AdminDao{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;

	@Override
	public boolean adminLogin(String aEmailId, String aPassword) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select * from Admin142 where aEmailId=? And aPassword=?");
			ps.setString(1, aEmailId);
			ps.setString(2, aPassword);
			rs=ps.executeQuery();
			if(rs.next()) {
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
	public boolean adminChangePassword(String aEmailId, String aPassword) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("update Admin142 set aPassword=? where aEmailId=?");
			ps.setString(1, aPassword);
			ps.setString(2, aEmailId);
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
	public boolean userLogin(String cEmailId, String cPassword) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select * from Customer142 where cEmailId=? And cPassword=?");
			ps.setString(1, cEmailId);
			ps.setString(2, cPassword);
			rs=ps.executeQuery();
			if(rs.next()) {
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
	public boolean userChangePassword(String cEmailId, String cPassword) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("update Customer142 set cPassword=? where cEmailId=?");
			ps.setString(1, cPassword);
			ps.setString(2, cEmailId);
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
