package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryData {
    private String name;
    private String description;
    private boolean isPrivate;
    private boolean hasReadMe;
}
