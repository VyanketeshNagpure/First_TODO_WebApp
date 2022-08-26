package com.cognizant.firstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayhello() {
		return "hola, cómo estás !! \n (It has to be said in spanish ofc 'couse Authetic!!)";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayhelloHtml() {

		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>First html page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h2>Say hello in HTML</h2>");
		sb.append("</body>");
		sb.append("<html>");

		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayhelloJsp() {
		return "sayHello";
	}
}
