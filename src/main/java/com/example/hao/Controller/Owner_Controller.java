package com.example.hao.Controller;

import com.example.hao.Api_Response.Api_Response;
import com.example.hao.Entity.House;
import com.example.hao.Entity.Owner;
import com.example.hao.Service.Owner_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/owner")
public class Owner_Controller {

    private final Owner_Service owner_service;

    @PostMapping

    public ResponseEntity<Api_Response> saveownerDetails (@RequestBody Owner owner){

        Api_Response api_response = Api_Response.builder()
                .message("Process fail")
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try{
            Owner owner1 = owner_service.saveOwnerDetails(owner);
            api_response.setMessage("House details saved succesfully");
            api_response.setData(owner1);
            api_response.setSuccess(true);
            api_response.setStatus(HttpStatus.CREATED);
            return ResponseEntity.status(api_response.getStatus()).body(api_response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(api_response);
        }
    }
    @GetMapping
    public ResponseEntity<Api_Response> getOwnerDetails(){
        Api_Response response = Api_Response.builder()
                .message("Failed to get list of Owner details")
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {

            List<Owner> owners = owner_service.getownerDetails();
            response.setMessage("Owner list retrieved successfully");
            response.setData_list(Collections.singletonList(owners));
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
                .message("Failed to get a Owner with id" + " " + id)
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {
            Owner owner = owner_service.getOwnerDetailsByID(id);
            response.setMessage("Owner of id " + "" + id + "retrieved successfully");
            response.setData(owner);
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Api_Response> updateHouseDetails(@PathVariable("id") Long id, @RequestBody Owner owner) {
        Api_Response response = Api_Response.builder()
                .message("Failed to update Owner with id" + " " + id)
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(new Date())
                .success(false)
                .build();
        try {
            Owner owner1 = owner_service.updateOwner(id, owner);
            response.setMessage("Owner updated succesfully");
            response.setData(owner1);
            response.setSuccess(true);
            response.setStatus(HttpStatus.OK);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
