package com.springbootcourse.Customer;

import com.springbootcourse.Main;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        customerService.saveCustomer(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerService.deleteCustomerById(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody UpdateCustomerRequest request){
        Customer customer = customerService.getCustomers().stream().filter(person -> person.getId().equals(id))
                .findFirst().orElseThrow(
                );
        if(request.getName() !=null){
            customer.setName(request.getName());
        }
        if(request.getEmail() !=null){
            customer.setEmail(request.getEmail());
        }
        if(request.getAge() !=null){
            customer.setAge(request.getAge());
        }
        customerService.saveCustomer(customer);
    }
}
