/*
 * Copyright (C) 2014 The Android Open Source Project
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

package Camera2.src.com.android.camera.async;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Nonnull;

/**
 * Counts down on each update.
 */
public class UpdatableCountDownLatch<T> extends CountDownLatch implements Updatable<T> {
    public UpdatableCountDownLatch(int count) {
        super(count);
    }

    @Override
    public void update(@Nonnull T v) {
        countDown();
    }
}
