package castisvn.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/error"})
public class MyErrorController implements ErrorController{
	
	@RequestMapping
	public String handError(HttpServletRequest request) {
		Object statusObject = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(statusObject != null) {
			Integer statusCodeInteger = Integer.valueOf(statusObject.toString());			
			if(statusCodeInteger == HttpStatus.NOT_FOUND.value()) {
				System.out.println("404 error");
				return "404";
			} else if (statusCodeInteger == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				System.out.println("500 error");
				return "500";
			} else if (statusCodeInteger == HttpStatus.FORBIDDEN.value()) {
				System.out.println("403 error");
				return "403";
			}
		}
		return "error";
	}
	
	@RequestMapping(value = {"/access-denied"})
	public String accessDenied() {
		System.out.println("access denied");
		return "errors/access_denied";
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
