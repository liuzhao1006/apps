/*
 * Copyright (C) 2012 The Android Open Source Project
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

package Camera2.tests.src.com.android.camera;

import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;

import Camera2.tests_camera.src.com.android.camera.functional.CameraTest;
import Camera2.tests_camera.src.com.android.camera.functional.ImageCaptureIntentTest;
import Camera2.tests_camera.src.com.android.camera.functional.VideoCaptureIntentTest;
import Camera2.tests_camera.src.com.android.camera.unittest.CameraUnitTest;

import junit.framework.TestSuite;


public class CameraTestRunner extends InstrumentationTestRunner {

    @Override
    public TestSuite getAllTests() {
        TestSuite suite = new InstrumentationTestSuite(this);
        suite.addTestSuite(CameraTest.class);
        suite.addTestSuite(ImageCaptureIntentTest.class);
        suite.addTestSuite(VideoCaptureIntentTest.class);
        suite.addTestSuite(CameraUnitTest.class);
        return suite;
    }

    @Override
    public ClassLoader getLoader() {
        return CameraTestRunner.class.getClassLoader();
    }
}
