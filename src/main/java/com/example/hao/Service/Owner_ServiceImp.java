package com.example.hao.Service;

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
public class Owner_ServiceImp implements Owner_Service{

    private final Owner_Repo owner_repo;
    private final Hao_Repo hao_repo;

    @Override
    public Owner saveOwnerDetails(Owner owner) {

        return owner_repo.save(owner);
    }

    @Override
    public Owner getOwnerDetailsByID(Long id) {

        return owner_repo.findById(id).get();
    }

    @Override
    public List<Owner> getownerDetails() {

        return owner_repo.findAll();
    }

    @Override
    public Owner updateOwner(Long id, Owner owner) {

        Owner owner1 = getOwnerDetailsByID(id);
        owner1.setAddress(owner.getAddress());
        owner1.setEmail(owner.getEmail());
        owner1.setName(owner.getName());
        owner1.setPhoneNumber(owner.getPhoneNumber());

        return owner_repo.save(owner1);
    }
}
