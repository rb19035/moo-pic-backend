package com.cgms.moopicbackend;

import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@Validated
public class MooPicBackendService
{
    private static final Logger LOGGER = LoggerFactory.getLogger( MooPicBackendService.class );

    public void uploadMedia( @NotNull MultipartFile file )
    {
        File filePath = this.convertMediaNameToFilePath( file.getOriginalFilename() );
    }

    public void deleteMediaFiles( @NotNull List<String> mediaFileNameList )
    {

    }

    public List<String> verifyStoredMedia( @NotNull List<String> mediaFileNameList )
    {
        return null;
    }

    private File convertMediaNameToFilePath( String mediaFileName )
    {

        return null;
    }
}
