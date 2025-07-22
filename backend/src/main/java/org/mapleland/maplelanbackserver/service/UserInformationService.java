package org.mapleland.maplelanbackserver.service;

import org.mapleland.maplelanbackserver.table.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;


public class UserInformationService implements UserDetails {

    private final User user;

    public UserInformationService(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));

    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getBannedHours() == null || user.getBannedHours().isBefore(LocalDateTime.now());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
    public String getGlobalName() {
        return user.getGlobalName();
    }

    public String getAvatar() {
        return user.getImage();
    }

    public int getUserId() {
        return user.getUserId();
    }

    public String getDiscordId() {
        return user.getDiscordId();
    }

    public User getEntity() {
        return user;
    }
}
