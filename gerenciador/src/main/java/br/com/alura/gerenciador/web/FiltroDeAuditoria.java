package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		String usuario = "<deslogado>";
		
		if(usuarioLogado != null){
			usuario = usuarioLogado.getEmail();
		}
		
		System.out.println("Usuário " + usuario + " acessando a URI: " + uri);
		chain.doFilter(request, response);
	}

	//Método não é mais utilizado
	private String getUsuario(HttpServletRequest req) {
		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		if(cookie == null) return "<deslogado>";
		return cookie.getValue();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
