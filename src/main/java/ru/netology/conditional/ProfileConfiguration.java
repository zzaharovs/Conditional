package ru.netology.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.conditional.profile.DevProfile;
import ru.netology.conditional.profile.ProdProfile;
import ru.netology.conditional.profile.SystemProfile;

@Configuration
public class ProfileConfiguration {


    @Bean
    @ConditionalOnProperty(value = "netology.profile", havingValue = "dev")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile", havingValue = "prod")
    public SystemProfile prodProfile() {
        return new ProdProfile();
    }


}
