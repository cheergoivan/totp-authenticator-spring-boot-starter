package com.github.cheergoivan.totp.spring.boot.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.cheergoivan.totp.TOTPAuthenticator;
import com.github.cheergoivan.totp.decoder.Decoder;
import com.github.cheergoivan.totp.decoder.SHA1Decoder;

/**
 * Auto configuration for TOTPAuthenticator.
 * 
 * @author Ivan
 */
@Configuration
@ConditionalOnClass(TOTPAuthenticator.class)
@EnableConfigurationProperties(TOTPConfigurationProperties.class)
public class TOTPAutoConfiguration {

	private final TOTPConfigurationProperties properties;

	@Autowired
	public TOTPAutoConfiguration(TOTPConfigurationProperties properties) {
		this.properties = properties;
	}

	@Bean
	@ConditionalOnMissingBean
	public TOTPAuthenticator totpAuthenticator()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Decoder decoder = new SHA1Decoder();
		Object inputDecoder = Class.forName(properties.getDecoder()).newInstance();
		if (inputDecoder instanceof Decoder) {
			decoder = Decoder.class.cast(inputDecoder);
		}
		return TOTPAuthenticator.builder()
				.allowedFutureValidationWindows(properties.getAllowedFutureValidationWindows())
				.allowedPastValidationWindows(properties.getAllowedPastValidationWindows())
				.hashAlgorithm(properties.getHashAlgorithm()).timeStepSize(properties.getTimeStepSize())
				.totpLength(properties.getLength()).decoder(decoder).build();
	}
}
