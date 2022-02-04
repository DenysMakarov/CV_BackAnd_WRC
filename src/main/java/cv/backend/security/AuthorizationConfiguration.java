package cv.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthorizationConfiguration extends WebSecurityConfigurerAdapter  {

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/h2-console/**");
        web.ignoring().antMatchers("/registration/**");
        web.ignoring().antMatchers("/events/events/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and();
        http.httpBasic();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/user")
                .permitAll()
//                .antMatchers("/users")
//                .hasRole("MODERATOR")
                .antMatchers(HttpMethod.POST, "/login")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/events/event/**")
                .access("hasRole('ADMINISTRATOR')")

                .antMatchers(HttpMethod.PUT, "/user/tickets/{login}")
                .access("#login == authentication.name")



//                .antMatchers("/account/user/{login}/role/{role}/**")
//                .hasRole("ADMINISTRATOR")
//                .antMatchers(HttpMethod.PUT, "/account/user/{login}/**")
//                .access("#login == authentication.name")
//                .antMatchers(HttpMethod.DELETE, "/account/user/{login}/**")
//                .access("#login == authentication.name or hasRole('ADMINISTRATOR')")
//                .antMatchers(HttpMethod.POST, "/forum/post/{author}/**")
//                .access("#author == authentication.name")
//                .antMatchers(HttpMethod.PUT, "/forum/post/{id}/comment/{author}/**")
//                .access("#author == authentication.name")
//                .antMatchers(HttpMethod.PUT, "/forum/post/{id}/**")
//                .access("@customSecurity.checkPostAuthority(#id, authentication.name)")
//                .antMatchers(HttpMethod.DELETE, "/forum/post/{id}/**")
//                .access("@customSecurity.checkPostAuthority(#id, authentication.name) or hasRole('MODERATOR')")
                .anyRequest()
                .authenticated();
    }


//    @Bean
//    CorsConfigurationSource corsConfigurationSource(){
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://192.168.1.181:3030"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }
}
