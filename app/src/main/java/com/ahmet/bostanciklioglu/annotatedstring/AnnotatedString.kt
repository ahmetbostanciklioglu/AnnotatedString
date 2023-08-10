package com.ahmet.bostanciklioglu.annotatedstring

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun AnnotatedCustomString(context: Context) {
    val annotatedText: AnnotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.DarkGray,
                textDecoration = TextDecoration.LineThrough
            ),
        ) {
            append("There")
        }
        withStyle(
            style = SpanStyle(fontWeight = FontWeight.SemiBold)
        ) {
            append(" are two ")
        }
        withStyle(
            style = SpanStyle(color = Color.Red, textDecoration = TextDecoration.Underline)
        ) {
            append("ways")
        }
        withStyle(
            style = SpanStyle(color = Color.LightGray)
        ) {
            append(" to live ")
        }
        withStyle(
            style = SpanStyle(background = Color.Red, color = Color.White, fontSize = 21.sp)
        ) {
            append("you")
        }
        withStyle(
            style = SpanStyle()
        ) {
            append(" can ")
        }

        withStyle(
            style = SpanStyle(fontSize = 28.sp, fontWeight = FontWeight.SemiBold)
        ) {
            append("live ")
        }
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline,
                baselineShift = BaselineShift.Superscript
            )
        ) {
            append("as if not")
        }
        withStyle(
            style = SpanStyle()
        ) {
            append("hing ")
        }
        withStyle(
            style = SpanStyle()
        ) {
            append("is a miracle: ")
        }
        withStyle(
            style = SpanStyle(
                baselineShift = BaselineShift.Subscript
            )
        ) {
            append("you")
        }
        withStyle(
            style = SpanStyle(color = Color.DarkGray)
        ) {
            append("can live as if everything is a miracle. ")
        }
        val start = length
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,

                )
        ) {
            append("CLICK ahmetbostanciklioglu")
            val test = start + "CLICK ahmetbostanciklioglu".length
            addStringAnnotation("ClickableText", "CLICK ahmetbostanciklioglu", start, test)
        }

    }
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            val annotations = annotatedText.getStringAnnotations("ClickableText", offset, offset)

            if (annotations.isNotEmpty()) {
                val annotation = annotations[0]
                if (annotation.item == "CLICK ahmetbostanciklioglu") {
                    Toast.makeText(context, "This a simple toast tutorial!", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewAnnotatedText() {
    AnnotatedCustomString(context = LocalContext.current)
}



