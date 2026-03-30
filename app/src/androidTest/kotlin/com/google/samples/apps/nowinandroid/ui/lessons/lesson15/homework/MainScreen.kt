/*
 * Copyright 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.lessons.lesson15.homework

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidRule
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule

object MainScreen : ComposeScreen<MainScreen>() {

    val toolbarTitle = child<KNode> {
        hasTestTag("toolbarTitle")
        //для поиска сложных локаторов включаем опцию ниже.
        // Но если есть kakaoRule, то можно убрать это -
        useUnmergedTree = true
    }

    val toolbarSearchIcon = child<KNode> {
        hasTestTag("toolbarSearchIcon")
    }

    val toolbarSettingsIcon = child<KNode> {
        hasTestTag("toolbarSettingsIcon")
    }

    //заголовок "What are you interested in"
    val mainHeaderTitle = child<KNode> {
        hasTestTag("headerTitle")
    }

    val subHeaderTitle = child<KNode>{
        hasTestTag("subHeaderTitle")
    }

    abstract class ConfigureTest : TestCase(Kaspresso.Builder.withComposeSupport()) {
        @get:Rule(order = 0)
        val hiltRule = HiltAndroidRule(this)

        @get:Rule(order = 1)
        // запускает приложение с compose
        val composeTestRule = createAndroidComposeRule<MainActivity>()

        @get:Rule(order = 2)
        val kakaoRule = KakaoComposeTestRule(composeTestRule, true)
    }
}