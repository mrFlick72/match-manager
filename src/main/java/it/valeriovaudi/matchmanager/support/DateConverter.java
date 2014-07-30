package it.valeriovaudi.matchmanager.support;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/11/14
 * Time: 3:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class DateConverter implements Converter<String,Date> {

    private Logger logger = Logger.getLogger(DateConverter.class);

    private SimpleDateFormat simpleDateFormat;

    private String pattern;

    @PostConstruct
    public void init()
    {
        simpleDateFormat = new SimpleDateFormat(pattern);
    }

    @Override
    public Date convert(String date) {

        Date result = null;

        try {
            result = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error(e);
        }

        return result;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}