package com.acem.demo.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse  implements Serializable {

    private String name;
    private String description;
    private List<SubjectResponse> subjects;

}
