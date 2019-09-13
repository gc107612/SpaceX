/*
 *  Copyright 2017 Google Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.spacex.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.spacex.viewmodel.spacexdetails.SpaceXDetailsViewModel;
import com.example.spacex.viewmodel.spacexlist.SpaceXViewModel;

/**
 * A creator is used to inject the product ID into the ViewModel
 * <p>
 * This creator is to showcase how to inject dependencies into ViewModels. It's not
 * actually necessary in this case, as the product ID can be passed in a public method.
 */
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Application mApplication;

    private ViewModelFactory() {
    }

    static ViewModelFactory getInstance() {
        return ViewModelFactoryInstanceHolder.INSTANCE;
    }

    void setApplication(Application application) {
        mApplication = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SpaceXViewModel.class)) {
            //noinspection unchecked
            return (T) new SpaceXViewModel(mApplication);
        }

        if (modelClass.isAssignableFrom(SpaceXDetailsViewModel.class)) {
            //noinspection unchecked
            return (T) new SpaceXDetailsViewModel(mApplication);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

    private static class ViewModelFactoryInstanceHolder {
        private static final ViewModelFactory INSTANCE = new ViewModelFactory();
    }
}
