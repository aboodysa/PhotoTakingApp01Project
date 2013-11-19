package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class Folder {
	@SerializedName("Name")
	private boolean name;


    @SerializedName("FileCount")
    private long fileCount;

    @SerializedName("ModifiedDate")
    private String modifiedDate;

    public Folder(boolean name, long fileCount, String modifiedDate) {
        this.name = name;
        this.fileCount = fileCount;
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public long getFileCount() {
        return fileCount;
    }

    public void setFileCount(long fileCount) {
        this.fileCount = fileCount;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }
}

