package com.sushant.kafka.learning.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private Double latitude;
    private Double longitude;

    public static Location setLocation(final Double latitude, final Double longitude) {
        return new Location(latitude, longitude);
    }
}
