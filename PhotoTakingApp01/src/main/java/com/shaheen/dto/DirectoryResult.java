package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class DirectoryResult {
	@SerializedName("FolderResult")
	private boolean directory;

    public DirectoryResult(boolean directory) {
        this.directory = directory;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }
}

