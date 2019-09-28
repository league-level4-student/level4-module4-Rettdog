package _04_hospital;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import junit.framework.TestCase;

/* requirements:
 * 1. hospital has doctors and patients
 * 2. doctors can be GeneralPractictioner or Surgeon
 * 3. patients can be assigned to doctors
 * 4. doctors can have no more than 3 patients
 */

public class HospitalTest extends TestCase {

	Hospital testHospital = new Hospital();

	public void testAddDoctor() {
		testHospital.addDoctor(new GeneralPractitioner());
		testHospital.addDoctor(new GeneralPractitioner());
		testHospital.addDoctor(new Surgeon());
		assertEquals(3, testHospital.getDoctors().size());
	}

	public void testAddPatient() throws Exception {
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		assertEquals(3, testHospital.getPatients().size());
	}

	/* Fix asserts one at a time */
	public void testDoctorsHaveSpecialties() throws Exception {

		GeneralPractitioner testGP = new GeneralPractitioner();
		Doctor testDoctor = new Doctor();
		Doctor testSurgeon = new Surgeon();
		assertFalse( testDoctor.performsSurgery());
		assertTrue(testSurgeon.performsSurgery());
		assertTrue (testGP.makesHouseCalls());
		assertFalse( testSurgeon.makesHouseCalls());
		assertFalse( testDoctor.makesHouseCalls());
	}

	/* A doctor has a list of patients */
	public void testAssignDoctor() throws Exception {
		Doctor testDoctor = new GeneralPractitioner();
		testDoctor.assignPatient(new Patient());
		assertEquals(1, testDoctor.getPatients().size());
		testDoctor.assignPatient(new Patient());
		assertEquals(2, testDoctor.getPatients().size());
		testDoctor.assignPatient(new Patient());
		assertEquals(3, testDoctor.getPatients().size());
	}

	/* When you check a patient's pulse, they feel cared for */
	public void testCheckPulse() throws Exception {
		Patient testPatient = new Patient();
		assertFalse(testPatient.feelsCaredFor());
		testPatient.checkPulse();
		assertTrue(testPatient.feelsCaredFor());
	}

	/* Doctors work on their Patients by checking their pulses. */
	public void testDoctorsWork() throws Exception {
		Doctor testDoctor = new GeneralPractitioner();
		Patient max = new Patient();
		Patient macky = new Patient();
		testDoctor.assignPatient(max);
		testDoctor.assignPatient(macky);
		assertFalse(max.feelsCaredFor());
		assertFalse(macky.feelsCaredFor());
		testDoctor.doMedicine();
		assertTrue(max.feelsCaredFor());
		assertTrue(macky.feelsCaredFor());
	}

	/* test calling assignPatient when doctor is full throws exception */
	public void testDoctorsCanOnlyHandle3Patients() throws Exception {
		Doctor testDoctor = new Doctor();
		testDoctor.assignPatient(new Patient());
		testDoctor.assignPatient(new Patient());
		testDoctor.assignPatient(new Patient());
		try {
			testDoctor.assignPatient(new Patient());
			assertTrue(false);
		} catch (DoctorFullException dfe) {
			assertTrue(true);
		}
assertTrue(testDoctor.getPatients().size() == 3);
	}

	public void test8Patients() throws Exception {
		
		testHospital = new Hospital();
		// TODO: add 3 doctors to hospital
		testHospital.addDoctor(new Doctor());
		testHospital.addDoctor(new Doctor());
		testHospital.addDoctor(new Doctor());
		// TODO: add 8 patients to hospital
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		// hospital assigns patients to doctors
		testHospital.assignPatientsToDoctors();
		// hospital.getDoctors shows doctors have 3, 3, 2 patients
		List<Doctor> testDoctors = testHospital.getDoctors();
		assertEquals(3, testDoctors.get(0).getPatients().size());
		assertEquals(3, testDoctors.get(1).getPatients().size());
		assertEquals(2, testDoctors.get(2).getPatients().size());
	}



}
