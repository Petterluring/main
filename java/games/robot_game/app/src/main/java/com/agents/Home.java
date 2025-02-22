package com.agents;

import com.position.StaticPosition;

/**
 * The Robot is needs to reach Home in order to 
 * win the game. This class represents that object, and 
 * contain basic functionality from Agent.java and StaticPosition.java. 
 */
public class Home extends Agent {

    public Home(String name, String emblem, StaticPosition position) {
        super(name, emblem, position);
    }
}
