package ru.itis.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditFileData extends FileData {
    private String newFileName;
    private String newCommit;

    public EditFileData(String name, String repositoryName, String commit, String newFileName, String newCommit) {
        super(name, repositoryName, commit);
        this.newFileName = newFileName;
        this.newCommit = newCommit;
    }
}
