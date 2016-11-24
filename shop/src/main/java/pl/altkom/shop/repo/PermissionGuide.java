package pl.altkom.shop.repo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class PermissionGuide {

	public boolean accunting() {
		return true;
	}

	public boolean userMgn() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		User principal = (User) authentication.getPrincipal();

		return true;
	}
}
