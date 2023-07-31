package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DButility.DataConnect;
import com.Dao.CustomerDao;
import com.pojo.Customer;

public class CustomerDaoImp implements CustomerDao{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;

	@Override
	public boolean addCustomer(Customer cs) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("Insert into Customer142(cName,cEmailId,cPassword,cAddress,cContactNo) values(?,?,?,?,?)");
			ps.setString(1, cs.getcName());
			ps.setString(2, cs.getcEmailId());
			ps.setString(3, cs.getcPassword());
			ps.setString(4, cs.getcAddress());
			ps.setString(5, cs.getcContactNo());
			row=ps.executeUpdate();
			if(row>0) {
				return true;
			}else {
				return false;
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomerById(Customer cs) {
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("Update Customer142 set cName=?,cPassword=?,cAddress=?,cContactNo=? where cEmailId=?");
			ps.setString(1, cs.getcName());
			ps.setString(2, cs.getcPassword());
			ps.setString(3, cs.getcAddress());
			ps.setString(4, cs.getcContactNo());
			ps.setString(5, cs.getcEmailId());
			row=ps.executeUpdate();
			if(row>0) {
				return true;
			}else {
				return false;
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomerById(String EmailId) {
		try{
			con=DataConnect.getConnect();
			ps=con.prepareStatement("Delete from Customer142 where cEmailId=?");
			ps.setString(1, EmailId);
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
	public List<Customer> getAllCustomer() {
		List<Customer>l=new ArrayList<>();
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select * from Customer142");
			rs=ps.executeQuery();
			while(rs.next()) {
				Customer cs=new Customer();
				cs.setcName(rs.getString("cName"));
				cs.setcEmailId(rs.getString("cEmailId"));
				cs.setcPassword(rs.getString("cPassword"));
				cs.setcAddress(rs.getString("cAddress"));
				cs.setcContactNo(rs.getString("cContactNo"));
				
				l.add(cs);
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return l;
	}

	@Override
	public Customer searchCustomerById(String EmailId) {
		Customer cs=null;
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select * from Customer142 where cEmailId=?");
			ps.setString(1, EmailId);
			rs=ps.executeQuery();
			if(rs.next()) {
				cs=new Customer();
				cs.setcName(rs.getString("cName"));
				cs.setcEmailId(rs.getString("cEmailId"));
				cs.setcPassword(rs.getString("cPassword"));
				cs.setcAddress(rs.getString("cAddress"));
				cs.setcContactNo(rs.getString("cContactNo"));
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return cs;
	}

}
