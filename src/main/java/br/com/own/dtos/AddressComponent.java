
package br.com.own.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddressComponent {

    @JsonProperty("long_name")
    private String longName;
   
    @JsonProperty("short_name")
    private String shortName;
  
    private List<String> types;
	
}
