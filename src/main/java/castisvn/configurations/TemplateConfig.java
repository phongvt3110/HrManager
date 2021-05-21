package castisvn.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class TemplateConfig {
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver resolverTemplate = new ClassLoaderTemplateResolver();
		resolverTemplate.setPrefix("templates/commonViews/");
		resolverTemplate.setSuffix(".html");
		resolverTemplate.setTemplateMode(TemplateMode.HTML);
		resolverTemplate.setCharacterEncoding("UTF-8");
		resolverTemplate.setOrder(1);
		resolverTemplate.setCheckExistence(true);
		return resolverTemplate;
	}
}
