package com.spring.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
public class Cupon {
    private Long id;
    private String code;
    private BigDecimal discount;
    private String exp_date;
}
