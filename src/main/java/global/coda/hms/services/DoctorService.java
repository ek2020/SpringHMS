package global.coda.hms.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.models.Doctor;
/**
 * The type Doctor service.
 */
@Service
public class DoctorService {
	
	/**
     * The Doctor mapper.
     */
	DoctorMapper mapper;
	public DoctorService(DoctorMapper mapper) {
		this.mapper = mapper;
	}
	/**
     * The Logger.
     */
    Logger LOGGER = LogManager.getLogger(DoctorService.class);

    /**
     * Gets all doctors.
     *
     * @return the all doctors
     */
	public List<Doctor> getAll() {
		LOGGER.traceEntry();
		List<Doctor> doctorList = mapper.getAll();	
		LOGGER.traceExit(doctorList);
		return doctorList;
	}
	/**
     * Gets doctor by id.
     *
     * @param id the id
     * @return the doctor
     */ 
		
	public Doctor getById(int id) {
		LOGGER.traceEntry("Doctor Id");
		Doctor doctor =mapper.getById(id);
		LOGGER.traceExit(doctor);
        return doctor;
	}
	/**
     * Create doctor doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     */
	public boolean createDoctor(Doctor doctor)
	{
		LOGGER.traceEntry();
		boolean userResult=false,doctorResult=false;
		userResult=mapper.createUser(doctor);
		doctorResult=mapper.createDoctor(doctor);
		LOGGER.traceExit(doctor);
		if(userResult && doctorResult)
		{
			return true;
		}
		return false;
		
	}
	
	public boolean updateDoctor(Doctor doctor)
	{
		boolean userResult=false;
		boolean doctorResult=false;
		userResult=mapper.updateUser(doctor, doctor.getPkUserId());
		doctorResult=mapper.updateDoctor(doctor, doctor.getPkUserId());
		if(userResult&&doctorResult)
		{
			return true;
		}
		return false;
	}
	/**
     * Delete doctor boolean.
     *
     * @param id the id
     * @return the boolean
     */
	
	public boolean deleteDoctorById(int id)
	{
		 LOGGER.traceEntry();
		boolean userResult=false,patientResult=false;
		userResult=mapper.deleteUserbyId(id);
		patientResult=mapper.deleteDoctorById(id);
		if(userResult&&patientResult)
		{
			LOGGER.traceExit("true");
			return true;
		}
		return false;
	}
	
	/**
     * Get all patient under doctor or doctor List.
     *
     * @param id the id
     * @return the list
     */
	public List<Doctor> listOfPatient(int id)
	{
		LOGGER.traceEntry();
		List<Doctor> doctorList = mapper.listOfPatients(id);
		 LOGGER.traceExit(doctorList);
		 return doctorList;
		 
	}
	
	


}
