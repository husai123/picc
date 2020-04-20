package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Table(name = "customer_insurance_policy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class policy {
    private String pollcy_id;
    private String start_time;
    private String year;
    private String month;
    private String cut;
}
