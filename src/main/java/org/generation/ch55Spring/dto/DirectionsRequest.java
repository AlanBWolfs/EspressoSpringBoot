package org.generation.ch55Spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectionsRequest {
    private String street;
    private String zipCode;
    private String suburb;
    private String country;
}