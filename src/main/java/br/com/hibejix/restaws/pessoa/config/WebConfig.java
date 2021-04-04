package br.com.hibejix.restaws.pessoa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author macrusal on 03/04/21
 * @project rest-aws
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation( ContentNegotiationConfigurer configurer ) {
        configurer.favorPathExtension(false)
                .favorParameter(true)
                .ignoreAcceptHeader(false)
                .parameterName( "mediaType" )
                .useRegisteredExtensionsOnly( false )
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }
}
