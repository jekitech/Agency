package com.example.hao.Controller;

import com.example.hao.Api_Response.Api_Response;
import com.example.hao.DTO.AgencyRequestDTO;
import com.example.hao.DTO.HouseRequestDto;
import com.example.hao.Entity.Agency;
import com.example.hao.Entity.House;
import com.example.hao.Service.Agency_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/agency")
public class Agency_Controller {

    private final Agency_Service agency_service;

    @PostMapping

    public ResponseEntity<Api_Response> saveAgency(@RequestBody AgencyRequestDTO agencyRequestDTO){

        Api_Response response = Api_Response.builder()
                .message("Failed to save Agency details")
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {
            Agency agency = agency_service.saveAgency(agencyRequestDTO);
            response.setMessage("Agency details saved succesfully");
            response.setData(agency);
            response.setSuccess(true);
            response.setStatus(HttpStatus.CREATED);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping
    public ResponseEntity<Api_Response> getAgency(){
        Api_Response response = Api_Response.builder()
                .message("Failed to get list of Agency names")
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {

            List<Agency> agencies = agency_service.getAgencyDetails();
            response.setMessage("Agency list retrieved successfully");
            response.setData_list(Collections.singletonList(agencies));
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK);
            return ResponseEntity.status(response.getStatus()).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Api_Response> getByID(@PathVariable("id") Long id) {
        Api_Response response = Api_Response.builder()
                .message("Failed to get a Agency with id" + " " + id)
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {
            Agency hao = agency_service.getAgencyByID(id);
            response.setMessage("Agency of id " + "" + id + "retrieved successfully");
            response.setData(hao);
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Api_Response> updateAgencyDetails(@PathVariable("id") Long id, @RequestBody AgencyRequestDTO agencyRequestDTO) {
        Api_Response response = Api_Response.builder()
                .message("Failed to update Agency with id" + " " + id)
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {
            Agency agency = agency_service.updateAgency(id,agencyRequestDTO);
            response.setMessage("Agency updated succesfully");
            response.setData(agency);
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
