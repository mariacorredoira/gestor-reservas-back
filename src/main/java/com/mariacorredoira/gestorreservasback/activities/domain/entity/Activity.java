package com.mariacorredoira.gestorreservasback.activities.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Activity {
    private Long id;
    private String name;
    private String description;
    private Date date;
    private int capacity;
    private String image;
    private double price;

    public Activity(Long id) {
        this.id = id;
    }
}
