package data;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

import entities.Product;

public class DbHandler {
	
	private Connection conn;
	private String host = "localhost";
	private String db = "javamarket";
	private String user = "root";
	private String password = "1234";
	
	public DbHandler() {
		//Registro del conector
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() {
		try {
			if(conn==null || conn.isClosed())
			conn=DriverManager.getConnection("jdbc:mysql://"+host+"/"+db, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void cerrarConnection() {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> listado(){
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn;
		ArrayList <Product> productos = new ArrayList<>();
		
		
		try {
			conn=this.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from Product");
			
		while (rs.next() && rs!= null ) {
			
			Product pro = new Product();
			pro.setID(rs.getInt("idproducto"));
			pro.setDesctiption(rs.getString("description"));
			pro.setName(rs.getString("name"));
			pro.setPrice(rs.getDouble("price"));
			pro.setShippingIcluded(rs.getBoolean("shippingincluded"));
			
			productos.add(pro);
				
		} return productos;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				this.cerrarConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
	
	

}
