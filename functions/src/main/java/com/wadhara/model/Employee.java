package com.wadhara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Employee {
    private Integer empId;
    private String name;
    private String emailId;
}
