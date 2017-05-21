
package br.com.own.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EstabelecimentoDetails {

    @JsonProperty("html_attributions")
    private List<Object> htmlAttributions = null;
   
    private Result result;
    private String status;

}
