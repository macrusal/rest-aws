package br.com.hibejix.restaws;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableMongock
@SpringBootApplication
public class RestAwsApplication {

    public static void main( String[] args ) {
        SpringApplication.run( RestAwsApplication.class, args );
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
