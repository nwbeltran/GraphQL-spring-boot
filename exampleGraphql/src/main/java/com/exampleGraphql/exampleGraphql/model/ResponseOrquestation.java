package com.exampleGraphql.exampleGraphql.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrquestation {
    private String urlState;
    private String requestID;
}
