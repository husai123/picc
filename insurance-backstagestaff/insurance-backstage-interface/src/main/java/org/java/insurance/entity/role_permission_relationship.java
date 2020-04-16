package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Table(name = "role_permission_relationship")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class role_permission_relationship {
    private Integer role_id;
    private Integer permission_id;
}
