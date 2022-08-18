package com.wadhara.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private Integer empId;
    private String name;
    private String emailId;
}
