package it.valeriovaudi.matchmanager.support.factory;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/12/14
 * Time: 2:31 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractModelDTOFactory<I,O>  implements ModelDTOFactory<I,O> {

    protected SimpleDateFormat simpleDateFormat;

    protected String pattern;

    @PostConstruct
    public void init() {
        simpleDateFormat = new SimpleDateFormat(pattern);
    }

    @Override
    public O getObject(I input) {

        O out = null;
        if(input!=null) {
            out = doGetObject(input);
        }

        return out;
    }


    public abstract O doGetObject(I input);

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
