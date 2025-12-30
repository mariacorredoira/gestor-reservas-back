package com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;

    @Column(name = "price", nullable = false)
    private double price;

    public ActivityEntity(Long id) {
        this.id = id;
    }
}
