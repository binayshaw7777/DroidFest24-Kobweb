package com.binayshaw7777.droidfest24kobweb.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.binayshaw7777.droidfest24kobweb.components.Utils.BACKGROUND_IMAGE
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.percent
import com.binayshaw7777.droidfest24kobweb.components.sections.NavHeader
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.filter
import org.jetbrains.compose.web.css.keywords.auto

val PageContentStyle by ComponentStyle {
    base { Modifier.fillMaxSize().padding(leftRight = 2.cssRem, top = 4.cssRem) }
    Breakpoint.MD { Modifier.maxWidth(60.cssRem) }
}

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun PageLayout(title: String, content: @Composable ColumnScope.() -> Unit) {
    LaunchedEffect(title) {
        document.title = "Kobweb - $title"
    }

    val isLight = when (ColorMode.current) {
        ColorMode.LIGHT -> true
        ColorMode.DARK -> false
    }

    Box(
        Modifier
            .fillMaxWidth()
            .backgroundColor(
                if (isLight) Colors.White
                else Colors.Black
            )
            .minHeight(100.percent)
            .overflow(Overflow.Hidden)
            // Create a box with two rows: the main content (fills as much space as it can) and the footer (which reserves
            // space at the bottom). "min-content" means the use the height of the row, which we use for the footer.
            // Since this box is set to *at least* 100%, the footer will always appear at least on the bottom but can be
            // pushed further down if the first row grows beyond the page.
            // Grids are powerful but have a bit of a learning curve. For more info, see:
            // https://css-tricks.com/snippets/css/complete-guide-grid/
            .gridTemplateRows { size(1.fr); size(minContent) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            // Isolate the content, because otherwise the absolute-positioned SVG above will render on top of it.
            // This is confusing but how browsers work. Read up on stacking contexts for more info.
            // https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_positioned_layout/Understanding_z-index/Stacking_context
            // Some people might have used z-index instead, but best practice is to avoid that if possible, because
            // as a site gets complex, Z-fighting can be a huge pain to track down.
            Modifier.fillMaxSize().gridRow(1),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NavHeader()
            Column(
                PageContentStyle.toModifier(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()
            }
        }


        Image(
            src = BACKGROUND_IMAGE,
            modifier = Modifier.width(100.percent).height(auto).padding(10.cssRem)
                .styleModifier {
                    filter { if (isLight) invert(1) else invert(0) }
                }

        )
    }
}
