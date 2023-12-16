package com.example.crud.poorganizer.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Table(name = "user")
@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class User implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String email;

    private String password;

    private Boolean situation;

    private UserPermission permission;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.permission == UserPermission.ADMIN)
            return List.of(new SimpleGrantedAuthority("PERMISSION_ADMIN"),
                    new SimpleGrantedAuthority("PERMISSION_USER"));
        else return List.of(new SimpleGrantedAuthority("PERMISSION_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
