package com.example.hao.Controller;

import com.example.hao.Api_Response.Api_Response;
import com.example.hao.DTO.HouseRequestDto;
import com.example.hao.Entity.House;
import com.example.hao.Service.Hao_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/hao")
public class Hao_Controller {

    private final Hao_Service hao_service;

    @PostMapping

    public ResponseEntity<Api_Response> saveHao(@RequestBody HouseRequestDto house){

        Api_Response response = Api_Response.builder()
                .message("Failed to save House details")
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {
            House hao = hao_service.saveHouse(house);
            response.setMessage("House details saved succesfully");
            response.setData(hao);
            response.setSuccess(true);
            response.setStatus(HttpStatus.CREATED);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping
    public ResponseEntity<Api_Response> getHouse(){
        Api_Response response = Api_Response.builder()
                .message("Failed to get list of House names")
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {

            List<House> hao = hao_service.getHouse();
            response.setMessage("Maintenance list retrieved successfully");
            response.setData_list(Collections.singletonList(hao));
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
                .message("Failed to get a House with id" + " " + id)
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {
            House hao = hao_service.getHouseById(id);
            response.setMessage("House of id " + "" + id + "retrieved successfully");
            response.setData(hao);
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Api_Response> updateHouseDetails(@PathVariable("id") Long id, @RequestBody HouseRequestDto house) {
        Api_Response response = Api_Response.builder()
                .message("Failed to update House with id" + " " + id)
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {
            House hao = hao_service.updateHouse(id,house);
            response.setMessage("House updated succesfully");
            response.setData(hao);
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
