package com.example.demo.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VPCResponse implements Serializable {
    @JsonProperty("Results")
    private List<CarVPC> result;

    public List<CarVPC> getResult() {
        return result;
    }

    public void setResult(List<CarVPC> result) {
        this.result = result;
    }
}
