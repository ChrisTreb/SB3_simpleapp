package com.ctrl.simpleapp.rest.api.repository;

import com.ctrl.simpleapp.records.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {

}
