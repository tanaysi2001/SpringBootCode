package com.example.HibernateDemo.model;

import jakarta.persistence.AttributeConverter;

import java.util.Objects;

public class BooleanToStringConverter implements AttributeConverter<Boolean,String> {


    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {

        if(aBoolean==null){
            return null;
        }

        if(aBoolean==true){
            return "YES";
        }else{
            return "NO";
        }
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData==null){
            return null;
        }
        return Objects.equals(dbData, "Yes");
    }
}
