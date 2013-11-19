package com.shaheen.dto;

import com.google.gson.annotations.SerializedName;


/**
* Created by shaheen on 11/2/13.
*/

public class Entity {
	@SerializedName("Id")
	private int id;


    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

