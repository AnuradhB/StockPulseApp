package com.example.stockpulseapp.presentation.explore.presenting

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockpulseapp.R
import com.example.stockpulseapp.ui.theme.StockPulseAppTheme
import com.example.stockpulseapp.utils.AppFontFamily
import com.example.stockpulseapp.utils.AppFontNormalFamily

@Composable
fun ExploreScreen() {

    val stockList = listOf(
        "Apple Inc.",
        "Tesla",
        "Google",
        "Microsoft",
        "Amazon"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        var searchQuery by remember {
            mutableStateOf("")
        }

        SearchBarExample(
            query = searchQuery,
            onQueryChange = {
                searchQuery = it
            }
        )

        Spacer(modifier = Modifier.padding(4.dp))
        LazyColumn(

            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 4.dp)
        ) {

            items(stockList) { stock ->
                ExploreItem(stock)
            }
        }
    }
}

@Composable
fun ExploreItem(stocks: String) {


    Card(
        modifier = Modifier
            .padding(top = 4.dp)
            .border(
                1.dp,
                Color.LightGray,
                RoundedCornerShape(20.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.profile_circle_svgrepo_com),
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        1.dp,
                        Color.LightGray,
                        RoundedCornerShape(30.dp)
                    ),
                contentDescription = ""
            )

            Column(
                modifier = Modifier
                    .padding(start = 6.dp)
                    .weight(1f)
            ) {

                Text(
                    stocks,
                    fontFamily = AppFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    "djwiqsjd",
                    fontFamily = AppFontNormalFamily,
                    fontSize = 16.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {

                Text(
                    "$${787}",
                    fontFamily = AppFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    "${8}%",
                    fontFamily = AppFontNormalFamily,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Composable
fun SearchBarExample(
    query: String,
    onQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth().padding(2.dp), placeholder = {
            Text("Search...")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(

            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.LightGray,

            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,

            cursorColor = Color.Blue,

            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ))
}

@Preview(showBackground = true)
@Composable
fun ShowView() {

    StockPulseAppTheme {
        ExploreScreen()
    }
}