package calculator_api.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CalculationRepository {
    private final JdbcTemplate jdbcTemplate;

    public CalculationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveCalculation(String operation, double result) {
        String sql = "INSERT INTO calculations (operation, result) VALUES (?, ?)";
        jdbcTemplate.update(sql, operation, result);
    }
}