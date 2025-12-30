package com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDetailResponse {
    private long id;
    private String name;
    private String description;
    private Date date;
    private int capacity;
    private String image;
    private double price;
    private boolean canReserve;

}
