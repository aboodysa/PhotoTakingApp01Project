package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shaheen on 11/13/13.
 */
public class FileResult {
    @SerializedName("Name")
    private String name;

    @SerializedName("Extension")
    private String extension;

    @SerializedName("FileSizeBytes")
    private long fileSizeBytes;

    @SerializedName("ModifiedDate")
    private String modifiedDate;

    @SerializedName("IsTextFile")
    private boolean isTextFile;

    @SerializedName("Contents")
    private String contents;

    public FileResult(String name, String extension, long fileSizeBytes, String modifiedDate, boolean isTextFile, String contents) {
        this.name = name;
        this.extension = extension;
        this.fileSizeBytes = fileSizeBytes;
        this.modifiedDate = modifiedDate;
        this.isTextFile = isTextFile;
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isTextFile() {
        return isTextFile;
    }

    public void setTextFile(boolean isTextFile) {
        this.isTextFile = isTextFile;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
