package pl.altkom.shop;

import java.util.List;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = (SimpleClientHttpRequestFactory) restTemplate
				.getRequestFactory();
		simpleClientHttpRequestFactory.setReadTimeout(1000 * 2);
		((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory())
				.setConnectTimeout(1000 * 2);

		Object forObject = restTemplate.getForObject(
				"http://localhost:8080/shop/rest/product", List.class);
		System.out.println(forObject);

	}
}
