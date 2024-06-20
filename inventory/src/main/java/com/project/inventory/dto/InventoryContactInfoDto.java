package com.project.inventory.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "inventory")
public record InventoryContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
