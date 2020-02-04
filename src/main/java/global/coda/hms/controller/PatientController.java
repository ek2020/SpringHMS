package global.coda.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.filter.MyFilter;
import global.coda.hms.models.CustomResponse;
import global.coda.hms.models.Patient;
import global.coda.hms.services.PatientService;

/*
 * The type Patient controller.
 */ 

/**
 * 
 * @author ek
 * 
 */

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController {
	/*
	 * Logger
	 */
	private  org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(PatientController.class);

	/*
	 * Patient service
	 */
	PatientService service;
	/*
	 * Autowired Patient Service
	 */
	public PatientController(PatientService service) {
		this.service = service;
	}
	
	/**
     * Gets all patients.
     *
     * @param httpServletRequest the http servlet request
     * @return the all patients
     */

	@GetMapping("/all")
	  public CustomResponse<List<Patient>> getAllPatients(HttpServletRequest httpServletRequest) {
        LOGGER.traceEntry();
        CustomResponse<List<Patient>> responseEntity = new CustomResponse<>();
        List<Patient> patientList = service.getAll();
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setData(patientList);
        responseEntity.setRequestId( httpServletRequest.getAttribute("requestId").toString());
        LOGGER.traceExit(patientList);
        return responseEntity;
    }
	
	 /**
     * Gets patient by their userId
     *
     * @param id the id
     * @return the patient record
     */
	@GetMapping("/read/{id}")
	public CustomResponse<Patient> getPatientById(@PathVariable("id") int id) {
		LOGGER.traceEntry();
		CustomResponse<Patient> responseEntity = new CustomResponse<>();
        Patient patient = service.getById(id);
        responseEntity.setData(patient);
        responseEntity.setStatusCode(Response.SC_OK);
        LOGGER.traceExit(patient);
        return responseEntity;
	}
	 /**
     * Gets patient by their userName
     *
     * @param id the id
     * @return the patient record
     */
	@GetMapping("/read/{name}")
	public CustomResponse<Patient> getPatientById(@PathVariable("name") String name) {
		LOGGER.traceEntry();
		CustomResponse<Patient> responseEntity = new CustomResponse<>();
        Patient patient = service.getByName(name);
        responseEntity.setData(patient);
        responseEntity.setStatusCode(Response.SC_OK);
        LOGGER.traceExit(patient);
        return responseEntity;
	}

	/**
     * Create patient 
     *
     * @param patient the patient
     * @return the response entity
     */
	@PostMapping("/create")
	public CustomResponse<Boolean> createPatient(@RequestBody Patient patient) {
        LOGGER.traceEntry();
        CustomResponse<Boolean> customResponse = new CustomResponse<>();
        boolean result = service.createPatient(patient);
        customResponse.setStatusCode(Response.SC_OK);
        customResponse.setData(result);
        LOGGER.traceExit(patient);
        return customResponse;
    }
	
	
	/**
     * Update patient response entity.
     *
     * @param patient the patient
     * @return the response entity
     */
    @PutMapping("/update")
    public CustomResponse<Integer> updatePatient(@RequestBody Patient patient) {
        LOGGER.traceEntry();
        CustomResponse<Integer> customResponse = new CustomResponse<>();
        boolean result=false;
        result = service.updatePatient(patient);
        customResponse.setData(patient.getPkUserId());
        customResponse.setStatusCode(Response.SC_OK);
        LOGGER.traceExit(patient);
        return customResponse;
    }
    /**
     * Delete patient record.
     *
     * @param id the id
     * @return the custom response
     */

	@DeleteMapping("/delete/{id}")
	public CustomResponse<Boolean> deletePatient(@PathVariable("id") int id) {
        LOGGER.traceEntry();
        CustomResponse<Boolean> responseEntity = new CustomResponse<>();
        boolean result = service.deletePatientById(id);
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setData(result);
        LOGGER.traceExit(result);
        return responseEntity;
    }
	
	
}
