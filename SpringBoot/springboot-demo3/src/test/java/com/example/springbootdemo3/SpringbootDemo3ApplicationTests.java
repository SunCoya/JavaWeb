package com.example.springbootdemo3;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
class SpringbootDemo3ApplicationTests {
    @Test
    void JWTTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","tom");
        String jwt = Jwts.builder()
                .setClaims(map)//设置自定义数据
                .signWith(SignatureAlgorithm.HS256, "CoCoya")//指定签名算法与密钥
                .setExpiration(new Date(System.currentTimeMillis() + 120*1000))//设置令牌有效期2min
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void JWTParse(){
        Claims claims = Jwts.parser()
                .setSigningKey("CoCoya")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcxMDc2MzI2Mn0.Ce8r_iQAH5-pOzHJCtw0ZLHEfUY-tdYGyWDW_k0s3wE")
                .getBody();
        System.out.println(claims);
    }
}
