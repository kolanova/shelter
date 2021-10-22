package com.refugee.service;

import com.refugee.model.Feed;
import com.refugee.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedService {

    @Autowired
    private FeedRepository feedRepository;
    //Find pet by id to be feed
    public Optional<Feed> findById(Long id) {
        return feedRepository.findById(id);
    }
}