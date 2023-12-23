package com.example.parkingproviderservice.dto;

import com.example.parkingproviderservice.model.ChargeType;
import com.example.parkingproviderservice.model.SpotType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FareCalculatorDto {
    private String checkInDateTime;
    private String checkOutDateTime;
    private String areaId;
    private SpotType spotType;
    private ChargeType chargeType;
    private int count;
}
