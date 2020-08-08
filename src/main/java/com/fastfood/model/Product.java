package com.fastfood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String description;

    @Column
    private String ingredients;

    @Column
    private String type;

    @Column
    private String nameTranslate;

    @Column
    private String descriptionTranslate;

    @Column
    private String ingredientsTranslate;

    @ManyToMany(mappedBy = "order")
    private List<User> userOrders;

}
