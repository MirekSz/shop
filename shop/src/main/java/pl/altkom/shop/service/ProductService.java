package pl.altkom.shop.service;

import org.springframework.stereotype.Service;

import pl.altkom.shop.aop.Monitoring;
import pl.altkom.shop.aop.ResponseCache;

@Service
public class ProductService {
	@Monitoring(maxTime = 145)
	@ResponseCache("products")
	@EvictCache("products")
	public String hello() {
		return System.currentTimeMillis() + "";
	}
}
