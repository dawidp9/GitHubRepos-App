package com.piwko.dawid.searchgithubrepos.di;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;
import com.piwko.dawid.searchgithubrepos.base.BaseActivity;
import com.piwko.dawid.searchgithubrepos.base.BaseController;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

@ActivityScope
public class ScreenInjector {

    private final Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjectors;
    private final Map<String, AndroidInjector<Controller>> cache = new HashMap<>();

    @Inject
    ScreenInjector(Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjectors) {
        this.screenInjectors = screenInjectors;
    }

    void inject(Controller controller) {
        if (!(controller instanceof BaseController)) {
            throw new IllegalArgumentException("Your controller doesn't extend BaseController!");
        }

        String instanceId = controller.getInstanceId();
        if (cache.containsKey(instanceId)) {
            cache.get(instanceId).inject(controller);
            return;
        }

        //noinspection unchecked
        AndroidInjector.Factory<Controller> injectorFactory =
                (AndroidInjector.Factory<Controller>) screenInjectors.get(controller.getClass()).get();
        AndroidInjector<Controller> injector = injectorFactory.create(controller);
        cache.put(instanceId, injector);
        injector.inject(controller);
    }

    void clear(Controller controller) {
        cache.remove(controller.getInstanceId());
    }

    static ScreenInjector get(Activity activity) {
        if(!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Your controller doesn't hosted BaseActivity!");
        }
        return ((BaseActivity) activity).getScreenInjector();
    }


}
