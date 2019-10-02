package adresar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

	// kada se otvori URL .../login, otvara se sadržaj stranice login
	@GetMapping("/login")
	public String otvoriLogin(){
		return "login";
	}
	
}
