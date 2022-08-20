package com.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import processing.core.PVector;


@Data
@AllArgsConstructor
public class BoundingPoint {
    BPType type;
    PVector pos;

}
