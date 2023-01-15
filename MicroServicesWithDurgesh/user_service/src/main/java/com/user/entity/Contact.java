package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
    private Long contactId;
    private String email;
    private String conatctName;
    private Long userId;
}
