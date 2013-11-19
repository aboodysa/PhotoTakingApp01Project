package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class File {
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

    public File(String name, String extension, long fileSizeBytes, String modifiedDate, boolean isTextFile) {
        this.name = name;
        this.extension = extension;
        this.fileSizeBytes = fileSizeBytes;
        this.modifiedDate = modifiedDate;
        this.isTextFile = isTextFile;
    }

    public String isName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isTextFile() {
        return isTextFile;
    }

    public void setTextFile(boolean isTextFile) {
        this.isTextFile = isTextFile;
    }
}

