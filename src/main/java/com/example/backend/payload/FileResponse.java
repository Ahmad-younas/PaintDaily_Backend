package com.example.backend.payload;

public class FileResponse {
    String fileName;
    String message;

    public String getFileName() {
        return fileName;
    }

    public FileResponse(String fileName, String message, String path) {
        this.fileName = fileName;
        this.message = message;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
