package com.project.optimization.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "optimization")
public record OptimizationContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
