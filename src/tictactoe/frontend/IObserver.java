package tictactoe.frontend;

import tictactoe.controller.MyEvent;

public interface IObserver {
    public void update(MyEvent event);
}
