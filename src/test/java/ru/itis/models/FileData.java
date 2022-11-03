package ru.itis.models;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class FileData {
    private String name;
    private String repositoryName;
    private String commit;
}
