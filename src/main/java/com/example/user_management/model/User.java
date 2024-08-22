package com.example.user_management.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class User {

    private int id;
    private String name;
    private String email;
    private String phone_no;
    private Address address;

}
