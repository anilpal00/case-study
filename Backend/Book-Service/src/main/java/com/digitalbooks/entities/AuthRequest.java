package com.digitalbooks.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class AuthRequest {

    private String userName;
    private String password;
}