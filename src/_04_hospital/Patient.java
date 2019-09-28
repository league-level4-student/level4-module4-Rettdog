package _04_hospital;

public class Patient {
	Boolean isAssigned = false;
private Boolean isCaredFor = false;
	public Boolean feelsCaredFor() {
		// TODO Auto-generated method stub
		return getCared();
	}

	public void checkPulse() {
		// TODO Auto-generated method stub
		setCared(true);
	}

	public Boolean getCared() {
		return isCaredFor;
	}

	public void setCared(Boolean isCaredFor) {
		this.isCaredFor = isCaredFor;
	}
	
	

}
