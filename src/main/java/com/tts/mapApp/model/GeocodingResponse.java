package com.tts.mapApp.model;


import lombok.Data;

import java.util.List;

@Data
public class GeocodingResponse {
    private List<Geocoding> results;
}
