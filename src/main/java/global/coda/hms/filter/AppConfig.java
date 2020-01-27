package global.coda.hms.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	 @Bean
	 public FilterRegistrationBean < MyFilter > filterRegistrationBean() {
	  FilterRegistrationBean < MyFilter > registrationBean = new FilterRegistrationBean();
	  MyFilter customURLFilter = new MyFilter();

	  registrationBean.setFilter(customURLFilter);
	  registrationBean.addUrlPatterns("/patients/*");
	  registrationBean.setOrder(2); 
	  return registrationBean;
	 }
	}
