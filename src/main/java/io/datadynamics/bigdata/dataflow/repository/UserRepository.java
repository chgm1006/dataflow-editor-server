package io.datadynamics.bigdata.dataflow.repository;

import io.datadynamics.bigdata.dataflow.model.User;
import io.datadynamics.bigdata.dataflow.model.UserId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, UserId> {

}
