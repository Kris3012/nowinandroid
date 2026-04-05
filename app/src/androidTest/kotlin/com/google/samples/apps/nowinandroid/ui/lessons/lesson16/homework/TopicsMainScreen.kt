package com.google.samples.apps.nowinandroid.ui.lessons.lesson16.homework

import LazyListItemPositionSemantics
import LazyListSizeSemantics
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.google.samples.apps.nowinandroid.core.designsystem.component.Tags
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidRule
import io.github.kakaocup.compose.node.builder.ViewBuilder
import io.github.kakaocup.compose.node.core.BaseNode
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemBuilder
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule

object TopicsMainScreen: ComposeScreen<TopicsMainScreen>() {

    //список 1
    val topicsList = createLazyList(
        viewBuilderAction = {
            hasTestTag(Tags.TOPICS_SELECTION)
        },
        itemTypeBuilder = {
            itemType(::ListTopicsItem)
        },
    )

    //список 2
    val feedList = createLazyList(
        viewBuilderAction = {
            hasTestTag(Tags.MAIN_FEED)
        },
        itemTypeBuilder = {
            itemType(::FeedTopicsItem)
        }
    )

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

//функция расширения BaseNode для создания списков (пример дан для случая с новым Kakao):

fun BaseNode<*>.createLazyList(
    viewBuilderAction: ViewBuilder.() -> Unit,
    itemTypeBuilder: KLazyListItemBuilder.() -> Unit,
) = KLazyListNode(
    viewBuilderAction = viewBuilderAction,
    itemTypeBuilder = itemTypeBuilder,
    positionMatcher = {
        SemanticsMatcher.expectValue(LazyListItemPositionSemantics, it)
    },
    lengthSemanticsPropertyKey = LazyListSizeSemantics,
)
