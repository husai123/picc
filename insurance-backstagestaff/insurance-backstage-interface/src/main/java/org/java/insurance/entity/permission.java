package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Table(name = "permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class permission {
    private Integer permission_id;
    private String permission_name;
    private String permission_code;
    private String permission_type;
    private String permission_url;

}
