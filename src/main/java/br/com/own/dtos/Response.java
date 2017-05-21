package br.com.own.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Response {

    @JsonProperty("html_attributions")
    private List<Object> htmlAttributions;
    
    @JsonProperty("results")
    private List<Resultado> resultados;
    
    private String status;
    
}
