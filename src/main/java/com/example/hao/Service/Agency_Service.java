package com.example.hao.Service;

import com.example.hao.DTO.AgencyRequestDTO;
import com.example.hao.Entity.Agency;

import java.util.List;

public interface Agency_Service {

    public Agency saveAgency(AgencyRequestDTO agency) throws Exception;

    public List<Agency> getAgencyDetails ();

    public Agency getAgencyByID (Long id);

    public Agency updateAgency(Long id, AgencyRequestDTO agency);
}
