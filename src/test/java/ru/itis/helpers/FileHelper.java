package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.itis.AppManager;
import ru.itis.models.EditFileData;
import ru.itis.models.FileData;

import java.util.*;

public class FileHelper extends HelperBase {
    public FileHelper(AppManager manager) {
        super(manager);
    }

    public void createFile(FileData file) throws InterruptedException {
        manager.getNavigation().goTo(manager.getBaseURL() + "/" + file.getRepositoryName() + "/new/master");
        fillFieldByName(file.getName(), "filename");
        if (file.getCommit() != null) {
            fillFieldById(file.getCommit(), "commit-summary-input");
        }
        Thread.sleep(1000);
        clickItemById("submit-file");
    }

    public FileData getCreatedFile(String repoName) {
        String filesPage = manager.getBaseURL() + "/" + repoName + "/tree/master";
        if (!driver.getCurrentUrl().equals(filesPage)) {
            manager.getNavigation().goTo(filesPage);
        }
        var elements = driver.findElements(By.cssSelector("div.Box-row"));
        WebElement lastElement = elements.get(elements.size() - 1);
        // extract fileData from lastElement
        String name = lastElement.findElement(By.cssSelector("a.Link--primary")).getText();
        String commit = lastElement.findElement(By.cssSelector("a.Link--secondary")).getText();
        return FileData.builder()
                .name(name)
                .commit(commit)
                .repositoryName(repoName)
                .build();
    }

    public void editFile(EditFileData file) {
        if(file.getNewFileName() != null) {
            fillFieldByName(file.getNewFileName(), "filename");
        }
        if(file.getNewCommit() != null) {
            fillFieldById(file.getNewCommit(), "commit-summary-input");
        }
        clickItemById("submit-file");
    }

    /**
     * Deletes file from repository
     * This function assumes that you have navigated to the file page
     * Also, the function is safe i.e. it does not throw when elements that are required for deletion are not found.
     */
    public void deleteFiles(Collection<FileData> files) {
        Set<String> fileNameSet = new HashSet<>();
        for (FileData file : files) {
            fileNameSet.add(file.getName());
        }
       manager.getNavigation().openRepositoryPage("lordvidex/selenium-test");
       driver.findElements(By.cssSelector("a.Link--primary")).forEach(element -> {
           try {
               if (fileNameSet.contains(element.getText())) {
                   manager.getNavigation().openFilePage("lordvidex/selenium-test", element.getText());
                   clickDeleteBtn();
               }
           } catch (Exception ignored) {}
       });
    }

    private void clickDeleteBtn() {
        var deleteBtn = findElementSafe(By.cssSelector("button.btn-octicon-danger"));
        deleteBtn.ifPresent(WebElement::click);
        var addCommitBtn = findElementSafe(By.id("submit-file"));
        addCommitBtn.ifPresent(WebElement::click);
    }
}