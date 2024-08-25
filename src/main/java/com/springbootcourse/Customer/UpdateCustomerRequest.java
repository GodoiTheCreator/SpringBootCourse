package com.springbootcourse.Customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateCustomerRequest {
    private String name;
    private String email;
    private Integer age;
}
