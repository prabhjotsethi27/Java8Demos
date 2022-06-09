package com.hcl.java8.part1n2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class LogLine {
    LocalDateTime accessDateTime;
    String userName;
    String operation;

    @Override
    public String toString() {
        return "\n LogLine {accessDateTime=" + this.accessDateTime + ", userName='" + this.userName + '\'' + ", operation='" + this.operation + '\'' + '}';
    }
}
