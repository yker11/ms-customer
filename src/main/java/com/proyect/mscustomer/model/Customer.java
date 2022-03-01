package com.proyect.mscustomer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@Document(collection = "Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;

    private String name;

    private String lastName;

    private DocumentType documentType;

    private String documentNumber;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateBirth;

    private String gender;

    public enum DocumentType {
        DNI,
        CEX,
        PASSPORT
    }
}
