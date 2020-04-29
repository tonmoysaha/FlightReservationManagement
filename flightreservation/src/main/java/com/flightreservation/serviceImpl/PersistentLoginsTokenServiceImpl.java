package com.flightreservation.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import com.flightreservation.entity.PersistentLoginToken;
import com.flightreservation.repository.PersistentLoginsTokenRespository;

@Component
public class PersistentLoginsTokenServiceImpl implements  PersistentTokenRepository {

	@Autowired
	private PersistentLoginsTokenRespository tokenRepository;

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		this.tokenRepository.save(new PersistentLoginToken(token.getUsername(), token.getSeries(),
				token.getTokenValue(), token.getDate()));

	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		PersistentLoginToken currentToken = tokenRepository.findBySeries(series);
	    PersistentLoginToken persistentLoginToken =	new PersistentLoginToken(
				  currentToken.getUsername(),
				  series,
				  tokenValue,
				  lastUsed);
	    persistentLoginToken.setId(currentToken.getId());
		tokenRepository.save(persistentLoginToken);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		PersistentLoginToken currentToken = tokenRepository.findBySeries(seriesId);
		return new PersistentRememberMeToken(currentToken.getUsername(), currentToken.getSeries(),
				currentToken.getTokenValue(), currentToken.getDate());
	}

	@Override
	public void removeUserTokens(String username) {
		PersistentLoginToken currentToken = tokenRepository.findByUsername(username);
		if (currentToken != null) {
			tokenRepository.delete(currentToken);
		}
	}

}
