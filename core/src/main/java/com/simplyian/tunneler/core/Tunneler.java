package com.simplyian.tunneler.core;

import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;

public class Tunneler implements ApplicationListener {
    Texture texture;

    SpriteBatch batch;

    float elapsed;

    Mesh mesh;

    ShaderProgram shader;

    PerspectiveCamera cam;

    @Override
    public void create() {
        texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
        batch = new SpriteBatch();

        float[] data = new float[]{-1.0f, -1.0f, 0.0f,
            1.0f, -1.0f, 0.0f,
            0.0f, 1.0f, 0.0f};

        mesh = new Mesh(true, 3, 3, VertexAttribute.Position());
        mesh.setVertices(data);
        mesh.setIndices(new short[]{0, 1, 2});

        shader = new ShaderProgram(Gdx.files.internal("vertex.glsl"), Gdx.files.internal("fragment.glsl"));

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(0, 0, -10);
        cam.lookAt(0, 0, 0);
        cam.near = 0.1f;
        cam.far = 300;
        cam.update();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        GL10 gl = Gdx.gl10;

        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        shader.begin();
        shader.setUniformMatrix("u_worldView", cam.combined);
        mesh.render(shader, GL20.GL_TRIANGLES);
        shader.end();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
