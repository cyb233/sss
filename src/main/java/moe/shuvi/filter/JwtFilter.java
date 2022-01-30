package moe.shuvi.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import moe.shuvi.utils.JwtConstant;
import moe.shuvi.utils.JwtTokenUtil;
import moe.shuvi.utils.Result;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @ClassName JwtFilter
 * @Description TODO
 * @Author Administrator
 * @Date: 2022/1/10 17:33
 * @Version 1.0
 */
public class JwtFilter extends BasicAuthenticationFilter {

    //@Autowired
    private JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();


    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //从header中取
        String jwtToken = request.getHeader(JwtConstant.ACCESS_TOKEN);
        //header或body没带token的，直接放过，因为部分url匿名用户也可以访问
        //如果需要不支持匿名用户的请求没带token，这里放过也没问题，
        // 因为SecurityContext中没有认证信息，后面会被权限控制模块拦截
        if (StringUtils.isEmpty(jwtToken)) {
            chain.doFilter(request, response);
            return;
        }

        try {
            //认证结果,放入SecurityContext中
            UsernamePasswordAuthenticationToken authentication = getAuthentication(jwtToken, response);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result();
            result.setCode(Result.CODE_LOGIN_NEEDED);
            result.setMsg(Result.MSG_LOGIN_NEEDED);
            ObjectMapper objectMapper = new ObjectMapper();
            String string = objectMapper.writeValueAsString(result);
            response.getWriter().write(string);
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String jwtToken, HttpServletResponse response) {

        //权限
        //List<GrantedAuthority> authorities = new ArrayList<>();
        //解析token
        System.out.println(jwtTokenUtil);
        String username = jwtTokenUtil.getUserName(jwtToken);

        //获取权限
        Claims claims = jwtTokenUtil.getClaimsFromToken(jwtToken);
        //Collection<Map> collection = (Collection) claims.get(JwtConstant.JWT_PERMISSIONS_KEY);
        Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>) claims.get(JwtConstant.JWT_PERMISSIONS_KEY);
        /*System.out.println(collection);
        if (!collection.isEmpty()) {
            for (Map<String,String> map : collection) {
                //权限字符串
                String authority = map.get("authority");
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }*/
        if (!StringUtils.isEmpty(username)) {
            //踩坑提醒 此处password不能为null
            UserDetails principal = new User(username, "", authorities);
            return new UsernamePasswordAuthenticationToken(principal, null, authorities);
        }
        return null;
    }
}
