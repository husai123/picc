package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class employee implements Serializable {
    private String emp_id;
    private String username;
    private String password;
    private String phone;
    private String salt;
}
