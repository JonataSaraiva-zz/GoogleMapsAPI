
package br.com.own.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Photo {

    private Integer height;
    
    @JsonProperty("html_attributions")
    private List<String> htmlAttributions = null;
    
    @JsonProperty("photo_reference")
    private String photoReference;
    
    private Integer width;

}
