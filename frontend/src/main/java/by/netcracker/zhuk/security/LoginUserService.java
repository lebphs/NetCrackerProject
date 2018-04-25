
package by.netcracker.zhuk.security;

import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface LoginUserService {

    void authenticateUserAndSetSession(String username, String password, HttpServletRequest request, HttpServletResponse response);

    String resolveHomeView(List<GrantedAuthority> authorities);
}
