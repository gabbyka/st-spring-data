package com.startrac.stspringdata.loader;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.startrac.stspringdata.model.Hipster;
import com.startrac.stspringdata.model.Hobby;
import com.startrac.stspringdata.repositories.HipsterRepository;
import com.startrac.stspringdata.repositories.HobbyRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
    
    private final HipsterRepository hipsterRepository;
    private final HobbyRepository hobbyRepository;
    
    
    public DatabaseLoader(HipsterRepository hipsterRepository, HobbyRepository hobbyRepository) {
        this.hipsterRepository = hipsterRepository;
        this.hobbyRepository = hobbyRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        
        Optional<Hobby> cosplayOptional = hobbyRepository.findByName("cosplaying");
        Hobby cosplay = cosplayOptional.orElseThrow(IllegalArgumentException::new);
        
        
        Optional<Hipster> joeHipsterOptional = hipsterRepository.findByNameAndNickName("Joe", "The wizard");
        Hipster joe = joeHipsterOptional.orElseThrow(IllegalArgumentException::new);
        
        
        cosplay.getHipsters().add(joe);
        //joe.getHobbies().add(cosplay);
        
        hobbyRepository.save(cosplay);
        hipsterRepository.save(joe);
    }

}
