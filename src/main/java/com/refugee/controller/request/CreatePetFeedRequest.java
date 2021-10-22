package com.refugee.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePetFeedRequest {
    private long petId;
    private long feedId;
}
