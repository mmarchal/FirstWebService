package com.mmapps.pp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PronosDto
{

    Long id;

    Date dateMatch;

    String Type;

    String Sport;

    String Match;

    String Prediction;

    Double Cote;

    String Explication;

    boolean goodProno;
}
