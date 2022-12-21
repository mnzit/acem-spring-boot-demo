package com.acem.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "AUTHORITIES")
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends CommonEntity implements GrantedAuthority {

    @Column(length = 150, name = "NAME", nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
