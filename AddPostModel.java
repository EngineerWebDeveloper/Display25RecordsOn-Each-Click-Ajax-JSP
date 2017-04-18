package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddPostModel {
	int userid;
	String post;
	int posttype;
	String datecreated;
	String dateupdated;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getPosttype() {
		return posttype;
	}
	public void setPosttype(int posttype) {
		this.posttype = posttype;
	}
	public String getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}
	public String getDateupdated() {
		return dateupdated;
	}
	public void setDateupdated(String dateupdated) {
		this.dateupdated = dateupdated;
	}
	
	


public List<AddPostModel> getPosts() {
	String dburl = "jdbc:mysql://localhost:3306/carpoolingdb";
	try {
        Class.forName("com.mysql.jdbc.Driver");
        
    } catch (ClassNotFoundException ex) {
        System.out.println("MySQL JDBC driver not found in DBConnection\n" + ex);
        System.exit(0);
    }

	String readQuery1 = "SELECT * from posts";
	 List<AddPostModel> list=new ArrayList();
    //String fullname = "No information found for the requested user: " + email;

    try (Connection con = DriverManager.getConnection(dburl, "root", "password");
            Statement stmt = con.createStatement();) {

        System.out.println("the query: " + readQuery1);
        ResultSet rs = stmt.executeQuery(readQuery1);
        System.out.println(rs);

      while (rs.next()) {
    	  AddPostModel posts=new AddPostModel();
         posts.setUserid(Integer.parseInt(rs.getString(2)));
         posts.setPost(rs.getString(3));
         posts.setPosttype(Integer.parseInt(rs.getString(4)));
         posts. setDatecreated(rs.getString(5));
         posts. setDateupdated(rs.getString(6));
         list.add(posts);
      }
      
      rs.close();
      con.close();
    
  } catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    return list;
}
}