package com.example.beans.models;

import lombok.Data;

import java.io.InputStream;
import java.util.stream.Stream;

@Data
public class FileSourceModel {
    private InputStream source;
}
