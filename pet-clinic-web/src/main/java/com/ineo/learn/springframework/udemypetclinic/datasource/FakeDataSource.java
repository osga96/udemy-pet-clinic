package com.ineo.learn.springframework.udemypetclinic.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:datasource.properties")
@Component
public class FakeDataSource {
    private String username;
    private String password;
    private String jdbcUrl;

    public FakeDataSource(@Value("${pet.clinic.username}") String username,
                          @Value("${pet.clinic.password}") String password,
                          @Value("${pet.clinic.jdbcUrl}") String jdbcUrl,
                          @Value("${test.otro.valor}") String otroValor) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
        System.out.println("######### otro valor: " + otroValor);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
