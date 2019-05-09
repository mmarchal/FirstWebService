package com.mmapps.pp.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@Entity
public class Pronos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    Date dateMatch;

    @Column
    String Type;

    @Column
    String Sport;

    @Column
    String matchs;

    @Column
    String Prediction;

    @Column
    Double Cote;

    @Column
    String Explication;

    @Column
    boolean goodProno;
}
