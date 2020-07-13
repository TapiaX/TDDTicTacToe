package tictactoe.backend;

import tictactoe.controller.MyEvent;
import tictactoe.frontend.ITicTacToeUI;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * Concrete implementation for ChangeManager
 */
class ChangeManager {
    private static ChangeManager chMan;
    public static ChangeManager getInstance(){
        if(chMan == null)
            chMan = new ChangeManager();
        return chMan;
    }
    private Map<ITicTacToe, List<ITicTacToeUI>> mapping;

    private ChangeManager(){
        mapping = new HashMap<ITicTacToe, List<ITicTacToeUI>>();
    }


    public void register(ITicTacToe observable, ITicTacToeUI observer){
        if(mapping.containsKey(observable)){
            List<ITicTacToeUI> observers = mapping.get(observable);
            if(!observers.contains(observer))
                observers.add(observer);
        }
        else{
            mapping.put(observable, new ArrayList<ITicTacToeUI>(Collections.singletonList(observer)));
        }
    }

    public void notifyObservers(ITicTacToe observable,String name){
        if(mapping.containsKey(observable)) {
            MyEvent e;
            try {
                e = new MyEvent(observable, name);
            }catch(Exception ex){
                e = new MyEvent(observable, name,false,true);
            }
            for (ITicTacToeUI observer : mapping.get(observable)) {
                if(observer!=null)
                    observer.update(e);
            }
        }
    }
}
