package com.example.myapplicationassigment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerId
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationassigment.ui.theme.MyApplicationAssigmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                    ImageDefilante()
                }
            }
        }


@Composable
fun ImageComponent(imageResId:Int, contentDescripton: String) {
    Box(
        modifier=Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)

    )
    Image(
      painter = painterResource(id=imageResId),
        contentDescripton,
        modifier=Modifier
            .fillMaxWidth()
            .height(350.dp)
            .width(300.dp)
            .scale(2f)
            .border(20.dp,Color.White)
            .shadow(2.5.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .size(400.dp,400.dp)

    )
}

@Composable
fun CaptionComponent(caption:String) {
    Text(
        text = caption,
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .shadow(100.dp, RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(15.dp)
    )

}

@Composable
fun NavigationButtons(onPreviousClick:()-> Unit, onNextClick:()-> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement=Arrangement.spacedBy(16.dp),

    ){
        Button(onClick = onPreviousClick) {
            Text("previous")
        }
        Button(onClick =onNextClick ) {
            Text("Next")
        }
    }
}



@Composable
fun ImageDefilante() {
    val imageListe=listOf(
        R.drawable.newyork,
        R.drawable.ampedehevetonhomme,
        R.drawable.oodorninganrancisco


    )
    val imageCations= listOf("Statut de la liberté situe en Amérique plus précisement au USA","Un bohonne avec une lampe", "Le pont de san-fransico")

    var indexCible by remember{ mutableStateOf(0) }
    Box(modifier =Modifier
        .border(2.dp, Color.Gray)
        .fillMaxSize()
        .fillMaxWidth()
        .padding(96.dp),
        contentAlignment=
        Alignment.Center){
        Column(
            modifier= Modifier.fillMaxWidth(),
            verticalArrangement= Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ImageComponent(
                imageResId=imageListe[indexCible],
                contentDescripton=imageCations[indexCible]
            )
            Spacer(modifier = Modifier.height(16.dp))
            CaptionComponent(caption=imageCations[indexCible])
            Spacer(modifier=Modifier.height(16.dp))
            NavigationButtons(onPreviousClick={
                indexCible=(indexCible-1 + imageListe.size)% imageListe.size
            },
                onNextClick={
                    indexCible=(indexCible+1) % imageListe.size
                })
        }
    }

}