package com.amogh.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
@Data
@NoArgsConstructor //required as @Data Annotation has RequiredArgsContrsuction but noArgsConstructor as NoArgsConstructor is required during deserilsation i.e., json to pogo constructor
public class JournalEntry {

    @Id
    private ObjectId id;

    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;


}