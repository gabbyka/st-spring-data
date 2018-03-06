package com.startrac.stspringdata.services;

import java.util.HashSet;
import java.util.Set;

import com.startrac.stspringdata.model.Hipster;
import com.startrac.stspringdata.repositories.HipsterRepository;

public class HipsterServiceImpl implements HipsterService {

    private final HipsterRepository hipsterRepository;
    
    public HipsterServiceImpl(HipsterRepository hipsterRepository) {
        this.hipsterRepository = hipsterRepository;
    }


    @Override
    public Set<Hipster> listAllHipsters() {
        Set<Hipster> hipstersSet = new HashSet<>();
        hipsterRepository.findAll().iterator().forEachRemaining(hipstersSet::add);
        return hipstersSet;
    }

}
