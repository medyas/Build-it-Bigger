package com.udacity.gradle.builditbigger;

import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.format.DateUtils;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import ml.medyas.jokeactivity.JokesActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    /*@Rule
    public ActivityTestRule<LoginActivity> mActivityRule
            = new ActivityTestRule<>(LoginActivity.class);*/

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule
            = new IntentsTestRule<>(MainActivity.class);



    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityRule.getActivity().getIdlingResource();
        // Make sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(DateUtils.SECOND_IN_MILLIS * 75 * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(DateUtils.SECOND_IN_MILLIS * 75 * 2, TimeUnit.MILLISECONDS);

        // Now we wait
        IdlingRegistry.getInstance().register(mIdlingResource);

    }


    @Test
    public void useAppContext() {

        onView(withId(R.id.tell_joke_btn)).perform(click());

        intended(hasComponent(JokesActivity.class.getName()));

        // passes if the textView does not match the empty string
        onView(withId(R.id.text_setup)).check(matches(not(withText(""))));
        onView(withId(R.id.text_punchline)).check(matches(not(withText(""))));

    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(mIdlingResource);
    }

}
