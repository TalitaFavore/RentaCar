package br.com.talitafavore.rentacar.service;

import br.com.talitafavore.rentacar.dto.CityDto;
import br.com.talitafavore.rentacar.exception.ResourceNotFoundException;
import br.com.talitafavore.rentacar.mapper.CustomModelMapper;
import br.com.talitafavore.rentacar.model.CityModel;
import br.com.talitafavore.rentacar.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public CityDto create(CityDto cityDto){
        CityModel city = CustomModelMapper.parseObject(cityDto, CityModel.class);
        return CustomModelMapper.parseObject(repository.save(city), CityDto.class);
    }

    public CityDto findByID(long id) {
        CityModel found = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada"));
        return CustomModelMapper.parseObject(found, CityDto.class);
    }

    public CityDto update(CityDto cityDto) {
        CityModel found = repository.findById(cityDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada"));
        found.setName(cityDto.getName());
        found.setState(cityDto.getState());
        return CustomModelMapper.parseObject(repository.save(found), CityDto.class);
    }

    public void delete(long id) {
        CityModel found = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada"));
        repository.delete(found);
    }

    public List<CityDto> findAll() {
        var list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, CityDto.class);
    }

    public List<CityDto> findByName(String name) {
        var cities = repository.findByNameContainsIgnoreCaseOrderByName(name);
        return CustomModelMapper.parseObjectList(cities, CityDto.class);
    }

    public List<CityDto> findByState(String state) {
        var states = repository.findByStateEqualsIgnoreCaseOrderByStateAscNameAsc(state);
        return CustomModelMapper.parseObjectList(states, CityDto.class);
    }
}
