package com.xiaomy.book_city.common.security.utils;

import com.xiaomy.book_city.app.service.UserService;
import com.xiaomy.book_city.common.security.entity.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * - token的工具类
 */
@Component
public class JwtTokenUtil implements Serializable {
  private static final long SerializableVersionUID = 3301605591108950415L;

  private static final String CLAIM_KEY_USERNAME = "sub";

  private static final String CLAIM_KEY_CREATED = "created";

  @Value("${jwt.secret}")
  private String secret; // - 生成token的密钥

  @Value("${jwt.expiration}")
  private Long expiration; // - token 的过期时间

  @Autowired
  private UserService userService;

  /**
   *  - 生成token的过期时间
   * @return
   */
  private Date generateExpirationDate(){
    return new Date(System.currentTimeMillis() + expiration * 1000);
  }

  /**
   *  - 生成token
   * @return
   */
  public String generateToken(UserDetails userDetails){
    Map<String, Object> claims = new HashMap<>();
    claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
    claims.put(CLAIM_KEY_CREATED, new Date());
    return generateToken(claims);
  }

  String generateToken(Map<String, Object> claims){
    return Jwts.builder()
        .setClaims(claims)
        .setExpiration(generateExpirationDate())
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }


  /**
   * 获取token中包含的数据声明
   * @param token
   * @return
   */
  public Claims getClaimsFromToken(String token){
    Claims claims;
    try {
      claims = Jwts.parser()
          .setSigningKey(secret)
          .parseClaimsJws(token)
          .getBody();
    }catch (Exception e){
      claims = null;
    }
    return claims;
  }

  /**
   *  - 刷新token
   * @return
   */
  public String refreshToken(String token){
    String refreshedToken;
    try {
      Claims claims = getClaimsFromToken(token);
      claims.put(CLAIM_KEY_CREATED, new Date());
      refreshedToken = generateToken(claims);
    }catch (Exception e){
      refreshedToken = null;
    }
    return refreshedToken;
  }

  /**
   *  - 根据token获取用户名
   * @return
   */
  public String getUsernameFromToken(String token){
    String username;
    try {
      Claims claims = getClaimsFromToken(token);
      username = claims.getSubject();
    }catch (Exception e){
      username = null;
    }
    return username;
  }

  /**
   *  - 获取token的创建时间
   * @param token
   * @return
   */
  public Date getCreateDateFromToken(String token){
    Date createDate;
    try {
      Claims claims = getClaimsFromToken(token);
      createDate = new Date((Long) claims.get(CLAIM_KEY_CREATED));
    }catch (Exception e){
      createDate = null;
    }
    return createDate;
  }

  /**
   *  - 获取token的过期时间
   * @return
   */
  public Date getExpirationDateFromToken(String token){
    Date expiration;
    try {
      Claims claims = getClaimsFromToken(token);
      expiration = claims.getExpiration();
    }catch (Exception e){
      expiration = null;
    }
    return expiration;
  }

  /**
   *  - 判断这个token是否过期
   * @param token
   * @return
   */
  private Boolean isTokenExpired(String token){
    Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  /**
   * 判断创建时间是否大于最后一次登录时间
   * @param created  创建时间
   * @param lastPasswordReset  最后一次重置密码的时间
   * @return
   */
  private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset){
    return (lastPasswordReset != null && created.before(lastPasswordReset));
  }
  public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
    final Date created = getCreateDateFromToken(token);
    return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
        && !isTokenExpired(token);
  }

  /**
   * 验证token
   * @param token
   * @param userDetails
   * @return
   */
  public Boolean validateToken(String token, UserDetails userDetails){
    UserDetailsImpl user = (UserDetailsImpl) userDetails;

    String username = getUsernameFromToken(token);
    String userToken = userService.findUserByUsername(username);
    if(!userToken.equals(token)){
      return false;
    }
    return (username.equals(user.getUsername()) && !isTokenExpired(token));
  }
}
