package pl.altkom.shop.aop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TraceStorage {
	private int level;

	public void incLevel() {
		this.level++;
	}

	public void decLevel() {
		this.level--;
	}

	private List<String> storage = new ArrayList();

	public void add(String s) {
		String levelChars = "";
		for (int i = 0; i < this.level * 4; i++) {
			levelChars += " ";
		}
		this.storage.add(levelChars + s);
	}

	@PreDestroy
	public void dead() {
		Collections.reverse(storage);
		for (String string : storage) {
			System.out.println(string);
		}
	}
}
