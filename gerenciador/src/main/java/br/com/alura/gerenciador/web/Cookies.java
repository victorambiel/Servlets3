package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookie;
	
	Cookies(Cookie[] cookie){
		this.cookie = cookie;
	}
	
	public Cookie getUsuarioLogado(){
		if(cookie == null) return null;
		for(Cookie cookies : cookie){
			if(cookies.getName().equals("usuario.logado")){
				return cookies;
			}
		}
		
		return null;	
	}
}
