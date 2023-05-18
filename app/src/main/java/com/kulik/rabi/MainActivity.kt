package com.kulik.rabi

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.kulik.rabi.ui.theme.Black
import com.kulik.rabi.ui.theme.RabiTheme
import com.kulik.rabi.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

data class Author(
    @SerializedName("name") val name: String,
    )

data class Book(
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("bookId") val bookId: String,
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: Author,
    @SerializedName("status") val status: String,
    @SerializedName("priority") val priority: String
)

data class JsonResponse(
    @SerializedName("items") val items: List<Book>
)

@Composable
fun Greeting() {
    val gson = Gson()
    val context = LocalContext.current
    val response =  gson.fromJson(booksString, JsonResponse::class.java)

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item() {
            Text("Books", modifier = Modifier.clickable() {
                context.startActivity(Intent(context, PoetsActivity::class.java))
            })
        }

        items(response.items) {
            Card(elevation = 10.dp,
                contentColor = White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(10.dp)
                    .background(color = Black)
            ) {
                Row(modifier = Modifier.height(56.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(
                            buildAnnotatedString {
                                append("book: ")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                                ) {
                                    append(it.title)
                                }
                            }
                        )
                        Text(
                            buildAnnotatedString {
                                append("author")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                                    append(": ")
                                }
                                append(it.author.name)
                            }
                        )
                    }

                    AsyncImage(model = it.imageUrl, contentDescription = null)
                }
            }
        }
    }
}

const val booksString = """{"items":[{"imageUrl":"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1541836413l/42742894.jpg","bookId":"cca85d52-cb93-49d2-a4da-54038df085d1","title":"পল্লী সমাজ","author":{"name":"শরৎ চন্দ্র চট্টোপাধ্যায়"},"status":"Completed","priority":4},{"imageUrl":"https://prodimage.images-bn.com/pimages/9781981107230_p0_v1_s550x406.jpg","bookId":"cca85d52-cb93-49d2-a4da-54038df085e1","title":"চরিত্রহীন","author":{"name":"শরৎ চন্দ্র চট্টোপাধ্যায়"},"status":"Completed","priority":4},{"imageUrl":"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1364162285l/17673148.jpg","bookId":"cca85d52-cb93-49d2-a4da-54038df085d2","title":"পদ্মানদীর মাঝি","author":{"name":"মানিক বন্দ্যোপাধ্যাযটোপাধ্যায়"},"status":"Completed","priority":4},{"imageUrl":"https://upload.wikimedia.org/wikipedia/en/0/0d/Shabash_Professor_shonku.jpg","bookId":"cca85d52-cb93-49d2-a4da-54038df085d3","title":"শাবাশ প্রফেসর শঙ্কু","author":{"name":"সত্যজিৎ রায়"},"status":"Completed","priority":4},{"imageUrl":"https://images-na.ssl-images-amazon.com/images/I/918RS+8CdIL.jpg","bookId":"cca85d52-cb93-49d2-a4da-54038df085d4","title":"রক্তকারাবি","author":{"name":"রবীন্দ্রনাথ ঠাকুর"},"status":"Completed","priority":1},{"imageUrl":"https://upload.wikimedia.org/wikipedia/en/3/38/Pransakha_Vivekananda_front_cover.jpg","bookId":"cca85d52-cb93-49d2-a4da-54038df085d5","title":"প্রাণসখা ভিভেকানান্দ","author":{"name":"রঞ্জন বন্দ্যোপাধ্যায়"},"status":"Completed","priority":4},{"imageUrl":"https://prodimage.images-bn.com/pimages/9781986018135_p0_v1_s550x406.jpg","bookId":"cca85d52-cb93-49d2-a4da-54038df085d6","title":"হাজব্রেলা","author":{"name":"সুকুমার রায়"},"status":"Completed","priority":4},{"imageUrl":"https://images-na.ssl-images-amazon.com/images/I/51nEtkBn0OL.jpg","bookId":"cca85d52-cb93-49d2-a4da-54038df045d5","title":"নষ্টনীড়","author":{"name":"রবীন্দ্রনাথ ঠাকুর"},"status":"Completed","priority":4}]}"""