package com.startrac.stspringdata.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.startrac.stspringdata.model.Hobby;

public interface HobbyRepository extends CrudRepository<Hobby, Long> {

    Optional<Hobby> findByName(String name);

}
