package com.brenda.demotesting

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    lateinit var escenario : ActivityScenario<MainActivity>

    @get:Rule
    val mActivityRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textoIsBren(){
        escenario = ActivityScenario.launch(MainActivity::class.java)
        escenario.moveToState(Lifecycle.State.CREATED)

        //Simular que esta escribiendo
        onView(withId(R.id.txtNombre)).perform(typeText("Hola!!"), ViewActions.closeSoftKeyboard())

        //Simular que el btn es presionado
        onView(withId(R.id.btnOperacion)).perform(click())

        //Cambiar el texto en el editText
        onView(withId(R.id.txtNombre)).check(matches(withText("Bren")))

    }

    @After
    @Throws(Exception::class)
    open fun terminar() {
        escenario.close()
    }
}