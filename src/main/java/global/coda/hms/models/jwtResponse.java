package global.coda.hms.models;

import java.io.Serializable;

public class jwtResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String jwttoken;

	/**
	 * @return the jwttoken
	 */
	public String getJwttoken() {
		return jwttoken;
	}

	/**
	 * @param jwttoken the jwttoken to set
	 */
	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	
	

}
