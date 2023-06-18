package com.example.videozin

import android.os.Bundle
import android.text.Html.ImageGetter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.videozin.ui.theme.VideozinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideozinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()


                ) {
                        DisplayFinal()
                }
            }
        }
    }
}


val Spider = FontFamily(Font(R.font.spiderfont))

@Composable
fun DisplayFinal() {
    Row(modifier = Modifier.background(Color(0x11, 0x11, 0x11, 0xFF))){
        Column {
            Banner()
            Spacer(modifier = Modifier.height(15.dp))
            Carrossel()
            StartsFinal()

        }


    }



}

@Preview(showBackground = true)
@Composable
fun PreviewDisplay() {
    VideozinTheme() {
        DisplayFinal()

    }
}


@Composable
fun Banner(){
    VideozinTheme() {
        var title = "Spider-Verse"

    Card( modifier = Modifier
        .height(200.dp)



    ) {

        Box(modifier = Modifier.height(200.dp)

        ){
            Image(painter = painterResource(id = R.drawable.banner),
                contentDescription = "Banner",
                //Mexe com todo container ao redor da imagem
                modifier = Modifier
                .fillMaxWidth(),
                //ContentScale Mexe com as propriedades da Imagem
                contentScale = ContentScale.FillWidth,
                )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 350f
                    )

                )
            ){


            }

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                Text(text = title, style = TextStyle(color= Color.White, fontSize = 36.sp,
                    fontFamily=Spider
                ))

            }

        }





    }

    }
}


@OptIn(ExperimentalFoundationApi::class) //Puxa a API
@Composable
fun Carrossel () {
    val pagerState = rememberPagerState(initialPage = 1)
    val posters = listOf(
        R.drawable.miles,
        R.drawable.gwen,
        R.drawable.peter,
        R.drawable.pork
    )
    val names = listOf(
        "Miles",
        "Gwen",
        "Peter",
        "Pork"
    )

    Column(

    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text("Aranhas", style= TextStyle(color = Color.White, fontFamily = Spider, fontSize = 25.sp))
        }


        HorizontalPager(
            pageCount = posters.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 65.dp),
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .padding(20.dp, 0.dp)

        ) {

                page ->
            Card(
                shape = RoundedCornerShape(10.dp),

                )
            {
                Image(
                    painter = painterResource(id = posters[page]),
                    contentDescription = "Imagens",

                    )

                Box(modifier = Modifier
                    .background(Color.White)
                    .padding(41.dp, 0.dp)
                ){
                Text(names[page])
                }
            }


        }
    }


}

@Composable
fun StartsFinal(){
    Row(){
        Image(painter = painterResource(id = R.drawable.othermiles), contentDescription ="Other Miles" ,
            modifier = Modifier
                .height(200.dp)
                .width(240.dp),

                contentScale =  ContentScale.Crop
            )

        Column() {
            Text("Equipe Aranha",
                style = TextStyle(color = Color.White, fontFamily = Spider, fontSize = 30.sp)
            )

            Text("Junte-se a Equipe com os Melhores Homens Aranhas",
                style = TextStyle(color = Color.White, fontSize = 15.sp))


            Spacer(modifier = Modifier.height(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(
                    Color(0xFD, 0x33, 0x25, 0xFF)

                ),
                contentPadding = PaddingValues(),
                onClick = { /*TODO*/



                }
            ) {
                Box(
                    modifier = Modifier

                        .padding(horizontal = 12.dp, vertical = 3.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Se Junte a Equipe")
                }
            }

        }



    }

}








