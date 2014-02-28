package net.osmand.plus.views;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class GLView extends GLSurfaceView {

	public GL10 gl;

	public GLView(Context context) {
		super(context);
		initView(context);
	}

	public GLView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	private void initView(Context context) {
		setEGLContextClientVersion(2);
		setRenderer(new OsmAndGLRenderer());
		setRenderMode(RENDERMODE_CONTINUOUSLY);
	}

	public class OsmAndGLRenderer implements Renderer {


		@Override
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			GLView.this.gl = gl;
			// Set the background frame color
	        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		}

		@Override
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			GLView.this.gl = gl;
			  // Redraw background color
	        GLES20.glViewport(0, 0, width, height);
		}

		@Override
		public void onDrawFrame(GL10 gl) {
			GLES20.glClearColor(0, 1, 0, 0.2f);
			GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
		}
		
	}
}
