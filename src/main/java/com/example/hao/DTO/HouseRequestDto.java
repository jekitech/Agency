package com.example.hao.DTO;

import com.example.hao.Entity.Owner;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RequiredArgsConstructor
@Data
public class HouseRequestDto {

    private String name;
    private String location;
    private String price;

    private Long owner_id;

}
