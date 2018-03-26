package com.bellinfo.spring.javaconfig;



import org.apache.tiles.access.TilesAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan(basePackages={"com.bellinfo.spring"})
@EnableWebMvc
public class AppConfig {

	@Bean
	public UrlBasedViewResolver  viewResolver(){
		UrlBasedViewResolver  urlvr = new UrlBasedViewResolver ();
		/*irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".jsp");*/
		urlvr.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
		urlvr.setOrder(0);
		return urlvr;
	}
	@Bean
	public TilesConfigurer tc() {
		TilesConfigurer tc= new TilesConfigurer();
		tc.setDefinitions(new String[]{"/WEB-INF/tiles.xml"});
		return tc;
		
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setBasename("messages");
		return rbms;
	}
	
}
