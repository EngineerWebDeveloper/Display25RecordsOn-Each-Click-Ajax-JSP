package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.models.AddPostModel;

/**
 * Servlet implementation class DisplayPosts
 */
@WebServlet("/DisplayPosts")
public class DisplayPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 AddPostModel posts=new AddPostModel();
			List mypost=posts.getPosts();//posts
			System.out.println(mypost);
			String json = new Gson().toJson(mypost);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			/*request.setAttribute("mypost", mypost);
	
			for(int i=0;i<mypost.size();i++){
			    System.out.println(((AddPostModel) mypost.get(i)).getPost());
			} 
		RequestDispatcher rd = request.getRequestDispatcher("DisplayPostsAjax.jsp");
		rd.forward( request, response );
		System.out.println("=========end====");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
