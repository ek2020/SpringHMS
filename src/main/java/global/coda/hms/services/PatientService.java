package global.coda.hms.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.models.Patient;

/**
 * The type Patient service.
 */
@Service

public class PatientService {
	/**
	 * The Patient mapper.
	 */
	PatientMapper mapper;
	/**
	 * The Logger.
	 */
	Logger LOGGER = LogManager.getLogger(PatientService.class);

	/**
	 * Instantiates a new Patient service.
	 *
	 * @param mapper the mapper
	 */
	public PatientService(PatientMapper mapper) {
		this.mapper = mapper;
	}

	/**
     * Gets all patients.
     *
     * @return the all patients
     */
	public List<Patient> getAll() {
		LOGGER.traceEntry();
		List<Patient> patientList = mapper.getAll();
		LOGGER.traceExit(patientList);
		return patientList;
	}

	/**
     * Gets patient by id.
     *
     * @param id the id
     * @return the patient
     */
	public Patient getById(int id) {
		LOGGER.traceEntry();
		 Patient patient =  mapper.getById(id);
		 LOGGER.traceExit(patient);
		 return patient;
	}
	
	/**
     * Gets patient by name
     *
     * @param id the name
     * @return the patient
     */
	public Patient getByName(String name) {
		LOGGER.traceEntry();
		 Patient patient =  mapper.getByName(name);
		 LOGGER.traceExit(patient);
		 return patient;
	}

	/**
	 * Create patient record.
	 *
	 * @param patient the patient
	 * @return the int
	 */
	public boolean createPatient(Patient patient) {
		LOGGER.traceEntry();
		LOGGER.info("service");
		boolean userResult = false;
		boolean patientResult = false;
		userResult = mapper.createUser(patient);
		patientResult = mapper.createPatient(patient);
		LOGGER.traceExit(patient);
		if (userResult && patientResult ) {
			return true;

		}
		return false;

	}

	/**
     * Update patient record.
     *
     * @param patient the patient
     * @return the boolean
     */
	public boolean updatePatient(Patient patient) {
		LOGGER.traceEntry();
		boolean userResult = false, patientResult = false;

		userResult = mapper.updateUser(patient, patient.getPkUserId());
		patientResult = mapper.updatePatient(patient, patient.getPkUserId());
		 LOGGER.traceExit(patient); 
		if (patientResult && userResult) {
			return true;
		}
		return false;
	}

	/**
     * Delete patient record.
     *
     * @param id the id
     * @return the boolean
     */
	public boolean deletePatientById(int id) {
		LOGGER.traceEntry();
		boolean userResult = false, patientResult = false;
		userResult = mapper.deleteUserbyId(id);
		patientResult = mapper.deletePatientById(id);
		LOGGER.traceExit("true");
		if (userResult && patientResult) {
			return true;
		}
		return false;
	}
	

}
