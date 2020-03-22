package com.spring.users.security;

import java.util.Date;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Value("${spring.security.user.name}")
    private String username;
    
    @Value("${spring.security.user.password}")
    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated().and()
            .formLogin().loginPage("/login")
            .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        redirectStrategy.sendRedirect(request, response, "/index");
                     
//                        Date inTime = new Date(System.currentTimeMillis());
//                        Auditlog auditLog = new Auditlog();
//                        auditLog.setInfo("Login");
//                        auditLog.setStatus(AUDITLOG_INFO.getMessage());
//                        auditLog.setStartTime(inTime);
//                        auditLog.setObjectData(authentication.toString());
//                        auditLog.setFunctionName("Login");
//                        auditLogService.saveOrUpdate(auditLog);
                    }
                }).permitAll().and()
                  .logout().clearAuthentication(true).logoutUrl("/logout").addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                    	System.out.println("from logout");
                    	try {
                            redirectStrategy.sendRedirect(request, response, "/");
                        } catch (IOException e) {
                            
//                            Date time = new Date(System.currentTimeMillis());
//                            Auditlog auditLog = new Auditlog();
//                            auditLog.setInfo("Logout Error");
//                            auditLog.setStatus(AUDITLOG_WARN.getMessage());
//                            auditLog.setStartTime(time);
//                            auditLog.setEndTime(time);
//                            auditLog.setObjectData(e.toString());
//                            auditLog.setFunctionName("Logout Error");
//                            auditLogService.saveOrUpdate(auditLog);
                        }
                       
//                        Date time = new Date(System.currentTimeMillis());
//                        Auditlog auditLog = new Auditlog();
//                        auditLog.setInfo("Logout");
//                        auditLog.setStatus(AUDITLOG_INFO.getMessage());
//                        auditLog.setObjectData(authentication.toString());
//                        auditLog.setEndTime(time);
//                        auditLog.setFunctionName("Logout");
//                        auditLogService.saveOrUpdate(auditLog);
                    }
                }).invalidateHttpSession(true)
                  .deleteCookies("JSESSIONID")
                  .logoutSuccessUrl("/logout")
                  .permitAll();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/webjars/**");
        web.ignoring().antMatchers("/ws-ebill/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String passDecrypted;
        passDecrypted = new String(DatatypeConverter.parseBase64Binary(this.getPassword()));
        auth.inMemoryAuthentication()
        .withUser(username).password("{noop}" + passDecrypted).roles("USER");
    }
    
}