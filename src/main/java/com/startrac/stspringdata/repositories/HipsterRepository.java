package com.startrac.stspringdata.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.startrac.stspringdata.model.Hipster;
import com.startrac.stspringdata.model.Hobby;

public interface HipsterRepository extends CrudRepository<Hipster, Long> {
    Optional<Hipster> findByName(String name);
    Optional<Hipster> findByNameAndNickName(String name, String nickName);
    Optional<Hipster> findByHobbies(Hobby hobby);
}
