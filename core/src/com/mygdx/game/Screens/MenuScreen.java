package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyCoreClass;
import com.mygdx.game.PersevereGame;

import static java.lang.System.exit;

public class MenuScreen implements Screen {
    private Viewport viewport;
    private Stage stage;
    private Game game;

    public MenuScreen(Game g) {
        //FileHandle file = Gdx.files.local("highscore.txt");
        //file.emptyDirectory();
        MyCoreClass myCoreClass = new MyCoreClass();
        myCoreClass.SaveFile();
        game=g;
        stage =new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        TextButton btnLogin = new TextButton("Start Game",skin);
        btnLogin.setPosition(180,300);
        btnLogin.setSize(300,40);

        btnLogin.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point , int button){
                btnSGC();
            }

        });

        stage.addActor(btnLogin);

        btnLogin = new TextButton("About",skin);
        btnLogin.setPosition(180,250);
        btnLogin.setSize(300,40);

        btnLogin.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point , int button){
                btnAC();
            }

        });

        stage.addActor(btnLogin);

        btnLogin = new TextButton("High Score",skin);
        btnLogin.setPosition(180,200);
        btnLogin.setSize(300,40);

        btnLogin.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point , int button){
                btnHSC();
            }

        });

        stage.addActor(btnLogin);

        btnLogin = new TextButton("Credits",skin);
        btnLogin.setPosition(180,150);
        btnLogin.setSize(300,40);

        btnLogin.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point , int button){
                btnCC();
            }

        });

        stage.addActor(btnLogin);

        btnLogin = new TextButton("Exit",skin);
        btnLogin.setPosition(180,100);
        btnLogin.setSize(300,40);

        btnLogin.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point , int button){
                btnEC();
            }

        });

        stage.addActor(btnLogin);

    }

    public void btnSGC(){
        game.setScreen(new NameInput(game));
    }

    public void btnAC(){
        game.setScreen(new About(game));
    }

    public void btnHSC(){
        game.setScreen(new HighScores(game));
    }

    public void btnCC(){
        game.setScreen(new Credits(game));
    }

    public void btnEC(){
        exit(0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            game.setScreen(new ChapterMenuPlay((PersevereGame) game));
            dispose();
        }

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        stage.dispose();
    }
}
