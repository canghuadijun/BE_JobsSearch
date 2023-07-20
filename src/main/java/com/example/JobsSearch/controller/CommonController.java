package com.example.JobsSearch.controller;

import com.example.JobsSearch.service.impl.ImageUploadService;
import com.example.JobsSearch.service.impl.NewsService;
import com.example.JobsSearch.service.impl.SearchLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommonController {
  @Autowired NewsService newsService;

  @Autowired SearchLabelService searchLabelService;

  @Autowired ImageUploadService imageUploadService;

  @GetMapping("/news")
  public ResponseEntity<?> getAllNews() {
    return ResponseEntity.ok().body(newsService.getAll());
  }

  @GetMapping("/tag-search")
  public ResponseEntity<?> getAllSearchTag() {
    return ResponseEntity.ok().body(searchLabelService.getAll());
  }
}
