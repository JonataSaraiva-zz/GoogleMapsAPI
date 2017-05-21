
package br.com.own.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Result {

    private List<AddressComponent> addressComponents;
    
    private String adrAddress;
    
    @JsonProperty("formatted_address")
    private String formattedAddress;
    
    private Geometry geometry;
    
    private String icon;
    
    private String id;
    
    private String name;
    
    private List<Photo> photos;
    
    private String placeId;
    
    private Float rating;
    
    private String reference;
    
    private List<Review> reviews;
    
    private String scope;
    
    private List<String> types;
    
    private String url;
    
    @JsonProperty("utc_offset")
    private Integer utcOffset;
    
    private String vicinity;

}
