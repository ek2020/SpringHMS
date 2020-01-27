package global.coda.hms.models;

import java.sql.Timestamp;
import java.util.List;

public class Doctor extends User{
	private int pkDoctorId=-1;
	private String doctorSpecification;
	private boolean isActive;
	private Timestamp currentDate;
	private Timestamp updateDate;
	List<Patient> listOfPatient;
	
	

	/**
	 * @return the listOfPatient
	 */
	public List<Patient> getListOfPatient() {
		return listOfPatient;
	}


	/**
	 * @param listOfPatient the listOfPatient to set
	 */
	public void setListOfPatient(List<Patient> listOfPatient) {
		this.listOfPatient = listOfPatient;
	}


	/**
	 * checks for null values in the object.
	 * @return boolean
	 */
	
	public boolean isEmpty() {
		if (doctorSpecification == null || pkDoctorId==-1) {
			return true;
		}
		return false;

	}

	
	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return pkDoctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.pkDoctorId = doctorId;
	}

	/**
	 * @return the doctorSpecification
	 */
	public String getDoctorSpecification() {
		return doctorSpecification;
	}

	/**
	 * @param doctorSpecification the doctorSpecification to set
	 */
	public void setDoctorSpecification(String doctorSpecification) {
		this.doctorSpecification = doctorSpecification;
	}
	
	

	/**
	 * @return the isActive
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the currentDate
	 */
	public Timestamp getCurrentDate() {
		return currentDate;
	}

	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(Timestamp currentDate) {
		this.currentDate = currentDate;
	}

	/**
	 * @return the updateDate
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + pkDoctorId + ", doctorSpecification=" + doctorSpecification + ", isActive="
				+ isActive + ", currentDate=" + currentDate + ", updateDate=" + updateDate + "]";
	}

	

}
