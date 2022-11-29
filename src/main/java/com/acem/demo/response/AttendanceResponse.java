package com.acem.demo.response;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceResponse {
    private String name;
    private String batchId;
    private String courseId;
    private String data;
}
