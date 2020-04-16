package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Table(name = "role_employee_relationship")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class role_employee_relationship {
    private String emp_id;
    private Integer role_id;
}
