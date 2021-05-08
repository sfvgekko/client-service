package com.citapelu.clientservice.VO;

import com.citapelu.clientservice.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Client client;
    private Center center;

}
