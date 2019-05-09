package com.mmapps.pp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactDto {

    Long id;

    String nomValue;

    String mailValue;

    String messageValue;

    @Override
    public String toString() {
        return "ContactDto{" +
                "id=" + id +
                ", nomMessage='" + nomValue + '\'' +
                ", mailMessage='" + mailValue + '\'' +
                ", messageValue='" + messageValue + '\'' +
                '}';
    }
}
