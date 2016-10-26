package pl.altkom.shop;

import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import pl.altkom.shop.model.Product;

public class RestClient {
	public static void main(String[] args) {
		HttpHeaders headers = new HttpHeaders();
		String string = "Basic " + Base64Utils.encodeToString("user:user".getBytes(Charset.forName("UTF-8")));
		System.out.println(string);
		headers.add("Authorization", string);
		RestTemplate restTemplate = new RestTemplate();
		((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(1000 * 30);
		((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(1000 * 30);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Product[]> exchange = restTemplate.exchange("http://localhost:8080/shop/rest/product",
				HttpMethod.GET, entity, Product[].class);
		System.out.println(exchange.getBody()[0].getName());
		System.out.println(exchange.getHeaders());
	}
}
