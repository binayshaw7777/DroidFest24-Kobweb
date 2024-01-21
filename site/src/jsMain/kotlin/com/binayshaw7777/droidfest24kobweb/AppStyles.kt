package com.binayshaw7777.droidfest24kobweb

import com.binayshaw7777.droidfest24kobweb.components.Utils
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import com.varabyte.kobweb.silk.components.layout.HorizontalDividerStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.addVariantBase
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.modifyComponentStyleBase
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@InitSilk
fun initSiteStyles(ctx: InitSilkContext) {
    ctx.stylesheet.registerStyleBase("body") {
        Modifier
            .fontFamily(
                "-apple-system", "BlinkMacSystemFont", "Segoe UI", "Roboto", "Oxygen", "Ubuntu",
                "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", "sans-serif"
            )
            .fontSize(18.px)
            .lineHeight(1.5)
    }

    // Silk dividers only extend 90% by default; we want full width dividers in our site
    ctx.theme.modifyComponentStyleBase(HorizontalDividerStyle) {
        Modifier.fillMaxWidth()
    }
}


// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle by ComponentStyle {
    base { Modifier.width(100.percent).minHeight(100.vh).gap(2.cssRem) }
    Breakpoint.MD { Modifier.margin { top(20.vh) } }
}

val HeadingFontStyle by ComponentStyle {
    base {
        Modifier.fontSize(4.5.cssRem)
            .fontWeight(FontWeight.Bolder)
            .fontFamily(Utils.MONTSERRAT)

    }
}

val HeroImageStyle by ComponentStyle {
    base {
        Modifier.width(100.percent).height(auto).padding(1.cssRem).margin(left = 2.cssRem)
    }
    Breakpoint.SM {
        Modifier.width(50.percent).height(auto)
    }
    Breakpoint.MD {
        Modifier.width(75.percent).height(auto).padding(1.cssRem).margin(left = 2.cssRem)
    }
}

val SecondaryFontStyle by ComponentStyle {
    base {
        Modifier
            .fontSize(2.5.cssRem)
            .opacity(0.45f)
            .fontWeight(FontWeight.Light)
    }
}

val KotlinGradient = Modifier.styleModifier {
    property(
        "background",
        "linear-gradient(91deg, #6B57FF 49.09%, #B223E9 76.7%, #E3475A 103.23%)"
    )
}

val HeadlineTextStyle by ComponentStyle.base {
    Modifier
        .fontSize(3.cssRem)
        .textAlign(TextAlign.Start)
        .lineHeight(1.2) //1.5x doesn't look as good on very large text
}

val SubheadlineTextStyle by ComponentStyle.base {
    Modifier
        .fontSize(1.cssRem)
        .textAlign(TextAlign.Start)
        .color(colorMode.toPalette().color.toRgb().copyf(alpha = 0.8f))
}

val CircleButtonVariant by ButtonStyle.addVariantBase {
    Modifier.padding(0.px).borderRadius(50.percent)
}

val UncoloredButtonVariant by ButtonStyle.addVariantBase {
    Modifier.setVariable(ButtonVars.BackgroundDefaultColor, Colors.Transparent)
}
