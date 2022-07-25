package com.example.hao.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class AgencyRequestDTO {

    private String agency_name;

    private List<Long> House_id;
}
