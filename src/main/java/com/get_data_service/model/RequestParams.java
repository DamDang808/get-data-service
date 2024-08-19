package com.get_data_service.model;

import lombok.Data;

import java.util.List;

@Data
public class RequestParams {

    private int zoneId;
    private int contentFilter;
    private List<Integer> list;
    private int limit;
    private int offset;
}
