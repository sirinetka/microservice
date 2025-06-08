package com.example.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor @ToString
@Builder @Data

public class ClientResponses {
    private Long idC;
    private String name;
    private String email;
    private String adresse;


}
