package com.yedam.tfprj.admin.worker.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Data
public class WorkerVO implements UserDetails {
    private String workerId;
    private String password;
    private int staffStatusCd;
    private String workerName;
    private String phoneNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date birth;

    private int militaryCd;
    private String memo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date startDay;

    private int positionCd;
    private int late;
    private int absence;
    private int userType;
    private String goingTime;
    private String quittingTime;
    private int gender;
    private int postcode;
    private String roadAddress;
    private String detailAddress;
    private String jibunAddress;

    private String fileName;
    private String filePath;
    private String originalFileName;
    private String workerAuth = "ADMIN";
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.workerAuth));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    // 시큐리티의 userName
    // -> 따라서 얘는 인증할 때 id를 봄
    @Override
    public String getUsername() {
        return this.workerId;
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
