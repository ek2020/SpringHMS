package global.coda.hms.models;

import java.sql.Timestamp;
import java.util.List;


public class Patient extends User {
	private int pkPatientId;
	private int weight;
	private String bloodGroup;
	private boolean isActive;
	private Timestamp currentDate;
	private Timestamp updateDate;
	List<Integer> listOfPatientId;
	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return pkPatientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.pkPatientId = patientId;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the bloodGroup
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
	
	

	/**
	 * @return the listOfPatientId
	 */
	public List<Integer> getListOfPatientId() {
		return listOfPatientId;
	}

	/**
	 * @param listOfPatientId the listOfPatientId to set
	 */
	public void setListOfPatientId(List<Integer> listOfPatientId) {
		this.listOfPatientId = listOfPatientId;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + pkPatientId + ", weight=" + weight + ", bloodGroup=" + bloodGroup + ", isActive="
				+ isActive + ", currentDate=" + currentDate + ", updateDate=" + updateDate + "]";
	}

	

}

