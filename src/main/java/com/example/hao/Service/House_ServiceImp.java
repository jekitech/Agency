package com.example.hao.Service;

import com.example.hao.DTO.HouseRequestDto;
import com.example.hao.Entity.House;
import com.example.hao.Entity.Owner;
import com.example.hao.Repository.Hao_Repo;
import com.example.hao.Repository.Owner_Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class House_ServiceImp implements Hao_Service{

    private final Hao_Repo hao_repo;
    private final Owner_Repo owner_repo;

    @Override
    public House saveHouse(HouseRequestDto house) throws Exception {

        Optional<Owner> owner = owner_repo.findById(house.getOwner_id());

        if(owner.isPresent()){
            House house1 = House.builder()
                    .owner(owner.get())
                    .location(house.getLocation())
                    .name(house.getName())
                    .price(house.getPrice())
                    .build();
            return hao_repo.save(house1);
        }else{
            throw new Exception("Owner not found");
        }

    }

    @Override
    public House getHouseById(Long id) {
        return hao_repo.findById(id).get();
    }

    @Override
    public List<House> getHouse() {
        return hao_repo.findAll();
    }

    @Override
    public House updateHouse(Long id, HouseRequestDto house) throws Exception {

        Optional<Owner> owner = owner_repo.findById(house.getOwner_id());

        if(owner.isPresent()){

            House house1 = getHouseById(id);
            house1.setName(house.getName());
            house1.setLocation(house.getLocation());
            house1.setOwner(owner.get());
            house1.setPrice(house.getPrice());
            return hao_repo.save(house1);

        }else{
            throw new Exception("Owner not found");
        }


    }
}
