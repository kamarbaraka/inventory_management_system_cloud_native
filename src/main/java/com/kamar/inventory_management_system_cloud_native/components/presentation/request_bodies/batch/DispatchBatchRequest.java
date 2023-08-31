package com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.batch;

import lombok.Getter;
import lombok.Setter;

/**
 * dispatch batch request body.
 * @author kamar baraka.*/

@Getter
@Setter
public class DispatchBatchRequest {

    private long batchId;
    private String carrier;

    private String destination;
}
