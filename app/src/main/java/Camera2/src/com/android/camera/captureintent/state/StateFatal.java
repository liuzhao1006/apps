/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package Camera2.src.com.android.camera.captureintent.state;

import Camera2.src.com.android.camera.FatalErrorHandler;
import Camera2.src_pd.com.android.camera.stats.UsageStatistics;
import com.google.common.base.Optional;

import com.android.camera.async.RefCountBase;
import Camera2.src.com.android.camera.captureintent.resource.ResourceConstructed;
import Camera2.src.com.android.camera.captureintent.stateful.State;
import Camera2.src.com.android.camera.captureintent.stateful.StateImpl;
import com.android.camera2.R;
import Camera2.src_pd.com.google.common.logging.eventprotos;

/**
 * Represents a state that app is in an unrecoverable error state. Must show an
 * error dialog and finish.
 */
public final class StateFatal extends StateImpl {
    private final RefCountBase<ResourceConstructed> mResourceConstructed;

    public static StateFatal from(
            State previousState, RefCountBase<ResourceConstructed> resourceConstructed) {
        return new StateFatal(previousState, resourceConstructed);
    }

    private StateFatal(State previousState, RefCountBase<ResourceConstructed> resourceConstructed) {
        super(previousState);
        mResourceConstructed = resourceConstructed;
        mResourceConstructed.addRef();
    }

    @Override
    public Optional<State> onEnter() {
        mResourceConstructed.get().getMainThread().execute(new Runnable() {
            @Override
            public void run() {
                mResourceConstructed.get().getFatalErrorHandler().onGenericCameraAccessFailure();
            }
        });
        return NO_CHANGE;
    }
}