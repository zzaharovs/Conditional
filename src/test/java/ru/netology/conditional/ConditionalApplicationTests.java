package ru.netology.conditional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConditionalApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    private GenericContainer<?> devapp = new GenericContainer<>("devapp").
            withExposedPorts(8080);
    public static GenericContainer<?> prodapp = new GenericContainer<>("prodapp")
            .withExposedPorts(8080);

    @BeforeAll
    public static void setUp() {
        prodapp.start();
    }

    @BeforeEach
    void setUpDev() {
        devapp.start();
    }

    @Test
    void contextLoadsProdContainer() {

        //given
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" +
                prodapp.getMappedPort(8080) + "/profile", String.class);
        final String expectedResult = "Current profile is production";

        //then
        final String requestBodyResult = forEntity.getBody();

        //when
        Assertions.assertEquals(expectedResult, requestBodyResult);

    }

    @Test
    void contextLoadsDevContainer() {


        //given
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" +
                devapp.getMappedPort(8080) + "/profile", String.class);
        final String expectedResult = "Current profile is developer";

        //then
        final String requestBodyResult = forEntity.getBody();

        //when
        Assertions.assertEquals(expectedResult, requestBodyResult);


    }

}
