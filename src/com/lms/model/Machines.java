package com.lms.model;

public class Machines {

	private int MachineID;
	private String MachineBrand;
	private String Condition;
	private int SlotNo;
	
	
	public Machines(int machineID, String machineBrand, String condition, int slotNo) {
		super();
		MachineID = machineID;
		MachineBrand = machineBrand;
		Condition = condition;
		SlotNo = slotNo;
	}

	public Machines() {
		
	}
	
	public int getMachineID() {
		return MachineID;
	}
	public void setMachineID(int machineID) {
		MachineID = machineID;
	}
	public String getMachineBrand() {
		return MachineBrand;
	}
	public void setMachineBrand(String machineBrand) {
		MachineBrand = machineBrand;
	}
	public String getCondition() {
		return Condition;
	}
	public void setCondition(String condition) {
		Condition = condition;
	}
	public int getSlotNo() {
		return SlotNo;
	}
	public void setSlotNo(int slotNo) {
		SlotNo = slotNo;
	}

	
	
	
}
