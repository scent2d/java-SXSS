package labs;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*; 

import java.security.*; 
import java.util.*;
import org.apache.commons.lang3.RandomStringUtils; 


@WebFilter("/CSRFFilter")
public class CSRFFilter implements Filter {

	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("CSRFFilter initialized");
	}

	private String generateCSRFToken(){
        String salt = RandomStringUtils.random(20, 0, 0, true, true, null, new SecureRandom());
		return salt;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(req.getMethod().equalsIgnoreCase("GET")){
			HttpSession session = req.getSession();		
			session.setAttribute("csrfToken", generateCSRFToken());
       	}
		if(req.getMethod().equalsIgnoreCase("POST")){
			HttpSession session = req.getSession();		
			String csrfToken = req.getParameter("csrfToken");
			String storedToken = (String)session.getAttribute("csrfToken");
			if (!storedToken.equals(csrfToken)){
				res.sendRedirect("/XSS/error.jsp");
			}				
       	}
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
