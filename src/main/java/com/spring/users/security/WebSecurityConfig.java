package com.spring.users.security;

import java.io.IOException;
import javax.xml.bind.DatatypeConverter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
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
                    }
                }).permitAll().and()
                  .logout().clearAuthentication(true).logoutUrl("/logout").addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                    	
                    	try {
                            redirectStrategy.sendRedirect(request, response, "/");
                        } catch (IOException e) {
                            
                            System.err.println("Caught IOException: " + e.getMessage());
                        }
                    }
                }).invalidateHttpSession(true)
                  .deleteCookies("JSESSIONID")
                  .logoutSuccessUrl("/logout")
                  .permitAll();
    }

    @Override
    public void configure(WebSecurity web) {
        
        web.ignoring().antMatchers("/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        String passDecrypted = new String(DatatypeConverter.parseBase64Binary(this.getPassword()));
        auth.inMemoryAuthentication().withUser(username).password("{noop}" + passDecrypted).roles("USER");
    }
    
}