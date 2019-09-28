package _04_hospital;

import java.util.ArrayList;

public class Hospital {
private 	ArrayList<Doctor> doctors = new ArrayList<Doctor>();
private ArrayList<Patient> patients = new ArrayList<Patient>();
	public void addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctors.add(doctor);
	}
	
	public ArrayList<Doctor> getDoctors(){
		return doctors;
	}

	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		patients.add(patient);
	}

	public ArrayList<Patient> getPatients() {
		// TODO Auto-generated method stub
		return patients;
	}

	public void assignPatientsToDoctors() {
		// TODO Auto-generated method stub
		Boolean found;
		int counter = 0;
		for(Patient p :patients) {
			System.out.println("p("+counter+"): "+p.isAssigned);
			if(!p.isAssigned) {
				found = false;
				for(Doctor d:doctors) {
					int patientSlotsLeft = 3-d.getPatients().size();
					System.out.println(patientSlotsLeft);
					if(patientSlotsLeft>0&&!found) {
						try {
							d.assignPatient(p);
						} catch (DoctorFullException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						found = true;
					}
					
					
				
				
				}
				
				
			}
			counter++;
			
		}
		
	}

	

}
