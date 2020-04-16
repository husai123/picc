package org.java.userauth.web;

import org.java.insurance.util.CookieUtils;
import org.java.userauth.config.JwtProperties;
import org.java.userauth.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@EnableConfigurationProperties(JwtProperties.class)
public class UserAuthController {


    @Autowired
    private UserAuthService userAuthService;


    @Autowired
    private JwtProperties jwtProperties;


    /**
     *     /**
     *      * 接收用户名，密码，判断数据是否正确，如果正确，则通过jwt生成token发送到客户端保存
     *      * 直接访问地址: localhost:15500/accredit
     *      * 通过网关访问的地址是: api.shopping.com/api/auth/accredit
     *      *
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/accredit")
    public ResponseEntity<Boolean> accredit(@RequestParam("username")String username,
                                            @RequestParam("password")String password,
                                            HttpServletRequest request,
                                            HttpServletResponse response){


      String toekn=userAuthService.accredit(username,password);


      if (toekn==null){
          return ResponseEntity.badRequest().build();
      }

        CookieUtils.setCookie(request,response,jwtProperties.getCookieName(),toekn,jwtProperties.getExpire()*60);


      return ResponseEntity.ok().build();
    }
}
