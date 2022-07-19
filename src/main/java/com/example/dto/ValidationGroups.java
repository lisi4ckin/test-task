package com.example.dto;

import javax.validation.groups.Default;

public interface ValidationGroups {
    interface Post extends Default{ }
    interface Put extends Default{}
}
