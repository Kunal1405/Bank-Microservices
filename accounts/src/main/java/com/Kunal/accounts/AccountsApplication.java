package com.Kunal.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "Accounts Microservice",
				description = "Accounts Microservice Rest Api Documentation",
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
				description = "Accounts Microservice Documentation",
				url="https://github.com/Kunal1405/Kunal1405"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccountsApplication.class, args);

	}

}
