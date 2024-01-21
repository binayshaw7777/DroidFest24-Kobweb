package com.binayshaw7777.droidfest24kobweb.pages

import androidx.compose.runtime.Composable
import com.binayshaw7777.droidfest24kobweb.HeadingFontStyle
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.*
import com.binayshaw7777.droidfest24kobweb.HeroContainerStyle
import com.binayshaw7777.droidfest24kobweb.HeroImageStyle
import com.binayshaw7777.droidfest24kobweb.KotlinGradient
import com.binayshaw7777.droidfest24kobweb.SecondaryFontStyle
import com.binayshaw7777.droidfest24kobweb.components.Utils.DROID
import com.binayshaw7777.droidfest24kobweb.components.Utils.FEST
import com.binayshaw7777.droidfest24kobweb.components.Utils.KOLKATA_24
import com.binayshaw7777.droidfest24kobweb.components.Utils.KOTLIN_3D
import com.binayshaw7777.droidfest24kobweb.components.Utils.KotlinKolkataLinkedIn
import com.binayshaw7777.droidfest24kobweb.components.Utils.LETS_GO
import com.binayshaw7777.droidfest24kobweb.components.layouts.PageLayout
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.jetbrains.compose.web.css.keywords.auto


@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Box(HeroContainerStyle.toModifier()) {

            SimpleGrid(
                modifier = Modifier.fillMaxSize(),
                numColumns = numColumns(base = 1, sm = 1, md = 2)
            ) {

                Column(
                    verticalArrangement = Arrangement.Center
                ) {

                    Row {

                        SpanText(
                            text = DROID,
                            modifier = HeadingFontStyle.toModifier()
                        )

                        SpanText(
                            text = FEST,
                            modifier = HeadingFontStyle.toModifier()
                                .then(KotlinGradient)
                                .styleModifier {
                                    property("-webkit-background-clip", "text")
                                    property("-webkit-text-fill-color", "transparent")
                                }
                        )
                    }

                    SpanText(
                        text = KOLKATA_24,
                        modifier = SecondaryFontStyle.toModifier()
                    )

                    val ctx = rememberPageContext()

                    Box(
                        modifier = Modifier
                            .cursor(Cursor.Pointer)
                            .borderRadius(10.px)
                            .padding(leftRight = 3.cssRem, topBottom = 0.5.cssRem)
                            .margin(top = 2.cssRem)
                            .zIndex(1f)
                            .then(KotlinGradient)
                            .onClick {
                                ctx.router.navigateTo(KotlinKolkataLinkedIn)
                            }

                    ) {
                        SpanText(
                            text = LETS_GO,
                            modifier = Modifier.color(Colors.White)
                        )
                    }
                }

                Box(
                    modifier = Modifier.width(100.percent).height(auto),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        src = KOTLIN_3D,
                        modifier = HeroImageStyle.toModifier()
                    )
                }

            }
        }
    }
}
