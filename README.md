# totp-authenticator-spring-boot-starter
A spring boot starter for [TOTPAuthenticator](https://github.com/cheergoivan/totp-authenticator).

## Quick start
### Add Maven dependency
```xml
<dependency>
    <groupId>com.github.cheergoivan</groupId>
    <artifactId>totp-authenticator-spring-boot-starter</artifactId>
    <version>1.0</version>
</dependency>
```
### Usage
```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.cheergoivan.totp.TOTPAuthenticator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TOTPAuthenticatorTest {
	
	@Autowired
	private TOTPAuthenticator totpAuthenticator;

	@Test
	public void contextLoads() {
		String secret = "ASDFGFHJKL";
		String totp = totpAuthenticator.generateTOTP(secret);
		System.out.println(totp);
		System.out.println(totpAuthenticator.validateTOTP(secret, totp));
	}
}
```
### Configuration
Here are all supported configurations and their default values in TOTPAuthenticator.
```
iplay.totp.length=6
iplay.totp.time-step-size=30
iplay.totp.hash-algorithm=SHA_1
iplay.totp.allowed-past-validation-windows=2
iplay.totp.allowed-future-validation-windows=0
iplay.totp.decoder=com.github.cheergoivan.totp.decoder.SHA1Decoder
```


## License
This project is licensed under the [Apache 2 License](http://www.apache.org/licenses/LICENSE-2.0).

