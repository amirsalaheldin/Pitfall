package com.demoversion.pitfall.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;



public class GameManager {
    private static final GameManager ourInstance = new GameManager();

    public GameData gameData;
    private Json json = new Json();
    private FileHandle fileHandle = Gdx.files.local("bin/GameData.json");

    public boolean gameStartedFromMainMenu, isPaused = true;
    public int lifeScore,time, score, diamondCount, lvl;
    public float lastPositionx =70 ;
    public float lastPositiony =700;

    private Music introMusic;
    private Music backgroundMusic;
    private Music gameOverMusic;

    private GameManager() {
    }

    public void initializeGameData(){
        if (!fileHandle.exists()){
            gameData = new GameData();

            gameData.setHighscore(0);
            gameData.setDiamondHighscore(0);
            saveData();
        }
        else {
            loadData();
        }
    }

    public void saveData(){
        if (gameData != null){
            fileHandle.writeString(Base64Coder.encodeString(json.prettyPrint(gameData)),
                    false);
        }
    }

    public void loadData(){
        gameData = json.fromJson(GameData.class, Base64Coder.decodeString(fileHandle.readString()));
    }

    public void checkForHighscore(){
        int oldHighscore = gameData.getHighscore();
        int oldDiamondHighscore = gameData.getDiamondHighscore();

        if (oldHighscore < score){
            gameData.setHighscore(score);
        }

        if (oldDiamondHighscore < diamondCount){
            gameData.setDiamondHighscore(diamondCount);
        }

        saveData();
    }

    public void playIntroMusic(){
        if (introMusic == null){
            introMusic = Gdx.audio.newMusic(Gdx.files.internal("Intro Screen.mp3"));
        }

        if (!introMusic.isPlaying()){
            introMusic.play();
        }
    }

    public void stopIntroMusic(){
        if (introMusic.isPlaying()){
            introMusic.stop();
            introMusic.dispose();
        }
    }

    public void playBackgroundMusic(){
        if (backgroundMusic == null){
            backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("bg.mp3"));
        }

        if (!backgroundMusic.isPlaying()){
            backgroundMusic.play();
            backgroundMusic.setLooping(true);
        }
    }


    public void pauseBackgroundMusic(){
        if (backgroundMusic.isPlaying()){
            backgroundMusic.pause();
        }
    }

    public void stopBackgroundMusic(){
        if (backgroundMusic.isPlaying()){
            backgroundMusic.stop();
            backgroundMusic.dispose();
        }
    }

    public void playGameOverMusic(){
        if (gameOverMusic == null){
            gameOverMusic = Gdx.audio.newMusic(Gdx.files.internal("gameover.mp3"));
        }

        if (!gameOverMusic.isPlaying()){
            gameOverMusic.play();
            gameOverMusic.setLooping(true);
        }
    }

    public void stopGameOverMusic(){
        if (gameOverMusic.isPlaying()){
            gameOverMusic.stop();
            gameOverMusic.dispose();
        }
    }


    public static GameManager getInstance() {
        return ourInstance;
    }


}
