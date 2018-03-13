package com.startrac.stspringdata.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.startrac.stspringdata.model.Hobby;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HobbyRepositoryIT {

    @Autowired
    HobbyRepository hobbyRepository;

    @Test
    public void findByName() throws Exception {
        Optional<Hobby> current = hobbyRepository.findByName("travel");
        assertEquals("travel2", current.get().getName());
    }
}
