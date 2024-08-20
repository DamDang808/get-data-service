package com.get_data_service.controller;

import com.get_data_service.model.MediaDTO;
import com.get_data_service.model.RequestParams;
import com.get_data_service.model.ResponseMessage;
import com.get_data_service.service.GetDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/get-data")
public class GetDataController {

    @Autowired
    private GetDataService getDataService;

    @PostMapping("/{type}")
    public ResponseEntity<ResponseMessage> getRecommendationData(@PathVariable String type,
                                                                 @RequestBody RequestParams requestParams) {
        if (type == null || requestParams == null || requestParams.getList() == null) {
            return ResponseEntity.badRequest().body(ResponseMessage.builder().message("Invalid request").status(400).build());
        }

        // Convert type to uppercase
        if (type.equals("video")) type = "VOD";

        List<MediaDTO> data = getDataService.getData(type, requestParams.getList(), requestParams.getZoneId(), requestParams.getContentFilter(), requestParams.getLimit(), requestParams.getOffset());
        return ResponseEntity.ok(ResponseMessage.builder().message("Success").status(200).data(data).build());
    }
}
