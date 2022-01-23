package com.gt.cloud.admin.security.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author GTsung
 * @date 2022/1/24
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String adminContextPath;

    public SecurityConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeRequests()
                // 1.配置所有靜態資源和登錄頁可以公開訪問
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                // 2.配置登錄和登出路徑
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler)
                .and().logout().logoutUrl(adminContextPath + "/logout").and()
                // 3.開啓http basic支持，admin-client注冊時需要使用
                .httpBasic()
                .and()
                .csrf()
                // 4.開啓基於cookie的csrf保護
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                // 5.忽略這些路徑的csrf保護以便admin-client注冊
                .ignoringAntMatchers(adminContextPath + "/instances", adminContextPath + "/actuator/**");

    }
}
