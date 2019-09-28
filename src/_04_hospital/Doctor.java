package _04_hospital;

import java.util.ArrayList;

public class Doctor {
private ArrayList<Patient> patients = new ArrayList<Patient>();
	public Boolean performsSurgery() {
		// TODO Auto-generated method stub
		return false;
	}

	public Boolean makesHouseCalls() {
		// TODO Auto-generated method stub
		return false;
	}

	public void assignPatient(Patient patient) throws DoctorFullException{
		// TODO Auto-generated method stub
		if(patients.size()>=3) {
			throw new DoctorFullException();
		}else {
		patients.add(patient);
		patient.isAssigned=true;
		}
	}

	public ArrayList<Patient> getPatients() {
		// TODO Auto-generated method stub
		return patients;
	}

	public void doMedicine() {
		// TODO Auto-generated method stub
		for(Patient p : patients) {
			p.setCared(true);
		}
	}

}
