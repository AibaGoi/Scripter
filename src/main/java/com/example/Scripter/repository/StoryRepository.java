package com.example.Scripter.repository;

import com.example.Scripter.domain.entity.story.Story;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StoryRepository extends MongoRepository<Story, String> {

    List<Story> findAllStoriesByUserId(String userId);
}
