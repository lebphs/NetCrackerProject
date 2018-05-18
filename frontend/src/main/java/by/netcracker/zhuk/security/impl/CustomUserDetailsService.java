package by.netcracker.zhuk.security.impl;

import by.netcracker.zhuk.entities.UserEntity;
import by.netcracker.zhuk.models.UserViewModel;
import by.netcracker.zhuk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        List<UserEntity> userEntities = userService.findUserByUserName(username);

        if (userEntities.size() != 1) {
            throw new UsernameNotFoundException("Username not found");//todo rewrite exception message
        }
        UserEntity userEntity = userEntities.get(0);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userEntity.getRole().getName()));
        return buildUserForAuthentication(userEntity, authorities);
    }

    private CustomUser buildUserForAuthentication(UserEntity userEntity, List<GrantedAuthority> authorities) {
        UserViewModel userViewModel = new UserViewModel(userEntity.getUsername(), userEntity.getPassword(), authorities);
        userViewModel.setId(userEntity.getId());
        userViewModel.setPassword(userEntity.getPassword());
        userViewModel.setUsername(userEntity.getUsername());
        return userViewModel;
    }


}
