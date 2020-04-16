package org.java.userauth.text;


import org.java.insurance.userauth.pojo.UserInfo;
import org.java.insurance.userauth.utils.JwtUtils;
import org.java.insurance.userauth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "C:\\tmp\\rsa\\rsa.pub";

    private static final String priKeyPath = "C:\\tmp\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(2L, "chris"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJjaHJpcyIsImV4cCI6MTU4NzA0MzMyN30.kckWpyX4yxA0f3TFJvD4PiMvxAr_GnylRzmTdY3_ypvYTR2nUD82eCtp6NTgs-1fvjk2C2DwdsDFW1qPa-nE8vZ2BANDngmO9KKq-L0RCRQDGh8Jv6oP61f88Pm3UDy9MwKgON4uaPD_H78cFgsOhFo9mYrgJdRbWA69qQxoy_c";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}