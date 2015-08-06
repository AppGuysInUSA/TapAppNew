package com.chiznoca.scottblaster;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {

    private SpriteBatch batch;
    private Texture tapButton;
    private Sprite buttonSprite;
    private GlyphLayout glyphLayout;
    Stage tapThatStage;
    Skin btnSkin;
    TextureAtlas atlasBtnSkin;
    ImageButton tapThatBtn;
    ImageButton.ImageButtonStyle tapThatBtnStyle;
    int addTaps = 0;
    private String tapCount = "Begin!";
    private BitmapFont font;
    private int screenWidth;
    private int screenHeight;


    @Override
    public void create () {

        //Stage tapThatStage = new Stage();
        //Gdx.input.setInputProcessor(tapThatStage);


        //btnSkin = new Skin();
        //atlasBtnSkin = new TextureAtlas(Gdx.files.internal("tapThatBtnSkin.pack"));
        //btnSkin.addRegions(atlasBtnSkin);
        //tapThatBtnStyle = new ImageButton.ImageButtonStyle();

        //tapThatBtnStyle.up = btnSkin.getDrawable("tapThatBtnSkin2.png");
        //tapThatBtnStyle.down = btnSkin.getDrawable("tapThatBtnSkin.png");
        //tapThatBtn = new ImageButton(tapThatBtnStyle);





        this.batch = new SpriteBatch();
        this.glyphLayout = new GlyphLayout();

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();

        font = new BitmapFont();
        font.setColor(Color.BLUE);
        font.getData().scale(5);

        tapButton = new Texture(Gdx.files.internal("tapThatBtnSkin2.png"));

        buttonSprite = new Sprite(tapButton);


        //tapThatStage.addActor(tapThatBtn);

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render () {
        super.render();

        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        glyphLayout.setText(font, tapCount);



        buttonSprite.setPosition(Gdx.graphics.getWidth() / 2 - buttonSprite.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - buttonSprite.getHeight() / 2);

        batch.begin();
        //tapThatStage.draw();
        buttonSprite.draw(batch);
        font.draw(batch, glyphLayout, screenWidth/2 - glyphLayout.width/2, screenHeight/2 + glyphLayout.height/2);
        batch.end();

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        tapButton = new Texture(Gdx.files.internal("tapThatBtnSkin.png"));
        buttonSprite = new Sprite(tapButton);
        addTaps++;
        tapCount = Integer.toString(addTaps);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        tapButton = new Texture(Gdx.files.internal("tapThatBtnSkin2.png"));
        buttonSprite = new Sprite(tapButton);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
