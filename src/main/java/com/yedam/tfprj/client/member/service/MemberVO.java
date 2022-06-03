package com.yedam.tfprj.client.member.service;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class MemberVO implements UserDetails {
    private String memberId;
    private String memberName;
    private String tel;
    private int    grade;
    private String password;
    private int    blacklistYn;
    private String blacklistReason;
    private String trophy;
    private String preferred;
    private int    teamId;
    private int ROWNUM;
    private String memberAuth ="USER";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.memberAuth));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    // 시큐리티의 userName
    // -> 따라서 얘는 인증할 때 id를 봄
    @Override
    public String getUsername() {
        return this.memberId;
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
