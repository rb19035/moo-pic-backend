package com.cgms.moopicbackend;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping ("/moo")
@Validated
public class MooPicBackendAPI
{
    @Autowired
    private MooPicBackendService mooPicBackendService;

    @PostMapping
    public void uploadMedia(
            @NotNull @RequestParam("file") MultipartFile file,
            @NotNull @RequestParam("name") String mediaName,
            @NotNull @RequestParam("date") String date )
    {
        try
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
            LocalDate localDate = LocalDate.parse( date, formatter );

            this.mooPicBackendService.uploadMedia( file, mediaName, localDate );
        }
        catch ( IllegalArgumentException e )
        {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Not a valid date.", e );
        }
    }

    @DeleteMapping
    public void deleteMedia( @NotNull @RequestBody List<String> mediaNameList )
    {
        this.mooPicBackendService.deleteMediaFiles( null );
    }

    @GetMapping
    public ResponseEntity<List<String>> getStoredMediaData( @NotNull @RequestBody List<String> mediaNameList )
    {
        List<String> foundMediaNames = this.mooPicBackendService.verifyStoredMedia( mediaNameList );

        return new ResponseEntity<>( foundMediaNames, HttpStatus.OK );
    }
}
