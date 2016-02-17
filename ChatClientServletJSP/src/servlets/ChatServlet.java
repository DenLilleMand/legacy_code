package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import messageWrapper.MessageWrapper;
import messageWrapper.Observable;
import messageWrapper.Observer;
import network.NetworkControllerClient;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/chat")
public class ChatServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private MessageWrapper messageWrapper = MessageWrapper.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("chat.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("post method was called.");
		String startServer = request.getParameter("startServer");
		if(!startServer.equals(""))
		{
			try 
			{
				NetworkControllerClient.getInstance(messageWrapper).connectToServer();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
		
		
		
		request.setAttribute("messages", messageWrapper.getMessages());
		//response.
		request.getRequestDispatcher("chat.jsp").forward(request,response);
		
	}



}
