package org.jdbc.task.service;

import lombok.RequiredArgsConstructor;
import org.jdbc.task.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final MyRepository repository;

    public List<String> getProductName(String name) {
        return repository.getProductName(name);
    }
}
