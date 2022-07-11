package com.paladinzzz.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.paladinzzz.game.database.Database;
import com.paladinzzz.game.database.JSONfunctions;
import com.paladinzzz.game.database.parseJSON;
import com.paladinzzz.game.screens.GameScreen;
import com.paladinzzz.game.screens.MenuScreen;
import com.paladinzzz.game.sprites.Mole;
import com.paladinzzz.game.util.playerMemory;

import static com.paladinzzz.game.screens.MenuScreen.inPlayscreen;

public class CrossplatformApp extends Game {
	public static SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));
		playerMemory.database = new Database();
		playerMemory.database.connect();

		JSONfunctions json = new JSONfunctions();
		System.out.println(json.doInBackground());

		parseJSON parse = new parseJSON(json.doInBackground());

//		System.out.println(parse.getNames());
		for (String i : parse.getNames()){
			if(i != null) {
				System.out.println(i);
			}
		}

		for (String i : parse.getScores()){
			if(i != null) {
				System.out.println(i);
			}
		}

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
