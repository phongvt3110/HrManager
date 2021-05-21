package castisvn.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebMvcConfiguration implements WebMvcConfigurer{	 
	private static final int BROWSER_CACHE_CONTROL = 604800;
	
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		// TODO Auto-generated method stub
////		WebMvcConfigurer.super.addViewControllers(registry);
//		registry.addViewController("/login").setViewName("/login");
//		registry.addViewController("/logout").setViewName("/logout");
//	}
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		// TODO Auto-generated method stub
////		WebMvcConfigurer.super.addCorsMappings(registry);
//		registry.addMapping("/logout").allowedOrigins("http://localhost:8082");
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addResourceHandlers(registry);
	  registry.addResourceHandler("/js/**").addResourceLocations("/public/js/","/public/bootstrap_4_3_1/js/").setCachePeriod(BROWSER_CACHE_CONTROL);
      registry.addResourceHandler("/css/**").addResourceLocations("/public/css/", "/public/bootstrap_4_3_1/css/").setCachePeriod(BROWSER_CACHE_CONTROL);
      registry.addResourceHandler("/fonts/**").addResourceLocations("/public/fonts/").setCachePeriod(BROWSER_CACHE_CONTROL);
      registry.addResourceHandler("/assets/**").addResourceLocations("/public/assets/").setCachePeriod(BROWSER_CACHE_CONTROL);
      registry.addResourceHandler("/images/**").addResourceLocations("/public/images/").setCachePeriod(BROWSER_CACHE_CONTROL);      
	}				
}
