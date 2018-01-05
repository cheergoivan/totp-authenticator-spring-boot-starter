package com.github.cheergoivan.totp.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.github.cheergoivan.totp.HMACHashAlgorithm;
import com.github.cheergoivan.totp.decoder.SHA1Decoder;

/**
 * Configuration properties for TOTP
 * 
 * @author Ivan
 */
@ConfigurationProperties(prefix = "iplay.totp")
public class TOTPConfigurationProperties {
	/**
	 * Time size of a time window and the default value is 30s.
	 */
	private int timeStepSize = 30;

	/**
	 * The hash algorithm in HMAC(keyed-hash message authentication code). The
	 * default value is SHA_1. Optional value: SHA_256, SHA_512.
	 */
	private HMACHashAlgorithm hashAlgorithm = HMACHashAlgorithm.SHA_1;

	/**
	 * If you set allowedPassedValidationWindows=1, this would mean the
	 * validator could perform not only a validation against the current time
	 * window but also one more validations for the passed time window (for a
	 * total of 2 validations).
	 * 
	 * The default value is 2, which means the totp is valid in 1 minutes if the
	 * time window size is 30s.
	 */
	private int allowedPastValidationWindows = 2;

	/**
	 * If you set allowedFutureValidationWindows=1, this would mean the
	 * validator would perform not only a validation against the current time
	 * window but also one more validations for the next time window (for a
	 * total of 2 validations).
	 * 
	 * The default value is 0.
	 */
	private int allowedFutureValidationWindows = 0;

	/**
	 * The length of the time-based one-time password and the default value is
	 * 6.
	 * 
	 */
	private int length = 6;

	/**
	 * The decoder is a class which implements interface
	 * com.github.cheergoivan.totp.decoder.Decoder. It is used to decode the
	 * string to byte array when users provide a string format key instead of
	 * byte array format. The default value is
	 * com.github.cheergoivan.totp.decoder.SHA1Decoder.
	 */
	private String decoder = SHA1Decoder.class.getName();

	public int getTimeStepSize() {
		return timeStepSize;
	}

	public void setTimeStepSize(int timeStepSize) {
		this.timeStepSize = timeStepSize;
	}

	public HMACHashAlgorithm getHashAlgorithm() {
		return hashAlgorithm;
	}

	public void setHashAlgorithm(HMACHashAlgorithm hashAlgorithm) {
		this.hashAlgorithm = hashAlgorithm;
	}

	public int getAllowedPastValidationWindows() {
		return allowedPastValidationWindows;
	}

	public void setAllowedPastValidationWindows(int allowedPastValidationWindows) {
		this.allowedPastValidationWindows = allowedPastValidationWindows;
	}

	public int getAllowedFutureValidationWindows() {
		return allowedFutureValidationWindows;
	}

	public void setAllowedFutureValidationWindows(int allowedFutureValidationWindows) {
		this.allowedFutureValidationWindows = allowedFutureValidationWindows;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDecoder() {
		return decoder;
	}

	public void setDecoder(String decoder) {
		this.decoder = decoder;
	}
}
