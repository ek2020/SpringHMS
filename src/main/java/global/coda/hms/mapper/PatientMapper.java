package global.coda.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hms.models.Patient;

/**
 * The  Patient mapper.
 */
/**
 * @author ek
 *
 */
@Mapper
public interface PatientMapper {

	/**
     * Gets all patients.
     *
     * @return the all patients record which are not deleted
     */
	@Select("SELECT * FROM hms.t_user_details LEFT JOIN hms.t_patient ON hms.t_user_details.pk_user_id = hms.t_patient.fk_user_id where hms.t_user_details.is_active=1 UNION SELECT  * FROM hms.t_user_details RIGHT JOIN hms.t_patient ON hms.t_user_details.pk_user_id = hms.t_patient.fk_user_id where hms.t_patient.is_active=1 ;")
	List<Patient> getAll();
	/**
     * Gets patient by id.
     *
     * @param id the id
     * @return the patient record
     */
	@Select("select * from t_user_details join t_patient on t_user_details.pk_user_id=t_patient.fk_user_id where fk_user_id=#{id}")
	Patient getById(int id);
	/**
     * Create user record.
     *
     * @param patient the patient
     * @return the boolean
     */
	@Insert("insert into t_user_details(username,password,firstname,lastname,fk_role_id,city,state,phone_number) values(#{userName},#{password},#{firstName},#{lastName},101,#{city},#{state},#{phoneNumber})")
	@Options(useGeneratedKeys = true,keyProperty = "pkUserId",keyColumn = "pk_user_id")
	boolean createUser(Patient patient);
	
	/**
     * Create patient record.
     *
     * @param patient the patient
     * @return the int
     */
	@Insert("insert into t_patient(blood_group,weight,fk_user_id,fk_doctor_id) values(#{bloodGroup},#{weight},#{pkUserId},102)")
	@Options(useGeneratedKeys = true,keyProperty = "pkPatientId",keyColumn = "pk_patient")
	int createPatient(Patient patient);
	 /**
     * Update user record for the given patients
     *
     * @param patient the patient
     * @return the boolean
     */
	
	@Update("update hms.t_user_details set hms.t_user_details.username = #{patient.userName},hms.t_user_details.password = #{patient.password},hms.t_user_details.firstname=#{patient.firstName},hms.t_user_details.lastname=#{patient.lastName},hms.t_user_details.fk_role_id = 1,hms.t_user_details.city=#{patient.city},hms.t_user_details.state=#{patient.state},hms.t_user_details.phone_number = #{patient.phoneNumber} where hms.t_user_details.pk_user_id=#{id} and hms.t_user_details.is_active=1")
	boolean updateUser(Patient patient,int id);
	/**
     * Update patient record.
     *
     * @param patient the patient
     * @return the boolean
     */
	@Update("update hms.t_patient set hms.t_patient.weight = #{patient.weight} ,hms.t_patient.blood_group=#{patient.bloodGroup} where hms.t_patient.fk_user_id = #{id} and hms.t_patient.is_active=1")
	boolean updatePatient(Patient patient,int id);
	/**
     * Delete user record.
     *
     * @param id the id
     * @return the boolean
     */
	@Delete("update hms.t_patient set hms.t_patient.is_active=0 where hms.t_patient.fk_user_id = 201")
	boolean deletePatientById(int id);
	/**
     * Delete patient record.
     *
     * @param id the id
     * @return the boolean
     */
	@Delete("update hms.t_user_details set hms.t_user_details.is_active=0 where hms.t_user_details.pk_user_id = 201")
	boolean deleteUserbyId(int id);
	
} 
