package br.com.own.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Resultado {

    private Geometry geometry;
    private String id;
    
    @JsonProperty("place_id")
    private String placeId;
    
    private String reference;

}
