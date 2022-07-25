package com.example.hao.Service;

import com.example.hao.DTO.AgencyRequestDTO;
import com.example.hao.Entity.Agency;
import com.example.hao.Entity.House;
import com.example.hao.Repository.Agency_repo;
import com.example.hao.Repository.Hao_Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Agency_ServiceImp implements Agency_Service{

    private final Agency_repo agency_repo;
    private final Hao_Repo hao_repo;

    @Override
    public Agency saveAgency(AgencyRequestDTO agency) throws Exception {
        List<House> house = hao_repo.findAllById(agency.getHouse_id());

            Agency agency1 = Agency.builder()
                    .house(house)
                    .agency_name(agency.getAgency_name())
                    .build();
            return agency_repo.save(agency1);

    }

    @Override
    public List<Agency> getAgencyDetails() {
        return agency_repo.findAll();
    }

    @Override
    public Agency getAgencyByID(Long id) {
        return agency_repo.findById(id).get();
    }

    @Override
    public Agency updateAgency(Long id, AgencyRequestDTO agency) {

        Agency agency1 = getAgencyByID(id);
        agency1.setAgency_name(agency.getAgency_name());
        return agency_repo.save(agency1);
    }
}
