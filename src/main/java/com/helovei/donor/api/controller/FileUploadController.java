package com.helovei.donor.api.controller;

import java.nio.file.Path;
import java.util.stream.Collectors;

import com.helovei.donor.api.exception.StorageFileNotFoundException;
import com.helovei.donor.api.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;

@RestController
public class FileUploadController {

    private final StorageService storageService;
    private final ServletContext servletContext;

    @Autowired
    public FileUploadController(StorageService storageService, ServletContext servletContext) {
        this.storageService = storageService;
        this.servletContext = servletContext;
    }

    //get all files
    @GetMapping("/file_storage")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));
        return model.toString();
    }

    //get file
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Path> serveFile(@PathVariable String filename) {
        Path file = storageService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.toFile().getName() + "\"").body(file);
    }


    //get image
    @GetMapping("/images/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getImageAsResource(@PathVariable String filename){
        HttpHeaders headers = new HttpHeaders();
        Resource resource = storageService.loadAsResource(filename);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    //save file
    @PostMapping("/file_storage")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }


}