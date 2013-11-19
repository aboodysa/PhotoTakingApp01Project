package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//todo for boolean values you need to put prefix is instead of get

/**
* Created by shaheen on 11/2/13.
*/

public class FolderResult {
	@SerializedName("Folders")
	private List<Folder> folders;

	@SerializedName("Files")
	private List<File> files;

    public FolderResult(List<Folder> folders, List<File> files) {
        this.folders = folders;
        this.files = files;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}

