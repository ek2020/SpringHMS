package global.coda.hms.models;
import java.sql.Timestamp;

/**
*
* @author ek
*
* entity that represents a user
*
*/

public class User {
	
	private int pkUserId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String phoneNumber;
	private boolean isActive;
	private Timestamp currentDate;
	private Timestamp updateDate;
	private int fk_role_id;
	/**
	 * checks for null values in the object.
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (userName == null || password == null || lastName==null || city==null||state==null|| firstName == null  || phoneNumber == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return the pkUserId
	 */
	public int getPkUserId() {
		return pkUserId;
	}

	/**
	 * @param pkUserId the pkUserId to set
	 */
	public void setPkUserId(int pkUserId) {
		this.pkUserId = pkUserId;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the isActive
	 */
	public boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param b the isActive to set
	 */
	public void setIsActive(boolean b) {
		this.isActive = b;
	}
	/**
	 * @return the currentDate
	 */
	public Timestamp getCurrentDate() {
		return currentDate;
	}
	/**
	 * @param timestamp the currentDate to set
	 */
	public void setCurrentDate(Timestamp timestamp) {
		this.currentDate = timestamp;
	}
	/**
	 * @return the updateDate
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param timestamp the updateDate to set
	 */
	public void setUpdateDate(Timestamp timestamp) {
		this.updateDate = timestamp;
	}

	/**
	 * @return the fk_role_id
	 */
	public int getFk_role_id() {
		return fk_role_id;
	}

	/**
	 * @param fk_role_id the fk_role_id to set
	 */
	public void setFk_role_id(int fk_role_id) {
		this.fk_role_id = fk_role_id;
	}
	


}
