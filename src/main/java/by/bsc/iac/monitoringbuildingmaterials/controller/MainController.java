package by.bsc.iac.monitoringbuildingmaterials.controller;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(){
        return "uploadPage";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "adminPage";
    }

    @GetMapping("/user")
    public String userPage(){
        return "userPage";
    }

    @PostMapping("/uploadExcelFile")
    public String uploadExcelFile(@RequestParam("file") MultipartFile file){
    Workbook workbook;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
