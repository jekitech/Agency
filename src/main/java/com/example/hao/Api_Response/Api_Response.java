package com.example.hao.Api_Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Api_Response {

    private Boolean success;

    private String message;

    @JsonFormat(pattern = "YYYY-MM-DD ")
    private Date timestamp;


    private HttpStatus status;


    private Object data;


    private List<Object> data_list;
}
