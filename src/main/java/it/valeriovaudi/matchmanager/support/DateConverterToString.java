package it.valeriovaudi.matchmanager.support;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/11/14
 * Time: 3:05 AM
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by centos on 2/14/14.
 */
public class DateConverterToString implements Converter<Date,String> {

    private SimpleDateFormat simpleDateFormat;

    private String pattern;

    @PostConstruct
    public void init() {
        simpleDateFormat = new SimpleDateFormat(pattern);
    }

    @Override
    public String convert(Date date) {
        String result = simpleDateFormat.format(date);

        return result;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}