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
 * Servlet implementation class EditMachineServlet
 */
@WebServlet("/EditMachineServlet")
public class EditMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMachineServlet() {
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
        response.setContentType("text/html");

        int MachineID = Integer.parseInt(request.getParameter("MachineID"));

        IMachineService imachine = new MachineServiceImpl();

        Machines machine = imachine.selectMachines(MachineID);

        request.setAttribute("machine", machine);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/EditMachine.jsp");
        requestDispatcher.forward(request, response);
	}

}
