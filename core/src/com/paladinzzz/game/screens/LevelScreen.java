package com.paladinzzz.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.paladinzzz.game.CrossplatformApp;
import com.paladinzzz.game.database.JSONfunctions;
import com.paladinzzz.game.util.Constants;
import com.paladinzzz.game.util.TempMS;
import com.paladinzzz.game.util.playerMemory;

import static com.badlogic.gdx.Gdx.input;
import static com.paladinzzz.game.screens.LoginScreen.playername;

public class LevelScreen implements Screen {

    private OrthographicCamera camera;
    private CrossplatformApp game;
    public Stage levelstage, button2stage, button3stage;
    private Texture background, level1texture, level2texture, level3texture, backbutton, level2textureDeny, level3textureDeny;
    private ImageButton level1, level2, level3, back, level2NOT, level3NOT;
    private Drawable level1drawable, level2drawable, level3drawable, backdrawable, level2deny, level3deny;
    private Table table, table2, table3;
    private Label label2, label3;
    private Sound click = Gdx.audio.newSound(Gdx.files.internal("Audio/click.wav"));
    private Viewport viewport;
//    public static boolean Gdx.input.isTouched() = false;

    private TempMS tempMS;

    public LevelScreen(CrossplatformApp game, TempMS tempMS) {
        this.game = game;
        this.camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);
        this.levelstage = new Stage(viewport);
        this.background = new Texture("Screens/LevelScreen/LevelSelection.png");
        this.backbutton = new Texture("Screens/BackButton.png");
        this.level1texture = new Texture("Screens/LevelScreen/Button1.png");
        this.level2texture = new Texture("Screens/LevelScreen/Button2.png");
        this.level3texture = new Texture("Screens/LevelScreen/Button3.png");
        this.tempMS = tempMS;
        this.level2textureDeny = new Texture("Screens/LevelScreen/Button2NOT.png");
        this.level3textureDeny = new Texture("Screens/LevelScreen/Button3NOT.png");
        label2 = new Label(("Complete level 1 first!"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        label3 = new Label(("Complete level 2 first!"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    }
//    public Overlay(SpriteBatch batch) {
//
//        this.button2stage = new Stage(viewport, batch);
//        this.button3stage = new Stage(viewport, batch);
//    }

    @Override
    public void show() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.viewport.apply();
        JSONfunctions s = new JSONfunctions();
        int showbutton = s.getHasLevel("haslevel1", playername);
        int showbutton2 = s.getHasLevel("haslevel2", playername);
        level1drawable = new TextureRegionDrawable(new TextureRegion(level1texture));
        level1 = new ImageButton(level1drawable);
        level1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play(Constants.soundLevel * 1.0f);
                tempMS.menuScreen.musicHandler.stopMusic();
                System.out.println("Loading new world: " + playerMemory.player.worldAndLevelData.getCurrentWorld() + "-" + playerMemory.player.worldAndLevelData.getCurrentLevel() );
                playerMemory.player.worldAndLevelData.setCurrentWorld(1);
                playerMemory.player.worldAndLevelData.setCurrentLevel(1);
                System.out.println("Loading new world: " + playerMemory.player.worldAndLevelData.getCurrentWorld() + "-" + playerMemory.player.worldAndLevelData.getCurrentLevel() );
                game.setScreen(new GameScreen(game, tempMS));
                levelstage.dispose();
                click.play(2.0f);
            }
        });

        level2drawable = new TextureRegionDrawable(new TextureRegion(level2texture));
        level2 = new ImageButton(level2drawable);
        level2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play(1.0f * Constants.soundLevel);
                System.out.println("Level 2 clicked");
                if (playerMemory.player.levelOneDone) {
                    MenuScreen.musicHandler.stopMusic();
                    playerMemory.player.worldAndLevelData.setCurrentWorld(2);
                    playerMemory.player.worldAndLevelData.setCurrentLevel(1);
                    game.setScreen(new GameScreen(game, tempMS));
                    levelstage.dispose();
                } else {
                    System.out.println("Complete World 1 first!");
                }
            }
        });


        level3drawable = new TextureRegionDrawable(new TextureRegion(level3texture));
        level3 = new ImageButton(level3drawable);
        level3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play(1.0f * Constants.soundLevel);
                System.out.println("Level 3 clicked");
                if (playerMemory.player.levelTwoDone) {
                    MenuScreen.musicHandler.stopMusic();
                    playerMemory.player.worldAndLevelData.setCurrentWorld(3);
                    playerMemory.player.worldAndLevelData.setCurrentLevel(1);
                    game.setScreen(new GameScreen(game, tempMS));
                    levelstage.dispose();
                } else {
                    System.out.println("Complete World 2 first!");
                }
            }//
        });

        backdrawable = new TextureRegionDrawable(new TextureRegion(backbutton));
        back = new ImageButton(backdrawable);
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                click.play(1.0f * Constants.soundLevel);
                System.out.println("Back button clicked");
            }
        });
//
//        Table table2 = new Table();
//        table2.center();
//        table2.setFillParent(true);
//        table2.add(label2);
//
//

//        Table table3 = new Table();
//        table3.center();
//        table3.setFillParent(true);
//        table3.add(label3);


        Gdx.input.setInputProcessor(levelstage);

        table = new Table();
        table.setFillParent(true);
        table.top();
        table.add().expandX();
        table.add(level1).expandX().padTop(190);
        if (showbutton == 1) {
            table.add(level2).expandX().padTop(190);
        }
        else {
            table.add(level2NOT).expandX().padTop(190);
//            if (Gdx.input.isTouched()) {
//                button2stage.clear();
//            } else {
//                button2stage.addActor(table2);
//            }
        }
        if (showbutton2 == 1) {
            table.add(level3).expandX().padTop(190);
        }
        else {
            table.add(level3NOT).expandX().padTop(190);
//            if (Gdx.input.isTouched()) {
//                button3stage.clear();
//            } else {
//                button3stage.addActor(table3);
//            }
        }
        table.add().expandX();
        table.add().expandX();
        table.row();
        table.add(back).expandX().padTop(50);

        levelstage.addActor(table);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(levelstage.getCamera().combined);

        game.batch.begin();

        game.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        game.batch.end();
        levelstage.draw();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        levelstage.dispose();
        background.dispose();
        level1texture.dispose();
        level2texture.dispose();
        level3texture.dispose();
        backbutton.dispose();
        this.button2stage.dispose();
        this.button3stage.dispose();
    }
}

