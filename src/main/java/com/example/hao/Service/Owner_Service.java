package com.example.hao.Service;

import com.example.hao.Entity.Owner;

import java.util.List;

public interface Owner_Service {

    public Owner saveOwnerDetails(Owner owner);

    public Owner getOwnerDetailsByID (Long id);

    public List<Owner> getownerDetails();

    public Owner updateOwner(Long id, Owner owner);

}
