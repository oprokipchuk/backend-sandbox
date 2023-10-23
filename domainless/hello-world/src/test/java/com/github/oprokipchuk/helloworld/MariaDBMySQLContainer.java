package com.github.oprokipchuk.helloworld;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

public class MariaDBMySQLContainer extends MySQLContainer<MariaDBMySQLContainer> {

    public MariaDBMySQLContainer(DockerImageName dockerImageName) {
        super(dockerImageName);
    }

    @Override
    public String getDriverClassName() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return "org.mariadb.jdbc.Driver";
        } catch (ClassNotFoundException e) {
            return "org.mariadb.jdbc.Driver";
        }
    }

    @Override
    public String getJdbcUrl() {
        return super.getJdbcUrl().replace(":mysql:", ":mariadb:");
    }
}
