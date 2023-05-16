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
			pro.setDescription(rs.getString("description"));
			pro.setStock(rs.getInt("stock"));
			pro.setName(rs.getString("name"));
			pro.setPrice(rs.getDouble("price"));
			pro.setShippingIncluded(rs.getBoolean("shippingincluded"));
			
			productos.add(pro);
				
		} return productos;
		}catch (SQLException e) {
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
	
	public Product busqueda(int id) {
		PreparedStatement stmt=null;
		Connection conn;
		ResultSet rs = null;
		
		try {
			conn=this.getConnection();
			stmt = conn.prepareStatement("Select * from Product where idproducto=?");
			stmt.setInt(1, id);
			Product pro = new Product();
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getInt("idproducto")==id) {
			pro.setID(rs.getInt("idproducto"));
			pro.setDescription(rs.getString("description"));
			pro.setStock(rs.getInt("stock"));
			pro.setName(rs.getString("name"));
			pro.setPrice(rs.getDouble("price"));
			pro.setShippingIncluded(rs.getBoolean("shippingincluded"));
			
			} return pro;
			
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
	
	public boolean newProduct(Product pro) {
		PreparedStatement pstmt=null;
		Connection conn;
		ResultSet keyRS = null;
		Product pro2 = pro;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement("Insert into product (name,description,stock,price,shippingincluded) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, pro.getName());
			pstmt.setString(2, pro.getDescription());
			pstmt.setInt(3, pro.getStock());
			pstmt.setDouble(4, pro.getPrice());
			pstmt.setBoolean(5, pro.isShippingIncluded());
			pstmt.executeUpdate();
			// La key no se usa para nada, solo se agrego para estudio del alumno
			keyRS = pstmt.getGeneratedKeys();
			if (keyRS != null && keyRS.next()) {
				pro2.setID(keyRS.getInt(1));
	
			} return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(keyRS!=null)keyRS.close();
				if(pstmt!=null)pstmt.close();
				this.cerrarConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	}

	public int updateProduct(Product prob, String at) {
		PreparedStatement pstmt=null;
		Connection conn;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement("Update Product SET ? = ? where idproduct = ?");
			pstmt.setString(1,at);
			pstmt.setInt(3, prob.getID());
			switch (at) {
			case "name":
				pstmt.setString (2,prob.getName());
				break;
			case "description":
				pstmt.setString (2,prob.getDescription());
				break;
			case "price":
				pstmt.setDouble(2,prob.getPrice());
				break;
			case "stock":
				pstmt.setInt(2,prob.getStock());
				break;
			case "shippingincluded":
				pstmt.setBoolean(2, prob.isShippingIncluded());
				break;
			default:
				break;
				
			}
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
			
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				this.cerrarConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	
	}
}
