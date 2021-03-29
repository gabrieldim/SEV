package mk.ukim.finki.sev.config.security;

import mk.ukim.finki.sev.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final PasswordAndUsernameAuthenticationProvider authenticationProvider;
    private final UserService userService;

    public WebSecurityConfig(PasswordEncoder passwordEncoder,
                             PasswordAndUsernameAuthenticationProvider authenticationProvider, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/css/**","/img/**", "/js/**", "/webfonts/**", "/home", "/assets/**", "/register", "/auth/logout").permitAll();
//                .and()
//                .formLogin()
//                .loginPage("/auth/login").permitAll()
//                .failureUrl("/auth/login?error=BadCredentials")
//                .defaultSuccessUrl("/home", true)
//                .and()
//                .x509()
//                .subjectPrincipalRegex("CN=(.*?)(?:,|$)")
//                .userDetailsService(this.userService);
//                .and()
//                .logout()
//                .logoutUrl("/auth/logout")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/auth/login");
//                .and()
//                .exceptionHandling().accessDeniedPage("/access_denied");

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider);
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//                .and()
//                .x509()
//                .subjectPrincipalRegex("CN=(.*?)(?:,|$)")
//                .userDetailsService(userDetailsService());
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) {
//                if (username.equals("Bob")) {
//                    return new User(username, "",
//                            AuthorityUtils
//                                    .commaSeparatedStringToAuthorityList("ROLE_USER"));
//                }
//                throw new UsernameNotFoundException("User not found!");
//            }
//        };
//    }

}
