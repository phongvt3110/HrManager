package castisvn.configurations;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{
	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		factory.setPort(8082);
	}
}
