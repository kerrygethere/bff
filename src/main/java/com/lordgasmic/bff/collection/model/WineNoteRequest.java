package com.lordgasmic.bff.collection.model;

import lombok.Data;

@Data
public class WineNoteRequest {
    private int wineId;
    private String user;
    private String note;
    private int ordinal;
    private String date;
}
