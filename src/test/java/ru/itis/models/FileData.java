package ru.itis.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FileData {
    private String name;
    private String repositoryName;
    private String commit;
}
