package com.example.flightsearchapp.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearchapp.R
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme
import com.example.flightsearchapp.ui.theme.primaryDark

@Composable
fun MainScreen(
    viewModel:FlightSearchViewModel= viewModel(factory = FlightSearchViewModel.factory)
){
    var name by rememberSaveable {
        mutableStateOf("")
    }
     Surface(
         modifier = Modifier
             .safeDrawingPadding()
             .fillMaxSize()
             .padding(dimensionResource(id = R.dimen.small_padding))
             .navigationBarsPadding()
     ) {
        Column {
             SearchTopAppBar(
                 title = stringResource(R.string.app_title),
                 modifier = Modifier
                     .height(dimensionResource(id = R.dimen.bar_height)),
                 style = MaterialTheme.typography.headlineLarge
             )
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "null") },
                trailingIcon = {
                    Image(painter = painterResource(id = R.drawable.baseline_keyboard_voice_24), contentDescription = "null")
                },
                        placeholder = {Text(text = "Enter departure airport")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimensionResource(id = R.dimen.large_padding)))
                }
         }
     }
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopAppBar(title:String,modifier: Modifier,
                    style:TextStyle){
    TopAppBar(
        modifier = modifier,
        title = {
    Text(text = title,
        style = style)},
        colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
            containerColor = primaryDark,
        ))
}
@Preview
@Composable
fun ViewScreen(){
    FlightSearchAppTheme {
    }
}