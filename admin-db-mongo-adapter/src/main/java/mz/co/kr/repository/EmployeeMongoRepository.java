package mz.co.kr.repository;

import mz.co.kr.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMongoRepository extends MongoRepository<Employee, String> {

}
