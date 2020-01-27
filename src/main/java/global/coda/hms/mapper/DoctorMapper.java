package global.coda.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hms.models.Doctor;
import global.coda.hms.models.Doctor_Mapping;
import global.coda.hms.models.Patient;

/**
 * The Doctor mapper.
 */
/**
 * @author ek
 *
 */
public interface DoctorMapper {

	 /**
     * Gets all doctors record.
     *
     * @return the all doctors
     */
	@Select("SELECT * FROM hms.t_user_details LEFT JOIN hms.t_patient ON hms.t_user_details.pk_user_id = hms.t_patient.fk_user_id  where hms.t_user_details.is_active=1 UNION SELECT  * FROM hms.t_user_details RIGHT JOIN hms.t_patient ON hms.t_user_details.pk_user_id = hms.t_patient.fk_user_id where hms.t_patient.is_active=1")
	List<Doctor> getAll();


    /**
     * Gets doctor by id
     *
     * @param id the id
     * @return the doctor
     */
	@Select("select * from t_user_details join t_doctor on t_user_details.pk_user_id=t_doctor.fk_user_id where fk_user_id=#{id}")
	Doctor getById(int id);

	/**
     * Create user record.
     *
     * @param doctor the doctor
     * @return the 
     */
	@Insert("insert into t_user_details(username,password,firstname,lastname,fk_role_id,city,state,phone_number) values(#{userName},#{password},#{firstName},#{lastName},101,#{city},#{state},#{phoneNumber})")
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	boolean createUser(Doctor doctor);

	 /**
     * Create doctor int.
     *
     * @param doctor the doctor
     * @return the int
     */
	@Insert("insert into t_doctor(doctor_specialization,fk_user_id) values(#{doctorSpecification},#{pkUserId})")
	@Options(useGeneratedKeys = true, keyProperty = "pkPatientId", keyColumn = "pk_patient")
	boolean createDoctor(Doctor doctor);

	/**
     * Update User record.
     *
     * @param doctor the doctor
     * @return the boolean
     */
	@Update("update hms.t_user_details set hms.t_user_details.username = #{userName},hms.t_user_details.password = #{password},hms.t_user_details.firstname=#{firstName},hms.t_user_details.lastname=#{lastName},hms.t_user_details.fk_role_id = 1,hms.t_user_details.city=#{city},hms.t_user_details.state=#{state},hms.t_user_details.phone_number = #{phoneNumber} where hms.t_user_details.pk_user_id=#{id}")
	boolean updateUser(Doctor doctor, int id);
	/**
     * Update doctor record.
     *
     * @param doctor the doctor
     * @return the boolean
     */

	@Update("update hms.t_patient.t_patient set hms.t_patient.weight = #{weight} ,hms.t_patient.blood_group=#{bloodGroup} where hms.t_patient.fk_user_id = #{id}")
	boolean updateDoctor(Doctor doctor, int id);

    /**
     * Delete doctor Record.
     *
     * @param id the id
     * @return the boolean
     */

	@Delete("update hms.t_doctor set hms.t_doctor.is_active=0 where hms.t_doctor.fk_user_id = #{id}")
	boolean deleteDoctorById(int id);

    /**
     * Delete User Record.
     *
     * @param id the id
     * @return the boolean
     */

	@Delete("update hms.t_user_details set hms.t_user_details.is_active=0 where hms.t_user_details.pk_user_id = #{id}")
	boolean deleteUserbyId(int id);

	

	@Select(" select * from t_user_details join t_patient on t_user_details.pk_user_id=t_patient.fk_user_id where pk_patient_id in (SELECT"
			+ "    `t_patient_doctor_mapping`.`fk_patient_id`"
			+ "FROM `hms`.`t_patient_doctor_mapping` where fk_doctor_id=#{id})")
	List<Patient> setOfPatientId(int id);

	

	/**
     * Gets all patient under all doctors OR Gets patient under a doctor.
     *
     * @param id the id
     * @return the all patient under all doctors OR the all patient under specific doctors
     */
	
	@Select("<script> select * from t_user_details join t_doctor on t_user_details.pk_user_id=t_doctor.fk_user_id <if test='id!=0'>where fk_user_id=#{id}</if></script>")
	@Results(value = {
			@Result(property = "listOfPatient", javaType = List.class, column = "pk_doctor_id", many = @Many(select = "setOfPatientId")) })
	List<Doctor> listOfPatients(@Param("id") int id);

}
