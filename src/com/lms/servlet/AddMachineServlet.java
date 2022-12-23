package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.model.Machines;
import com.lms.service.IMachineService;
import com.lms.service.MachineServiceImpl;

/**
 * Servlet implementation class AddMachineServlet
 */
@WebServlet("/AddMachineServlet")
public class AddMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMachineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IMachineService imachine = new MachineServiceImpl();

        
        int MachineID = Integer.parseInt(request.getParameter("MachineID"));
        String MachineBrand = request.getParameter("MachineBrand");
        String Condition = request.getParameter("Condition");
        int SlotNo = Integer.parseInt(request.getParameter("SlotNo"));
        
        Machines machine1 = new Machines(MachineID,MachineBrand,Condition,SlotNo);
        
        imachine.addMachine(machine1);
        //redirect to JSP
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/MachinesList.jsp");
        requestDispatcher.forward(request, response);
	}

}
