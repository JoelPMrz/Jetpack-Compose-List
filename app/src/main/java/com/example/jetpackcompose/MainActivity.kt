package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

private val messages : List<MyMessage> = listOf(
    MyMessage("Hola Jetcpack Cmompose", "¿Estás preparad? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 2", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 3", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 4", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 5", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 6", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 7", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 8", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 9", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 10", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 11", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 12", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 13", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
    MyMessage("Hola Jetcpack Cmompose 14", "¿Estás preparad?Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dapibus lectus id dui pretium, non laoreet nibh venenatis. Integer sagittis mi sit amet erat facilisis, ac feugiat felis scelerisque. Donec at turpis quis eros fermentum tristique. Vivamus et leo elit. Sed fringilla felis nec urna euismod, sed venenatis sem aliquet. "),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn() {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)){
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage(){
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription =  "",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}

@Composable
fun MyTexts(message: MyMessage){

    var expanded by remember { mutableStateOf(false) }

    Column (modifier = Modifier.padding(start = 8.dp).clickable {
        expanded = !expanded
    }) {
        MyText(
            message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall,
            if(expanded) Int.MAX_VALUE  else 1
        )
    }

}

@Composable
fun MyText(text : String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent(){
    JetpackComposeTheme {
            MyMessages(messages)
    }
}