package com.user.userAuth.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int phoneid;

    @Column(nullable = false)
    private long number;

    @Column(nullable = false)
    private int cityCode;

    @Column(nullable = false)
    private String countryCode;

    @ManyToOne
    public User user;

}
