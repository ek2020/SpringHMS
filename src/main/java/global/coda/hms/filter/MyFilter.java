package global.coda.hms.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyFilter implements Filter {
	 private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);
	 
	 @Override
	 public void init(FilterConfig filterConfig) throws ServletException {
	  LOGGER.info("########## Initiating My filter ##########");
	 }
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse myResponse = (HttpServletResponse) response;
		LOGGER.info("request is mapped");
		if (httpRequest.getRequestURL().toString().endsWith("/all")||httpRequest.getRequestURL().toString().endsWith("/doctors")) {
			myResponse.addHeader("profile", "FILTERED");
			String token = UUID.randomUUID().toString().toUpperCase().replace("-","");
		    request.setAttribute("requestId",token);
		    LOGGER.info("Filter test");
			chain.doFilter(httpRequest, myResponse);
			return;
		}
		chain.doFilter(httpRequest, myResponse);



	}
	@Override
	 public void destroy() {
	 }
}
