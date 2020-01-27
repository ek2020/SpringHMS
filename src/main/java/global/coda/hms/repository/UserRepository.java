package global.coda.hms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import global.coda.hms.models.JPAUser;

@Repository
public interface UserRepository extends CrudRepository<JPAUser, Integer> {

}