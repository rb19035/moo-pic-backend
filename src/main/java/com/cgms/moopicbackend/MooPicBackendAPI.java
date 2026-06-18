package com.cgms.moopicbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping ("/moo")
public class MooPicBackendAPI
{
    @Autowired
    private MooPicBackendService mooPicBackendService;

    @PostMapping
    public void uploadMedia( @RequestParam("file") MultipartFile file )
    {
        this.mooPicBackendService.uploadMedia( file );
    }

    @DeleteMapping
    public void deleteMedia( @RequestBody List<String> mediaNameList )
    {
        this.mooPicBackendService.deleteMediaFiles( null );
    }

    @GetMapping
    public ResponseEntity<List<String>> getStoredMediaData( @RequestBody List<String> mediaNameList )
    {
        List<String> foundMediaNames = this.mooPicBackendService.verifyStoredMedia( mediaNameList );

        return new ResponseEntity<>( foundMediaNames, HttpStatus.OK );
    }
}
