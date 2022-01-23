package com.gt.cloud.oauth2.server.service;

import com.gt.cloud.oauth2.server.domain.Fucker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GTsung
 * @date 2022/1/24
 */
@Service
public class FuckLiuXiaoMotherService implements UserDetailsService {

    private List<Fucker> fuckers;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("fuck");
        fuckers = new ArrayList<>();
        fuckers.add(new Fucker("LiuXiao", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        fuckers.add(new Fucker("LiuXiao's mother", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        fuckers.add(new Fucker("fuck", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Fucker> fuckerList = fuckers.stream()
                .filter(fucker -> fucker.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(fuckerList)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return fuckerList.stream().findFirst().orElse(null);
    }
}
