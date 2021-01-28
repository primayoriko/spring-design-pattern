package my.primayoriko.springbasic.designpattern.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

public class FactoryApplication {

    @Data
    @AllArgsConstructor
    public static class Database {
        private String host;
        private Integer port;
        private String username;
        private String password;
        private String db;
    }

    public static class DatabaseFactory implements FactoryBean<Database> {
        @Override
        public Database getObject() throws Exception {
            Database database = new Database("localhost", 8080, "root", "root", "main");
            return database;
        }

        @Override
        public Class<?> getObjectType() {
            return Database.class;
        }

        @Override
        public boolean isSingleton() {
            return false;
        }
    }

    @SpringBootApplication
    public static class Configuration {

        @Bean
        public FactoryBean<Database> database(){
            return new DatabaseFactory();
        }

    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Configuration.class);

        Database database = context.getBean(Database.class);

        System.out.println(database);
    }

}
