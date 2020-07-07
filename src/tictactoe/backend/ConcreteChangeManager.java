package tictactoe.backend;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * Concrete implementation for ChangeManager
 */
public class ConcreteChangeManager implements ChangeManager {
    private static ChangeManager chMan;
    public static ChangeManager getInstance(){
        if(chMan == null)
            chMan = new ConcreteChangeManager();
        return chMan;
    }
    private Map<Observable, List<Observer>> mapping;

    private ConcreteChangeManager(){
        mapping = new HashMap<Observable, List<Observer>>();
    }

    @Override
    public void register(Observable Observable, Observer observer){
        if(mapping.containsKey(Observable)){
            List<Observer> observers = mapping.get(Observable);
            if(!observers.contains(observer))
                observers.add(observer);
        }
        else{
            mapping.put(Observable, new ArrayList<Observer>(Collections.singletonList(observer)));
        }
    }

    @Override
    public void unregister(Observable Observable, Observer observer){
        if(mapping.containsKey(Observable)){
            if(mapping.get(Observable).contains(observer)){
                mapping.get(Observable).remove(observer);
            }
        }
    }

    @Override
    public void notifyBoard(Observable Observable){
        if(mapping.containsKey(Observable)) {
            for (Observer observer : mapping.get(Observable)) {
                observer.updateBoard(Observable);
            }
        }
    }
    @Override
    public void notifyFinish(Observable Observable){
        if(mapping.containsKey(Observable)) {
            for (Observer observer : mapping.get(Observable)) {
                observer.updateFinish(Observable);
            }
        }
    }
}
