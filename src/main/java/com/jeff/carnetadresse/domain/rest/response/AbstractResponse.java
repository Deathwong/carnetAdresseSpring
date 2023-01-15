package com.jeff.carnetadresse.domain.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AbstractResponse {
    private Integer status;
    private Instant date;
    private String message;
}
