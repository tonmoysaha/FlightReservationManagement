package com.flightreservation.service;

public interface TFODetailsService {

	boolean isTotpEnabled(String name);
	public String generateNewGoogleAuthQrUrl(String email);
	public boolean verifyCode(String email, int code);
	public void enableTFOForUser(String email, int code);

}
