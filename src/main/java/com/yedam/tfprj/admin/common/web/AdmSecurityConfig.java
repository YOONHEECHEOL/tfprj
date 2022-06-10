package com.yedam.tfprj.admin.common.web;

import com.yedam.tfprj.admin.worker.service.WorkerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Order(0)
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AdmSecurityConfig extends WebSecurityConfigurerAdapter {
    private final WorkerServiceImpl workerServiceImpl;
    /**
     * 규칙 설정
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/resources/**","/css/**","/ckeditor/**","/font/**","/images/**","/js/**","/vendor/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/adm/loginview","/adm/login","/download","/cli/imageUpload").permitAll()
                .and()
                .antMatcher("/adm/**")
                .authorizeRequests().anyRequest().hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/adm/loginview")
                .loginProcessingUrl("/adm/login")
                .defaultSuccessUrl("/adm/index")
                .successHandler(admLoginSuccessHandler())
                .failureUrl("/adm/loginFail") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
                .and()
                .logout()
                .logoutUrl("/adm/logout")
                .logoutSuccessHandler(admLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .and()
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .csrf().disable();		//로그인 창
    }

    /**
     * 로그인 인증 처리 메소드
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(workerServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Bean
    public AdmCustomLoginSuccessHandler admLoginSuccessHandler(){
        return new AdmCustomLoginSuccessHandler();
    }

    @Bean
    public AdmCustomLogoutSuccessHandler admLogoutSuccessHandler(){
        return new AdmCustomLogoutSuccessHandler();
    }
}
