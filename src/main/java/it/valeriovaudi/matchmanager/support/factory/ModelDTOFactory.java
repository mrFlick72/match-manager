package it.valeriovaudi.matchmanager.support.factory;

/**
 * Created with IntelliJ IDEA.
 * User: seminario
 * Date: 4/12/14
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ModelDTOFactory<I,O> {

    O getObject(I input);

}
