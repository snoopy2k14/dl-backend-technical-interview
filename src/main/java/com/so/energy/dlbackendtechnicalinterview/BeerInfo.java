package com.so.energy.dlbackendtechnicalinterview;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BeerInfo {
    private long beer_identifier;
    private String beer_name;
    private String beer_description;

    public long getBeer_identifier() {
        return beer_identifier;
    }

    public void setBeer_identifier(long beer_identifier) {
        this.beer_identifier = beer_identifier;
    }

    public String getBeer_name() {
        return beer_name;
    }

    public void setBeer_name(String beer_name) {
        this.beer_name = beer_name;
    }

    public String getBeer_description() {
        return beer_description;
    }

    public void setBeer_description(String beer_description) {
        this.beer_description = beer_description;
    }
}
