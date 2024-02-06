package net.Mehdi.customerservice.web;

import net.Mehdi.customerservice.entities.Customer;
import net.Mehdi.customerservice.repo.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private CustomerRepository customerRepository;
    public CustomerRestController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
    @GetMapping("/mySession")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
