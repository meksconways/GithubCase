package com.mek.githubcase.di;

import android.app.Activity;
import android.content.Context;

import com.mek.githubcase.base.BaseActivity;
import com.mek.githubcase.base.GithubApplication;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

public class ActivityInjector {


    private final Map<Class<? extends Activity>,
            Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors;

    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();

    @Inject
    ActivityInjector(Map<Class<? extends Activity>,
            Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors) {
        this.activityInjectors = activityInjectors;
    }

    void inject(Activity activity) {

        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }

        String instanceId = ((BaseActivity) activity).getInstanceId();
        if (cache.containsKey(instanceId)) {
            //noinspection unchecked,ConstantConditions
            ((AndroidInjector<Activity>) cache.get(instanceId)).inject(activity);
            return;
        }

        //noinspection unchecked,ConstantConditions
        AndroidInjector.Factory<Activity> injectorFactory = (AndroidInjector.Factory<Activity>)
                activityInjectors.get(activity.getClass()).get();

        AndroidInjector<Activity> injector = injectorFactory.create(activity);
        cache.put(instanceId, injector);
        injector.inject(activity);


    }

    void clear(Activity activity){
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }
        cache.remove(((BaseActivity) activity).getInstanceId());
    }

    static ActivityInjector get(Context context){
        return ((GithubApplication) context.getApplicationContext()).getActivityInjectorObj();
    }

}
