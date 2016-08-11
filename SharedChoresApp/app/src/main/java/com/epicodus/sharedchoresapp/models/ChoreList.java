package com.epicodus.sharedchoresapp.models;

public class ChoreList {
    private String listName;
    private String owner;
    private String choreListId;

    public ChoreList() {
    }

    public ChoreList(String listName, String owner){
        this.listName = listName;
        this.owner = owner;
    }

    public String getListName() {
        return listName;
    }
    public String getOwner(){
        return owner;
    }

    public String getChoreListId() {
        return choreListId;
    }

    public void setChoreListId(String choreListId) {
        this.choreListId = choreListId;
    }

}

