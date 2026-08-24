package com.amogh.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)//Auto indexing cannot be done automattvally so to set it automatically, in application properties we have to set something(Refer application properties file
    @NonNull
    private String username;

    @NonNull
    private String passowrd;

    @DBRef//reference to the entries present in collection named journal_entries(it just links users collection and journal_entries collection)
    private List<JournalEntry> journalEntries = new ArrayList<>();

}