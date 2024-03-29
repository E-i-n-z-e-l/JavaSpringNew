package com.example.Practical_07.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception { // Устанавливает конфигурацию для HTTP-запросов;
        http.authorizeRequests()
                .antMatchers("/private-data").hasRole("ADMIN") // указывает, что путь /private-data доступен только для пользователей с ролью "ADMIN;
                .antMatchers("/public-data").permitAll() // указывает, что путь /public-data доступен для всех пользователей без ограничений;
                .and()
                .formLogin() // включает форму входа для аутентификации пользователей;
//                .loginPage("/login") // не работает, приводит к ошибке;
                .and()
                .logout() // включает возможность выхода из учетной записи пользователя;
                .logoutSuccessUrl("/login") // устанавливает URL-адрес перенаправления после успешного выхода из системы на страницу входа /login;
                .and()
                .exceptionHandling().accessDeniedPage("/login"); // устанавливает URL-адрес перенаправления в случае отказа в доступе;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // Настраивает менеджер аутентификации для провайдера аутентификации;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // используется для шифрования и проверки паролей;
        auth.inMemoryAuthentication() // указывает, что аутентификация будет проводиться на основе пользователей, определенных в памяти;
                .passwordEncoder(passwordEncoder) // устанавливает BCryptPasswordEncoder в качестве кодировщика паролей;
                // добавляет пользователей с указанными именем пользователя, зашифрованным паролем и ролями/привилегиями:
                .withUser("user").password(passwordEncoder.encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("12345")).roles("ADMIN");
    }

    /**
     * Конфигурирует безопасность для доступа к статическим ресурсам, игнорируя их аутентификацию и авторизацию.
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**"); // указывает, что все пути, начинающиеся с /resources/, будут игнорироваться без обязательной аутентификации;
    }

    /**
     * Создает и возвращает новый экземпляр BCryptPasswordEncoder для шифрования и проверки паролей.
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



