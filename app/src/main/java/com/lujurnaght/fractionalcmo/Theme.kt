package com.lujurnaght.fractionalcmo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** The boardroom: warm paper, black ink, nothing else. Black is the only accent, so where it lands it means something. */
object P {
    val paper = Color(0xFFF3F0E8)
    val sheet = Color(0xFFFAF8F3)
    val ink = Color(0xFF111111)
    val inkSoft = Color(0xFF2B2B2A)
    val grey = Color(0xFF6E6B64)
    val faint = Color(0xFFA29E94)
    val rule = Color(0xFFD8D3C6)
    val onInk = Color(0xFFF3F0E8)
    val onInkDim = Color(0xFF9C9A94)
}

@OptIn(ExperimentalTextApi::class)
private fun archivo(w: Int) = Font(
    R.font.archivo, weight = FontWeight(w),
    variationSettings = FontVariation.Settings(FontVariation.weight(w), FontVariation.width(125f)),
)

@OptIn(ExperimentalTextApi::class)
private fun instrument(w: Int) = Font(
    R.font.instrument, weight = FontWeight(w),
    variationSettings = FontVariation.Settings(FontVariation.weight(w)),
)

/** Archivo, expanded: headlines and the big numbers. */
val Display = FontFamily(archivo(600), archivo(700), archivo(800), archivo(900))

/** Instrument Sans: everything you read. */
val Sans = FontFamily(instrument(400), instrument(500), instrument(600), instrument(700))

object T {
    val hero = TextStyle(fontFamily = Display, fontWeight = FontWeight(800), fontSize = 40.sp, lineHeight = 42.sp, letterSpacing = (-1.2).sp, color = P.ink)
    val h1 = TextStyle(fontFamily = Display, fontWeight = FontWeight(800), fontSize = 28.sp, lineHeight = 32.sp, letterSpacing = (-0.6).sp, color = P.ink)
    val h2 = TextStyle(fontFamily = Display, fontWeight = FontWeight(700), fontSize = 19.sp, lineHeight = 24.sp, letterSpacing = (-0.2).sp, color = P.ink)
    val num = TextStyle(fontFamily = Display, fontWeight = FontWeight(800), fontSize = 34.sp, lineHeight = 36.sp, letterSpacing = (-1).sp, color = P.ink)
    val body = TextStyle(fontFamily = Sans, fontWeight = FontWeight(400), fontSize = 16.sp, lineHeight = 25.sp, color = P.inkSoft)
    val strong = TextStyle(fontFamily = Sans, fontWeight = FontWeight(600), fontSize = 16.sp, lineHeight = 22.sp, color = P.ink)
    val small = TextStyle(fontFamily = Sans, fontWeight = FontWeight(500), fontSize = 13.sp, lineHeight = 18.sp, color = P.grey)
    val label = TextStyle(fontFamily = Sans, fontWeight = FontWeight(700), fontSize = 11.sp, lineHeight = 14.sp, letterSpacing = 0.9.sp, color = P.grey)
    val button = TextStyle(fontFamily = Sans, fontWeight = FontWeight(600), fontSize = 15.sp, lineHeight = 20.sp, color = P.onInk)
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(primary = P.ink, onPrimary = P.onInk, background = P.paper, surface = P.paper, onSurface = P.ink),
        content = content,
    )
}

val Sharp = RoundedCornerShape(3.dp)

fun Modifier.tap(onClick: () -> Unit): Modifier = this.clickable(
    interactionSource = null, indication = null, onClick = onClick,
)

@Composable
fun Rule(modifier: Modifier = Modifier, color: Color = P.rule, thick: Dp = 1.dp) {
    Box(modifier.fillMaxWidth().height(thick).background(color))
}

@Composable
fun Label(text: String, modifier: Modifier = Modifier, color: Color = P.grey) {
    Text(text.uppercase(), style = T.label.copy(color = color), modifier = modifier)
}

/** "01  Pipeline" — numbered like the pages of a board deck. */
@Composable
fun Section(num: Int, title: String, modifier: Modifier = Modifier, trailing: (@Composable () -> Unit)? = null) {
    Column(modifier.fillMaxWidth().padding(top = 34.dp, bottom = 14.dp)) {
        Rule(color = P.ink, thick = 2.dp)
        Row(Modifier.fillMaxWidth().padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            if (num > 0) {
                Text(num.toString().padStart(2, '0'), style = T.h2.copy(color = P.faint))
                Spacer(Modifier.width(12.dp))
            }
            Text(title, style = T.h2, modifier = Modifier.weight(1f))
            trailing?.invoke()
        }
    }
}

@Composable
fun PrimaryButton(text: String, modifier: Modifier = Modifier, enabled: Boolean = true, onClick: () -> Unit) {
    Box(
        modifier
            .background(if (enabled) P.ink else P.faint, Sharp)
            .then(if (enabled) Modifier.clickable(onClick = onClick) else Modifier)
            .padding(horizontal = 18.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center,
    ) { Text(text, style = T.button) }
}

@Composable
fun GhostButton(text: String, modifier: Modifier = Modifier, enabled: Boolean = true, onClick: () -> Unit) {
    Box(
        modifier
            .border(1.5.dp, if (enabled) P.ink else P.faint, Sharp)
            .then(if (enabled) Modifier.clickable(onClick = onClick) else Modifier)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center,
    ) { Text(text, style = T.button.copy(color = if (enabled) P.ink else P.faint)) }
}

/** A small black-or-outline selector. */
@Composable
fun Chip(text: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier
            .then(if (selected) Modifier.background(P.ink, Sharp) else Modifier.border(1.dp, P.rule, Sharp))
            .clickable(onClick = onClick)
            .padding(horizontal = 11.dp, vertical = 7.dp),
    ) { Text(text, style = T.small.copy(color = if (selected) P.onInk else P.ink, fontWeight = FontWeight(600))) }
}

@Composable
fun Bar(fraction: Float, modifier: Modifier = Modifier, track: Color = P.rule, fill: Color = P.ink, height: Dp = 4.dp) {
    Box(modifier.fillMaxWidth().height(height).background(track)) {
        Box(Modifier.fillMaxWidth(fraction.coerceIn(0f, 1f)).height(height).background(fill))
    }
}

/** A square tick box: empty outline, or solid black when done. */
@Composable
fun Tick(done: Boolean, modifier: Modifier = Modifier, size: Dp = 20.dp) {
    Box(
        modifier.width(size).height(size)
            .then(if (done) Modifier.background(P.ink, RoundedCornerShape(2.dp)) else Modifier.border(1.5.dp, P.ink, RoundedCornerShape(2.dp))),
        contentAlignment = Alignment.Center,
    ) { if (done) Text("✓", style = T.small.copy(color = P.onInk, fontWeight = FontWeight(700), textAlign = TextAlign.Center)) }
}

@Composable
fun Input(
    value: String, onChange: (String) -> Unit, hint: String, modifier: Modifier = Modifier,
    singleLine: Boolean = true, minLines: Int = 1, secret: Boolean = false, numeric: Boolean = false,
) {
    BasicTextField(
        value = value, onValueChange = onChange, singleLine = singleLine, minLines = minLines,
        textStyle = T.body.copy(color = P.ink),
        cursorBrush = SolidColor(P.ink),
        visualTransformation = if (secret) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            capitalization = if (secret || numeric) KeyboardCapitalization.None else KeyboardCapitalization.Sentences,
            keyboardType = if (numeric) androidx.compose.ui.text.input.KeyboardType.Number else androidx.compose.ui.text.input.KeyboardType.Text,
        ),
        modifier = modifier.fillMaxWidth(),
        decorationBox = { inner ->
            Box(Modifier.fillMaxWidth().background(P.sheet, Sharp).border(1.dp, P.rule, Sharp).padding(horizontal = 14.dp, vertical = 12.dp)) {
                if (value.isEmpty()) Text(hint, style = T.body.copy(color = P.faint))
                inner()
            }
        },
    )
}

/** Big number over a small label, the way a board slide states a figure. */
@Composable
fun Figure(value: String, label: String, modifier: Modifier = Modifier, sub: String? = null, fraction: Float? = null) {
    Column(modifier) {
        Text(value, style = T.num)
        Spacer(Modifier.height(2.dp))
        Label(label)
        if (sub != null) Text(sub, style = T.small)
        if (fraction != null) { Spacer(Modifier.height(8.dp)); Bar(fraction, height = 3.dp) }
    }
}

@Composable
fun Bullets(items: List<String>, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items.forEach { s ->
            Row {
                Text("—", style = T.body.copy(color = P.ink, fontWeight = FontWeight(700)))
                Spacer(Modifier.width(10.dp))
                Text(s, style = T.body)
            }
        }
    }
}

@Composable
fun BackRow(text: String, onBack: () -> Unit) {
    Text("←  $text", style = T.strong, modifier = Modifier.padding(vertical = 14.dp).tap(onBack))
}
