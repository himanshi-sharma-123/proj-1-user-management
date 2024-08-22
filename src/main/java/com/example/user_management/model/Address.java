package com.example.user_management.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Address {

    private String line1;
    private String city;
    private String zip;
}
