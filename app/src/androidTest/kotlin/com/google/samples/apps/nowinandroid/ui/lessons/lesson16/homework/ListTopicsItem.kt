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

package com.google.samples.apps.nowinandroid.ui.lessons.lesson16.homework

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.component.Tags
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode

// создаем описание списка выбора топиков
// (в котором иконка, название, "плюсик" добавления)

class ListTopicsItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
): KLazyListItemNode<ListTopicsItem> (semanticNode, semanticsProvider) {

    val imageIcon = child<KNode> {
        hasTestTag(Tags.IMAGE_ICON)
    }

    val topicTitle = child<KNode>{
        hasTestTag(Tags.TOPIC_TEXT)
    }

    val plusIcon = child<KNode> {
        hasTestTag(Tags.PLUS_ICON)
    }

    val checkedIcon = child<KNode> {
        hasTestTag(Tags.CHECKED_ICON)
    }
}