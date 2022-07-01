package jpabook.start;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true) // autoApply 속성을 주면 모든 boolean타입에 컨버터를 적용한다는 의미이다
public class BooleanToYNConverter implements AttributeConverter<Boolean,String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute!=null && attribute) ? "Y":"N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equals(dbData);
    }
}
