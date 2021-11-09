package com.tim23.fishnchill.general.service;

import com.tim23.fishnchill.general.model.BaseEntity;
import com.tim23.fishnchill.general.repository.BaseEntityRepository;
import com.tim23.fishnchill.cottage.model.Cottage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseEntityService {
    @Autowired
    private BaseEntityRepository baseEntityRepository;

    public BaseEntity findById(Long id){
        return baseEntityRepository.getById(id);
    }

}
