package com.refugee.controller.request;

import com.refugee.model.ShelterTypes;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateShelterRequest {
    private String name;
    private ShelterTypes shelterTypes;
    private String location;
}
