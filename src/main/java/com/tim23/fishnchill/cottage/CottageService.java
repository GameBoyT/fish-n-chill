package com.tim23.fishnchill.cottage;

import com.tim23.fishnchill.cottage.model.Cottage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageService {
    @Autowired
    private CottageRepository cottageRepository;

    public List<Cottage> findAll()
    {
        return cottageRepository.findAll();
    }
}
