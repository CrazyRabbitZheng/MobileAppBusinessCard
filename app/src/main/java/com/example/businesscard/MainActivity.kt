package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        //.background(Color.Red)//This is not working
                    //在下面wholeContent里面的modifier = modifier.background（Color.Cyan）设置Worked！
                    ) {
                   WholeContent(
                       name = stringResource(id = R.string.name_text),
                       title = stringResource(id = R.string.title_text),
                       cellNumber = stringResource(id = R.string.cellNumber_text),
                       gitHubUrl = stringResource(id = R.string.gitHubUrl_text),
                       socialMediaUrl = stringResource(id = R.string.zuiHuaTingUrl_text)
                   )
                }
            }
        }
    }
}

@Composable
fun NameText(name: String,modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 80.dp)
            .padding(12.dp)
    )
}

@Composable
fun TitleText(title: String, modifier : Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        //textAlign = TextAlign.Center//Still, didn't work. So padding again.
        modifier = Modifier.padding(start = 116.dp)
        )
}

@Composable
fun CellNumber(cellNumber: String, modifier: Modifier = Modifier) {
    Text(text = cellNumber)
}

@Composable
fun GitHubURL(gitHubUrl: String, modifier: Modifier = Modifier) {
    Text(text = gitHubUrl)
}

@Composable
fun SocialMediaUrl (socialMediaUrl: String, modifier: Modifier = Modifier) {
    Text(
        text = socialMediaUrl,
        modifier = modifier.padding(start = 4.dp)
        )
}

@Composable
fun PhotoImage(name:String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.babyprogrammer)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(450.dp)
        )
        NameText(name = name)
        TitleText(title = title)
    }

}

@Composable
fun CellIcon(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.cellicon64px)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.padding(end = 10.dp))
}

@Composable
fun GitHubIcon(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.githubicon64px)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.padding(end = 16.dp)
    )
}

@Composable
fun SocialMediaIcon(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.flippedinlove)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.size(36.dp)
            .padding(start = 4.dp, end = 10.dp)
        )
}

@Composable
fun ContactInfo(
    cellNumber: String, 
    gitHubUrl: String, 
    socialMediaUrl: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .width(400.dp)
            .height(200.dp)
            .padding(top = 52.dp)
            .background(Color.Cyan)
    ) {
        Row(modifier = modifier.padding(start = 40.dp)) {
            CellIcon(modifier)
            CellNumber(cellNumber = cellNumber)
        }
        Row(modifier = modifier.padding(start = 40.dp)) {
            GitHubIcon(modifier)
            GitHubURL(gitHubUrl = gitHubUrl)
        }
        Row(modifier = modifier.padding(start = 40.dp)) {
            SocialMediaIcon(modifier)
            SocialMediaUrl(socialMediaUrl = socialMediaUrl)
        }
    }

}

@Composable
fun WholeContent(
    name: String,
    title: String,
    cellNumber: String,
    gitHubUrl: String,
    socialMediaUrl: String,
    modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Color.Cyan)) {
        PhotoImage(name = name, title = title)
        ContactInfo(cellNumber = cellNumber, gitHubUrl = gitHubUrl, socialMediaUrl = socialMediaUrl)
    }
}

