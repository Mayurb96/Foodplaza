package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.DButility.DataConnect;
import com.Dao.OrderDao;
import com.pojo.Order;

public class OrderDaoImp implements OrderDao{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;

	@Override
	public Order placeOrder(String emailId) {
		String Odate=new Date().toString();
		float totalprice=0;
		Order o=null;
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select sum(totalprice) as total from Cart142 where emailId=?");
            ps.setString(1, emailId);
            rs=ps.executeQuery();
            if(rs.next()) {
            	totalprice=rs.getFloat("total");
            }
            if(totalprice>0) {
            	ps=con.prepareStatement("Insert into Orders(emailId,totalprice,Odate) values(?,?,?)");
                ps.setString(1,emailId);
                ps.setFloat(2,totalprice);
                ps.setString(3,Odate);
                row=ps.executeUpdate();
                if(row>0) {
                	ps=con.prepareStatement("select * from Orders where emailId=? And Odate=?");
                	ps.setString(1, emailId);
                	ps.setString(2, Odate);
                	rs=ps.executeQuery();
                	if(rs.next()) {
                		o=new Order();
                	o.setOrderId(rs.getInt("orderId"));
                	o.setEmailId(rs.getString("emailId"));
                	o.setTotalprice(rs.getFloat("totalprice"));
                	o.setOdate(rs.getString("Odate"));
                }
            }
            }
		}catch (SQLException s) {
			s.printStackTrace();
		}
		return o;
	}

	@Override
	public List<Order> showOrder() {
		List<Order>l=new ArrayList<>();
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select * from Orders");
			rs=ps.executeQuery();
			while(rs.next()) {
				Order o=new Order();
            	o.setOrderId(rs.getInt("orderId"));
            	o.setEmailId(rs.getString("emailId"));
            	o.setTotalprice(rs.getFloat("totalprice"));
            	o.setOdate(rs.getString("Odate"));
            	l.add(o);
			}
		}catch (SQLException s) {
			s.printStackTrace();
		}
		return l;
	}

}
