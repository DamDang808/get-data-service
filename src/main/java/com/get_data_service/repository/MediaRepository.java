package com.get_data_service.repository;

import com.get_data_service.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Integer> {
    @Query(value = "SELECT * FROM media m WHERE m.id IN :ids " +
            "and m.status = 2 " +
            "and m.zone_id = :zone_id " +
            "and m.published_at < now() " +
            "and m.is_active = 1 " +
            "and m.type = :type " +
            "and m.content_filter < :content_filter " +
            "and m.source in (:sources) LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Media> findByIdIn(Collection<Integer> ids, int zone_id, String type, int content_filter, int limit, int offset, Collection<Integer> sources);
}
