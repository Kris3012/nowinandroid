package com.google.samples.apps.nowinandroid.ui.lessons.lesson15.homework

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import kotlinx.coroutines.MainScope
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest

class MainScreenTest: MainScreen.ConfigureTest(){

    @Test
    fun checkToolBar() {
        run {
            MainScreen {
                //элементы туллбара
                toolbarTitle.assertTextEquals("Now in Android")
                toolbarSearchIcon.assertContentDescriptionContains("Search")
                toolbarSettingsIcon.assertContentDescriptionContains("Settings")
                //заголовок и подзаголовок
                mainHeaderTitle.assertTextEquals("What are you interested in?")
                subHeaderTitle.assertTextEquals("Updates from topics you follow will appear here. Follow some things to get started.")
                // assertTextEquals - метод какао.
                // все проверки у композа начинаются с "assert", а все действия с "perform"
            }
        }
    }


}