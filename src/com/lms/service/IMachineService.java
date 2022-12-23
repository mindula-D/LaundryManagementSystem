package com.lms.service;

import java.util.ArrayList;

import com.lms.model.Machines;

public interface IMachineService {

    public void addMachine(Machines machines);

    public ArrayList<Machines> listallMachines();

    public Machines selectOneMachinesDetials(String machineid);

    public ArrayList<Machines> getMachinesDetials(String machineid);

    public boolean deleteMachines(Machines machineid);

    public boolean updateMachinesDetails(Machines machineid);

    public ArrayList<Machines> selectMachinesById(int machineid);

    public Machines selectMachines(int machineid);
}
