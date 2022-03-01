package com.tim23.fishnchill.cottage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CottageServiceUnitTest {

    @Mock
    private CottageRepository cottageRepository;
    @Mock
    private ModelMapper modelMapper;
    private CottageService cottageService;

    @BeforeEach
    void setUp() {
        cottageService = new CottageService(cottageRepository, modelMapper);
    }

    @Test
    void shouldFindAll() {
        cottageService.findAll();
        verify(cottageRepository).findAll();
    }

    @Test
    void shouldFindOne() {
        Long id = 1L;
        cottageService.findOne(id);
        verify(cottageRepository).getById(id);
    }

    @Test
    void shouldFindByName() {
        String name = "CottageName";
        cottageService.findByNameContaining(name);
        verify(cottageRepository).findByNameContainingIgnoreCase(name);
    }
}