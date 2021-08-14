package com.paladinzzz.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.paladinzzz.game.database.Database;
import com.paladinzzz.game.screens.GameScreen;
import com.paladinzzz.game.screens.MenuScreen;

public class CrossplatformApp extends Game {
	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));
		Database database = new Database();
		database.getData(database.connect());

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
