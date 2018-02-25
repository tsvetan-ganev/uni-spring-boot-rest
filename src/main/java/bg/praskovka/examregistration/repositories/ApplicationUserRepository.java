package bg.praskovka.examregistration.repositories;

import org.springframework.data.repository.CrudRepository;

import bg.praskovka.examregistration.models.ApplicationUser;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long>{}
