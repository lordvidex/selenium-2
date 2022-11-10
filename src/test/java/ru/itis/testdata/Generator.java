package ru.itis.testdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.FileData;
import ru.itis.models.RepositoryData;

import java.io.File;
import java.io.IOException;

public class Generator {
    public static void main(String[] args) throws IOException {
        RepositoryData repo = generateRandomRepo();
        generateRandomFile(repo);

    }

    private static void generateRandomFile(RepositoryData repo) throws IOException {
        // save this in the test resource bundle
        String fileName = generateRandomChars(10);
        String commit = generateRandomSentence(5);
        String repositoryName = repo.getName();
        FileData file = FileData.builder()
                .name(fileName)
                .commit(commit)
                .repositoryName(repositoryName)
                .build();
        writeToJSON(file, "file.json");
    }

    private static RepositoryData generateRandomRepo() throws IOException {
        // save this in the test resource bundle
        String repoName = generateRandomChars(10);
        String repoDescription = generateRandomSentence(5);

        RepositoryData repo = new RepositoryData(repoName, repoDescription, true, true);
        writeToJSON(repo, "repo.json");
        return repo;
    }

    private static void writeToJSON(Object object, String fileName) throws IOException {
        // write the object to a file with jackson
        ObjectMapper mapper = new ObjectMapper();
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
