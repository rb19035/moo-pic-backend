package com.cgms.moopicbackend;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Service
@Validated
public class MooPicBackendService
{
    private static final Logger LOGGER = LoggerFactory.getLogger( MooPicBackendService.class );

    @Value ( "${file.storage.path}" )
    private String baseMediaDirectory;

    public void uploadMedia( @NotNull MultipartFile file, @NotNull String mediaName, @NotNull LocalDate localDate )
    {
        mediaName = FilenameUtils.normalize( mediaName );
        mediaName = FilenameUtils.getName( mediaName );

        String mediaPath = baseMediaDirectory + "/" + localDate.getYear() + "-" + localDate.getMonthValue() +"/" + mediaName;

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
