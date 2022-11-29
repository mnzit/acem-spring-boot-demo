package com.acem.demo.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse implements Serializable {
    private String name;
    private String code;
}
