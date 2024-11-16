package com.codecrafters.tvpss.repository;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRequestRepository extends MongoRepository<ResourceRequestModel, String> {
    List<ResourceRequestModel> findByStatus(String status);
}
