package com.paladinzzz.game.screens.worldobjects;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.paladinzzz.game.screens.worldobjects.visitor.objectVisitor;

//De interface van alle wereld objecten: sprites, objecten e.d. 

public interface IObject {
    void defineObject(World world, TiledMap map);
    void getType();
    void visit(objectVisitor visitor);
}
