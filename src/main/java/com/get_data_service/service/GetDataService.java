package com.get_data_service.service;

import com.get_data_service.model.Media;
import com.get_data_service.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDataService {

    @Autowired
    private MediaRepository filmRepository;

    public List<Media> getData(String type, List<Integer> listID, int zoneId, int contentFilter, int limit, int offset) {
        return filmRepository.findByIdIn(listID, zoneId, type, contentFilter, limit, offset, List.of(0));
    }
}
