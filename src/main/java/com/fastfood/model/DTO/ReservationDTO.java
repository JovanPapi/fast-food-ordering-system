package com.fastfood.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private String date;
    private String time;
    private int persons;
    private String name;
    private String clientMessage;
}
