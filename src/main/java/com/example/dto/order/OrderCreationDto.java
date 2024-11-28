package com.example.dto.order;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreationDto {
    @NotNull(message = "Account ID is required")
    private UUID accountId;

    @NotEmpty(message = "At least one item ID must be provided.")
    private List<UUID> itemsId;
}
