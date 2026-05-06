package com.darlellison.airport;

import jakarta.persistence.AttributeConverter;

public class VipConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute ? "Yes" : "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Yes".equalsIgnoreCase(dbData) ?
                Boolean.TRUE:Boolean.FALSE;
    }
}
