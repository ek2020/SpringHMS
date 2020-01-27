package global.coda.hms.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.models.CustomResponse;
import global.coda.hms.models.Doctor;
import global.coda.hms.services.DoctorService;

/**
 * The type Doctor controller.
 */
/**
 * @author ek
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/doctors")
public class DoctorController {
	/**
	 * The Logger.
	 */
	private org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(DoctorController.class);
	/**
	 * The Doctor service.
	 */
	DoctorService service;
	CustomResponse customResponse = new CustomResponse();

	public DoctorController(DoctorService service) {
		this.service = service;
	}

	/**
	 * Gets all doctors.
	 *
	 * @return the all doctors
	 */

	@GetMapping("/all")
	public CustomResponse<List<Doctor>> getAllDoctors() {
		LOGGER.traceEntry();
		CustomResponse<List<Doctor>> customResponse = new CustomResponse<>();
		List<Doctor> doctorList = service.getAll();
		customResponse.setData(doctorList);
		customResponse.setStatusCode(Response.SC_OK);
		LOGGER.traceExit(doctorList);
		return customResponse;
	}

	/**
	 * Gets doctor.
	 *
	 * @param id the id
	 * @return the doctor
	 */
	@GetMapping("/read/{id}")
	public CustomResponse<Doctor> getDoctor(@PathVariable int id) {
		LOGGER.traceEntry();
		CustomResponse<Doctor> customResponse = new CustomResponse<>();
		Doctor doctor = service.getById(id);
		customResponse.setStatusCode(Response.SC_OK);
		customResponse.setData(doctor);
		LOGGER.traceExit(doctor);
		return customResponse;
	}

	/**
	 * Create doctor record.
	 *
	 * @param doctor the doctor
	 * @return the response
	 */
	@PostMapping("/create")
	public CustomResponse<Integer> createDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry();
		CustomResponse<Integer> customResponse = new CustomResponse<>();
		boolean result = service.createDoctor(doctor);
		customResponse.setData(doctor.getPkUserId());
		customResponse.setStatusCode(Response.SC_OK);
		LOGGER.traceExit(doctor);
		return customResponse;
	}

	/**
	 * Update doctor record.
	 *
	 * @param doctor the doctor
	 * @return the response
	 */
	@PutMapping("/update/")
	public CustomResponse<Integer> updateDoctor(@RequestBody Doctor doctor) {
		LOGGER.traceEntry();
		CustomResponse<Integer> customResponse = new CustomResponse<>();
		boolean result = service.updateDoctor(doctor);
		customResponse.setStatusCode(Response.SC_OK);
		customResponse.setData(doctor.getPkUserId());
		LOGGER.traceExit(doctor);
		return customResponse;
	}

	/**
	 * Delete doctor record.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/delete/{id}")
	public CustomResponse<Boolean> deleteDoctor(@PathVariable("id") int id) {
		LOGGER.traceEntry();
		CustomResponse<Boolean> responseEntity = new CustomResponse<>();
		boolean result = service.deleteDoctorById(id);
		responseEntity.setData(result);
		responseEntity.setStatusCode(Response.SC_OK);
		LOGGER.traceExit(result);
		return responseEntity;
	}

	/**
	 * Gets patient under a specific doctor Id.
	 *
	 * @param doctorId the doctor id
	 * @return the patients under a doctor
	 */
	@GetMapping("/listOfPatient")
	public CustomResponse<List<Doctor>> listOfPatient(@PathParam("id") Integer id) {
		LOGGER.traceEntry("doctorId");
		if (id == null) {
			id = 0;
		}

		CustomResponse<List<Doctor>> customResponse = new CustomResponse<>();
		List<Doctor> doctorList = service.listOfPatient(id);
		customResponse.setStatusCode(Response.SC_OK);
		customResponse.setData(doctorList);
		LOGGER.traceExit(doctorList);
		return customResponse;

	}

}
