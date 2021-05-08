package com.citapelu.clientservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Center {

    private Long id;
    private String name;
    private String phone;
    private String city;

}

