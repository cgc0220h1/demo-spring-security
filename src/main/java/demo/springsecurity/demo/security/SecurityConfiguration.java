package demo.springsecurity.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(@Qualifier("userDetailServiceImp") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    //Truyền class vừa tạo vào. Ở đây phải sử dụng Qualifier để chỉ rõ tên của class mình định truyền vào
    //Thay cho một class mặc định có sẵn trong framework

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasRole("ADMIN");
        //Chặn các request vào trang chủ phải có role admin
        http.authorizeRequests().antMatchers("/login").permitAll();
        //Cho phép các request vào trang Login được vào thoải mái
        http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");
        //Sử dụng trang login của mình thay vì sử dụng trang login có sẵn. Cài đặt spring security kiểm tra password ở
        //2 ô input có name = username và name = password (param của form)
        http.csrf().disable();
        //Tuỳ chọn vô hiệu hoá bảo mật csrf để bỏ bớt mã hoá đăng nhập
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    //Cài đặt việc xác thực sẽ do userDetailService đảm nhiệm
    //Vì framework bắt phải mã hoá mật khẩu nên phải dùng noop để chấp nhận mật khẩu không được mã hoá
}
