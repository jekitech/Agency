package com.example.hao.Service;

import com.example.hao.DTO.HouseRequestDto;
import com.example.hao.Entity.House;

import java.util.ArrayList;
import java.util.List;

public interface Hao_Service {

    public House saveHouse(HouseRequestDto house) throws Exception;

    public House getHouseById(Long id);

    public List<House> getHouse();

     public House updateHouse(Long id,HouseRequestDto house) throws Exception;
}
