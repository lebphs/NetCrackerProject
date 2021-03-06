package by.netcracker.zhuk.security.impl;

import by.netcracker.zhuk.security.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Service
public class LoginUserServiceImpl implements LoginUserService {


    private static final String VIEW_NAME_HOME_ADMIN = "admin-page";
    private static final String VIEW_NAME_HOME_STUDENT = "student-page";
    private static final String VIEW_NAME_HOME_HEAD_OF_PRACTICE = "head-page";

    private static final String ROLE_STUDENT = "student";
    private static final String ROLE_ADMIN = "admin";
    private static final String ROLE_HEAD = "head_of_practice";


    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;


    public void authenticateUserAndSetSession(String username, String password, HttpServletRequest request, HttpServletResponse response) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, new ArrayList<GrantedAuthority>()));
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

    public String resolveHomeView(List<GrantedAuthority> authorities) {
        if (!CollectionUtils.isEmpty(authorities)) {
            String authority = authorities.get(0).getAuthority();
            if (authority.equalsIgnoreCase(ROLE_STUDENT)) {
                return VIEW_NAME_HOME_STUDENT;
            }
            if (authority.equalsIgnoreCase(ROLE_ADMIN)) {
                return VIEW_NAME_HOME_ADMIN;
            }
            if (authority.equalsIgnoreCase(ROLE_HEAD)) {
                return VIEW_NAME_HOME_HEAD_OF_PRACTICE;
            }
        }
        return "redirect:/login-page";
    }

}
