package br.com.joselucianorc.postalcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class ThirdPartTest {
	
	final String thirdPartUrl = "https://api.publicapis.org/entries?category=animals&https=true&Cors=unknow&Auth=apiKey"; 
	
	@Test
	public void testThirdPartApi() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(thirdPartUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		assertEquals(200, result.getStatusCodeValue());
		assertTrue(result.getBody().contains("https://docs.thecatapi.com"));
	}

}
