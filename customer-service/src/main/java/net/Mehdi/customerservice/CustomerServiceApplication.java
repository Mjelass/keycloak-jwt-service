package net.Mehdi.customerservice;

import net.Mehdi.customerservice.entities.Customer;
import net.Mehdi.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
					.name("Mehdi")
					.email("Jlass@gm.tn")
					.build());
			customerRepository.save(Customer.builder()
					.name("salem")
					.email("salem@gm.tn")
					.build());
			customerRepository.save(Customer.builder()
					.name("Sarra")
					.email("Sarra@gm.tn")
					.build());
		};
	}

}
