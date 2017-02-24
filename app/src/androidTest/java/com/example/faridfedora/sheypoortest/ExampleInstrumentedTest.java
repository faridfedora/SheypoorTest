package com.example.faridfedora.sheypoortest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        final Context appContext = InstrumentationRegistry.getTargetContext();
        Server server=new Server(appContext);
        server.getMoviesInPage(1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String correctName="Kirby Buckets";
                int correctRuntime=30;
                Gson gson=new Gson();

                try {
                    MovieModel movieModel= gson.fromJson(response.get(0).toString(),MovieModel.class);

                    //testing response
                    assertNotNull(movieModel);
                    assertEquals(movieModel.getName(),correctName);
                    assertEquals(movieModel.getRuntime(),correctRuntime);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        assertEquals("com.example.faridfedora.sheypoortest", appContext.getPackageName());
    }
}
