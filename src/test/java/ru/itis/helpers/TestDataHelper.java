package ru.itis.helpers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import ru.itis.AppManager;
import ru.itis.models.EditFileData;
import ru.itis.models.FileData;
import ru.itis.models.RepositoryData;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Getter
@Setter
public class TestDataHelper extends HelperBase {
    @JsonIgnore
    private final ObjectMapper mapper;
    private EditFileData editedFile;
    private FileData file;
    private RepositoryData repo;

    public TestDataHelper(AppManager manager) {
        super(manager);
        mapper = new ObjectMapper();
        try {
          readDataFile();
          combineData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readDataFile() throws IOException {
        InputStream is = Test.class.getResourceAsStream("/test-data.json");
        if (is == null) {
            throw new IOException("Problem: settings file, test-data.json not found");
        }
        // read to a map and extract each class
        HashMap<String, Object> map =  mapper.readValue(is, HashMap.class);
        editedFile = mapper.convertValue(map.get("edited_file"), EditFileData.class);
        file = mapper.convertValue(map.get("file"), FileData.class);
        repo = mapper.convertValue(map.get("repo"), RepositoryData.class);
    }

    private void combineData() {
        file.setRepositoryName(repo.getName());
        editedFile.setRepositoryName(file.getRepositoryName());
        editedFile.setName(file.getName());
        editedFile.setCommit(file.getCommit());
    }
}
