package com.lordgasmic.bff.dom.model;

import lombok.Data;

@Data
public class WineNoteOutput {
    private int id;
    private int wineId;
    private String user;
    private String note;
    private int ordinal;
    private String date;
}
