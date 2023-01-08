package com.acem.demo.response;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdResponse implements Serializable {

   private Long id;
   private String email;
}
