package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditFileData {
    private String newFileName;
    private String newCommit;
    private String name;
    private String commit;
    private String repositoryName;

    public FileData toFile() {
        return new FileData(newFileName, getRepositoryName(), newCommit);
    }
}
