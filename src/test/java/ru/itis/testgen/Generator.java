package ru.itis.testgen;

import static com.fasterxml.jackson.annotation.JsonInclude.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.EditFileData;
import ru.itis.models.FileData;
import ru.itis.models.RepositoryData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Generator {
    private static Map<String, Object> data;
    private static ObjectMapper mapper;
    public static void main(String[] args) throws IOException {
        data = new HashMap<>();
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        assembleData();
        writeToJSON(data, "test-data.json");
    }

    private static void assembleData() {
        RepositoryData repo = generateRandomRepo();
        FileData file = generateRandomFile();
        EditFileData editedFile = generateRandomEditedFile();
        data.put("repo", repo);
        data.put("file", file);
        data.put("edited_file", editedFile);
    }

    private static EditFileData generateRandomEditedFile() {
        return new EditFileData(generateRandomChars(10),
                generateRandomSentence(6),
                null, null, null);
    }

    private static FileData generateRandomFile() {
        // save this in the test resource bundle
        String fileName = generateRandomChars(10);
        String commit = generateRandomSentence(5);
        return FileData.builder()
                .name(fileName)
                .commit(commit)
                .repositoryName(null)
                .build();
    }

    private static RepositoryData generateRandomRepo()  {
        // save this in the test resource bundle
        String repoName = "lordvidex/" + generateRandomChars(10);
        String repoDescription = generateRandomSentence(5);

        return new RepositoryData(repoName, repoDescription, true, true);
    }

    private static void writeToJSON(Object object, String fileName) throws IOException {
        // write to the resources folder
        File file = new File("src/test/resources/" + fileName);
        mapper.writeValue(file, object);
    }

    private static String generateRandomChars(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    private static String generateRandomSentence(int length) {
        String[] words = new String[] {"test", "testing", "james", "selenium", "is", "great", "this", "is", "a", "sentence"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * words.length);
            sb.append(words[index]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
