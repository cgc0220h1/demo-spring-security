package demo.springsecurity.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").access("hasRole('ROLE_ADMIN')");
        //Chặn các request vào trang chủ phải có role admin
        http.authorizeRequests().antMatchers("/login").permitAll();
        //Cho phép các request vào trang Login được vào thoải mái
        http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");
        //Sử dụng trang login của mình thay vì sử dụng trang login có sẵn. Cài đặt spring security kiểm tra password ở
        //2 ô input có name = username và name = password (param của form)
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }
}
