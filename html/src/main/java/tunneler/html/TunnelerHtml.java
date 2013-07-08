package tunneler.html;

import tunneler.core.Tunneler;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class TunnelerHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Tunneler();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
