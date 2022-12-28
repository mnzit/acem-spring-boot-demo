package com.acem.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "USERS")
public class User extends CommonEntity implements UserDetails {

    @Embedded
    private Name name;

    @Column(name = "EMAIL", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", length = 100, nullable = false)
    private String password;

    @Column(name = "CONTACT_NO", length = 100, nullable = false, unique = true)
    private String contactNo;

    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Role role;


    public User(Long id) {
        this.id = id;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Authority> authorities = role.getAuthorities();
        authorities.add(new Authority("ROL_" + role.getName()));
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }
}
