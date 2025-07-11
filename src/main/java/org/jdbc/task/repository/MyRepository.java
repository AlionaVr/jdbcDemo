package org.jdbc.task.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MyRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final String query = read("sql/query.sql");

    public List<String> getProductName(String name) {
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter("name", name);
        return nativeQuery.getResultList();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read SQL script: " + scriptFileName, e);
        }
    }
}
