package com.blog.RossiBlog.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BlogDTO(@NotNull String titulo, @NotNull LocalDate data, @NotNull String texto) {
}
