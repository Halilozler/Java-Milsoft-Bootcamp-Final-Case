package com.example.lesson7.homework.a1;

public class MyContractImpl implements  MyContract{
    private String myField;
    @Override
    public String getMyField() {
        return myField;
    }

    @Override
    public void setMyField(String myField) {
        this.myField = myField;
    }

    @Override
    public String processSomething(String something) {
        return "İşleniyor " + something + " " + myField + " ile...";
    }
}
