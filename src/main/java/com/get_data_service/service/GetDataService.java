package com.get_data_service.service;

import com.get_data_service.model.Media;
import com.get_data_service.model.MediaDTO;
import com.get_data_service.repository.MediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GetDataService {

    @Autowired
    private MediaRepository mediaRepository;

    @Cacheable(value = "media", key = "#type + ':' + #listID ")
    public List<MediaDTO> getData(String type, List<Integer> listID, int zoneId, int contentFilter, int limit, int offset) {
        List<Media> mediaList = mediaRepository.findByIdIn(listID, zoneId, type, contentFilter, limit, offset, List.of(0));
        List<MediaDTO> mediaDTOList = new ArrayList<>();
        for (Media entity : mediaList) {
            MediaDTO mediaDTO = new MediaDTO();
            mediaDTO.loadFromEntity(entity);
            mediaDTOList.add(mediaDTO);
        }
        return mediaDTOList;
    }
}
