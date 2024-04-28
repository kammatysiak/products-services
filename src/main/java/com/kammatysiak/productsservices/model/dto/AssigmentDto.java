package com.kammatysiak.productsservices.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AssigmentDto {

    private long productAssignorId;
    private long productAssigneeId;
}
