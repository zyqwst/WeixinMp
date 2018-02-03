/**
 * 
 */
package com.albert.wechat.utils;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import com.albert.wechat.exceptions.UnAuthorizedException;
import com.albert.wechat.exceptions.WeixinMpException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/** 
* @ClassName: JwtUtil 
* @Description: 
* @author albert
* @date 2018年2月3日 上午11:10:06 
*  
*/
public class JwtUtil {
//	private final static Base64.Decoder m_decoder = Base64.getDecoder();
	private final static Base64.Encoder m_encoder = Base64.getEncoder();
	/**
	 * @param id
	 * @param issuer
	 * @param subject
	 * @param ttlMillis 过时毫秒数，负数表示不过时
	 * @param secretKey
	 * @return
	 */
	public static String createJWT(String id, String issuer, String subject, long ttlMillis,String secretKey) {

	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    byte[] apiKeySecretBytes = m_encoder.encode(secretKey.getBytes());
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    JwtBuilder builder = Jwts.builder().setId(id)
	                                .setIssuedAt(now)
	                                .setSubject(subject)
	                                .setIssuer(issuer)
	                                .signWith(signatureAlgorithm, signingKey);
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }
	    return builder.compact();
	}
	/**
	 * 
	 * @param jwt
	 * @param secretKey
	 */
	public static void parseJWT(String jwt,String secretKey) throws WeixinMpException{
	    try {
			Claims claims = Jwts.parser()         
			   .setSigningKey(m_encoder.encode(secretKey.getBytes()))
			   .parseClaimsJws(jwt).getBody();
			System.out.println("ID: " + claims.getId());
			System.out.println("Subject: " + claims.getSubject());
			System.out.println("Issuer: " + claims.getIssuer());
			System.out.println("Expiration: " + claims.getExpiration());
		} catch (ExpiredJwtException e) {
			throw new UnAuthorizedException("权限过期");
		} catch (UnsupportedJwtException e) {
			throw new UnAuthorizedException("鉴权错误");
		} catch (MalformedJwtException e) {
			throw e;
		} catch (SignatureException e) {
			throw new UnAuthorizedException("鉴权不通过");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw e;
		}
	}
	public static void main(String[] args) {
		String s = createJWT("123", "abc", "abc", -1, "abc");
		System.out.println(s);
		parseJWT(s, "abc");
	}
}
