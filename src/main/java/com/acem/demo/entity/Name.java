package com.acem.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Name implements Serializable {

    @Column(name = "FIRST_NAME", length = 100, nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 100)
    private String middleName;

    @Column(name = "LAST_NAME", length = 100, nullable = false)
    private String lastName;

    @Override
    public String toString() {
        StringBuilder name = new StringBuilder();

        name.append(firstName);
        if (middleName != null) {
            name.append(" ");
            name.append(middleName);
        }
        name.append(" ");
        name.append(lastName);

        return name.toString();
    }
}
