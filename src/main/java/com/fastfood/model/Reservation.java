package com.fastfood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reservations")
public class Reservation {
    @Id
    private String id;

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private int persons;

    @Column
    private String name;

    @Column
    private String clientMessage;

}
