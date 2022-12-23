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
 * Servlet implementation class UpdateMachineServlet
 */
@WebServlet("/UpdateMachineServlet")
public class UpdateMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMachineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        IMachineService imachine = new MachineServiceImpl();

        
        int MachineID = Integer.parseInt(request.getParameter("MachineID"));
        String MachineBrand = request.getParameter("MachineBrand");
        String Condition = request.getParameter("Condition");
        int SlotNo = Integer.parseInt(request.getParameter("SlotNo"));
        
        Machines machine1 = new Machines(MachineID,MachineBrand,Condition,SlotNo);
        //Create an object

        //getting values from JSP and assign to object setters
//        machine.setMachineID(Integer.parseInt(request.getParameter("MachineID")));
//        machine.setMachineBrand(request.getParameter("MachineBrand"));
//        machine.setCondition(request.getParameter("Condition"));
//        machine.setSlotNo(Integer.parseInt(request.getParameter("SlotNo")));


        //calling relevant method
        imachine.updateMachinesDetails(machine1);

        //redirect to JSP
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/MachinesList.jsp");
        requestDispatcher.forward(request, response);
	}

}
