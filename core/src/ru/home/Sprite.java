package ru.home;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;



public class Sprite extends Texture {
    //    TextureRegion region, float x, float y, float originX, float originY, float width, float height,
//    float scaleX, float scaleY, float rotation, boolean clockwise
    protected Vector2 pos;
    protected Vector2 speed;
    protected TextureRegion regions;
    Rectangle obj;
    protected float angle;
    protected float scale = 1f;
    float halfWidth;
    float halfHeight;

    public Sprite(String internalPath) {
        super(internalPath);
        this.pos = new Vector2(0, 0);
        this.speed = new Vector2(0, 0);
        this.regions = new TextureRegion(this);
        this.halfHeight = this.getHeight() / 2;
        this.halfWidth = this.getWidth() / 2;
    }

    public Sprite(String internalPath, float x, float y, float xSpeed, float ySpeed) {
        super(internalPath);
        this.pos = new Vector2(x, y);
        this.speed = new Vector2(xSpeed,ySpeed);
        this.regions = new TextureRegion(this);
        this.halfHeight = this.getHeight() / 2;
        this.halfWidth = this.getWidth() / 2;
        this.obj = new Rectangle(x,y,this.getWidth(),this.getHeight());

    }

    public Sprite(String internalPath, Vector2 pos, Vector2 speed, float angle, float scale) {
        super(internalPath);
        this.pos = pos;
        this.pos = speed;
        this.angle = angle;
        this.scale = scale;
        this.regions = new TextureRegion(this);
        this.halfHeight = this.getHeight() / 2;
        this.halfWidth = this.getWidth() / 2;
    }





    public void update(float deltaTime, Rectangle screen){
        checkAndHandleBounds(screen);
        pos.mulAdd(speed,deltaTime);
    }

    public void draw(SpriteBatch batch) {

        batch.draw(
                regions,
                pos.x, pos.y,
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale, angle
        );

    }

    protected void checkAndHandleBounds(Rectangle screen){
        if(pos.x> screen.getX()+screen.getWidth())           pos.x=0;
        if(pos.x + obj.getWidth() < screen.getX()) pos.x=screen.x;
        if(screen.getY() > pos.y+obj.getHeight()) pos.y=screen.y;
        if(pos.y > screen.getY()+screen.getHeight()) pos.y=0;
    }

    public boolean isOutside(Rectangle screen, Rectangle obj) {
        return obj.getX()> screen.getX()+screen.getWidth() || obj.getX() + obj.getWidth() < screen.getX()  || screen.getY() > obj.getY()+obj.getHeight() || obj.getY() > screen.getY()+screen.getHeight();

    }


    public void setPos(float x, float y) {
        this.pos = pos.set(x, y);
    }

    public void setRegions(TextureRegion regions) {
        this.regions = regions;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setHalfWidth(float halfWidth) {
        this.halfWidth = halfWidth;
    }

    public void setHalfHeight(float halfHeight) {
        this.halfHeight = halfHeight;
    }

}
