//package com.yedam.tfprj.client.common.web;
//
//import com.yedam.tfprj.client.member.service.MemberServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@Order(1)
//public class CliSecurityConfig extends WebSecurityConfigurerAdapter {
//    private final MemberServiceImpl memberServiceImpl;
//    /**
//     * 규칙 설정
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers( "/cli/home","/cli/loginview","/resources/**").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
//                // USER, ADMIN 접근 허용
//                .antMatchers("/client/**").hasRole("USER")
//                .and()
//                .formLogin()
//                .loginPage("/cli/loginview")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/cli/home")
//                .successHandler(loginSuccessHandler())
//                .failureUrl("/cli/loginFail") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
//                .and()
//                .csrf().disable();		//로그인 창
//    }
//
//    /**
//     * 로그인 인증 처리 메소드
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
//    }
//    @Bean
//    public CustomLoginSuccessHandler loginSuccessHandler(){
//        return new CustomLoginSuccessHandler();
//    }
//}
