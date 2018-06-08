package com.yuanpan.jfamily.security.auth.token;

import com.yuanpan.jfamily.security.auth.AuthenticationToken;
import com.yuanpan.jfamily.security.config.TokenProperties;
import com.yuanpan.jfamily.security.model.UserContext;
import com.yuanpan.jfamily.security.model.token.RawAccessToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.auth.token
 * @Description:  身份验证
 * @date 2018/6/7 13:28
 */
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

	private final TokenProperties tokenProperties;

	@Autowired
	public TokenAuthenticationProvider(TokenProperties tokenProperties) {
		this.tokenProperties = tokenProperties;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		RawAccessToken rawAccessToken = (RawAccessToken) authentication.getCredentials();
		Jws<Claims> jwsClaims = rawAccessToken.parseClaims(tokenProperties.getSigningKey());
		String subject = jwsClaims.getBody().getSubject();
		List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
		List<GrantedAuthority> authorities = scopes.stream().map(SimpleGrantedAuthority::new).collect(toList());
		UserContext context = UserContext.create(subject, authorities);
		return new AuthenticationToken(context, context.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (AuthenticationToken.class.isAssignableFrom(authentication));
	}
}
