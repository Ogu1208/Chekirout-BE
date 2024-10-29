package com.sch.chekirout.program.config;


import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "program")
@Getter
@Setter
public class ProgramProperties {

    private double targetLatitude;
    private double targetLongitude;
    private double maxDistanceMeters;
    private int startTimeWindowMinutes;
    private int endTimeWindowMinutes;

    @PostConstruct
    public void init() {
        log.info("Target Latitude: {}", targetLatitude);
        log.info("Target Longitude: {}", targetLongitude);
        log.info("Max Distance Meters: {}", maxDistanceMeters);
        log.info("Start Time Window Minutes: {}", startTimeWindowMinutes);
        log.info("End Time Window Minutes: {}", endTimeWindowMinutes);
    }
}