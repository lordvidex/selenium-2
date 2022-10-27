package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RepositoryData {
    private final String name;
    private final String description;
    private final boolean isPrivate;
    private final boolean hasReadMe;
}
