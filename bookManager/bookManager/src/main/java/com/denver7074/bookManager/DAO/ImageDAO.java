package com.denver7074.bookManager.DAO;

import com.denver7074.bookManager.model.Images;
import com.denver7074.bookManager.repositories.ImageRep;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;

/*Необходимы методы:
        * удалить картинку
        * заменить картинку
        * Но наверное нужно прежде чем заменить картинку -> нужно её удалить,
        * поэтому метод замены == методу удаления?
        * И наверное этот метод вы должны положить в BookController updateBook?*
        Или лучше данный сервис сразу в BookDAO положить?*/

@RequiredArgsConstructor
public class ImageDAO {
    public final ImageRep imageRep;
    public ResponseEntity<?> getImageById(Long id){
        Images image = imageRep.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getName())
                .contentType(MediaType.valueOf(image.getType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }




}
