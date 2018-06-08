package org.theplu;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import controllers.PostrojenjaController;
import controllers.KlasifikacijaController;
import controllers.TestController;

@ApplicationPath("/rest")
public class MyRestApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(PostrojenjaController.class);
        classes.add(KlasifikacijaController.class);
        return classes;
    }
}
