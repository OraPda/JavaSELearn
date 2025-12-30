package com.ProjectAndDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Park {
    private String size;
    private String color;

    @Override
    public String toString() {
        return size + " " + color;
    }
}
