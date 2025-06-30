package org.jdbc.task;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
@RequiredArgsConstructor
public class MyRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String query = read("sql/query.sql");

    public List<String> getProductName(String name) {
        Map<String, Object> params = Map.of("name", name);
        return jdbcTemplate.query(query, params,
                (rs, rowNum) -> rs.getString("product_name"));
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
