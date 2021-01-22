package io.datadynamics.bigdata.dataflow.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * Jackson 등의 유티릴티성 클래스를 Autowire하고자 하는 경우에 Bean을 정의하도록 함.
 */
@Configuration
public class UtilityConfiguration {

    @Bean("mapper")
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

/*
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Statement.class, new StatementDeserializer());
        mapper.registerModule(module);
*/

        return mapper;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder("qweQWE123!@#");
    }

}