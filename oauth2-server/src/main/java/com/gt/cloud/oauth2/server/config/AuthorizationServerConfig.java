package com.gt.cloud.oauth2.server.config;

import com.gt.cloud.oauth2.server.service.FuckLiuXiaoMotherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * @author GTsung
 * @date 2022/1/24
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FuckLiuXiaoMotherService fuckLiuXiaoMotherService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
        configurer.authenticationManager(authenticationManager)
                .userDetailsService(fuckLiuXiaoMotherService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 配置client-id
                .withClient("admin")
                .secret(passwordEncoder.encode("admin123"))
                // 配置訪問token有效期
                .accessTokenValiditySeconds(3600)
                // 配置刷新token的有效期
                .refreshTokenValiditySeconds(864000)
                // 配置redirect_uri，用于授权成功后跳转
                .redirectUris("http://www.baidu.com")
                // 配置申请的权限范围
                .scopes("all")
                // 配置grant_type，表示授权类型
                .authorizedGrantTypes("authorization_code", "password");
    }

}
