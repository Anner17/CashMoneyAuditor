package com.cashFlowAuditor.Models;

public class Description {
    public String description;
    public int value;
    public boolean bold;

    public Description(){}
    public Description(String description, int value){
        this.description = description;
        this.value = value;
        this.bold = false;
    }

    public Description(String description, int value, boolean bold){
        this.description = description;
        this.value = value;
        this.bold = bold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isBold() {
        return bold;
    }
}
