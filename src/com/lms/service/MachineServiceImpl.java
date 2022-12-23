package com.lms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lms.model.Machines;
import com.lms.util.DBconnect;

public class MachineServiceImpl implements IMachineService{

    private static final String ADD_NEW_MACHINE = "INSERT INTO machines" + "(MachineID,MachineBrand,MCondition,SlotNo) VALUES" + "(?,?,?,?);";
    private static final String UPDATE_MACHINE = "UPDATE machines SET MachineBrand=?, MCondition =?, SlotNo =? WHERE (MachineID = ?);";
    private static final String LIST_OF_MACHINES = "SELECT * FROM machines";
    private static final String DELETE_MACHINE = "DELETE FROM machines WHERE MachineID = ?;";
    private static final String GET_MACHINE_BY_ID = "SELECT * FROM machines WHERE MachineID = ?";
    
    
	@Override
	public void addMachine(Machines machines) {
		// TODO Auto-generated method stub
		try (Connection connection = DBconnect.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_MACHINE)) {

	            preparedStatement.setInt(1, machines.getMachineID());
	            preparedStatement.setString(2, machines.getMachineBrand());
	            preparedStatement.setString(3, machines.getCondition());
	            preparedStatement.setInt(4, machines.getSlotNo());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();

	            System.out.println(preparedStatement);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public ArrayList<Machines> listallMachines() {
		// TODO Auto-generated method stub
		
        ArrayList<Machines> listMachines = new ArrayList<>();

        try {
            Connection connection = DBconnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(LIST_OF_MACHINES);
           // System.out.println(resultset);

            while (resultset.next()) {
                int MachineID = Integer.parseInt(resultset.getString("MachineID"));
                String MachineBrand = resultset.getString("MachineBrand");
                String Condition = resultset.getString("MCondition");
                int SlotNo = Integer.parseInt(resultset.getString("SlotNo"));

                Machines machine = new Machines(MachineID, MachineBrand, Condition, SlotNo);
                listMachines.add(machine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMachines;
		
	}

	@Override
	public Machines selectOneMachinesDetials(String machineid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Machines> getMachinesDetials(String machineid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMachines(Machines machines) {
		// TODO Auto-generated method stub
        boolean row = false;

        try {
        	Connection connection = DBconnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MACHINE);
            preparedStatement.setInt(1, machines.getMachineID());
            System.out.println(preparedStatement);
            row = preparedStatement.executeUpdate() > 0;


            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
	}

	@Override
	public boolean updateMachinesDetails(Machines machines) {
        boolean rowUpdate = false;

        try {

        	Connection connection = DBconnect.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_MACHINE);
            
        	statement.setString(1, machines.getMachineBrand());
        	statement.setString(2, machines.getCondition());
        	statement.setInt(3, machines.getSlotNo());
        	statement.setInt(4, machines.getMachineID());
            System.out.println(statement);

            rowUpdate = statement.executeUpdate() > 0;

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdate;
	}

	@Override
	public ArrayList<Machines> selectMachinesById(int machineid) {
        ArrayList<Machines> listMachines = new ArrayList<>();

        try 
            (Connection connection = DBconnect.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MACHINE_BY_ID);) {

           preparedStatement.setInt(1, machineid);
           ResultSet resultset = preparedStatement.executeQuery();
           // System.out.println(resultset);

            while (resultset.next()) {
                int MachineID = Integer.parseInt(resultset.getString("MachineID"));
                String MachineBrand = resultset.getString("MachineBrand");
                String Condition = resultset.getString("MCondition");
                int SlotNo = Integer.parseInt(resultset.getString("SlotNo"));

                Machines machine = new Machines(MachineID, MachineBrand, Condition, SlotNo);
                listMachines.add(machine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMachines;
	}

	@Override
	public Machines selectMachines(int machineid) {
		return selectMachinesById(machineid).get(0);
	}

}
