package com.Kunal.Cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "Cards Microservice",
				description = "Cards Microservice Rest Api Documentation",
				version = "1.0",
				contact =@Contact(
						name="Kunal Sangwan",
						email="kunalsangwan0980@gmail.com"

				),
				license = @License(
						name="Apache 2.0",
						url="https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		externalDocs=@ExternalDocumentation(
				description = "Cards Microservice Documentation",
				url="https://github.com/Kunal1405/Kunal1405"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
