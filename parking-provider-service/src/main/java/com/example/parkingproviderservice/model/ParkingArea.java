package com.example.parkingproviderservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "parking_area")
public class ParkingArea {
    @Id
    @Field(type = FieldType.Keyword)
    private String areaId;
    @Field(type = FieldType.Keyword)
    private String parkingName;
    private int totalNoSpot;
    @Field(type = FieldType.Object)
    private Address address;
    @Field(type = FieldType.Keyword)
    private long providerId;  //Refrence to Provider 
}
